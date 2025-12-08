import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * JUnit test cases for all methods inside MyStack
 */
class MyStackTest {
	// Create fields for test
	private MyStack<String> stack;

	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}
	
	// Check if the stack is created successfully
	@Test
	final void testMyStack() {
		assertNotNull(stack);
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	// Test adding something to stack
	@Test
	final void testPush() {
		// add A and check the stack
		stack.push("A");
		assertEquals(1, stack.size());
		assertEquals("A", stack.peek());
		
		// add B to stack and check again
		stack.push("B");
		assertEquals(2, stack.size());
		assertEquals("B", stack.peek());
	}

	@Test
	final void testPop() {
		stack.push("A");
		stack.push("B");
		// Check if B is returned after pop
		assertEquals("B", stack.pop());
		assertEquals(1, stack.size());
		// Pop A and check if stack is empty
		assertEquals("A", stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	// Check if the peek checks top of stack
	@Test
	final void testPeek() {
		stack.push("A");
		assertEquals("A", stack.peek());
		
		// add B to stack and check again
		stack.push("B");
		assertEquals("B", stack.peek());
		assertEquals(2, stack.size());
	}

	@Test
	final void testIsEmpty() {
		// run multiple checks to see if its empty
		assertTrue(stack.isEmpty());
		stack.push("A");
		// 
		assertFalse(stack.isEmpty());
		// Pop the top of stack
		stack.pop();
		// check if stack is empty
		assertTrue(stack.isEmpty());
	}

	@Test
	final void testSize() {
		assertEquals(0, stack.size());
		stack.push("A");
		assertEquals(1, stack.size());
		stack.push("B");
		assertEquals(2, stack.size());
		stack.pop();
		assertEquals(1, stack.size());
	}
	
	@Test
	final void testExceptions() {
		// for null push to stack
		assertThrows(IllegalArgumentException.class, () -> stack.push(null));
		// for trying to add to a full stack
		for(int index = 0; index < 10; index++) {
			stack.push("Test" + index);
		}
		assertThrows(IllegalStateException.class, () -> stack.push("Test"));
		// Trying to pop an empty stack
		MyStack<String> testStack = new MyStack<>();
		assertThrows(NoSuchElementException.class, () -> testStack.pop());
		// peeking on empty stack
		assertThrows(NoSuchElementException.class, () -> testStack.peek());
	}

	@Test
	final void testToArray() {
		// Create a stack
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		// Send stack to array
		Object[] array = stack.toArray();
		// Check if the array toString is the same
		assertEquals("[A, B, C, D, E]", Arrays.toString(array));
	}

}
