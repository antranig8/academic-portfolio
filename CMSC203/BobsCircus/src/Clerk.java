/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Clerk class that extends Person class
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
public class Clerk extends Person {
    private String job;
    
    // Constructor
    public Clerk(String name, int age, int yearsWorked, String job) {
       super(name, age, yearsWorked);
       this.job = job;
    }
    
    // Method to get the job of the Clerk
    public String getJob() {
        return job;
    }

    // To string method to display Clerk information
    @Override
    public String toString() {
    	return String.format("Clerk [Name=%s, Age=%d, YearsWorked=%d, Job=%s]", getName(), getAge(), getYearsWorked(), job);      
    }   
     
}
