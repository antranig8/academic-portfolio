/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: TicketingOffice class that implements the Building interface
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class TicketingOffice implements Building {
	//instance variables
    private String color;
    private double length;
    private double width;
    private String buildingType;

    //constructor
    public TicketingOffice(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Ticketing Office";
    }
    // Sets the size of the building
    @Override
	public void setSize(double length, double width) {
		this.length = length;
		this.width = width;
	}
    // Returns the length of the building
    @Override
	public double getLength() {
    	return length;
    }
    // Returns the width of the building
    @Override
	public double getWidth() {
		return width;
	}
    // Sets the color of the building
    @Override
	public void setColor(String color) {
		this.color = color;
	}
    // Returns the color of the building
    @Override
	public String getColor() {
    	return color;
    }
    // Sets the type of the building
    @Override
	public void setBuildingType(String type) {
    	this.buildingType = type;
    }

    // Returns the type of the building
    @Override
	public String getBuildingType() {
		return buildingType;
	}

    // Method to display the details of the ticketing office
	public void displayBuildingDetails() {
		System.out.printf(toString());
    }
	// toString method to display the ticketing office details
    @Override
	public String toString() {
		return String.format("Ticketing Office [Color: %s, Length: %.2f, Width: %.2f, Type: %s]", color, length, width, buildingType);
	}

}
