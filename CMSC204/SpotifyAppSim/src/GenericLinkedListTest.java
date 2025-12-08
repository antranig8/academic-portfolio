import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericLinkedListTest {
	private GenericLinkedList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new GenericLinkedList<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	final void testConstructor() {
		// Test that the constructor creates an empty list
		assertNotNull(list);
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	final void testGetFirst() {
		list.addLast(1);
	    list.addLast(2);
	    assertEquals(1, list.getFirst());
	    assertEquals(2, list.size());
	    // remove head
	    assertEquals(1, list.remove(0));
	    assertEquals(1, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals(2, list.getFirst());
	    // remove head again, should be empty now
	    assertEquals(2, list.remove(0));
	    assertEquals(0, list.size());
	    assertTrue(list.isEmpty());
	    // now getFirst should throw exception
		assertThrows(NoSuchElementException.class, () -> { list.getFirst(); } );
	}

	@Test
	final void testGetLast() {
		list.addLast(1);
	    list.addLast(2);
	    assertEquals(2, list.getLast());
	    assertEquals(2, list.size());
	    // remove last
	    assertEquals(2, list.remove(1));
	    assertEquals(1, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals(1, list.getLast());
	    // remove last again, should be empty now
	    assertEquals(1, list.remove(0));
	    assertEquals(0, list.size());
	    assertTrue(list.isEmpty());
	    // now getLast should throw exception
		assertThrows(NoSuchElementException.class, () -> { list.getLast(); } );
	}

	@Test
	final void testSize() {
		// Make sure size is being tracked correctly
		assertEquals(0, list.size());
		list.addLast(1);
		assertEquals(1, list.size());
		list.addLast(2);
		assertEquals(2, list.size());
		list.remove(0);
		assertEquals(1, list.size());
		list.remove(0);
		assertEquals(0, list.size());
	}

	@Test
	final void testAddFirst() {
		// Make sure add first works correctly
		list.addFirst(1);
		list.addFirst(2);
		Object[] arr = list.toArray();
		assertEquals(2, arr[0]);
		assertEquals(1, arr[1]);
	}

	@Test
	final void testAddLast() {
		// Make sure add last works correctly
		list.addLast(1);
		list.addLast(2);
		Object[] arr = list.toArray();
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
	}

	@Test
	final void testContains() {
		// Test contains method
		list.addLast(1);
		list.addLast(2);
		assertTrue(list.contains(1));
		assertFalse(list.contains(3));
		assertTrue(list.contains(2));
	}

	@Test
	final void testGet() {
		// Test getting by index
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
	}

	@Test
	final void testRemoveInt() {
		// Test removing by index
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		assertEquals(2, list.remove(1));
		assertEquals(2, list.size());
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
	}

	@Test
	final void testRemoveT() {
		// Test removing by value
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		assertTrue(list.remove((Integer)2));
		assertEquals(2, list.size());
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
		assertFalse(list.remove((Integer)4));
	}

	@Test
	final void testToArray() {
		// Test toArray
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
		assertEquals(3, arr[2]);
	}
	
	@Test
	final void testIsEmpty() {
		// Test isEmpty
		assertTrue(list.isEmpty());
		list.addLast(1);
		assertFalse(list.isEmpty());
		list.remove(0);
		assertTrue(list.isEmpty());
	}
	
	@Test
	final void testClear() {
		// Test clearing the list
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		assertEquals(3, list.size());
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	final void getFirstOnEmtyList() {
		// Test getting first on empty list
		assertThrows(NoSuchElementException.class, () -> { list.getFirst(); } );
	}
	
	@Test
	final void getLastOnEmtyList() {
		// Test getting last on empty list
		assertThrows(NoSuchElementException.class, () -> { list.getLast(); } );
	}
	
	@Test
	final void removeOnEmptyList() {
		// Test removing from empty list
		assertThrows(IndexOutOfBoundsException.class, () -> { list.remove(0); } );
	}
	
	@Test
	final void iteratorHasNext() {
		// Test hasNext on a normal list
		list.addLast(1);
		list.addLast(2);
		ListIterator<Integer> iterator = list.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	final void iteratorNextOnEmptyList() {
		// Test calling next on empty list
		ListIterator<Integer> iterator = list.iterator();
		assertThrows(NoSuchElementException.class, () -> { iterator.next(); } );
	}
	
	@Test
	final void iteratorNextOutOfBounds() {
		// Test calling next, and going out of bounds
		list.addLast(1);
		ListIterator<Integer> iterator = list.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.next());
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> { iterator.next(); } );
	}
	
	@Test
	final void iteratorRemove() {
		// Test removing elements with iterator and checking list
		list.addLast(1);
		list.addLast(2);
		ListIterator<Integer> iterator = list.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.next());
		iterator.remove();
		assertEquals(1, list.size());
		assertEquals(2, list.get(0));
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.next());
		iterator.remove();
		assertEquals(0, list.size());
		assertFalse(iterator.hasNext());
		assertThrows(IllegalStateException.class, () -> { iterator.remove(); } );
	}

}
