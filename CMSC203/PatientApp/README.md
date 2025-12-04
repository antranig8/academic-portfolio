# Patient Management System – CMSC 203 Project 2

This project simulates a basic patient record system using multiple Java classes.  
It demonstrates object-oriented programming fundamentals such as constructors, accessors/mutators, composition, formatting, and user-input validation.

The program collects a patient's personal and emergency information, records three separate medical procedures, displays the formatted results, and calculates the total charge for all procedures.

---

## Project Structure

### src/
Contains the Java source code for this project:
- `Patient.java` – holds patient details such as name, address, phone, and emergency contact.
- `Procedure.java` – represents a medical procedure with name, date, practitioner, and cost.
- `PatientDriverApp.java` – the driver that collects input, creates objects, displays formatted output, and calculates total charges.

### dist/
Contains compiled versions of the application:
- `PatientApp.jar` - the runnable JAR exported from Eclipse
- `PatientApp.exe` — the Windows executable created using Launch4j