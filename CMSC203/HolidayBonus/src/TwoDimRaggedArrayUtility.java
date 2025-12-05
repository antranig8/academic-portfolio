/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Utility class for TwoDimRaggedArray
 * Due: 07/21/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	// Set default values for max rows and columns
	private static final int MAX_ROWS = 10;
	private static final int MAX_COLUMNS = 10;
	
	// private default constructor 
	private TwoDimRaggedArrayUtility() {
	}
	
	/*
	 *  Method to read a file and return a 2D ragged array
	 *  @param file The name of the file to read
	 *  @return A 2D ragged array of doubles
	 */
	public static double[][] readFile(File file) throws FileNotFoundException 
	{
		// Initialize a 2D ragged array with a maximum number of rows
		double[][] array = new double[MAX_ROWS][];
		// Use a Scanner to read the file line by line
		try (Scanner scanner = new Scanner((file))) 
		{
			int rowCount = 0;
			// Read each line of the file
			while (scanner.hasNextLine() && rowCount < MAX_ROWS) 
			{
				String line = scanner.nextLine();
				// Skip empty lines
				String[] tokens = line.trim().split(" ");
				array[rowCount] = new double[tokens.length];
				// Make each token a double and store it in the array
				for (int col = 0; col < tokens.length; col++) 
				{
					array[rowCount][col] = Double.parseDouble(tokens[col].trim());
				}
				rowCount++;
			}
			// Resize the array to the actual number of rows read
			double[][] resizedArray = new double[rowCount][];
			for (int index = 0; index < rowCount; index++) {
				resizedArray[index] = array[index];
			}
			// Return the resized array
			return resizedArray;
		}
	}
	
	/*
	 * Method to write a 2D ragged array to a file
	 * @param data The 2D ragged array to write
	 * @param outputFile The name of the file to write to
	 * @throws IOException If an I/O error occurs
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException 
	{
		// Open the file for writing
		try (PrintWriter writer = new PrintWriter(outputFile)) 
		{
			// Go through each row of the 2D ragged array
			for (int row = 0; row < data.length; row++) 
			{
				// Go through each element of the row
				for(int index = 0; index < data[row].length; index++) 
				{
					// Write each element of the row to the file
					// Format the number to one decimal place
					writer.printf("%.1f", data[row][index]);
					// Add a space after each element except the last one
						if (index < data[row].length - 1) 
						{
						    writer.print(" ");
						}
				}
				// Only adds a newline if it's not the last row
				if (row < data.length - 1) 
				{
				writer.println();
	    }
			}
		}
	}
	
	/*
	 * Method to get the total of all elements in a 2D ragged array
	 * @param data The 2D ragged array
	 * @return the total of all elements
	 */
	public static double getTotal(double[][] data) 
	{
		double total = 0.0;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) {
			// Go through each element of the row
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total; // Return the total
	}
	
	/*
	 * Method to get the total of a selected row
	 * @param data The 2D ragged array
	 * @param row The index of the row to total
	 * @return The total of the selected row
	 */
	public static double getRowTotal(double[][] data, int row) 
	{
		double total = 0.0;
		if (row < 0 || row >= data.length) {
			System.out.println("Incorrect row index entered.");
		}
		// Go through each element of the specified row
		for (int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}
		return total;
	}
	/*
	 * Method to get the average of all elements in a 2D ragged array
	 * @param data The 2D ragged array
	 * @return The average of all elements
	 */
	public static double getAverage(double[][] data)
	{
		// Get total of all elements
		double total = getTotal(data);
		double average = 0.0;
		int count = 0;
		// Go through each row of thearray
		for (int row = 0; row < data.length; row++) 
		{
			count += data[row].length;
		}
		// if there are no elements, set average to 0
		if (count == 0) 
		{
			average = 0.0;
		}
		// if there are elements, calculate average
		else
		{
			average = total / count;
		}
		return average;
	}
	/*
	 * Method to get the total of a selected column
	 * @param data The 2D ragged array
	 * @param col The index of the column to total
	 * @return The total of the selected column
	 */
	public static double getColumnTotal(double[][] data, int col) 
	{
		double total = 0.0;
		if (col < 0 || col >= MAX_COLUMNS) 
		{
			// Check if the column index is valid
			System.out.println("Incorrect column index entered.");
		}
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) 
		{
			// Check if the column index is still within the current row's length
			if (col < data[row].length) 
			{
				// Add the element to total
				total += data[row][col];
			}
		}
		return total;
	}
	/*
	 * Method to get the largest element in a 2D ragged array
	 * @param data The 2D ragged array
	 * @param row The index of the row to search
	 * @return The largest element found
	 */
	public static double getHighestInRow(double[][] data, int row) 
	{
		// Set highest as the first element of the specified row
		double highest = Double.NEGATIVE_INFINITY;
		// Go through each row of the 2D ragged array
		for (int index = 0; index < data.length; index++) 
		{
			// Go through each element of the row
			for (int col = 0; col < data[index].length; col++) 
			{
				// Check if current element is greater than highest
				if (data[index][col] > highest) 
				{
					// Set highest to current element
					highest = data[index][col];
				}
			}
		}
		return highest; // Return the highest value found
	}
	
	/*
	 * Method to get the index of the highest element in a row
	 * @param data The 2D ragged array
	 * @param row The index of the row to search
	 * @return The index of the highest element in the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		// Initialize highest as the first element of the specified row
		double highest = Double.NEGATIVE_INFINITY;
		// Set the index of the highest element to 0
		int highestIndex = 0;
		// Go through each element of the specified row
		for (int col = 0; col < data[row].length; col++) 
		{
			// Check if current element is greater than highest
			if (data[row][col] > highest) 
			{
				// Set highest to current element
				highest = data[row][col];
				// Set the index of the highest element to the current column
				highestIndex = col; 
			}
		}
		return highestIndex;
	}
	/*
	 * Method to get the lowest element in a row
	 * @param data The 2D ragged array
	 * @param row The index of the row to search
	 * @return The lowest element found in the specified row
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		// Set lowest as the first element of the specified row
		double lowest = Double.POSITIVE_INFINITY;
		// Go through each element of the specified row
		for (int col = 0; col < data[row].length; col++) 
		{
			// Check if current element is less than lowest
			if (data[row][col] < lowest) 
			{
				// Set lowest to current element
				lowest = data[row][col];
			}
		}
		return lowest; // Return the lowest value found
	}
	/*
	 * Method to get the index of the lowest element in a row
	 * @param data The 2D ragged array
	 * @param row The index of the row to search
	 * @return The index of the lowest element in the specified row
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		// Initialize lowest as the first element of the specified row
		double lowest = Double.POSITIVE_INFINITY;
		// Set the index of the lowest element to 0
		int lowestIndex = 0;
		// Go through each element of the specified row
		for (int col = 0; col < data[row].length; col++) 
		{
			// Check if current element is less than lowest
			if (data[row][col] < lowest) 
			{
				// Set lowest to current element
				lowest = data[row][col];
				// Set the index of the lowest element to the current column
				lowestIndex = col; 
			}
		}
		return lowestIndex;
	}
	/*
	 * Method to get the highest element in a selected column
	 * @param data The 2D ragged array
	 * @param col The index of the column to search
	 * @return The highest element found in the specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) 
	{
		// Set highest as the first element of the specified column
		double highest = Double.NEGATIVE_INFINITY;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) 
		{
			// Check if the column index is still within the current row's length
			if (col < data[row].length) 
			{
				// Check if current element is greater than highest
				if (data[row][col] > highest) 
				{
					// Set highest to current element
					highest = data[row][col];
				}
			}
		}
		return highest; // Return the highest value found
	}
	/*
	 * Method to get the highest element in a selected columns index
	 * @param data The 2D ragged array
	 * @param col The index of the column to search
	 * @return The lowest element found in the specified column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		// Initialize highest as the first element of the specified column
		double highest = Double.NEGATIVE_INFINITY;
		// Set the index of the highest element to 0
		int highestIndex = 0;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) 
		{
			// Check if the column index is still within the current row's length
			if (col < data[row].length) 
			{
				// Check if current element is greater than highest
				if (data[row][col] > highest) 
				{
					// Set highest to current element
					highest = data[row][col];
					// Set the index of the highest element to the current row
					highestIndex = row; 
				}
			}
		}
		return highestIndex;
	}
	/*
	 * Method to get the lowest element in a selected column
	 * @param data The 2D ragged array
	 * @param col The index of the column to search
	 * @return The lowest element found in the specified column
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		// Set lowest as the first element of the specified column
		double lowest = Double.POSITIVE_INFINITY;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) 
		{
			// Check if the column index is still within the current row's length
			if (col < data[row].length) 
			{
				// Check if current element is less than lowest
				if (data[row][col] < lowest) 
				{
					// Set lowest to current element
					lowest = data[row][col];
				}
			}
		}
		return lowest; // Return the lowest value found
	}
	/*
	 * Method to get the index of the lowest element in a selected column
	 * @param data The 2D ragged array
	 * @param col The index of the column to search
	 * @return The index of the lowest element found in the specified column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		// Initialize lowest as the first element of the specified column
		double lowest = Double.POSITIVE_INFINITY;
		// Set the index of the lowest element to 0
		int lowestIndex = 0;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) 
		{
			// Check if the column index is still within the current row's length
			if (col < data[row].length) 
			{
				// Check if current element is less than lowest
				if (data[row][col] < lowest) 
				{
					// Set lowest to current element
					lowest = data[row][col];
					// Set the index of the lowest element to the current row
					lowestIndex = row; 
				}
			}
		}
		return lowestIndex;
	}
	/*
	 * Method to get the largest element in a 2D ragged array
	 * @param data The 2D ragged array
	 * @return The largest element found in the array
	 */
	public static double getHighestInArray(double[][] data) 
	{
		// Set highest as the first element of the 2D ragged array
		double highest = Double.NEGATIVE_INFINITY;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) {
			// Go through each element of the row
			for (int col = 0; col < data[row].length; col++) {
				// Check if current element is greater than highest
				if (data[row][col] > highest) {
					// Set highest to current element
					highest = data[row][col];
				}
			}
		}
		return highest; // Return the highest value found
	}
	/*
	 * Method to get the lowest element in a 2D ragged array
	 * @param data The 2D ragged array
	 * @return The lowest element found in the array
	 */
	public static double getLowestInArray(double[][] data)
	{
		// Set lowest as the first element of the 2D ragged array
		double lowest = Double.POSITIVE_INFINITY;
		// Go through each row of the 2D ragged array
		for (int row = 0; row < data.length; row++) {
			// Go through each element of the row
			for (int col = 0; col < data[row].length; col++) {
				// Check if current element is less than lowest
				if (data[row][col] < lowest) {
					// Set lowest to current element
					lowest = data[row][col];
				}
			}
		}
		return lowest; // Return the lowest value found
	}
}
