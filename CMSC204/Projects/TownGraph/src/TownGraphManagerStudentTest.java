import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManagerStudentTest {
	// Create a TownGraphManager object
	private TownGraphManager manager;
	
	@BeforeEach
	void setUp() throws Exception {
		manager = new TownGraphManager();
		manager.addTown("Gaithersburg");
		manager.addTown("Rockville");
		manager.addTown("Bethesda");
		manager.addRoad("Gaithersburg", "Rockville", 8, "MD355");
		manager.addRoad("Rockville", "Bethesda", 6, "MD28");
		manager.addRoad("Gaithersburg", "Bethesda", 12, "I-270");
	}

	@AfterEach
	void tearDown() throws Exception {
		manager = null;
	}

	@Test
	final void testAddTown() {
		assertTrue(manager.addTown("Silver Spring"));
		// adding duplicate town
		assertFalse(manager.addTown("Gaithersburg")); 
		// adding null town
		assertFalse(manager.addTown(null));
	}
	@Test
	final void testContainsTown() {
		assertTrue(manager.containsTown("Rockville"));
		// town that does not exist
		assertFalse(manager.containsTown("Silver Spring"));
		// null town name
		assertFalse(manager.containsTown(null));
	}
	@Test
	final void testGetTown() {
		Town town = manager.getTown("Bethesda");
		assertNotNull(town);
		assertEquals("Bethesda", town.getName());
		// town that does not exist
		assertNull(manager.getTown("Silver Spring"));
		// null town name
		assertNull(manager.getTown(null));
	}
	
	@Test
	final void testAllTownsSorted() {
		java.util.ArrayList<String> towns = manager.allTowns();
		assertEquals(3, towns.size());
		assertEquals("Bethesda", towns.get(0));
		assertEquals("Gaithersburg", towns.get(1));
		assertEquals("Rockville", towns.get(2));
	}
	
	@Test
	final void testAddRoad() {
		// adding road between an existing and non existing town
		assertFalse(manager.addRoad("Bethesda", "Silver Spring", 5, "MD97"));
		// adding road with null town
		assertFalse(manager.addRoad("Bethesda", null, 5, "MD97"));
		// adding valid road
		assertTrue(manager.addRoad("Bethesda", "Rockville", 6, "MD29"));
	}
	
	@Test
	final void testContainsRoadConnection() {
		assertTrue(manager.containsRoadConnection("Gaithersburg", "Rockville"));
		// road that does not exist
		assertFalse(manager.containsRoadConnection("Gaithersburg", "Silver Spring"));
		// null town name
		assertFalse(manager.containsRoadConnection(null, "Rockville"));
	}
	
	@Test
	final void testGetPathAndDeleteRoadConnection() {
		ArrayList<String> path = manager.getPath("Gaithersburg", "Bethesda");
		assertNotNull(path);
		assertEquals(1, path.size());
		assertEquals("Gaithersburg via I-270 to Bethesda 12 mi", path.get(0));
		// now remove the direct road and test again
		manager.deleteRoadConnection("Gaithersburg", "Bethesda", "I-270");
		path = manager.getPath("Gaithersburg", "Bethesda");
		assertNotNull(path);
		assertEquals(2, path.size());
		assertEquals("Gaithersburg via MD355 to Rockville 8 mi", path.get(0));
		assertEquals("Rockville via MD28 to Bethesda 6 mi", path.get(1));
	}
	
	@Test
	final void testDeleteTown() {
		assertTrue(manager.deleteTown("Rockville"));
		// deleting town that does not exist
		assertFalse(manager.deleteTown("Silver Spring"));
		// deleting null town
		assertFalse(manager.deleteTown(null));
	}
	
	@Test
	final void testPopulateTownGraph() throws FileNotFoundException, IOException {
		File file = new File("MD Towns.txt");
		manager = new TownGraphManager();
		manager.populateTownGraph(file);
		// test if towns were added
		assertTrue(manager.allTowns().size() > 0);
		// test if roads were added
		assertTrue(manager.allRoads().size() > 0);
		// test a specific town
		assertTrue(manager.containsTown("Gaithersburg"));
		// test a specific road
		assertTrue(manager.containsRoadConnection("Gaithersburg", "Rockville"));
	}
}
