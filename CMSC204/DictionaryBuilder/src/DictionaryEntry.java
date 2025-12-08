/**
 * DictionaryEntry class represents a single entry in a dictionary.
 * represents a single word stored in the dictionary and its frequency.
 */
public final class DictionaryEntry {
	// fields
	private final String word;
	private int frequency;
	
	/**
	 * Constructor that initializes the word and frequency
	 * @param word the word to store in the dictionary entry
	 */
	public DictionaryEntry(String word) {
		// check for null or empty word
		if(word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Word cannot be null or empty.");
		}
		// store word in lowercase
		String w = word.toLowerCase();
		this.word = w;
		this.frequency = 1; // initial frequency is 1
	}
	/**
	 * getWord method that returns the word
	 * @return the word stored in the dictionary entry
	 */
	public String getWord() {
		return this.word;
	}
	/**
	 * getFrequency method that returns the frequency
	 * @return the frequency of the word
	 */
	public int getFrequency() {
		return this.frequency;
	}
	/**
	 * incrementFrequency method that increases the frequency by 1
	 */
	public void incrementFrequency() {
		this.frequency++;
	}
	
	/**
	 * Override equals method to compare DictionaryEntry objects based on word
	 * @param obj the object to compare with
	 * @return true if the words are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		// check for same reference
		if(this == obj) {
			return true;
		}
		// check for null
		if(obj == null) {
			return false;
		}
		// check for same class
		if(!(obj instanceof DictionaryEntry)) {
			return false;
		}
		// cast to DictionaryEntry and compare words
		DictionaryEntry other = (DictionaryEntry) obj;
		// compare words for equality and return result
		return this.word.equals(other.word);
	}
	
	/**
	 * Override hashCode method
	 * @return hash code based on the word
	 */
	@Override
	public int hashCode() {
		return word.hashCode();
	}
	
	/**
	 * Override toString method 
	 * @return word and frequency as a string
	 */
	@Override
	public String toString() {
		return word + ": " + frequency;
	}
	
}
