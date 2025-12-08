import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongTest {
	private Song song;

	@BeforeEach
	void setUp() throws Exception {
		song = new Song();
	}

	@AfterEach
	void tearDown() throws Exception {
		song = null;
	}

	@Test
	final void testSongConstructor() {
		// test the no-arg constructor
		assertNotNull(song);
		assertNull(song.getTitle());
		assertNull(song.getArtist());
	}

	@Test
	final void testSongConstructor2() {
		// test the single parameter constructor
		song = new Song("Imagine");
		assertNotNull(song);
		assertEquals("Imagine", song.getTitle());
		assertNull(song.getArtist());
	}
	
	@Test
	final void testSongCompleteConstructor() {
		// test the fully parameterized constructor
		song = new Song("Imagine", "John Lennon");
		assertNotNull(song);
		assertEquals("Imagine", song.getTitle());
		assertEquals("John Lennon", song.getArtist());
	}

	@Test
	final void testSetTitle() {
		song.setTitle("Bohemian Rhapsody");
		assertEquals("Bohemian Rhapsody", song.getTitle());
	}

	@Test
	final void testGetTitle() {
		song.setTitle("Which One");
		assertEquals("Which One", song.getTitle());
	}

	@Test
	final void testSetArtist() {
		song.setArtist("Drake");
		assertEquals("Drake", song.getArtist());
	}

	@Test
	final void testGetArtist() {
		song.setArtist("Drake");
		assertEquals("Drake", song.getArtist());
	}

}
