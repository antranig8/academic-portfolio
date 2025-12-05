/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: HolidayBonus class for TwoDimRaggedArray
 * Due: 07/21/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class HolidayBonus {
	private static final double HIGH_BONUS = 5000.0;
	private static final double LOW_BONUS = 1000.0;
	private static final double OTHER_BONUS = 2000.0;
	
	// Constructor for HolidayBonus
	public HolidayBonus() {
	}

	/*
	 * Calculate the holiday bonus for each store
	 * @param data The 2D array containing store data
	 * @return An array with the calculated bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] data) 
	{
		// Create an array to hold the bonuses
		double[] bonuses = new double[data.length];
		// Find the maximum number of columns in the 2D array
		int maxColumns = 0;
		for (int row = 0; row < data.length; row++) 
		{
            if (data[row].length > maxColumns) 
            {
                maxColumns = data[row].length;
			}
		}
		// Loop through each column
		for (int col = 0; col < maxColumns; col++)
		{
			// Set initial values for highest and lowest sales
			double highest = Double.NEGATIVE_INFINITY;
			double lowest = Double.POSITIVE_INFINITY;
			// Find highest and lowest sales in the column
			for (int row = 0; row < data.length; row++)
			{
				if (col < data[row].length)
                {
                    if (data[row][col] > highest) 
                    {
                        highest = data[row][col];
                    }
                    if (data[row][col] < lowest) 
                    {
                        lowest = data[row][col];
                    }
				}
			}
			// Calculate bonuses based on the highest and lowest sales
			for (int row = 0; row < data.length; row++) 
			{
				if (col < data[row].length && data[row][col] >= 0)
                {
                    if (data[row][col] == highest) 
                    {
                        bonuses[row] += HIGH_BONUS;
                    } 
                    else if (data[row][col] == lowest) 
                    {
                        bonuses[row] += LOW_BONUS;
                    } 
                    else if (data[row][col] >= 0)
                    {
                        bonuses[row] += OTHER_BONUS;
                    }
				}
			}
		}
		return bonuses;
	}
	
	/*
	 * Calculate the total holiday bonus for all stores
	 * @param data The 2D array containing store data
	 * @return The total of all bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double totalBonus = 0.0;
		double[] bonuses = calculateHolidayBonus(data);
		for (int index = 0; index < bonuses.length; index++) 
		{
			totalBonus += bonuses[index];
		}
		return totalBonus;
	}
}
