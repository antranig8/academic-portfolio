import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class MorseCodeConverterTest {
	
	MorseCodeConverter converter;
	
	@Test
	final void testConvertToEnglish() {
		// test simple morse code conversion
		assertEquals("e", MorseCodeConverter.convertToEnglish("."));
		assertEquals("t", MorseCodeConverter.convertToEnglish("-"));
		assertEquals("s", MorseCodeConverter.convertToEnglish("..."));
		// test a full word
		assertEquals("sos", MorseCodeConverter.convertToEnglish("... --- ..."));
		// test multiple words
		assertEquals("hello world", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
		// test with extra spaces
		assertEquals("sos", MorseCodeConverter.convertToEnglish("  ...   ---   ...  "));
	}
	@Test
	final void testConvertToEnglishComplex() {
		// test a sentence with lots of spaces
		String morseCode = "  ....   .   .-.. .-.. ---   /   .-- --- .-. .-.. -..   ";
		String output = MorseCodeConverter.convertToEnglish(morseCode);
		assertEquals("hello world", output);
	}
	@Test
	final void testConvertToEnglishInvalidLetterAdded() {
		String in = ".... ....... .";
        String out = MorseCodeConverter.convertToEnglish(in);
        assertEquals("he", out);
		// the invalid morse code should be ignored and not affect the output
		String morseCode = "... -...- --- ...";
		String output = MorseCodeConverter.convertToEnglish(morseCode);
		assertEquals("sos", output);
	}
	
	// file conversion tests
	// test file conversion of daisy.txt
	@Test
	final void testConvertToEnglishFile() {
		try {
			File testFile = new File("src/Daisy.txt");
			String result = MorseCodeConverter.convertToEnglish(testFile);
			assertEquals("give me your answer do", result);
		} catch (FileNotFoundException e) {
			fail("File not found exception thrown");
		}
	}
	// test file conversion of howDoILoveThee.txt
	@Test
	final void testConvertToEnglishHowDoILoveTheeFile() {
		try {
			File testFile = new File("src/howDoILoveThee.txt");
			String result = MorseCodeConverter.convertToEnglish(testFile);
			assertEquals("how do i love thee let me count the ways", result);
		} catch (FileNotFoundException e) {
			fail("File not found exception thrown");
		}
	}
	// test file conversion of howDoILoveThee.txt
	@Test
	final void testDaisyDaisyFile() {
		try {
			File testFile = new File("src/DaisyDaisy.txt");
			String result = MorseCodeConverter.convertToEnglish(testFile);
			assertEquals("im half crazy all for the love of you", result);
		} catch (FileNotFoundException e) {
			fail("File not found exception thrown");
		}
	}
	
}
