import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// Junit 5 test class for DictionaryEntry
class DictionaryEntryTest {
	// fields for testing
	private DictionaryEntry entry1;
	private DictionaryEntry entry2;
	
	

	@BeforeEach
	void setUp() throws Exception {
		entry1 = new DictionaryEntry("example");
		entry2 = new DictionaryEntry("test");
	}

	@AfterEach
	void tearDown() throws Exception {
		entry1 = null;
		entry2 = null;
	}

	@Test
	final void testHashCode() {
		
	}

	@Test
	final void testDictionaryEntry() {
		// test for null word
		assertThrows(IllegalArgumentException.class, () -> {new DictionaryEntry(null); } ) ;
		// test for empty word
		assertThrows(IllegalArgumentException.class, () -> { new DictionaryEntry(""); } ) ;
		// test for valid word
		DictionaryEntry entry = new DictionaryEntry("Hello");
		assertEquals("hello", entry.getWord());
		assertEquals(1, entry.getFrequency());
	}

	@Test
	final void testGetWord() {
		assertEquals("example", entry1.getWord());
		assertEquals("test", entry2.getWord());
	}

	@Test
	final void testGetFrequency() {
		assertEquals(1, entry1.getFrequency());
		assertEquals(1, entry2.getFrequency());
		// increment frequency and test again
		entry1.incrementFrequency();
		assertEquals(2, entry1.getFrequency());
		// increment frequency multiple times
		entry2.incrementFrequency();
		entry2.incrementFrequency();
		assertEquals(3, entry2.getFrequency());
	}

	@Test
	final void testIncrementFrequency() {
		// test incrementing frequency
		int initialFreq = entry1.getFrequency();
		entry1.incrementFrequency();
		assertEquals(initialFreq + 1, entry1.getFrequency());
	}

	@Test
	final void testEqualsObject() {
		// test equality with same word
		DictionaryEntry entryCopy = new DictionaryEntry("example");
		assertTrue(entry1.equals(entryCopy));
		// test inequality with different word
		assertFalse(entry1.equals(entry2));
		// test inequality with null
		assertFalse(entry1.equals(null));
		// test equality with same reference
		assertTrue(entry1.equals(entry1));
	}

	@Test
	final void testToString() {
		// test string representation
		assertEquals("example: 1", entry1.toString());
		assertEquals("test: 1", entry2.toString());
		// increment frequency and test again
		entry1.incrementFrequency();
		assertEquals("example: 2", entry1.toString());
	}

}
