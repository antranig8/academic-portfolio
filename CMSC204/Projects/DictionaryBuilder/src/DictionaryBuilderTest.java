import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DictionaryBuilderTest {
	private DictionaryBuilder dictionary;
	@BeforeEach
	void setUp() throws Exception {
		dictionary = new DictionaryBuilder(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		dictionary = null;
	}
	
	@Test
	final void testAddAndGetFrequency() {
		// add words and check frequencies
		dictionary.addWord("Hello");
		dictionary.addWord("Hello");
		dictionary.addWord("World");
		assertEquals(2, dictionary.getFrequency("Hello"));
		assertEquals(1, dictionary.getFrequency("World"));
		assertEquals(0, dictionary.getFrequency("NonExistent"));
	}
	
	@Test
	void testAddWordAndParsesCorrectly() {
		// add word with punctuation and check frequency
		dictionary.addWord("Hello,!");
		assertEquals(1, dictionary.getFrequency("hello"));
		// add more of the same word in different cases
		dictionary.addWord("HELLO");
		dictionary.addWord("helLO';!");
		assertEquals(3, dictionary.getFrequency("hello"));
		// make sure the unique word count is correct
		assertEquals(1, dictionary.getUniqueWords());
	}
	
	@Test
	void testGetFrequencyNullAndEmpty() {
		// add words that should not be counted
		dictionary.addWord(null);
		dictionary.addWord("");
		dictionary.addWord("!!!");
		// test null input
		assertEquals(0, dictionary.getFrequency(null));
		// test empty string input
		assertEquals(0, dictionary.getFrequency(""));
		// test string with only punctuation
		assertEquals(0, dictionary.getFrequency("!!!"));
	}
	
	@Test
	void testGetFrequencyAfterNotFound() {
		// add some words
		dictionary.addWord("Test");
		dictionary.addWord("Example");
		// check frequency of a word not added
		assertEquals(0, dictionary.getFrequency("Missing"));
	}
	
	@Test
	void testGetFrequencyAndDuplicates() {
		// add duplicate words
		dictionary.addWord("Duplicate");
		dictionary.addWord("duplicate");
		dictionary.addWord("DUPLICATE");
		// check frequency
		assertEquals(3, dictionary.getFrequency("duplicate"));
		// check unique word count
		assertEquals(1, dictionary.getUniqueWords());
	}
	
	@Test
	void testRemoveWord() throws DictionaryEntryNotFoundException {
		// add and remove a word
		dictionary.addWord("test");
		assertEquals(1, dictionary.getFrequency("test"));
		// remove the word
		dictionary.removeWord("test");
		// check frequency is now 0
		assertEquals(0, dictionary.getFrequency("test"));
		// check unique word count is 0
		assertEquals(0, dictionary.getUniqueWords());
		// check total word count is 0
		assertEquals(0, dictionary.getTotalWords());
	}
	
	@Test
	void testRemoveWordMultiple() throws DictionaryEntryNotFoundException {
		// add the same word multiple times
		dictionary.addWord("repeat");
		dictionary.addWord("repeat");
		dictionary.addWord("repeat");
		assertEquals(3, dictionary.getFrequency("repeat"));
		// remove the word
		dictionary.removeWord("repeat");
		// check frequency is now 0
		assertEquals(0, dictionary.getFrequency("repeat"));
		// check unique word count is 0
		assertEquals(0, dictionary.getUniqueWords());
		// check total word count is 0
		assertEquals(0, dictionary.getTotalWords());
	}
	
	@Test
	void testRemoveWordNotFound() {
		// attempt to remove a word that doesn't exist
		assertThrows(DictionaryEntryNotFoundException.class, () -> {
			dictionary.removeWord("nonexistent");
		});
	}
	
	@Test
	void testRemoveWordNullAndEmpty() {
		// attempt to remove null
		assertThrows(DictionaryEntryNotFoundException.class, () -> {
			dictionary.removeWord(null);
		});
		// attempt to remove empty string
		assertThrows(DictionaryEntryNotFoundException.class, () -> {
			dictionary.removeWord("");
		});
		// attempt to remove string with only punctuation
		assertThrows(DictionaryEntryNotFoundException.class, () -> {
			dictionary.removeWord("!!!");
		});
	}
	
	@Test
	void testGetAllWords() {
		// add multiple words
		dictionary.addWord("grape");
		dictionary.addWord("apple");
		dictionary.addWord("tomato");
		// get all words
		java.util.List<String> words = dictionary.getAllWords();
		// check size and contents
		assertEquals(3, words.size());
		assertTrue(words.contains("apple"));
		assertTrue(words.contains("grape"));
		assertTrue(words.contains("tomato"));
	}
	
	@Test
	void testGetAllWordsEmptyDictionary() {
		// get all words from an empty dictionary
		java.util.List<String> words = dictionary.getAllWords();
		// check that the list is empty
		assertTrue(words.isEmpty());
	}
	
	@Test
	void testGetAllWordsSortedOrder() {
		// add words in random order
		dictionary.addWord("banana");
		dictionary.addWord("apple");
		dictionary.addWord("cherry");
		// get all words
		java.util.List<String> words = dictionary.getAllWords();
		// check that the words are in sorted order
		assertEquals("apple", words.get(0));
		assertEquals("banana", words.get(1));
		assertEquals("cherry", words.get(2));
	}
	
	@Test
	void testGetUniqueWords() {
		// add words
		dictionary.addWord("one");
		dictionary.addWord("two");
		dictionary.addWord("two");
		dictionary.addWord("three");
		dictionary.addWord("three");
		dictionary.addWord("three");
		// check unique word count
		assertEquals(3, dictionary.getUniqueWords());
	}
	
	@Test
	void testGetTotalWords() {
		// add words
		dictionary.addWord("one");
		dictionary.addWord("two");
		dictionary.addWord("two");
		dictionary.addWord("three");
		dictionary.addWord("three");
		dictionary.addWord("three");
		// check total word count
		assertEquals(6, dictionary.getTotalWords());
	}
	
	@Test
	void estimatedLoadFactorTest() {
		dictionary.addWord("one");
		dictionary.addWord("two");
		dictionary.addWord("three");
		// check estimated load factor
		double expectedLoadFactor = (double) dictionary.getUniqueWords() / (double) dictionary.getTableSize();
		assertEquals(expectedLoadFactor, dictionary.estimatedLoadFactor(), 0.0001);
	}
}
