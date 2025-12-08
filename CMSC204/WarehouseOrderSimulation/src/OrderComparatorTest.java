import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * OrderComparatorTest to run the tests
 */
class OrderComparatorTest {
	// Set up the fields
	private OrderComparator cmp;
	private Order a, b, early, late;

	@BeforeEach
	void setUp() throws Exception {
		// Create comparator
		cmp = new OrderComparator();
		// Create orders
		a = new Order("A",2);
		a.setArrivalMinute(3);
		
		b = new Order("B",3);
		b.setArrivalMinute(0);
		
		early = new Order("E",5);
		early.setArrivalMinute(1);
		
		late = new Order("L",5);
		late.setArrivalMinute(2);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Set everything to null
		cmp = null;
		a = b = early = late = null;
	}

	@Test
	public void testEarlierDeadline() {
		// A has an earlier deadline than B
		assertTrue(cmp.compare(a, b) < 0);
	}
	
	@Test
	public void testTieOnDeadline() {
		// early and late have same deadline
		assertTrue(cmp.compare(early, late) < 0);
	}
	
	@Test
	public void testAllEqual() {
		// When all the deadlines and arrivals are equal
		a.setArrivalMinute(2);
		a.setDeadlineMinute(2);
		b.setArrivalMinute(2);
		b.setDeadlineMinute(2);
		assertEquals(0, cmp.compare(a, b));
	}

}
