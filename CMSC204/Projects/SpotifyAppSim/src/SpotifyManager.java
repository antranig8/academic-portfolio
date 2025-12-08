import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SpotifyManager {
	//fields
	private GenericLinkedList<User> manager;
	private User currentUser;
	/*
	 * No arg constructor
	 */
	public SpotifyManager() {
		this.manager = new GenericLinkedList<>();
		this.currentUser = null;
	}
	/*
	 * full paramterized constructor
	 */
	public SpotifyManager(User user) {
		this.manager = new GenericLinkedList<>();
		this.currentUser = user;
	}
	
	/**
	 * loadUsersFromFile method that parses and gets infromation from a file
	 * @param filename the file to use
	 * @throws IOException when there is an issue
	 * @throws InvalidUserFormatException if account format is wrong
	 */
	public void loadUsersFromFile(String filename) throws IOException, InvalidUserFormatException{
		// Create the reader and read the filename given
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		try{
			// the line thats being read
			String line;
			//placeholders
			String loadedUsername = null;
			String loadedPassword = null;
			User loadedUser = null;
			Playlist loadedPlaylist = null;
			// start reading the file
			while((line = reader.readLine()) != null) {
				line = line.trim();
				// if the line is empty then continue
				if(line.isEmpty()) {
					continue;
				}
				// check for a user
				if(line.equalsIgnoreCase("# USER")) {
					//if there is a new user block found, finalize the previous user by setting it to null
					if(loadedUsername != null || loadedPassword != null || loadedUser != null) {
						if(loadedUsername == null || loadedPassword == null ) {
							// throw an error if the username and password are wrong
							throw new InvalidUserFormatException("The entered USER is missing a username or password");
						}
						//otherwise save the new user
						if(loadedUser == null) {
							loadedUser = new User(loadedUsername, loadedPassword);
						}
						// add the user to manager list
						manager.addLast(loadedUser);
					}
				// reset the placeholders for a new user
				loadedUsername = null;
				loadedPassword = null;
				loadedUser = null;
				loadedPlaylist = null;	
				continue;
				}
				// for the username:
				if(line.toLowerCase().startsWith("username:")) {
					//get the name after the : character
					String name = line.substring(line.indexOf(':')+1).trim();
					//check if its empty
					if(name.isEmpty()) {
						throw new InvalidUserFormatException("Username is empty.");
					}
					//otherwise save the name
					loadedUsername = name;
					continue;
				}
				// for the password:
				if(line.toLowerCase().startsWith("password:")) {
					//get the password after the : character
					String pass = line.substring(line.indexOf(':')+1).trim();
					//check if its empty
					if(pass.isEmpty()) {
						throw new InvalidUserFormatException("Password is empty.");
					}
					//otherwise save the name
					loadedPassword = pass;
					continue;
				}
				// for the playlist:
				if(line.toLowerCase().startsWith("playlist:")) {
					// first check if the username and password were entered
					if(loadedUsername == null || loadedPassword == null) {
						throw new InvalidUserFormatException("Playlist cannot come before username and password.");
					}
					// otherwise, create a user account with the username and password
					if(loadedUser == null){
						loadedUser = new User(loadedUsername, loadedPassword);
					}
					// get the playlist name after the : char
					String playlist = line.substring(line.indexOf(':')+1).trim();
					//check if its empty
					if(playlist.isEmpty()) {
						throw new InvalidUserFormatException("Playlist is empty.");
					}
					//otherwise save to list
					loadedPlaylist = new Playlist(playlist);
					loadedUser.addPlaylist(loadedPlaylist);
					continue;
				}
				// get song
				if(line.toLowerCase().startsWith("song:")) {
					// first check if the username and password were entered
					if(loadedUsername == null || loadedPassword == null) {
						throw new InvalidUserFormatException("Song cannot come before username and password.");
					}
					//create a user account with the username and password
					if(loadedUser == null){
						loadedUser = new User(loadedUsername, loadedPassword);
					}
					// check if playlist comes before the song
					if(loadedPlaylist == null) {
						throw new InvalidUserFormatException("Song cannot come before the Playlist");
					}
					// get the song name after the : char
					String playlist = line.substring(line.indexOf(':')+1).trim();
					//check if its empty
					if(playlist.isEmpty()) {
						throw new InvalidUserFormatException("Playlist is empty.");
					}
					// otherwise start the parsing for the song
					String parsed = line.substring(line.indexOf(':')+1).trim();
					// create an array to hold the two parts of the song
					// this split will also allow any amount of spaces between the dash
					String[] song = parsed.split("\\s*-\\s*",2);
					// check if either is empty
					if(song.length < 2 || song[0].trim().isEmpty() || song[1].trim().isEmpty()){
						throw new InvalidUserFormatException("Song must be in the format: Title - Artist");
					}
					// create placeholder for title and artist
					String title = song[0];
					String artist = song[1];
					// add song to playlist
					loadedPlaylist.addSong(new Song(title, artist));
					continue;
					
				}
				// if any other line comes thats not  listed above
				throw new InvalidUserFormatException("Unrecognized format: "+line);
			}
			// finalize with all information again
			if(loadedUsername != null || loadedPassword != null || loadedUser != null) {
				if(loadedUsername == null || loadedPassword == null ) {
					// throw an error if the username and password are wrong
					throw new InvalidUserFormatException("The entered USER is missing a username or password");
				}
				//otherwise save the new user
				if(loadedUser == null) {
					loadedUser = new User(loadedUsername, loadedPassword);
				}
				// add the user to manager list
				manager.addLast(loadedUser);
				}
		}
		// Close the reader
		finally {
			reader.close();
		}
	}
	/**
	 * findUser method that takes a username and password to find an account
	 * @param username the username
	 * @param password the password
	 * @return user the user if found
	 * @throws UserNotFoundException when user is not found
	 * @throws InvalidPasswordException when password does not match
	 */
	public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException{
		// traverse until the user with same username and password are found
		for(int index = 0; index < manager.size(); index++) {
			User check = manager.get(index);
			if(check != null && username !=null && username.equals(check.getUsername())) {
				if(password != null && password.equals(check.getPassword())) {
					currentUser = check;
					return check;
				}
				// if passwords dont match then throw exception
				throw new InvalidPasswordException("Incorrect Password.");
			}
		}
		//if user could not be found
		throw new UserNotFoundException("User not found.");
	}
	
	// getters for the users
	public GenericLinkedList<User> getUsers(){
		return manager;
	}
	public User getCurrentUser() {
		return currentUser;
	}
}
