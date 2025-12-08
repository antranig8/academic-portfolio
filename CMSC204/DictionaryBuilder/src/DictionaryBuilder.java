/**
 * DictionaryBuilder class for building the dictionary.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DictionaryBuilder {
	// fields
	private GenericLinkedList<DictionaryEntry>[] table;
	private int tableSize;
	private int uniqueWords;
	private int totalWords;
	public static final double LOAD_FACTOR = 0.6;
	/**
	 * Constructor that initializes the dictionary builder with estimated unique words
	 * @param estimatedUnique the estimated number of unique words
	 */
	public DictionaryBuilder(int estimatedUnique) {
		// make sure the estimated unique is = 1 
		if(estimatedUnique < 1) {
			estimatedUnique = 1;
		}
		// calculate table size using next 4k + 3 prime
		int size = (int) (estimatedUnique / LOAD_FACTOR);
		// get next 4k + 3 prime for table size
		this.tableSize = getNext4kPlus3(size);
		// initialize the table
		this.table = new GenericLinkedList[this.tableSize];
		// initialize unique and total words
		for(int i = 0; i < this.tableSize; i++) {
			this.table[i] = new GenericLinkedList<DictionaryEntry>();
		}
		// initialize unique and total words
		this.uniqueWords = 0;
		this.totalWords = 0;
	}
	/**
	 * Constructor that initializes the dictionary builder from a file
	 * @param filename the name of the file to read words from
	 * @throws FileNotFoundException
	 */
	public DictionaryBuilder(String filename) throws FileNotFoundException {
		// store file
		File file = new File(filename);
		//check for file validity
		if(!file.exists()) {
			throw new FileNotFoundException("File not found.");
		}
		// Otherwise, estimate the table size
		// Get the file size in BYTEs
		double fileSize = file.length();
		// get estimated unique words as doc describes 
		// unique words = file size in bytes / 100
		int estimatedUnique = (int)(fileSize/100);
		// make sure its atleast 1
		if(estimatedUnique < 1) {
			estimatedUnique = 1;
		}
		// calculate the tableSize
		// table size = Estimated unique words / 0.6
		int size = (int)(estimatedUnique / LOAD_FACTOR);
		// once size is computed we need to find the next smallest prime number in 4k+3 form
		// set it to tableSize
		this.tableSize = getNext4kPlus3(size);
		// Now we can create the table
		this.table = (GenericLinkedList<DictionaryEntry>[]) new GenericLinkedList[tableSize];
		// step through and create a linked list(bucket) for tableSize
		for(int index = 0; index < tableSize; index++) {
			// create a linked list for every entry
			table[index] = new GenericLinkedList<DictionaryEntry>();
		}
		// initialize unique and total words
		this.uniqueWords = 0;
		this.totalWords = 0;
		// Now read the words from the file
		try(Scanner scanner = new Scanner(file)){
			while(scanner.hasNext()) {
				// add all the words to the dictionary
				String word = scanner.next();
				addWord(word);
			}
		}
	}
	
	/**
	 * addWord method that adds a word to the dictionary
	 * if it already exists, increments its frequency
	 * @param word the word to add
	 */
	public void addWord(String word) {
		// check for null
		if(word == null) {
			return;
		}
		// clean the word up for only lowercase letters
		String w = word.toLowerCase().replaceAll("[^a-z]", "");
		// Check if the word is empty
		if(w.isEmpty()) {
			return;
		}
		// set the words index
		int index = (w.hashCode() % tableSize);
		// Make sure its non negative
		if(index < 0) {
			index = (index * -1);
		}
		// hash it to the linked list(bucket)
		GenericLinkedList<DictionaryEntry> bucket = table[index];
		// create a copy of the word
		DictionaryEntry copy = new DictionaryEntry(w);
		// see if there is already another
		DictionaryEntry check = bucket.get(copy);
		//if there is another 
		if(check != null) {
			check.incrementFrequency();
		}
		else {
			bucket.addFirst(new DictionaryEntry(w));
			uniqueWords++;
		}
		totalWords++;
	}
	/**
	 * getFrequency method that returns the frequency of a word
	 * @param word the word to check
	 * @return the frequency of the word
	 */
	public int getFrequency(String word){
		// check for null
		if(word == null) {
			return 0;
		}
		// clean the word up for only lowercase letters
		String w = word.toLowerCase().replaceAll("[^a-z]", "");
		// Check if the word is empty
		if(w.isEmpty()) {
			return 0;
		}
		// set the words index
		int index = (w.hashCode() % tableSize);
		// Make sure its non negative
		if(index < 0) {
			index = (index * -1);
		}
		// hash it to the linked list(bucket)
		GenericLinkedList<DictionaryEntry> bucket = table[index];
		// create a copy of the word
		DictionaryEntry copy = new DictionaryEntry(w);
		// see if there is already another
		DictionaryEntry found = bucket.get(copy);
		//if not found return 0
		if(found == null) {
			return 0;
		}
		// if its found return the frequency
		return found.getFrequency();
	}
	/**
	 * removeWord method that removes a word from the dictionary
	 * @param word the word to remove
	 * @throws DictionaryEntryNotFoundException if the word is not found
	 */
	public void removeWord(String word) throws DictionaryEntryNotFoundException{
		// check for null
		if(word == null) {
			throw new DictionaryEntryNotFoundException("Word cannot be null.");
		}
		// clean the word up for only lowercase letters
		String w = word.toLowerCase().replaceAll("[^a-z]", "");
		// Check if the word is empty
		if(w.isEmpty()) {
			throw new DictionaryEntryNotFoundException("Word cannot be empty.");
		}
		// check if dictionary is empty
		if(uniqueWords == 0) {
			throw new DictionaryEntryNotFoundException("Dictionary is empty.");
		}
		// set the words index
		int index = (w.hashCode() % tableSize);
		// Make sure its non negative
		if(index < 0) {
			index = (index * -1);
		}
		// hash it to the linked list(bucket)
		GenericLinkedList<DictionaryEntry> bucket = table[index];
		// create a copy of the word
		DictionaryEntry copy = new DictionaryEntry(w);
		// see if there is already another
		DictionaryEntry found = bucket.get(copy);
		//if not found throw exception
		if(found == null) {
			throw new DictionaryEntryNotFoundException("Word: " + w + " is not in the dictionary.");
		}
		// if it was found reduce total and unique words
		totalWords -= found.getFrequency();
		uniqueWords--;
		// remove it from the bucket
		bucket.remove(found);
	}
	/**
	 * getAllWords method that returns all words in the dictionary in alphabetical order
	 * @return a sorted list of all words in the dictionary
	 */
	public List<String> getAllWords(){
		// create an array list to store the words
		ArrayList<String> wordsList = new ArrayList<String>();
		// check if the dictionary is empty
		if(uniqueWords == 0) {
			// returns an empty list
			return wordsList;
		}
		// step through each bucket in the table
		for(int index = 0; index < tableSize; index++) {
			// get all entries in the bucket
			Object[] entries = table[index].toArray();
			// 
			for(Object entry : entries) {
				// cast and set the object as a dictionary entry
				DictionaryEntry e = (DictionaryEntry) entry;
				// add it to the list of words
				wordsList.add(e.getWord());
			}
		}
		// make it alphabetical
		Collections.sort(wordsList);
		// return the list
		return wordsList;
	}
	// methods for prime checking and finding next 4k + 3 prime
	/**
	 * isPrime method that checks if a number is prime uisng 6k +/- 1 
	 * @param n the number to check
	 * @return true if prime, false otherwise
	 */
	private static boolean isPrime(int n) {
		// first check for n <= 1
		if(n <= 1) {
			return false;
		}
		// check for 2 and 3
		if (n == 2 || n == 3) {
			return true;
		}
		// then check for multiples of 2 and 3
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		// check for other factors
		for (int index = 5; index * index <= n; index += 6) {
			if (n % index == 0 || n % (index + 2) == 0) {
				return false;
			}
		}
		// if no factors found its prime so retuyrn true
		return true;
	}
	/**
	 * getNext4kPlus3 method that returns the next prime number using 4k + 3
	 * @param n the number to start from
	 * @return the next prime number >= n
	 */
	private static int getNext4kPlus3(int n) {
		// check for n <= 3
		if(n <= 3) {
			return 3;
		}
		// make n odd
		if(n % 2 == 0) {
			n++;
		}
		// loop until there is a prime that is 4k + 3
		while(!isPrime(n) || n % 4 != 3) {
			// increment by 2
			n += 2;
		}
		// return n
		return n;
	}
	// Simple getters
	public int getTotalWords() {
		return totalWords;
	}
	public int getUniqueWords() {
		return uniqueWords;
	}
	public int getTableSize() {
		return tableSize;
	}
	/**
	 * method to get an estimated load factor based off of the unique words
	 * and the table size
	 */
	public double estimatedLoadFactor() {
		if(tableSize == 0) {
			return 0.0;
		}
		else {
			return (uniqueWords / (double)tableSize);
		}
	}
}