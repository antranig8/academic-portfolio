import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * MyPriorityQueueTest to test all methods for MyPriorityQueue class
 */
class MyPriorityQueueTest {
	// Setup fields
	private MyPriorityQueue<Order> priorityq;
	private Comparator<Order> cmp;
	@BeforeEach
	void setUp() throws Exception {
		cmp = new OrderComparator();
		priorityq = new MyPriorityQueue<>(cmp);
	}

	@AfterEach
	void tearDown() throws Exception {
		priorityq = null;
		cmp = null;
	}

	@Test
	final void testMyPriorityQueue() {
		assertNotNull(priorityq);
		assertTrue(priorityq.isEmpty());
		assertEquals(0, priorityq.size());
	}

	@Test
	final void testEnqueue() {
		// Create orders
		Order a = new Order("A", 5);
		a.setArrivalMinute(1);
		
		Order b = new Order("B",5);
		b.setArrivalMinute(2);
		
		Order c = new Order("C",3);
		c.setArrivalMinute(3);
		// Add all orders to priority queue
		priorityq.enqueue(a);
		priorityq.enqueue(b);
		priorityq.enqueue(c);
		
		// Check the queue size
		assertEquals(3, priorityq.size());
		// Check if B is at the top of the queue
		assertEquals("C", priorityq.peek().getId());
	}

	@Test
	final void testDequeue() {
		// Create orders
		Order a = new Order("A", 5);
		a.setArrivalMinute(1);
				
		Order b = new Order("B",4);
		b.setArrivalMinute(2);
				
		Order c = new Order("C",5);
		c.setArrivalMinute(3);
		// Add all orders to priority queue
		priorityq.enqueue(a);
		priorityq.enqueue(b);
		priorityq.enqueue(c);
		// Start dequing
		assertEquals("B", priorityq.dequeue().getId());
		assertEquals("A", priorityq.dequeue().getId());
		assertEquals("C", priorityq.dequeue().getId());
	}

	@Test
	final void testPeek() {
		// Create orders
		Order a = new Order("A", 5);
		a.setArrivalMinute(1);
				
		Order b = new Order("B",4);
		b.setArrivalMinute(2);
		// Add orders
		priorityq.enqueue(a);
		priorityq.enqueue(b);
		
		// Check if peek looks at first in queue
		assertEquals("B", priorityq.peek().getId());
	}

	@Test
	final void testIsEmpty() {
		// check if empty
		assertTrue(priorityq.isEmpty());
		// add order
		Order a = new Order("A", 5);
		priorityq.enqueue(a);
		// check if empty
		assertFalse(priorityq.isEmpty());
		// deque
		priorityq.dequeue();
		// check if empty
		assertTrue(priorityq.isEmpty());
	}

	@Test
	final void testSize() {
		// Check size
		assertEquals(0, priorityq.size());
		// add orders
		Order a = new Order("A", 5);
		Order b = new Order("B", 6);
		priorityq.enqueue(a);
		priorityq.enqueue(b);
		// check size again
		assertEquals(2, priorityq.size());
		// deque then check size
		priorityq.dequeue();
		assertEquals(1, priorityq.size());
	}
	
	@Test
	final void testExceptions() {
		// for null queue
		assertThrows(IllegalArgumentException.class, () -> priorityq.enqueue(null));
		// for trying to peek when there is nothing
		assertThrows(NoSuchElementException.class, () -> priorityq.peek());
		// trying to dequeue nothing
		assertThrows(NoSuchElementException.class, () -> priorityq.dequeue());
	}

	@Test
	final void testToArray() {
		// Add orders
		Order a = new Order("A", 5);
		Order b = new Order("B", 5);
		priorityq.enqueue(a);
		priorityq.enqueue(b);
		// send queue to array
		Object[] array = priorityq.toArray();
		assertEquals(2, array.length);
		assertEquals("[A, B]", Arrays.toString(array));
		}

}
