/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Circus Driver Application
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");
              
                // Use validateInput method
                int choice = 0;
                boolean validInput = false;

                // Retry until valid input is received
                while (!validInput) {
                    try {
                        choice = validateInput(scanner);
                        validInput = true;
                    } catch (CustomInputMismatchException e) {
                       System.out.println(e.getMessage());
                    }
                }
   

                switch (choice) {
                    case 1:
                        handleAddAnimal(circus, scanner);
                        break;
                    case 2:
                        handleAddPerson(circus, scanner);
                        break;
                    case 3:
                        handleAddBuilding(circus, scanner);
                        break;
                    case 4:
                        handleGenerateTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Displaying all animals:");
                        System.out.println("----------------------");
                        circus.displayAllAnimals();
                        break;
                    case 6:
                        System.out.println("Displaying all persons:");
                        System.out.println("----------------------");
                        circus.displayAllPersons();
                        break;
                    case 7:
                        System.out.println("Displaying all buildings:");
                        System.out.println("------------------------");
                        circus.displayAllBuildings();
                        break;
                    case 8:
                        System.out.println("Sorting animals by age...");
                        circus.sortAnimalsByAge();
                        System.out.println("Animals sorted by age.");
                        break;
                    case 9:
                        System.out.println("Sorting animals by name...");
                        circus.sortAnimalsByName();
                        System.out.println("Animals sorted by name.");
                        break;                       
                    case 10:
                        System.out.print("Enter the name of the animal to search: ");
                        scanner.nextLine(); // Consume the leftover newline
                        String searchName = scanner.nextLine();
                        circus.searchAnimalByName(searchName);
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
       
                } catch (Exception e) {
		            System.out.println("An unexpected error occurred: " + e.getMessage());
		            e.printStackTrace();
                } 
            
        }

        scanner.close();
    }

    
    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            throw new CustomInputMismatchException("Invalid input. Please enter a valid number.");
        }
    }
    
    private static void handleAddAnimal(Circus circus, Scanner scanner) {
    	// Display options
    	System.out.println("Select animal: ");
		System.out.println("1. Dog");
		System.out.println("2. Horse");
		System.out.println("3. Lion");
		System.out.println("4. Bird");
		System.out.print("Enter your choice: ");
		
		// Bariables for user input
		int choice = 0;
		boolean validInput = false;
		
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter your choice: ");
			try {
				choice = validateInput(scanner);
				if (choice >= 1 && choice <= 4) {
					validInput = true;
				}
				else {
					System.out.println("Invalid choice. Please select a valid number.");
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		// Clear the newline character
		scanner.nextLine();
		System.out.print("Enter animal name: ");
		String name = scanner.nextLine();
		
		// Get animal age
		int age = 0;
		validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter animal age: ");
			try {
				age = validateInput(scanner);
				if (age < 0) {
					System.out.println("Age cannot be negative. Please enter a valid age.");
				} else {
					validInput = true;
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		// Clear the newline character
		scanner.nextLine();
		
		// Get animal color
		System.out.print("Enter animal color: ");
		String color = scanner.nextLine();
		
		// Create animal based on choice
		Animal animal = null;
		String species = "";
		switch (choice) {
		case 1:
			System.out.println("Enter species of Dog: ");
			species = scanner.nextLine();
			animal = new Dog(name, age, species, color);
			break;
		case 2:
			System.out.println("Enter species of Horse: ");
			species = scanner.nextLine();
			animal = new Horse(name, age, species, color);
			break;
		case 3:
			System.out.println("Enter species of Lion: ");
			species = scanner.nextLine();
			animal = new Lion(name, age, species, color);
			break;
		case 4:
			System.out.println("Enter species of Bird: ");
			species = scanner.nextLine();
			animal = new Bird(name, age, species, color);
			break;
		}
		// Add animal to circus
		circus.addAnimal(animal);
		System.out.println(animal.getName() + " has been added to the circus.");
    }
	
    // handleAddPerson()
    private static void handleAddPerson(Circus circus, Scanner scanner) {
    	// Display options for person type
		System.out.println("Select person: ");
		System.out.println("1. Clerk");
		System.out.println("2. Acrobatic");
		// Set up variables for user input
		int choice = 0;
		boolean validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter your choice: ");
			try {
				choice = validateInput(scanner);
				if (choice == 1 || choice == 2) {
					validInput = true;
				} else {
					System.out.println("Invalid choice. Please select a valid number.");
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		// Clear the newline character
		scanner.nextLine();
		System.out.print("Enter person name: ");
		String name = scanner.nextLine();
		
		// Get person age
		int age = 0;
		validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter person age: ");
			try {
				age = validateInput(scanner);
				if (age < 0) {
					System.out.println("Age cannot be negative. Please enter a valid age.");
				} else {
					validInput = true;
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		// Get years wored
		int yearsWorked = 0;
		validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter years worked: ");
			try {
				yearsWorked = validateInput(scanner);
				if (yearsWorked < 0) {
					System.out.println("Years worked cannot be negative. Please enter a valid number.");
				} else {
					validInput = true;
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		// Clear the newline character
		scanner.nextLine();
		// Get job title
		System.out.print("Enter job title: ");
		String job = scanner.nextLine();
		
		// Create person based on choice
		Person person = null;
		switch (choice) {
		case 1:
			person = new Clerk(name, age, yearsWorked, job);
			break;
		case 2:
			person = new Acrobatic(name, age, yearsWorked, job);
			break;
		}
		
		// Add person to circus
		circus.addPerson(person);
		System.out.println(person.getName() + " has been added to the circus.");
	}
	
    private static void handleAddBuilding(Circus circus, Scanner scanner) {
		// Display options for building type
		System.out.println("Select building: ");
		System.out.println("1. Arena");
		System.out.println("2. Ticketing Office");
		System.out.print("Enter your choice: ");
		
		// Variables for user input
		int choice = 0;
		boolean validInput = false;

		// Get user input until valid
		while (!validInput) {
			try {
				choice = validateInput(scanner);
				if (choice == 1 || choice == 2) {
					validInput = true;
				} else {
					System.out.println("Invalid choice. Please select a valid number.");
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}

		// Clear the newline character
		scanner.nextLine();
		// Get building details
		// Get building color
		System.out.print("Enter building color: ");
		String color = scanner.nextLine();
		// Get building length
		double length = 0;
		validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter building length: ");
			try {
				length = validateInput(scanner);
				if (length <= 0) {
					System.out.println("Length must be positive. Please enter a valid length.");
				} else {
					validInput = true;
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Clear the newline character
		scanner.nextLine();
		// Variables for user input
		double width = 0;
		validInput = false;
		// Get user input until valid
		while (!validInput) {
			System.out.print("Enter building width: ");
			try {
				width = validateInput(scanner);
				if (width <= 0) {
					System.out.println("Width must be positive. Please enter a valid width.");
				} else {
					validInput = true;
				}
			} catch (CustomInputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Clear the newline character
		scanner.nextLine(); 
		
		// Create building based on choice
		Building building = null;
		switch (choice) {
		case 1:
			building = new Arena(color, length, width);
			break;
		case 2:
			building = new TicketingOffice(color, length, width);
			break;
		}
		
		// Add building to circus
		circus.addBuilding(building);
		System.out.println(building.getBuildingType() + " has been added to the circus.");
    }

    private static void handleGenerateTicket(Scanner scanner) {
        double totalAmount = 0;
        double basePrice;
        StringBuilder ticketDetails = new StringBuilder();
        boolean addMoreTickets = true;

        System.out.print("\nEnter ticket base price: ");
        basePrice = scanner.nextDouble();
        scanner.nextLine();

        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        while (addMoreTickets) {
            // Select day of the week
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek day = DayOfWeek.values()[i];
                if (day.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, day);
                }
            }
            System.out.print("\nEnter your choice: ");
            int dayChoice = scanner.nextInt();
            scanner.nextLine();

            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
                System.out.println("Invalid choice. Please select a valid day.");
                continue;
            }

            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Select customer type
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            System.out.print("\nEnter your choice: ");
            int customerType = scanner.nextInt();
            scanner.nextLine();

            double customerDiscount = 0.0;
            String customerTypeName = "";
            switch (customerType) {
                case 1:
                    customerDiscount = 0.10;
                    customerTypeName = "child";
                    break;
                case 2:
                    customerDiscount = 0.10;
                    customerTypeName = "student";
                    break;
                case 3:
                    customerTypeName = "adult";
                    break;
                case 4:
                    customerDiscount = 0.05;
                    customerTypeName = "senior";
                    break;
                default:
                    System.out.println("Invalid customer type. Please try again.");
                    continue;
            }

            // Select seat location
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            System.out.print("\nEnter your choice: ");
            int seatLocation = scanner.nextInt();
            scanner.nextLine();

            double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

            System.out.print("Enter number of tickets: ");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine();

            // Calculate discounts and total price for this batch of tickets
            Ticket ticket = new Ticket(selectedDay.toString(), basePrice, customerType);
            double ticketPrice = ticket.calculatePrice();
            
            ticketPrice *= seatMultiplier * (1 - seatDiscount);
            // Add to total amount
            totalAmount += ticketPrice;
            // Append details of this batch to the ticket details
            double totalBatchPrice = ticketPrice * numberOfTickets;

            ticketDetails.append(String.format("%d %s $%.2f (Day: %s", 
                numberOfTickets, customerTypeName, totalBatchPrice, selectedDay));

            // Append day discount if applicable
            if (dayDiscount > 0) {
                ticketDetails.append(String.format(", Day Discount: %.0f%%", dayDiscount * 100));
            }

            // Append customer discount if applicable
            if (customerDiscount > 0) {
                ticketDetails.append(String.format(", Customer Type Discount: %.0f%%", customerDiscount * 100));
            }

            // Append seat discount if applicable
            if (seatDiscount > 0) {
                ticketDetails.append(String.format(", Seat Discount: %.0f%%", seatDiscount * 100));
            }

            ticketDetails.append(")\n");

            // Ask user to add more tickets
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreTickets = response.equals("y");
        }

        // Display ticket calculation details
        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails);

        // Display final total amount
        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }


   
}
