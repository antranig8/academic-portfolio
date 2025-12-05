/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Test Class for TwoDimRaggedArrayUtility
 * Due: 07/21/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

public class TwoDimRaggedArrayUtilityTestStudent 
{
	// Test to get the total of all values in the array
	@Test
	public void testGetTotal() 
	{
		double[][] data = { {1.0, 2.0},{3}, {4.0, 5.0, 6.0} };
		assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
	}
	
	// Test to get the average of all values in the array
	@Test
	public void testGetAverage() 
	{
		double[][] data = { {1.0, 2.0, 3.0}, {2.0, 7.0}, {4.0, 5.0, 6.0} };
		assertEquals(30.0/8.0, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
	}
	
	// Test to get the highest value in a row
	@Test
	public void testGetHighestInRow() 
	{
		double[][] data = { {1.0, 2.0}, {3.0}, {4.0, 5.0, 6.0} };
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 2), 0.001);
	}
	
	// Test to get the lowest value in a row
	@Test
	public void testGetLowestInRow() 
	{
		double[][] data = { {1.0, 2.0}, {3.0}, {4.0, 5.0, 6.0} };
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
	}
	
	// Test to get the highest value in a column
	@Test
	public void testGetHighestInColumn() 
	{
		double[][] data = { {1.0, 2.0}, {3.0}, {4.0, 5.0, 6.0} };
		assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
	}
	
	// Test to get the lowest value in a column
	@Test
	public void testGetLowestInColumn() 
	{
		double[][] data = { {1.0, 2.0}, {3.0}, {4.0, 5.0, 6.0} };
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), 0.001);
	}
	
	// Test to read and write to a file
	@Test
	public void testWriteToFile() throws Exception
	{
        double[][] expected = { {1.0, 2.0}, {3.0, 4.0, 5.0} };
        File testFile = new File("test.txt");

        // Write to file
        TwoDimRaggedArrayUtility.writeToFile(expected, testFile);

        // Read from file
        double[][] actual = TwoDimRaggedArrayUtility.readFile(testFile);

        // Check if the arrays are equal
        assertEquals(expected.length, actual.length);
        assertArrayEquals(expected[0], actual[0], 0.001);
        assertArrayEquals(expected[1], actual[1], 0.001);
        // Delete the test file after the test
        testFile.delete();
	}
}
