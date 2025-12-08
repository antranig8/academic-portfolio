import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private Playlist playlist;
	private Song song;
	private Song song2;

	@BeforeEach
	void setUp() throws Exception {
		playlist = new Playlist("Playlist 1");
		song = new Song("Hotline Bling", "Drake");
		song2 = new Song("After Hours", "Drake");
	}

	@AfterEach
	void tearDown() throws Exception {
		playlist = null;
		Song song = null;
		Song song2 = null;
	}

	@Test
	final void testPlaylist() {
		// Test the constructor
		assertNotNull(playlist);
		assertEquals("Playlist 1", playlist.getName());
		assertTrue(playlist.isEmpty());
		assertEquals(0, playlist.getSize());
		// should be no current song so null
		assertNull(playlist.getCurrentSong());
	}

	@Test
	final void testAddSong() {
		// Test adding a song
		assertTrue(playlist.addSong(song));
		assertFalse(playlist.addSong(null));
		assertEquals(1, playlist.getSize());
		assertTrue(playlist.addSong(song2));
		assertEquals(2, playlist.getSize());
		assertFalse(playlist.isEmpty());
		// Now make sure the order is correct
		GenericLinkedList<Song> songs = playlist.getSongs();
		assertEquals("Hotline Bling", songs.get(0).getTitle());
		assertEquals("After Hours", songs.get(1).getTitle());
	}

	@Test
	final void testGetCurrentSong() {
		// Test getting the current song
		playlist.addSong(song);
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
		playlist.addSong(song2);
		playlist.nextSong();
		assertEquals("After Hours", playlist.getCurrentSong().getTitle());
		playlist.previousSong();
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
		// Test the iterator bounds
		playlist.previousSong();
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
		playlist.nextSong();
		playlist.nextSong();
		assertEquals("After Hours", playlist.getCurrentSong().getTitle());
	}

	@Test
	final void testGetSize() {
		// Test getting the size
		assertEquals(0, playlist.getSize());
		playlist.addSong(song);
		assertEquals(1, playlist.getSize());
		playlist.addSong(song2);
		assertEquals(2, playlist.getSize());
		// now remove a song and check size
		playlist.removeSong(song);
		assertEquals(1, playlist.getSize());
		playlist.removeSong(song2);
		assertEquals(0, playlist.getSize());
	}

	@Test
	final void testIsEmpty() {
		// Test if the playlist is empty
		assertTrue(playlist.isEmpty());
		playlist.addSong(song);
		assertFalse(playlist.isEmpty());
		playlist.removeSong(song);
		assertTrue(playlist.isEmpty());
	}

	@Test
	final void testGetSongs() {
		// Test getting the songs
		assertTrue(playlist.getSongs().isEmpty());
		playlist.addSong(song);
		GenericLinkedList<Song> songs = playlist.getSongs();
		assertEquals(1, songs.size());
		assertEquals("Hotline Bling", songs.get(0).getTitle());
		playlist.addSong(song2);
		songs = playlist.getSongs();
		assertEquals(2, songs.size());
		assertEquals("After Hours", songs.get(1).getTitle());
	}

	@Test
	final void testNextSong() {
		// Test moving to the next song
		playlist.addSong(song);
		playlist.addSong(song2);
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
		playlist.nextSong();
		assertEquals("After Hours", playlist.getCurrentSong().getTitle());
	}

	@Test
	final void testPreviousSong() {
		// Test going to the previous song
		playlist.addSong(song);
		playlist.addSong(song2);
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
		playlist.nextSong();
		assertEquals("After Hours", playlist.getCurrentSong().getTitle());
		playlist.previousSong();
		assertEquals("Hotline Bling", playlist.getCurrentSong().getTitle());
	}

	@Test
	final void testRemoveSong() {
		// Test removing a song
		playlist.addSong(song);
		playlist.addSong(song2);
		assertEquals(2, playlist.getSize());
		assertTrue(playlist.removeSong(song));
	}

	@Test
	final void testGetName() {
		// Test getting the name
		assertEquals("Playlist 1", playlist.getName());
	}

}
