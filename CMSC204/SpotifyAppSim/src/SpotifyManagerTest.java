import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpotifyManagerTest {
	private SpotifyManager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new SpotifyManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		manager = null;
	}

	@Test
	final void testSpotifyManagerDefaultConstructor() {
		// test the default constructor
		assertNotNull(manager);
		assertNull(manager.getCurrentUser());
		assertNotNull(manager.getUsers());
		assertTrue(manager.getUsers().isEmpty());
	}

	@Test
	final void testSpotifyManagerParamterizedConstructor() {
		// create a user and pass it to the constructor
		User user = new User("test", "password");
		SpotifyManager manager2 = new SpotifyManager(user);
		assertEquals(user, manager2.getCurrentUser());
		assertNotNull(manager2.getUsers());
		assertTrue(manager2.getUsers().isEmpty());
	}

	@Test
	final void testLoadUsersFromFile() throws IOException, InvalidUserFormatException {
		// create a temp file with data
		String filename = "test_users.txt";
		FileWriter writer = new FileWriter(filename);
		// data for one user with one playlist and two songs
		writer.write("# USER\n");
		writer.write("username: antranig\n");
		writer.write("password: cmsc204\n");
		writer.write("playlist: MyPlaylist\n");
		writer.write("song: Hotline Bling - Drake\n");
		writer.write("song: Blinding Lights - The Weeknd\n");
		// data for another user with 2 playlists and 1 song each
		writer.write("# USER\n");
		writer.write("username: test\n");
		writer.write("password: password\n");
		writer.write("playlist: Rock\n");
		writer.write("song: Bohemian Rhapsody - Queen\n");
		writer.write("playlist: Pop\n");
		writer.write("song: Hotline Bling - Drake\n");
		writer.close();
		// now run the method
		manager.loadUsersFromFile(filename);
		// check that the users were loaded correctly
		GenericLinkedList<User> users = manager.getUsers();
		assertEquals(2, users.size());
		// check first user
		User user1 = users.get(0);
		assertEquals("antranig", user1.getUsername());
		assertEquals("cmsc204", user1.getPassword());
		assertEquals(1, user1.getPlaylists().size());
		Playlist playlist1 = user1.getPlaylists().get(0);
		assertEquals("MyPlaylist", playlist1.getName());
		assertEquals(2, playlist1.getSongs().size());
		assertEquals("Hotline Bling", playlist1.getSongs().get(0).getTitle());
		assertEquals("Drake", playlist1.getSongs().get(0).getArtist());
		assertEquals("Blinding Lights", playlist1.getSongs().get(1).getTitle());
		assertEquals("The Weeknd", playlist1.getSongs().get(1).getArtist());
		// check second user
		User user2 = users.get(1);
		assertEquals("test", user2.getUsername());
		assertEquals("password", user2.getPassword());
		assertEquals(2, user2.getPlaylists().size());
		Playlist playlist2 = user2.getPlaylists().get(0);
		assertEquals("Rock", playlist2.getName());
		assertEquals(1, playlist2.getSongs().size());
		assertEquals("Bohemian Rhapsody", playlist2.getSongs().get(0).getTitle());
		assertEquals("Queen", playlist2.getSongs().get(0).getArtist());
	}
	// Now test for exceptions
	@Test
	final void testInvalidLoadUsersFromFile() throws IOException, InvalidUserFormatException {
		// create a temp file with invalid data
		String filename = "test_invalid_users.txt";
		FileWriter writer = new FileWriter(filename);
		writer.write("# USER\n");
		writer.write("username: antranig\n");
		// missing password
		writer.write("playlist: MyPlaylist\n");
		writer.write("song: Hotline Bling - Drake\n");
		writer.close();
		// now run the method and expect an exception
		assertThrows(InvalidUserFormatException.class, () -> {
			manager.loadUsersFromFile(filename);
		});
	}

	@Test
	final void testFindUser() throws UserNotFoundException, InvalidPasswordException {
		// create some users
		User user = new User("test", "password");
		User user2 = new User("antranig", "cmsc204");
		// add users to the manager
		manager.getUsers().addLast(user);
		manager.getUsers().addLast(user2);
		// find the user
		User foundUser = manager.findUser("test", "password");
		assertNotNull(foundUser);
		assertEquals("test", foundUser.getUsername());
		assertEquals("password", foundUser.getPassword());
	}

	@Test
	final void testGetUsers() {
		// create some users
		User user = new User("test", "password");
		User user2 = new User("antranig", "cmsc204");
		// add users to the manager
		manager.getUsers().addLast(user);
		manager.getUsers().addLast(user2);
		// get the users
		GenericLinkedList<User> users = manager.getUsers();
		assertNotNull(users);
		assertEquals(2, users.size());
		assertEquals(user, users.get(0));
		assertEquals(user2, users.get(1));
		}

	@Test
	final void testGetCurrentUser() {
		// create a user and set it as current user
		User user = new User("test", "password");
		manager = new SpotifyManager(user);
		assertEquals(user, manager.getCurrentUser());
		// change current user
		User user2 = new User("antranig", "cmsc204");
		manager = new SpotifyManager(user2);
		assertEquals(user2, manager.getCurrentUser());
	}

}
