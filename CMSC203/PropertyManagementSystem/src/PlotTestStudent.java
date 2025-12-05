/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Plot Test class for Project 4
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

public class PlotTestStudent {
	
	//Test method for the constructor with parameters
	@Test
	public void testDefaultConstructor() {
		Plot plot = new Plot();
		assertEquals(0, plot.getX());
		assertEquals(0, plot.getY());
		assertEquals(1, plot.getWidth());
		assertEquals(1, plot.getDepth());
	}
	
	 //Test method for the copy constructor
	@Test
	public void testCopyConstructor() {
		Plot plot = new Plot(5, 10, 15, 20);
		Plot copyPlot = new Plot(plot);
		assertEquals(5, copyPlot.getX());
		assertEquals(10, copyPlot.getY());
		assertEquals(15, copyPlot.getWidth());
		assertEquals(20, copyPlot.getDepth());
	}
	// Test method for getter and setter methods
	@Test
	public void testGettersAndSetters() {
		Plot plot = new Plot();
		plot.setX(10);
		plot.setY(20);
		plot.setWidth(30);
		plot.setDepth(40);
		
		assertEquals(10, plot.getX());
		assertEquals(20, plot.getY());
		assertEquals(30, plot.getWidth());
		assertEquals(40, plot.getDepth());
	}
	// Test method for overlapping plots
	@Test
	public void testOverlappingPlots() {
		Plot plot1 = new Plot(0, 0, 5, 5);
		Plot plot2 = new Plot(3, 3, 5, 5);
		// For an overlap
		assertTrue(plot1.checkOverlap(plot2));
		// For no overlap
		Plot plot3 = new Plot(6, 6, 5, 5);
		assertFalse(plot1.checkOverlap(plot3));
	}
	// Test method for plot inside another plot
	@Test
	public void testPlotInsideAnotherPlot() {
		Plot outerPlot = new Plot(0, 0, 10, 10);
		Plot innerPlot = new Plot(2, 2, 5, 5);
		assertTrue(outerPlot.isInside(innerPlot));
		
		Plot outsidePlot = new Plot(11, 11, 5, 5);
		assertFalse(outerPlot.isInside(outsidePlot));
	}
	// Test toString method
	@Test
	public void testToString() {
		Plot plot = new Plot(1, 2, 3, 4);
		assertEquals("1,2,3,4", plot.toString());
	}
}
