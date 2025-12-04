package patient;
/*
 * Class: CMSC203 CRN: 40438
 * Instructor: Dr. Grinberg
 * Description: PatientDriverApp for Project 2
 * Due: 06/30/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.util.*;

public class PatientDriverApp {

	public static void main(String[] args) 
	{
		// Create scanner object for user input
		Scanner keyboard = new Scanner(System.in);
		
		// Start of the program
		System.out.println("The program was developed by a Student: Antranig Tatarian 6/27/25\n");
		
		// Creating a Patient object
		Patient patient = new Patient();
		// Prompting user for patient details
		System.out.println("Enter the first name of the patient: ");
		String firstName = keyboard.nextLine();
		//
		System.out.println("Enter the middle name of the patient: ");
		String middleName = keyboard.nextLine();
		//
		System.out.println("Enter the last name of the patient: ");
		String lastName = keyboard.nextLine();
		//
		System.out.println("Enter the address of the patient: ");
		String address = keyboard.nextLine();
		//
		System.out.println("Enter City: ");
		String city = keyboard.nextLine();
		//
		System.out.println("Enter State: ");
		String state = keyboard.nextLine();
		//
		System.out.println("Enter Zip Code: ");
		String zipCode = keyboard.nextLine();
		//
		System.out.println("Enter Phone Number: ");
		String phoneNumber = keyboard.nextLine();
		// Validate phone number format (###-###-####)
		while (phoneNumber.length() != 12) 
		{
			System.out.println("Invalid phone number. It must be exactly 12 characters (format: ###-###-####).");
			System.out.println("Enter phone number:");
			phoneNumber = keyboard.nextLine();
		}
		//
		System.out.println("Enter Emergency Contact Name: ");
		String emergencyName = keyboard.nextLine();
		//
		System.out.println("Enter Emergency Contact Number: ");
		String emergencyNumber = keyboard.nextLine();
		// Validate emergency contact number format (###-###-####)
		while (emergencyNumber.length() != 12) 
		{
			System.out.println("Invalid phone number. It must be exactly 12 characters (format: ###-###-####).");
			System.out.println("Enter phone number:");
			emergencyNumber = keyboard.nextLine();
		}
		//
		// Creating the Patient object with input
		patient = new Patient(firstName, middleName, lastName, address, city, state, 
				zipCode, phoneNumber, emergencyName, emergencyNumber);
		
		/*
		 *  Procedure 1 input using all fields constructor
		 */
		System.out.println("\nEnter the name of the first procedure: ");
		String procedureName1 = keyboard.nextLine();
		//
		System.out.println("Enter the date of the first procedure: ");
		String procedureDate1 = keyboard.nextLine();
		//
		System.out.println("Enter the name of the doctor: ");
		String doctorName1 = keyboard.nextLine();
		//
		System.out.println("Enter the cost of the first procedure: ");
		// Check if the input is a number
		while (!keyboard.hasNextDouble()) {
		    System.out.println("Invalid input. Please enter a number.");
		    keyboard.next();
		}
		// Set the procedure cost
		double procedureCost1 = keyboard.nextDouble();
		// Check for negative numbers
		while (procedureCost1 < 0) 
		{
		    System.out.println("Cost cannot be negative. Please enter a valid cost.");
		    while (!keyboard.hasNextDouble()) {
		        System.out.println("Invalid input. Please enter a number.");
		        keyboard.next();
		    }
		    // Set the procedure cost again
		    procedureCost1 = keyboard.nextDouble();
		}
		keyboard.nextLine(); // clear buffer
		// Creating the first Procedure object using all fields
		Procedure procedure1 = new Procedure(procedureName1, procedureDate1, doctorName1, procedureCost1);
		
		/*
		 *  Procedure 2 input using only name and date constructor
		 */
		System.out.println("\nEnter the name of the second procedure: ");
		String procedureName2 = keyboard.nextLine();
		//
		System.out.println("Enter the date of the second procedure: ");
		String procedureDate2 = keyboard.nextLine();
		//
		System.out.println("Enter the name of the doctor: ");
		String doctorName2 = keyboard.nextLine();
		//
		System.out.println("Enter the cost of the second procedure: ");
		// Check if the input is a number
		while (!keyboard.hasNextDouble()) {
		    System.out.println("Invalid input. Please enter a number.");
		    keyboard.next();
		}
		// Set the procedure cost
		double procedureCost2 = keyboard.nextDouble();
		// Check for negative numbers
		while (procedureCost2 < 0) 
		{
		    System.out.println("Cost cannot be negative. Please enter a valid cost.");
		    while (!keyboard.hasNextDouble()) {
		        System.out.println("Invalid input. Please enter a number.");
		        keyboard.next();
		    }
		    // Set the procedure cost again
		    procedureCost2 = keyboard.nextDouble();
		}
		keyboard.nextLine(); // clear buffer
		// Creating the second Procedure object using only name and date
		Procedure procedure2 = new Procedure(procedureName2, procedureDate2);
		// Setting the doctor name and cost for the second procedure
		procedure2.setDoctorName(doctorName2);
		procedure2.setProcedureCost(procedureCost2);
		
		/*
		 *  Procedure 3 input using the no args constructor
		 */
		System.out.println("\nEnter the name of the third procedure: ");
		String procedureName3 = keyboard.nextLine();
		//
		System.out.println("Enter the date of the third procedure: ");
		String procedureDate3 = keyboard.nextLine();
		//
		System.out.println("Enter the name of the doctor: ");
		String doctorName3 = keyboard.nextLine();
		// 
		System.out.println("Enter the cost of the third procedure: ");
		// Check if the input is a number
		while (!keyboard.hasNextDouble()) {
		    System.out.println("Invalid input. Please enter a number.");
		    keyboard.next();
		}
		// Set the procedure cost
		double procedureCost3 = keyboard.nextDouble();
		// Check for negative numbers
		while (procedureCost3 < 0) 
		{
		    System.out.println("Cost cannot be negative. Please enter a valid cost.");
		    while (!keyboard.hasNextDouble()) {
		        System.out.println("Invalid input. Please enter a number.");
		        keyboard.next();
		    }
		    // Set the procedure cost again
		    procedureCost3 = keyboard.nextDouble();
		}
		keyboard.nextLine(); // clear buffer
		// Creating the third Procedure object using no args constructor
		Procedure procedure3 = new Procedure();
		// Setting the fields for the third procedure
		procedure3.setProcedureName(procedureName3);
		procedure3.setProcedureDate(procedureDate3);
		procedure3.setDoctorName(doctorName3);
		procedure3.setProcedureCost(procedureCost3);
		
		// Displaying the patient information using methods
		displayPatient(patient);
		System.out.println();
		// Displaying the first procedure information
		displayProcedure(procedure1);
		System.out.println();
		// Displaying the second procedure information
		displayProcedure(procedure2);
		System.out.println();
		// Displaying the third procedure information
		displayProcedure(procedure3);
		System.out.println();
		// Calculating and displaying the total charges for all procedures
		double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
		System.out.printf("Total Charges for all procedures: $%.2f%n", totalCharges);
		// End of the program
		System.out.println("\nPress Enter to exit...");
		keyboard.nextLine();
		keyboard.close();
	}
	// Methods
	
	/*
	 *  Method to display patient information
	 *  @param patient the Patient object containing patient details
	 */
	public static void displayPatient(Patient patient) 
	{
		System.out.println(patient.toString());
	}
	/*
	 *  Method to display procedure information
	 *  @param procedure the Procedure object containing procedure details
	 */
	public static void displayProcedure(Procedure procedure)
	{
		System.out.println(procedure.toString());
		System.out.println();
	}
	/**
	 * Method to calculate the total cost of all procedures
	 * @param procedure1 the first Procedure object
	 * @param procedure2 the second Procedure object
	 * @param procedure3 the third Procedure object
	 * @return the total cost of all procedures
	 */
	public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3)
	{
		return procedure1.getProcedureCost() + procedure2.getProcedureCost() + procedure3.getProcedureCost();
	}

}
