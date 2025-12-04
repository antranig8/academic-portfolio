package patient;
/*
 * Class: CMSC203 CRN: 40438
 * Instructor: Dr. Grinberg
 * Description: Patient class for Project 2
 * Due: 06/30/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/


public class Patient 
{
	// fields
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String EmergencyName;
	private String EmergencyNumber;
	 //Default Constructor (no args)
	public Patient()
	{
		firstName = "";
		middleName = "";
		lastName = "";
		address = "";
		city = "";
		state = "";
		zipCode = "";
		phoneNumber = "";
		EmergencyName = "";
		EmergencyNumber = "";
	}
	 /*
	  * Constructor with only first, middle, and last name
	  * @param fN first name of the patient
	  * @param mN middle name of the patient
	  * @param lN last name of the patient
	  */
	public Patient(String fN, String mN, String lN)
	{
		firstName = fN;
		middleName = mN;
		lastName = lN;
		address = "";
		city = "";
		state = "";
		zipCode = "";
		phoneNumber = "";
		EmergencyName = "";
		EmergencyNumber = "";
	}
	// Constructor with all fields
	public Patient(String firstName1, String middleName1, String lastName1, 
			String address1, String city1, String state1, String zipCode1, 
			String phoneNumber1, String EmergencyName1, String EmergencyNumber1)
	{
		firstName = firstName1;
		middleName = middleName1;
		lastName = lastName1;
		address = address1;
		city = city1;
		state = state1;
		zipCode = zipCode1;
		phoneNumber = phoneNumber1;
		EmergencyName = EmergencyName1;
		EmergencyNumber = EmergencyNumber1;
	}
	
	// Accessor methods
	
	public String getFirstName() 
	{
		return firstName;
	}
	public String getMiddleName() 
	{
		return middleName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public String getAddress() 
	{
		return address;
	}
	public String getCity() 
	{
		return city;
	}
	public String getState() 
	{
		return state;
	}
	public String getZipCode() 
	{
		return zipCode;
	}
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public String getEmergencyName() 
	{
		return EmergencyName;
	}
	public String getEmergencyNumber() 
	{
		return EmergencyNumber;
	}
	
	// Mutator methods
	
	public void setFirstName(String firstName2) 
	{
		firstName = firstName2;
	}
	public void setMiddleName(String middleName2) 
	{
		middleName = middleName2;
	}
	public void setLastName(String lastName2) 
	{
		lastName = lastName2;
	}
	public void setAddress(String address2) 
	{
		address = address2;
	}
	public void setCity(String city2) 
	{
		city = city2;
	}
	public void setState(String state2) 
	{
		state = state2;
	}
	public void setZipCode(String zipCode2) 
	{
		zipCode = zipCode2;
	}
	public void setPhoneNumber(String phoneNumber2) 
	{
		phoneNumber = phoneNumber2;
	}
	public void setEmergencyName(String EmergencyName2) 
	{
		EmergencyName = EmergencyName2;
	}
	public void setEmergencyNumber(String EmergencyNumber2) 
	{
		EmergencyNumber = EmergencyNumber2;
	}
	/**
	 * Method to return patient's full name
	 * @return string with the patient's full name
	 */
	public String buildFullName()
	{
		String FullName = firstName + " " + middleName + " " + lastName;
		return FullName;
	}
	/**
	 * Method to return patient's full address
	 * @return string with the patient's full address
	 * 
	 */
	public String buildFullAddress()
	{
		String FullAddress = address + ", " + city + ", " + state + " " + zipCode;
		return FullAddress;
	}
	/**
	 * Method to return patient's full emergency contact information
	 * @return string with the patient's emergency contact information
	 */
	public String buildEmergencyContact()
	{
		String EmergencyContact = EmergencyName + ": " + EmergencyNumber;
		return EmergencyContact;
	}
	/**
	 * Method to return patient's full information
	 * @return string with the patient's full information
	 */
	public String toString()
	{
		String fullInfo = "Patient Name: " + buildFullName() + "\n" +
				"Address: " + buildFullAddress() + "\n" +
				"Phone Number: " + phoneNumber + "\n" +
				"Emergency Contact: " + buildEmergencyContact();
		return fullInfo;
	}
	
	
	
}
