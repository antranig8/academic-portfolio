import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {
	MorseCodeTree tree = new MorseCodeTree();
	@BeforeEach
	void setUp() throws Exception {
		MorseCodeTree tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		MorseCodeTree tree = null;
	}
	
	
	// Test cases
	@Test
	final void testFetch() {
		// test if basic fetches work
		assertEquals("e", tree.fetch("."));
		assertEquals("t", tree.fetch("-"));
		assertEquals("s", tree.fetch("..."));
		assertEquals("o", tree.fetch("---"));
		assertEquals("h", tree.fetch("...."));
		assertEquals("a", tree.fetch(".-"));
		assertEquals("x", tree.fetch("-..-"));
	}
	// Test for insert method
	@Test
	final void testInsert() {
		// insert a word and test if it can be fetched
		tree.insert("...---...", "sos");
		assertEquals("sos", tree.fetch("...---..."));
		// insert another word
		tree.insert("......-...-..---", "hello");
		assertEquals("hello", tree.fetch("......-...-..---"));
		// test case for one letter
		tree.insert("....", "h");
		assertEquals("h", tree.fetch("...."));
	}
	// test for toArrayList method
	@Test
	final void testToArrayList() {
		// test if the toArrayList method returns the correct number of elements
		assertEquals(27, tree.toArrayList().size());
		// test if the first few elements are correct
		assertEquals("h", tree.toArrayList().get(0));
		assertEquals("s", tree.toArrayList().get(1));
		assertEquals("v", tree.toArrayList().get(2));
		assertEquals("i", tree.toArrayList().get(3));
		assertEquals("f", tree.toArrayList().get(4));
		// add a new element and test if the size increases
		tree.insert("...---...", "sos");
		assertEquals(28, tree.toArrayList().size());
	}
	@Test
	final void testInvalidCodeReturnsNull() {
		// test if fetching an invalid code returns null
		assertNull(tree.fetch("......"));
		assertNull(tree.fetch("-.--.-"));
		assertNull(tree.fetch("...-..-"));
		assertNull(tree.fetch("---x"));
	}
	@Test
	final void testEmptyCodeReturnsNothing() {
		// test if fetching an empty code returns nothing
		// Empty tree should exist
		assertEquals("", tree.fetch(""));
	}
}
