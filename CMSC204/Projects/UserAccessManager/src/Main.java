/**
 * Main class to run the application.
 * @author Antranig Tatarian
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Set up the UserAccessManager and Scanner for user input
		UserAccessManager uam = new UserAccessManager();
		Scanner input = new Scanner(System.in);
		// Creare menu driven interface
		System.out.println("User Access Management System");
		while (true) {
            System.out.print("User Access Manager> ");
            if (!input.hasNextLine()) {
            	break; }
            // create command line interface
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
            	continue; }
            // Split the input line into command and arguments
            String[] parts = line.split("\\s+");
            String cmd = parts[0];
            String arg = (parts.length > 1) ? parts[1].trim() : "";
            // Try statement to catch exceptions and run the program
            try {
				switch(cmd) {
				    // case of addUser
					case "add": {
						System.out.print("Password: ");
						String password = input.nextLine().trim();
						uam.addUser(arg, password);
						break;
					}
					// case of removeUser
					case "remove": {
						uam.removeUser(arg);
						break;
					}
					// case of verifyUser
					case "verify": {
						System.out.print("Password: ");
						String password = input.nextLine().trim();
						if (uam.verifyAccess(arg, password)) {
                            System.out.println("Access verified.");
                        }
                        break;
					}
					// case of load
					case "load": {
						uam.loadAccounts(arg);
						break;
					}
					// case of exit
					case "exit": {
						System.out.println("Exiting program.");
						return;
					}
				}
            } catch (Exception e) {
			String msg = e.getMessage();
			System.out.println("Error: " + msg);
            }
		}
	}
}
