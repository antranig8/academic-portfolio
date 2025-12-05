/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Property class for Project 4
 * Due: 07/14/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class Property {
	// Fields for the Property class
	private String propertyName;
	private String city;
	private String ownerName;
	private double rentAmount;
	// Creating a Plot object for property
	private Plot plot;
	
	// Default constructor
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.ownerName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	/*
	 * Constructor with parameters but no Plot
	 * @param propertyName The name of the property
	 * @param city The city where the property is located
	 * @param ownerName The name of the property owner
	 * @param rentAmount The rent amount for the property
	 * @param plot The Plot object associated with the property
	 */
	public Property(String propertyName, String city, double rentAmount, String ownerName) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.ownerName = ownerName;
	}
	
	/*
	 * Constructor with parameters, and Plot with no details
	 * @param propertyName The name of the property
	 * @param city The city where the property is located
	 * @param ownerName The name of the property owner
	 * @param rentAmount The rent amount for the property
	 * @param plot The Plot object associated with the property
	 */
	public Property(String propertyName, String city, double rentAmount, String ownerName, Plot plot) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.ownerName = ownerName;
		// Copy of the Plot object with no details
		this.plot = new Plot(plot); 
	}
	/*
	 * Constructor with parameters and Plot details
	 * @param propertyName The name of the property
	 * @param city The city where the property is located
	 * @param ownerName The name of the property owner
	 * @param rentAmount The rent amount for the property
	 * @param plot The Plot object associated with the property
	 */
	public Property(String propertyName, String city, double rentAmount, 
			String ownerName, int xCords, int yCords, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.ownerName = ownerName;
		// Copy of Plot object with coords and dimensions
		this.plot = new Plot(xCords, yCords, width, depth);
	}
	
	/*
	 * Copy constructor
	 * @param property The Property object to copy
	 */
	public Property(Property property) {
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.ownerName = property.ownerName;
		this.rentAmount = property.rentAmount;
		// Copy of the Plot
		this.plot = new Plot(property.plot);
	}
	// Getters and Setters for the Property class
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwner() {
		return ownerName;
	}
	public void setOwner(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot); // Copy of the Plot object
	}
	
	// toString method to return all details of the Property
	public String toString() {
		return propertyName + "," + city + "," + ownerName + "," + rentAmount;
	}
	
}
