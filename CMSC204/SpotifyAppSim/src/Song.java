
public class Song {
	//fields
	private String title;
	private String artist;
	/**
	 * no arg constructor for song
	 */
	public Song() {
		this.title = null;
		this.artist = null;
	}
	/**
	 * song title constructor
	 * @param title the title of the song
	 */
	public Song(String title) {
		this.title = title;
		this.artist = null;
	}
	/**
	 * fully paramterized constructor
	 * @param title the title of the song
	 * @param artist the name of the artists
	 */
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	// Getter and setters
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	
	public void setArtist(String Artist){
		this.artist = Artist;
	}
	public String getArtist(){
		return artist;
	}
	// toString method to display song information correctly on app
	@Override
	public String toString() {
		return title + " - " + artist;
	}
	
}
