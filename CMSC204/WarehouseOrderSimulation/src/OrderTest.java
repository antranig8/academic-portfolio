import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * OrderTest class that checks some of the functions in Order class
 */
class OrderTest {
	private Order order;

	@BeforeEach
	void setUp() throws Exception {
		// New order with deadline of 5
		order = new Order("A", 5);
	}

	@AfterEach
	void tearDown() throws Exception {
		order = null;
	}

	@Test
	final void testOrder() {
		assertNotNull(order);
		assertEquals("A", order.getId());
		assertEquals(5, order.getDeadlineMinute());
	}

	@Test
	final void testSetArrivalMinute() {
		order.setArrivalMinute(3);
		assertEquals(3, order.getArrivalMinute());
	}

	@Test
	final void testSetDeadlineMinute() {
		assertEquals(5, order.getDeadlineMinute());
		// create new order
		Order orderB = new Order("B", 3);
		assertEquals(3, orderB.getDeadlineMinute());
	}

	@Test
	final void testGetArrivalMinute() {
		// check default arrival minute
		assertEquals(-1, order.getArrivalMinute());
		// check after setting
		order.setArrivalMinute(4);
		assertEquals(4, order.getArrivalMinute());
	}

	@Test
	final void testGetDeadlineMinute() {
		assertEquals(5, order.getDeadlineMinute());
	}

	@Test
	final void testGetId() {
		assertEquals("A", order.getId());
	}

	@Test
	final void testToString() {
		// Set to string
		String string = order.toString();
		// check if its not null
		assertNotNull(string);
		// check if it contains the orderId
		assertTrue(string.contains("A"));
	}

}
