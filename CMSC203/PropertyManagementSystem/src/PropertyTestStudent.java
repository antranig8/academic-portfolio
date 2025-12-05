/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Property Test class for Project 4
 * Due: 07/14/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
// Importing the libraries for JUnit testing
import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyTestStudent {
	
	
	// Test method for the default constructor
	@Test
	public void testDefaultConstructor() {
		Property property = new Property();
		assertEquals("", property.getPropertyName());
		assertEquals("", property.getCity());
		assertEquals("", property.getOwner());
		assertEquals(0.0, property.getRentAmount(), 0.01);
		assertEquals("0,0,1,1", property.getPlot().toString());
	}

	// Test method for the constructor with parameters but no Plot details
	@Test
	public void testConstructorWithParametersNoPlot() {
		Plot plot = new Plot(1, 2, 3, 4);
		Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner", plot);
		assertEquals("Test Property", property.getPropertyName());
		assertEquals("Test City", property.getCity());
		assertEquals("Test Owner", property.getOwner());
		assertEquals(1000.0, property.getRentAmount(), 0.01);
		assertEquals("1,2,3,4", property.getPlot().toString());
	}

	// Test method for the constructor with parameters and Plot details
	@Test
	public void testConstructorWithParametersAndPlot() {
		Property property = new Property("Test Property", "Test City", 1000.0, 
				"Test Owner", 1, 2, 3, 4);
		assertEquals("Test Property", property.getPropertyName());
		assertEquals("Test City", property.getCity());
		assertEquals("Test Owner", property.getOwner());
		assertEquals(1000.0, property.getRentAmount(), 0.01);
		assertEquals("1,2,3,4", property.getPlot().toString());
	}
	// Test method for the copy constructor
	@Test
	public void testCopyConstructor() {
		Property original = new Property("Original Property", "Original City", 
			2500.0, "Original Owner", 1, 2, 3, 4);
		Property copy = new Property(original);
		assertEquals("Original Property", copy.getPropertyName());
		assertEquals("Original City", copy.getCity());
		assertEquals("Original Owner", copy.getOwner());
		assertEquals(2500.0, copy.getRentAmount(), 0.01);
		assertEquals("1,2,3,4", copy.getPlot().toString());
		}
	// Test method for getters and setters
	@Test
	public void testGettersAndSetters() {
		Property property = new Property();
		property.setPropertyName("New Property");
		property.setCity("New City");
		property.setOwner("New Owner");
		property.setRentAmount(1000.0);
		property.setPlot(new Plot(1, 2, 3, 4));
		
		assertEquals("New Property", property.getPropertyName());
		assertEquals("New City", property.getCity());
		assertEquals("New Owner", property.getOwner());
		assertEquals(1000.0, property.getRentAmount(), 0.01);
		assertEquals("1,2,3,4", property.getPlot().toString());
	}
	// Test method for toString
	@Test
	public void testToString() {
		Property property = new Property("Test Property", "Test City", 1000.0, 
				"Test Owner", 1, 2, 3, 4);
		String str = "Test Property,Test City,Test Owner,1000.0";
		assertEquals(str, property.toString());
	}

}
