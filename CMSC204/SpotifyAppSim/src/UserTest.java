import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	private User user;
	private User user2;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new User("user", "password");
		user2 = new User("antranig", "cmsc204");
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		user2 = null;
	}

	@Test
	final void testUser() {
		// testomg the no arg constructor
		User newUser = new User();
		assertNotNull(newUser);
		assertEquals(0, newUser.getPlaylistCount());
		newUser = null;
		assertNull(newUser);
	}

	@Test
	final void testUserCompleteParamters() {
		// testing the full paramterized constructor
		User newUser = new User("test", "password");
		assertNotNull(newUser);
		assertEquals(0, newUser.getPlaylistCount());
		assertEquals("test", newUser.getUsername());
		assertEquals("password", newUser.getPassword());
	}

	@Test
	final void testAddPlaylist() {
		// adding playlist to user
		Playlist list = new Playlist("Playlist 1");
		user.addPlaylist(list);
		assertEquals(1, user.getPlaylistCount());
		assertEquals(list, user.getPlaylists().get(0));
		
		Playlist list2 = new Playlist("Playlist 2");
		user.addPlaylist(list2);
		assertEquals(2, user.getPlaylistCount());
		assertEquals(list2, user.getPlaylists().get(1));
		// test add a null playlist which should throw an exception
		assertThrows(IllegalArgumentException.class, () -> {
			user.addPlaylist(null);
		});
		// count should still be 2
		assertEquals(2, user.getPlaylistCount());
	}

	@Test
	final void testGetPlaylistCount() {
		// initially should be 0
		assertEquals(0, user.getPlaylistCount());
		// add a playlist and check count
		Playlist list = new Playlist("Playlist 1");
		user.addPlaylist(list);
		assertEquals(1, user.getPlaylistCount());
		// add another playlist and check count
		Playlist list2 = new Playlist("Playlist 2");
		user.addPlaylist(list2);
		assertEquals(2, user.getPlaylistCount());
	}

	@Test
	final void testGetPlaylists() {
		// initially should be empty
		assertNotNull(user.getPlaylists());
		assertEquals(0, user.getPlaylists().size());
		// add a playlist and check
		Playlist list = new Playlist("Playlist 1");
		user.addPlaylist(list);
		assertEquals(1, user.getPlaylists().size());
		assertEquals(list, user.getPlaylists().get(0));
		// add another playlist and check
		Playlist list2 = new Playlist("Playlist 2");
		user.addPlaylist(list2);
		assertEquals(2, user.getPlaylists().size());
		assertEquals(list2, user.getPlaylists().get(1));
	}
	
	// Simple getters tests
	@Test
	final void testGetUsername() {
		assertEquals("user", user.getUsername());
		assertEquals("antranig", user2.getUsername());
	}

	@Test
	final void testGetPassword() {
		assertEquals("password", user.getPassword());
		assertEquals("cmsc204", user2.getPassword());
	}

}
