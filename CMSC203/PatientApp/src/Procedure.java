package patient;
/*
 * Class: CMSC203 CRN: 40438
 * Instructor: Dr. Grinberg
 * Description: Procedure class for Project 2
 * Due: 06/30/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/

public class Procedure 
{
	// fields
	private String procedureName;
	private String procedureDate;
	private String doctorName;
	private double procedureCost;
	
	// Default Constructor (no agrs)
	public Procedure() 
	{
		procedureName = "";
		procedureDate = "";
		doctorName = "";
		procedureCost = 0.0;
	}
	/**
	 * Constructor with only procedure name, and date
	 * @param procedureName1 name of the procedure
	 * @param procedureDate1 date of the procedure
	 * @param doctorName1 name of the doctor performing the procedure
	 */
	public Procedure(String procedureName1, String procedureDate1) 
	{
		procedureName = procedureName1;
		procedureDate = procedureDate1;
		doctorName = "";
		procedureCost = 0.0;
	}
	/**
	 * Constructor with all fields
	 * @param procedureName1 name of the procedure
	 * @param procedureDate1 date of the procedure
	 * @param doctorName1 name of the doctor performing the procedure
	 * @param procedureCost1 cost of the procedure
	 */
	public Procedure(String procedureName1, String procedureDate1, String doctorName1, double procedureCost1) 
	{
		procedureName = procedureName1;
		procedureDate = procedureDate1;
		doctorName = doctorName1;
		procedureCost = procedureCost1;
	}
	// Accessor methods
	public String getProcedureName() 
	{
		return procedureName;
	}
	public String getProcedureDate() 
	{
		return procedureDate;
	}
	public String getDoctorName() 
	{
		return doctorName;
	}
	public double getProcedureCost() 
	{
		return procedureCost;
	}
	// Mutator methods
	
	/**
	 * Method to set the procedure name
	 * @param procedureName1 name of the procedure
	 */
	public void setProcedureName(String procedureName1) 
	{
		procedureName = procedureName1;
	}
	/**
	 * Method to set the procedure date
	 * @param procedureDate1 date of the procedure
	 */
	public void setProcedureDate(String procedureDate1) 
	{
		procedureDate = procedureDate1;
	}
	/**
	 * Method to set the doctor's name
	 * @param doctorName1 name of the doctor performing the procedure
	 */
	public void setDoctorName(String doctorName1) 
	{
		doctorName = doctorName1;
	}
	/**
	 * Method to set the procedure cost
	 * @param procedureCost1 cost of the procedure
	 */
	public void setProcedureCost(double procedureCost1) 
	{
		procedureCost = procedureCost1;
	}
	/**
	 * Method to return patient's full information
	 * @return string with the patient's full information
	 */
	public String toString() 
	{
		return "Procedure Name: " + procedureName + "\n" +
			   "Procedure Date: " + procedureDate + "\n" +
			   "Doctor Name: " + doctorName + "\n" +
			   "Procedure Cost: $" + String.format("%.2f", procedureCost);
	}
}
