import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownTest {
	// Create two Town objects for testing
	Town town1 = new Town("Gaithersburg");
	Town town2 = new Town("Germantown");
	
	@AfterEach
	void tearDown() throws Exception {
		town1 = null;
		town2 = null;
	}

	@Test
	public void testEqualsAndCompareTo() {
		// Test equals of different towns
		assertFalse(town1.equals(town2));
		// Test equals of same towns
		Town town3 = new Town("Gaithersburg");
		assertTrue(town1.equals(town3));
		// Test compareTo method
		assertTrue(town1.compareTo(town2) < 0);
		assertTrue(town2.compareTo(town1) > 0);
		assertEquals(0, town1.compareTo(town3));
	}
	
	@Test
	public void testAddAdjacentTown() {
		// Add adjacent town and check
		town1.addAdjacentTown(town2);
		assertTrue(town1.getAdjacentTowns().contains(town2));
		// Try adding null adjacent town
		town1.addAdjacentTown(null);
		assertEquals(1, town1.getAdjacentTowns().size());
		// Try adding duplicate adjacent town
		town1.addAdjacentTown(town2);
		assertEquals(1, town1.getAdjacentTowns().size());
	}
	
	@Test
	public void testHashCode() {
		// Test hashCode consistency with equals
		Town town3 = new Town("Gaithersburg");
		assertEquals(town1.hashCode(), town3.hashCode());
	}
	
	@Test
	public void testGetName() {
		// Test getName method
		assertEquals("Gaithersburg", town1.getName());
		assertEquals("Germantown", town2.getName());
	}
}
