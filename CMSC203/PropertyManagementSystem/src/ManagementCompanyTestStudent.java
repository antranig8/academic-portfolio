/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: ManagementCompany Test class for Project 4
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

public class ManagementCompanyTestStudent {
	
	// Test method for the default constructor
	@Test
	public void testDefaultConstructor() {
		ManagementCompany managementCompany = new ManagementCompany("", "", 0);
		assertEquals("", managementCompany.getName());
		assertEquals("", managementCompany.getTaxID());
		assertEquals(0, managementCompany.getManagementFee(), 0.01);
	}
	// Test method for the constructor with parameters
	@Test
	public void testConstructorWithParameters() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		assertEquals("Test Company", managementCompany.getName());
		assertEquals("123456789", managementCompany.getTaxID());
		assertEquals(1000.0, managementCompany.getManagementFee(), 0.01);
	}
	// Test method for the addProperty method
	@Test
	public void testAddProperty() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner", 1, 2, 3, 4);
		int result = managementCompany.addProperty(property);
		// addProperty method returns 0 for success
		assertEquals(0, result);
	}
	// Test method for adding a property with an overlapping plot
	@Test
	public void testAddPropertyWithOverlappingPlot() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		Property property1 = new Property("Property 1", "City 1", 1000.0,  "Owner 1", 1, 2, 3, 4);
		Property property2 = new Property("Property 2", "City 2", 1500.0,  "Owner 2", 2, 2, 3, 3);
		managementCompany.addProperty(property1);
		int result = managementCompany.addProperty(property2);
		// addProperty method returns -4 for overlapping plots
		assertEquals(-4, result);
	}
	// Test method for the getTotalRent method
	@Test
	public void testTotalRent() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		Property property1 = new Property("Property 1", "City 1", 1000.0,  "Owner 1", 1, 1, 1, 1);
		Property property2 = new Property("Property 2", "City 2", 1500.0,  "Owner 2", 5, 5, 5, 5);
		managementCompany.addProperty(property1);
		managementCompany.addProperty(property2);
		assertEquals(2500.0, managementCompany.getTotalRent(), 0.01);
	}
	// Test method for the getHighestRentProperty method
	@Test
	public void testGetHighestRentProperty() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		Property property1 = new Property("Property 1", "City 1", 1000.0, "Owner 1", 1, 2, 3, 4);
		Property property2 = new Property("Property 2", "City 2", 1500.0, "Owner 2", 5, 5, 2, 2);
		managementCompany.addProperty(property1);
		managementCompany.addProperty(property2);
		Property highestRentProperty = managementCompany.getHighestRentProperty();
		assertEquals("Property 2", highestRentProperty.getPropertyName());
	}
	// Test method for the toString method
	@Test
	public void testToString() {
		ManagementCompany managementCompany = new ManagementCompany("Test Company", "123456789", 1000.0);
		managementCompany.addProperty(new Property("Test Property", "Test City", 1000.0, "Test Owner", 1, 2, 3, 4));
		String str = managementCompany.toString();
		assertEquals("List of the properties for: Test Company, taxID: 123456789\n"
				+ "-------------------\n"
				+ "Test Property,Test City,Test Owner,1000.0\n"
				+ "-------------------\n"
				+ "Total management Fee: 10000.0", str.toString());
	}

}
