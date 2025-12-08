import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoadTest {
	// Create towns and a road for testing
	Town town1 = new Town("Gaithersburg");
	Town town2 = new Town("Germantown");
	Road road = new Road(town1, town2, 6, "I-270");
	
	@Test
	final void testEqualsUndirectedRoad() {
		// Create another road with the same towns but reversed
		Road reverseRoad = new Road(town2, town1, 6, "I-270");
		// Test equality
		assertTrue(road.equals(reverseRoad), "Road should be equal regardless of town order");
		// Test hashCodes are the same
		assertEquals(road.hashCode(), reverseRoad.hashCode());
	}
	
	@Test
	final void testStringFormat() {
		String expected = "Gaithersburg via I-270 to Germantown 6 mi";
		assertEquals(expected, road.toString());
	}
	
	@Test
	final void testCompareToByName() {
		Road anotherRoad = new Road(town1, town2, 6, "I-495");
		assertTrue(road.compareTo(anotherRoad) < 0, "I-270 should come before I-495 alphabetically");
	}
}
