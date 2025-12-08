
public class User {
	// Playlist holder
	private GenericLinkedList<Playlist> playlist;
	private String username;
	private String password;
	/*
	 * default no arg user constructor
	 */
	public User() {
		this.playlist = new GenericLinkedList<>();
		this.username = null;
		this.password = null;
	}
	/**
	 * paramterized constructor
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password) {
		this.playlist = new GenericLinkedList<>();
		this.username = username;
		this.password = password;
	}
	/**
	 * Add playlist method that allows you to add a playlist to user account
	 * @param playlist
	 */
	public void addPlaylist(Playlist list) {
		if(list == null) {
			throw new IllegalArgumentException("Playlist cannot be null");
		}
		playlist.addLast(list);
	}
	/*
	 * returns the amount of playlist the account has
	 */
	public int getPlaylistCount() {
		return playlist.size();
	}
	public GenericLinkedList<Playlist> getPlaylists(){
		return playlist;
	}
	// getters for the account
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}
