/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Main class for Project 4 handling management of properties
 * Due: 07/14/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class ManagementCompany {
	// Create all fields for the ManagementCompany class
	private String companyName;
	private String taxID;
	private double managementFee;
	private Plot plot;
	private Property[] properties;
	private int numProperties;
	// Set the final constants
	public static final int MAX_PROPERTY = 5;
	public static final int MANAGEMENT_WIDTH = 10;
	public static final int MANAGEMENT_DEPTH = 10;
	// Default constructor
	public ManagementCompany() {
		this.companyName = "";
		this.taxID = "";
		this.managementFee = 0.0;
		this.plot = new Plot(0, 0, MANAGEMENT_WIDTH, MANAGEMENT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numProperties = 0;
	}
	/*
	 * Constructor with parameters but no Plot details
	 * @param companyName The name of the management company
	 * @param taxID The tax ID of the management company
	 * @param managementFee The management fee charged by the company
	 */
	public ManagementCompany(String companyName, String taxID, double managementFee) {
		this.companyName = companyName;
		this.taxID = taxID;
		this.managementFee = managementFee;
		this.plot = new Plot(0, 0, MANAGEMENT_WIDTH, MANAGEMENT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numProperties = 0;
	}
	/*
	 * Constructor with parameters and Plot details
	 * @param companyName The name of the management company
	 * @param taxID The tax ID of the management company
	 * @param managementFee The management fee charged by the company
	 */
	public ManagementCompany(String companyName, String taxID, double managementFee, 
			int xCords, int yCords, int width, int depth) {
		this.companyName = companyName;
		this.taxID = taxID;
		this.managementFee = managementFee;
		this.plot = new Plot(xCords, yCords, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		this.numProperties = 0;
	}
	/*
	 * Copy constructor
	 * @param other The ManagementCompany object to copy from
	 */
	public ManagementCompany(ManagementCompany copyCompany) {
		this.companyName = copyCompany.companyName;
		this.taxID = copyCompany.taxID;
		this.managementFee = copyCompany.managementFee;
		this.plot = new Plot(copyCompany.plot);
		this.properties = new Property[MAX_PROPERTY];
		for (int index = 0; index < copyCompany.numProperties; index++) {
			this.properties[index] = new Property(copyCompany.properties[index]);
		}
		this.numProperties = copyCompany.numProperties;
	}
	
	// Getters and Setters for the ManagementCompany class
	public String getName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public double getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(double managementFee) {
		this.managementFee = managementFee;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public Property[] getProperties() {
		return properties;
	}
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	public int getNumProperties() {
		return numProperties;
	}
	public void setNumProperties(int numProperties) {
		this.numProperties = numProperties;
	}
	
	// Method to check if the management fee is valid (0-100)
	public boolean isValidManagementFee() {
		if (managementFee < 0 || managementFee > 100) {
			return false;
		}
		else {
			return true;
		}
	}
	 //Method to check if the properties array is full
	public boolean isPropertiesFull() {
		if (numProperties >= MAX_PROPERTY) {
			return true;
		}
		else {
			return false;
		}
	}
 	/*
 	 *  Method to add a property to the management company
 	 *  @param property The Property object to add
 	 */
	public int addProperty(Property property) {
		// Checks if properties array is full
		if (isPropertiesFull()) {
			return -1;
		}
		// Checks if the property is null or overlaps with existing properties
		if (property == null) {
			return -2;
		}
		// Checks if the property plot is inside the management company plot
		if (!plot.isInside(property.getPlot())) {
			return -3;
		}
		// Check for overlap with existing properties
		for (int index = 0; index < numProperties; index++) {
			if (properties[index].getPlot().checkOverlap(property.getPlot())) {
			    return -4;
			}
		}
		// If all checks pass, add the property to the array
		properties[numProperties] = new Property(property);
		numProperties++;
		return numProperties - 1;
	}
	/*
	 * Method to add a property without plot details
	 * @param propertyName The name of the property
	 * @param city The city of the property
	 * @param ownerName The name of the property owner
	 * @param rentAmount The rent amount for the property
	 * @param plot The Plot object
	 * @return the new property
	 */
	public int addProperty(String propertyName, String city, String ownerName, 
			double rentAmount, Plot plot) 
	{
		Property property = new Property(propertyName, city, rentAmount, ownerName, plot);
		return addProperty(property);
	}
	/*
	 * Method to add a property with plot details
	 * @param propertyName The name of the property
	 * @param city The city of the property
	 * @param ownerName tthe name of the property owner
	 * @param rentAmount The rent amount for the property
	 * @param xCords X coords of the plot
	 * @param yCords Y coords of the plot
	 * @param width Width of the plot
	 * @param depth Depth of the plot
	 * @return the new property
	 */
	public int addProperty(String propertyName, String city, double rentAmount, 
			String ownerName, int xCords, int yCords, int width, int depth) 
	{
		Property property = new Property(propertyName, city, rentAmount, ownerName,
				xCords, yCords, width, depth);
		return addProperty(property);
	}
	
	// Method to remove the last property added
	public void removeLastProperty() {
		if (numProperties > 0) 
		{
			properties[numProperties - 1] = null;
			numProperties--;
		}
	}
	// Method to get total rent all properties make
	public double getTotalRent() {
		double totalRent = 0.0;
		for (int index = 0; index < numProperties; index++) 
		{
			totalRent += properties[index].getRentAmount();
		}
		return totalRent;
	}
	
	// Method to get property with highest rent
	public Property getHighestRentProperty() {
		if (numProperties == 0) {
			// If there are no properties, return null
			return null;
		}
		// create array to step through and find the highest rent property
		Property highestRent = properties[0];
		for (int index = 1; index < numProperties; index++) {
			if (properties[index].getRentAmount() > highestRent.getRentAmount()) 
			{
				highestRent = properties[index];
			}
		}
		return highestRent;
	}
	
	// toString method to return the management company details
	public String toString() {
		String str = "List of the properties for: " + companyName + ", taxID: " + taxID + "\n";
	    str += "-------------------\n";
	    for (int i = 0; i < numProperties; i++) {
	        str += properties[i].toString() + "\n";
	    }
	    str += "-------------------\n";
	    double totalFee = getTotalRent() * (managementFee / 100);
	    str += "Total management Fee: " + totalFee;
	    return str;
	}
}
	
