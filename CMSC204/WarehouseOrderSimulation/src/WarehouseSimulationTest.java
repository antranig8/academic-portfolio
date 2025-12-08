import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseSimulationTest {
	// set up fields
	private WarehouseSimulation whs;
	private Order[] orders;

	@BeforeEach
	void setUp() throws Exception {
		// Set up the orders array
		orders = new Order[] {
		new Order("A", 1),
		new Order("B", 2),
		new Order("C", 3),
		new Order("D", 2),
		};
		// create simulation
		whs = new WarehouseSimulation(orders);
	}

	@AfterEach
	void tearDown() throws Exception {
		whs = null;
		orders = null;
	}

	@Test
	final void testWarehouseSimulation() {
		assertNotNull(whs);
		assertEquals(0, whs.getCurrentMinute());
		assertFalse(whs.isFinished());
		assertEquals(0, whs.getTotalArrived());
		assertEquals(0, whs.getTotalShipped());
		assertEquals(0, whs.getTotalLate());
	}

	@Test
	final void testTick() {
		// tick 1
		whs.tick();
		assertEquals(1, whs.getCurrentMinute());
        assertEquals(1, whs.getTotalArrived());
        assertEquals(1, whs.getTotalShipped());
        assertEquals(0, whs.getTotalLate());
        // after 2 more ticks 
        whs.tick();
        whs.tick();
        assertEquals(3, whs.getCurrentMinute());
        assertEquals(3, whs.getTotalArrived());
        assertEquals(3, whs.getTotalShipped());
        assertEquals(0, whs.getTotalLate());
        // after 4th tick 1 should be late
        whs.tick();
        assertEquals(4, whs.getCurrentMinute());
        assertEquals(4, whs.getTotalArrived());
        assertEquals(4, whs.getTotalShipped());
        assertEquals(1, whs.getTotalLate());
	}

	@Test
	final void testIsFinished() {
		// advance time until all orders are finsihed being dealt with
		while (!whs.isFinished()) {
            whs.tick();
        }
        assertTrue(whs.isFinished());
        assertEquals(4, whs.getTotalArrived());
        assertEquals(4, whs.getTotalShipped());
        assertEquals(1, whs.getTotalLate());
	}

	@Test
	final void testGetCurrentMinute() {
		// check minute
		assertEquals(0, whs.getCurrentMinute());
		// advance time
        whs.tick();
        whs.tick();
        // check again
        assertEquals(2, whs.getCurrentMinute());
	}

	@Test
	final void testGetTotalArrived() {
		// Get total at start
		assertEquals(0, whs.getTotalArrived());
		// advance time so 3 arrive
        whs.tick();
        whs.tick(); 
        whs.tick(); 
        // 3 orders, (A, B, C)
        assertEquals(3, whs.getTotalArrived());
	}

	@Test
	final void testGetTotalShipped() {
		// get total at start
		assertEquals(0, whs.getTotalShipped());
		// advance time ship 2
	    whs.tick();
	    whs.tick();
	    // check total shipped
	    assertEquals(2, whs.getTotalShipped());
	}

	@Test
	final void testGetTotalLate() {
		// advance until simulation finished ticking
		while (!whs.isFinished()) {
            whs.tick();
        }
		// order C should be late
		assertEquals(1, whs.getTotalLate());
	}

}
