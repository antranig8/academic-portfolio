/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Ticket class that calculates ticket prices based on day of the week and age
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }
    
    // Calculate ticket price based on day of week and age
        // Apply discounts for weekdays
        // Apply age-based discounts
    public double calculatePrice() {
    	double price = basePrice;
    	// Apply the weekday discount
    	if(dayOfWeek.equals("monday") || 
		   dayOfWeek.equals("tuesday") || 
		   dayOfWeek.equals("wednesday") || 
		   dayOfWeek.equals("thursday") || 
		   dayOfWeek.equals("friday")) {
    		// 10% discount for weekdays
			price *= 0.90;
    	}
    	
    	// Apply age-based discounts
    	switch(age) {
    	// Child
    	case 1:
        // Student
    	case 2: 
    		price *= 0.90;
    		break;
    	// Adult
    	case 3:
    		break;
    	// Senior
    		case 4:
			price *= 0.95;
			break;
    	}
    	return price;
    }
    
    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}
