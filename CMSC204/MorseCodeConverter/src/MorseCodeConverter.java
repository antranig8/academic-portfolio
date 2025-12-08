import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * MorseCodeConverter utility class
 */
public class MorseCodeConverter {
	// fields
	private static MorseCodeTree tree = new MorseCodeTree();
	// Constructor
	public MorseCodeConverter() {
		if(tree == null) {
			tree = new MorseCodeTree();
		}
	}
	/**
	 * convertToEnglish method that converts morse code to english
	 * @param code the code to be translated to english
	 * @return string with convereted morse code to english
	 */
	public static String convertToEnglish(String code) {
		// create a stringbuilder to hold all the chars
		StringBuilder converted = new StringBuilder();
		
		//split the words by '/' and put into an array
		String[] words = code.trim().split("\\s*/\\s*");
		for(int index = 0; index < words.length; index++) {
			if(index > 0) {
				converted.append(" ");
			}
			// now split letters by spaces
			String[] letters = words[index].trim().split("\\s+");
			// store them
			for(String letter : letters) {
				if(!letter.isEmpty()) {
					// use the tree to translate each code to a letter
					String translated = tree.fetch(letter);
					if(translated != null && !translated.isEmpty()) {
						converted.append(translated);
					}
				}
			}
		}
		// return the converted string 
		return converted.toString();
	}
	/**
	 * convertToEnglish method that converts file of morse code into english
	 * Each letter is delimited by a space ' ' each word is delimted by a '/'
	 * @param codeFile
	 * @return convertToEnglish method that will return the converted morse code
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		// create the stringbuilder to hold chars
		StringBuilder converted = new StringBuilder();
		// create scanner to read the file
		try(Scanner fileScanner = new Scanner(codeFile)){
			// go through each line
			while(fileScanner.hasNextLine()) {
				// append each line to the stringbuilder
				converted.append(fileScanner.nextLine()).append(" ");
			}
		}
		// call the other convert method to return the converted string
		return convertToEnglish(converted.toString());
	}
	/**
	 * printTree method prints the tree that was formed in LNR order
	 * @return string with all data in the tree
	 */
	public static String printTree() {
		// create the stringbuilder and arrayList to hold tree
		StringBuilder result = new StringBuilder();
		ArrayList<String> list = tree.toArrayList();
		// traverse through tree
		for(int index = 0; index < list.size(); index++) {
			result.append(list.get(index));
			if(index < list.size() -1 ) {
				result.append(" ");
			}
		}
		// return the resulting print
		return result.toString().trim();
	}
}
