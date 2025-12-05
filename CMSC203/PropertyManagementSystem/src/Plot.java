/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Plot class for Project 4
 * Due: 07/14/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/

public class Plot {
	 //Fields for the Plot class
	private int xCords;
	private int yCords;
	private int width;
	private int depth;
	
	// default constructor 
	// makes a plot at 0,0 cords with a width and depth of 1
	public Plot() 
	{
		this(0, 0, 1, 1);
	}
	
	/* * Constructor with all parameters
	 * @param xCords The x-coordinate of the plot
	 * @param yCords The y-coordinate of the plot
	 * @param width The width of the plot
	 * @param depth The depth of the plot
	 */
	public Plot(int xCords, int yCords, int width, int depth)
	{
		this.xCords = xCords;
		this.yCords = yCords;
		this.width = width;
		this.depth = depth;
	}
	// copy constructor
	public Plot(Plot plot2)
	{
		this.xCords = plot2.xCords;
		this.yCords = plot2.yCords;
		this.width = plot2.width;
		this.depth = plot2.depth;
	}
	
	// Getters and Setters for the Plot class
	public int getX() {
		return xCords;
	}
	public void setX(int xCords) {
		this.xCords = xCords;
	}
	public int getY() {
		return yCords;
	}
	public void setY(int yCords) {
		this.yCords = yCords;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	// Plot check method for overlapping plots
	/**
	 * Checks if this plot overlaps with another plot.
	 * @param plot2 The other plot to check for overlap
	 * @return true if the plots overlap, false otherwise
	 */
	public boolean checkOverlap(Plot plot2) 
	{
		if (this.xCords < plot2.xCords + plot2.width &&
			this.xCords + this.width > plot2.xCords &&
			this.yCords < plot2.yCords + plot2.depth &&
			this.yCords + this.depth > plot2.yCords) 
		{
			// Overlap detected
			return true; 
		}
		// No overlap
		return false;
	}
	/*
	 * Checks if this plot is completely inside another plot.
	 * @param plot2 The other plot to check against
	 * @return true if this plot is inside plot2, false otherwise
	 */
	public boolean isInside(Plot plot2) 
	{
		if (plot2.xCords >= this.xCords &&
	        plot2.xCords + plot2.width <= this.xCords + this.width &&
	        plot2.yCords >= this.yCords &&
	        plot2.yCords + plot2.depth <= this.yCords + this.depth) 
			{	
	        // Plot2 is inside this plot
	        return true;
	        }
	    else
	    	{
	    	// Plot2 is not inside this plot
	    	return false;
	        }
	}
	
	// toString method for the Plot class
	public String toString() {
		return xCords + "," + yCords + "," + width + "," + depth;
	}
}
