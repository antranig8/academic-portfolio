import java.util.ListIterator;

public class Playlist {
	// fields for playlist
	private GenericLinkedList<Song> songs;
	private String name;
	// for the iterator
	private int index;
	/**
	 * Constructor for playlist
	 * @param name The name for the playlist
	 */
	public Playlist(String name) {
		this.songs = new GenericLinkedList<>();
		this.name = name;
		this.index = -1;
	}
	// the methods below
	
	/**
	 * addSong method to add a song to the playlist
	 * @param song The song to be added
	 * @return true if song was added, false if not
	 */
	public boolean addSong(Song song) {
		if(song == null) {
			return false;
		}
		songs.addLast(song);
		// Set the position for the iterator
		if(index == -1) {
			index = 0;
		}
		return true;
	}
	/**
	 * getCurrentSong method that returns the current song
	 * the iterator is at
	 * @return song where the iterator is at
	 */
	public Song getCurrentSong() {
		// if the current song is empty, there is no song selected, or the iterator is greater than the song list
		if(songs.isEmpty() || index < 0 || index >= songs.size()) {
			// return null
			return null;
		}
		//otherwise return the song iterator is at
		return songs.get(index);
	}
	/**
	 * getSize method to see the size of the playlsit
	 * @return size of playlist
 	 */
	public int getSize() {
		return songs.size();
	}
	/**
	 * isEmpty method to check if playlsit is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
		return songs.isEmpty();
	}
	/**
	 * getSongs method that returns a shallow copy of the list
	 * @return copy of the list
	 */
	public GenericLinkedList<Song> getSongs(){
		GenericLinkedList<Song> copy = new GenericLinkedList<>();
		// create a copy of the array
		Object[] array = songs.toArray();
		// use for loop to add every song to playlist
		for (Object song : array) {
			// need to do a type cast for song objects
			copy.addLast((Song) song);
		}
		// reutrn the copy of array
		return copy;
	}
	// iterator methods
	// go to next song
	public Song nextSong() {
		// checks before going to next song
		if(songs.isEmpty()) {
			return null;
		}
		// get the next song
		Song next = songs.get(index);
		// advance the iterator if there is a next song
		if(index+1 < songs.size()) {
			index++;
		}
		// return the next song
		return next;
	}
	// previous song
	public Song previousSong() {
		// checks before going to next song
		if(songs.isEmpty()) {
			return null;
		}
		// check if there is a previous song
		if(index-1 < 0) {
			return null;
		}
		// decrement to go backwards
		index--;
		// return the next song
		return songs.get(index);
	}
	/**
	 * removeSong method to remove a chosen song
	 * @return true if removed, false if not 
	 */
	public boolean removeSong(Song song) {
		// check for empty case
		if(songs.isEmpty()) {
			return false;
		}
		// traverse the playlist
		int position = -1;
		// counter
		int i = 0;
		// go through
		for(ListIterator<Song> iterator = songs.iterator(); iterator.hasNext(); i++) {
			Song other = iterator.next();
			// check for null case
			if(song == null && other == null) {
				// mark positon
				position = i;
				// get out
				break;
			}
			// check if song equals the currently selected one
			if(song != null && song.equals(other)) {
				// mark positon
				position = i;
				// get out
				break;
			}
		}
		// if the position is at -1, meaning playlist is empty
		if (position == -1) {
			return false;
		}
		// otherwise remove the song at the position
		songs.remove(position);
		// re adjust the iterator
		// if the playlist is now empty, iterator should be at -1
		if(songs.isEmpty()) {
			index = -1;
		}
		// if the song removed was before the current iterator point, move it back by 1 to keep the same
		else if(position < index) {
			index--;
		}
		// if the song removed was at the iterators position or greater no change is needed
		else if(position == index) {
			//but if the current position is greater than the playlist size then the last element was removed
			// so step back by 1
			if(index >= songs.size()) {
				index = songs.size()-1;
			}
		}
		// true if removed
		return true;
	}
	// getter
	public String getName() {
		return name;
	}
}
