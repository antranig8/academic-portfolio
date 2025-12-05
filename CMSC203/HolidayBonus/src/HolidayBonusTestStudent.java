/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Test Class for HolidayBonus
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


public class HolidayBonusTestStudent 
{
	// Test to calculate holiday bonus for each store
	// Bonus based off row and column sale amount
	@Test
	public void testCalculateHolidayBonus() 
	{
		double[][] sales = { {10000, 20000}, // row 0
							 {30000},			 // row 1
							 {40000, 50000, 60000} }; // row 2
        double[] expectedBonuses = 
        {
            1000 + 1000, // row 0
            2000,			 // row 1
            5000 + 5000 + 5000	 // row 2
        };

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(sales);

        assertArrayEquals(expectedBonuses, actualBonuses, 0.001);
	}

	// Test to calculate total holiday bonus of all stores
    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] sales = 
          { {10000, 20000},
            {30000},
            {40000, 50000, 60000} };
        double expectedTotalBonus = 1000 + 1000 + 2000 + 5000 + 5000 + 5000;
        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expectedTotalBonus, actualTotalBonus, 0.001);
    }

	// Test to calculate holiday bonus with no sales
	@Test
	public void testCalculateHolidayBonusNoSales() 
	{
		double[][] sales = { {}, {}, {} };
		double[] expectedBonuses = { 0.0, 0.0, 0.0 };
		assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.001);
	}
	// Test to calculate holiday bonus with negative sales
	@Test
	public void testCalculateHolidayBonusNegativeSales() 
	{
		double[][] sales = { {-10000, -20000}, {-30000}, {-40000, -50000, -60000} };
		double[] expectedBonuses = { 0.0, 0.0, 0.0 };
		assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(sales), 0.001);
	}
}
