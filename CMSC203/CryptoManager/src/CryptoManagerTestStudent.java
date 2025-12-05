/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: JUnit Testing class for CMSC203 Programming Assignment 3
 * Due: 07/07/2025
 * Platform/compiler: ECLIPSE IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Antranig Tatarian
*/

// Importing the libraries for JUnit testing
import org.junit.Test;
import static org.junit.Assert.*;

public class CryptoManagerTestStudent 
{
		@Test
	    public void testIsStringInBounds() 
		{
	        assertTrue(CryptoManager.isStringInBounds("MONTGOMERY 2025!"));
	        assertFalse(CryptoManager.isStringInBounds("Montgomery 2025!"));
	        assertFalse(CryptoManager.isStringInBounds("MonTgomery #$%!_-"));
	    }
		//
		@Test
		public void testVigenereEncryption() 
		{
		    String plainText = "MONTGOMERY 2025!";
		    String key = "KEY";
		    String encrypted = CryptoManager.vigenereEncryption(plainText, key);
		    String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
		    assertEquals(plainText, decrypted);
		}
	    //
	    @Test
	    public void testVigenereDecryption() 
	    {
	        String plainText = "MONTGOMERY 2025!";
	        String key = "KEY";
	        // Encrypt the text first
	        String encrypted = CryptoManager.vigenereEncryption(plainText, key);
	        // Then Decrypt it
	        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
	        // Check
	        assertEquals(plainText, decrypted);
	    }
	    //
	    @Test
	    public void testPlayfairEncryption() 
	    {
	        String plainText = "MONTGOMERY 2025!";
	        String key = "KEY";
	        String encrypted = CryptoManager.playfairEncryption(plainText, key);
	        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	        assertEquals(plainText, decrypted); 
	        assertNotEquals(plainText, encrypted);
	    }
	    //
	    @Test
	    public void testPlayfairDecryption() 
	    {
	        String plainText = "MONTGOMERY 2025!";
	        String key = "KEY";
	        // Encrypt the text first
	        String encrypted = CryptoManager.playfairEncryption(plainText, key);
	        // Then Decrypt it
	        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	        // Check
	        assertEquals(plainText, decrypted);
	    }
}