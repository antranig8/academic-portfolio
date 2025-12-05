/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Main class for CMSC203 Programming Assignment 3
 * Due: 07/07/2025
 * Platform/compiler: ECLIPSE IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Antranig Tatarian
*/
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 */


public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    // I included space to make it 64 characters because the given ALPHABET64 in the assignment description was incomplete.
    // given ALPHABET64: "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";
    // As you can see it has only 63 characters, I added space at the start to make it 64 characters, and to make the code actually work.
    private static final String ALPHABET64 = " ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";
    /**
	 * Checks to see if a string is within the defined bounds of characters.
	 * 
	 * @param plainText The string to check.
	 * @return true if all characters in the string are within the defined range, otherwise returns false.
	 */
    public static boolean isStringInBounds(String plainText) 
    {
        for (int i = 0; i < plainText.length(); i++) 
        {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) 
            {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   
    
    /**
	 * Encrypts plaintext using the Vigenere cipher with specified key
	 * 
	 * @param plainText The text to be encrypted.
	 * @param key The keyword used for encryption.
	 * @return The encrypted text.
	 */
    public static String vigenereEncryption(String plainText, String key) 
    {	
    	// Check if the input string is within the defined bounds
         if(!isStringInBounds(plainText)) 
         {
			return "The Selected String is not in bounds, please try again.";
         }
       // Char array to hold encrypted characters
       char[] encryptedArray = new char[plainText.length()];
       // Store the key length
       int keyIndex = key.length();
       // For loop to go through each character in the plainText
       for (int index = 0; index < plainText.length(); index++) 
	   	{
		   // Get the current character from the plainText
		   char currentChar = plainText.charAt(index);
		   // Get the corresponding character from the key
		   char keyChar = key.charAt(index % keyIndex);
		   // Calculate the shift value based on the key character
		   int shift = keyChar - LOWER_RANGE;
		   // Shift the plainChar forward
		   int shiftedValue = (currentChar - LOWER_RANGE + shift) % RANGE + LOWER_RANGE;
		   // store encrypted character in the array
		   encryptedArray[index] = (char)shiftedValue;
	     }
       // return the encrypted string
	   return new String(encryptedArray);
	   }
    /**
     * Decrypts encrypted text using the Vigenere cipher with specified key.
     * @param encryptedText The text to be decrypted.
     * @param key The keyword used for decryption.
     * @return The decrypted text.
     */
    public static String vigenereDecryption(String encryptedText, String key) 
    {
    	// Check if the input string is within the defined bounds
        if(!isStringInBounds(encryptedText)) 
        {
			return "The Selected String is not in bounds, please try again.";
        }
        // Char array to hold decrypted characters
        char[] decryptedArray = new char[encryptedText.length()];
        // Store the key length
        int keyIndex = key.length();
        // For loop to go through each character in the encryptedText
        for (int index = 0; index < encryptedText.length(); index++) 
		{
			// Get the current character from the encryptedText
			char encryptedChar = encryptedText.charAt(index);
			// Get the corresponding character from the key
			char keyChar = key.charAt(index % keyIndex);
			// Calculate the shift value based on the key character
			int shift = keyChar - LOWER_RANGE;
			// Shift the encryptedChar backward
			int shiftedValue = (encryptedChar - LOWER_RANGE - shift + RANGE) % RANGE + LOWER_RANGE;
			// Store decrypted character in the array
			decryptedArray[index] = (char)shiftedValue;
		}
        // Return the decrypted string
		return new String(decryptedArray);
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    
    
    /**
	 * Encrypts plaintext using the Playfair cipher with specified key.
	 * 
	 * @param plainText The text to be encrypted.
	 * @param key The keyword used for encryption.
	 * @return The encrypted text.
	 */
    public static String playfairEncryption(String plainText, String key) 
    {
        // Check if the input string is within the defined bounds
		if(!isStringInBounds(plainText)) 
		{
			return "The Selected String is not in bounds, please try again.";
		}
		// Pad with X if odd length
	    if (plainText.length() % 2 != 0) {
	        plainText += "X";
	    }
	    
		// Build an 8x8 matrix using the key
		char[][] matrix = new char[8][8];
		// Fill the matrix with characters from the key
		boolean[] used = new boolean[RANGE];
		// row and col variables to track the position in the matrix
		int row = 0, col = 0;
		
		// Add characters from the key to the matrix
		for (int i = 0; i < key.length(); i++) {
			// Get the current character from the key
	        char currentChar = key.charAt(i);
	        // Check if the character is within bounds
	        if (currentChar >= LOWER_RANGE && currentChar <= UPPER_RANGE) {
	        	// Calculate the index in the used array
	            int idx = currentChar - LOWER_RANGE;
	            // If the character is not used yet, add it to the matrix
	            if (!used[idx]) {
	                matrix[row][col] = currentChar;
	                used[idx] = true;
	                col++;
	                if (col == 8) {
	                    col = 0;
	                    row++;
	                }
	            }
	        }
	    }
		// Fill the remaining matrix with unused characters
		for (int i = 0; i < ALPHABET64.length(); i++) {
	        char c = ALPHABET64.charAt(i);
	        int idx = c - LOWER_RANGE;
	        if (!used[idx]) {
	            matrix[row][col] = c;
	            used[idx] = true;
	            col++;
	            if (col == 8) {
	                col = 0;
	                row++;
	            }
	        }
	    }
		// Encrypt the plaintext
		char[] encryptedArray = new char[plainText.length()];
		for (int index = 0; index < plainText.length(); index += 2) {
	        char firstChar = plainText.charAt(index);
	        char secondChar = plainText.charAt(index + 1);
	        // Create char variables to hold row and column positions
	        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
	        // Find positions
	        for (int r = 0; r < 8; r++) {
	            for (int c = 0; c < 8; c++) {
	                if (matrix[r][c] == firstChar) {
	                    row1 = r;
	                    col1 = c;
	                }
	                if (matrix[r][c] == secondChar) {
	                    row2 = r;
	                    col2 = c;
	                }
	            }
	        }
		    // Apply the playfair encryption rules
		    // When in the same row replace each letter with the one to its right
		    if (row1 == row2) {
		    	encryptedArray[index] = matrix[row1][(col1 + 1) % 8];
	            encryptedArray[index + 1] = matrix[row2][(col2 + 1) % 8];
		    }
		    // if its in the same column move down
		    else if (col1 == col2) {
		    	 encryptedArray[index] = matrix[(row1 + 1) % 8][col1];
		         encryptedArray[index + 1] = matrix[(row2 + 1) % 8][col2];
		    }
		    // if its a rectangle swap the columns of the letters
		    else {
		    	encryptedArray[index] = matrix[row1][col2];
	            encryptedArray[index + 1] = matrix[row2][col1];
		    }
		}
		return new String(encryptedArray);
    }
    /** 
     * Decrypts encrypted text using the Playfair cipher with specified key. 
	 * @param encryptedText The text to be decrypted.
	 * @param key The keyword used for decryption.
	 * @return The decrypted text.
	 */
    public static String playfairDecryption(String encryptedText, String key) 
    {
        // Check if the input string is within the defined bounds
		if(!isStringInBounds(encryptedText)) 
		{
			return "The Selected String is not in bounds, please try again.";
		}

		// Build an 8x8 matrix using the key
		char[][] matrix = new char[8][8];
		// Fill the matrix with characters from the key
	    boolean[] used = new boolean[RANGE];
	    // row and col variables to track the position in the matrix
	    int row = 0, col = 0;
		
		// Add characters from the key to the matrix
	    for (int i = 0; i < key.length(); i++) {
	        char currentChar = key.charAt(i);
	        if (currentChar >= LOWER_RANGE && currentChar <= UPPER_RANGE) {
	            int idx = currentChar - LOWER_RANGE;
	            if (!used[idx]) {
	                matrix[row][col] = currentChar;
	                used[idx] = true;
	                col++;
	                if (col == 8) {
	                    col = 0;
	                    row++;
	                }
	            }
	        }
	    }
		// Fill the remaining matrix with unused characters
	    for (int i = 0; i < ALPHABET64.length(); i++) {
	        char c = ALPHABET64.charAt(i);
	        int idx = c - LOWER_RANGE;
	        if (!used[idx]) {
	            matrix[row][col] = c;
	            used[idx] = true;
	            col++;
	            if (col == 8) {
	                col = 0;
	                row++;
	            }
	        }
	    }
		// Store decrypted characters in an array
	    char[] decryptedArray = new char[encryptedText.length()];
	    
	    for (int index = 0; index < encryptedText.length(); index += 2) {
	        char firstChar = encryptedText.charAt(index);
	        char secondChar = encryptedText.charAt(index + 1);
	        // Create char variables to hold row and column positions
	        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
	        // Find positions
	        for (int r = 0; r < 8; r++) {
	            for (int c = 0; c < 8; c++) {
	                if (matrix[r][c] == firstChar) {
	                    row1 = r;
	                    col1 = c;
	                }
	                if (matrix[r][c] == secondChar) {
	                    row2 = r;
	                    col2 = c;
	                }
	            }
	        }
			// Apply the playfair decryption rules
			// When in the same row replace each letter with the one to its right
		    if (row1 == row2) {
		    	decryptedArray[index]     = matrix[row1][(col1 + 7) % 8];
	            decryptedArray[index + 1] = matrix[row2][(col2 + 7) % 8];
		      }
			// If in the same column, move up
		    else if (col1 == col2) {
		    	decryptedArray[index]     = matrix[(row1 + 7) % 8][col1];
	            decryptedArray[index + 1] = matrix[(row2 + 7) % 8][col2];
	        }
			// If they form a rectangle swap the columns of the letters
		    else {
		    	decryptedArray[index]     = matrix[row1][col2];
	            decryptedArray[index + 1] = matrix[row2][col1];
	        	}
			}
	        String result = new String(decryptedArray);
	        // Remove padding X if present
	        if (result.endsWith("X")) {
	            result = result.substring(0, result.length() - 1);
	        }
	    return result;
    }
}
