/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Acrobatic class that extends Person class
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class Acrobatic extends Person {
    private String job;
    // Constructor
    public Acrobatic(String name, int age, int yearsWorked, String job) {
        super(name, age, yearsWorked);
        this.job = job;
    }
    // Method to get the job of the Acrobatic
    public String getJob() {
        return job;
    }
    // To string method to display Acrobatic information
    @Override
    public String toString() {
    	String message = "Name: " + getName()+ "\nAge: " + getAge()
    			+ "\nYears Worked: " + getYearsWorked() + "\nJob: " + job;
		return message;
    }   
 
}
