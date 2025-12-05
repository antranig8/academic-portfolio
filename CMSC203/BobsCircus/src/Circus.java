/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Circus class that manages animals, persons, buildings, and tickets
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    // Add building
    public void addBuilding(Building building) {
		buildings.add(building);
	}
    // Display building
    public void displayAllBuildings() {
		for (Building building : buildings) {
			System.out.println(building);
		}
	}
    // Add person
    public void addPerson(Person person) {
		persons.add(person);
	}
    // Display person
    public void displayAllPersons() {
		for (Person person : persons) {
			System.out.println(person);
		}
	}
    // Add animal
    public void addAnimal(Animal animal) {
		animals.add(animal);
	}
    // Display animal using toString() method
    public void displayAllAnimals() {
		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}
	}
    // Selection sort to sort animals by age
    public void sortAnimalsByAge() {
		for (int index = 0; index < animals.size() - 1; index++) {
			for (int sort = 0; sort < animals.size() - index - 1; sort++) {
				if (animals.get(sort).getAge() > animals.get(sort + 1).getAge()) {
					// Swap the animals
					Animal temp = animals.get(sort);
					animals.set(sort, animals.get(sort + 1));
					animals.set(sort + 1, temp);
				}
			}
		}
	}
    // Selection sort to sort animals by name
    public void sortAnimalsByName() {
    	for(int index = 0; index < animals.size() - 1; index++) {
			for(int sort = 0; sort < animals.size() - index - 1; sort++) {
				if(animals.get(sort).getName().compareTo(animals.get(sort + 1).getName()) > 0) {
					// Swap the animals
					Animal temp = animals.get(sort);
					animals.set(sort, animals.get(sort + 1));
					animals.set(sort + 1, temp);
				}
			}
		}
    }
    // Search for an animal by name
    public String searchAnimalByName(String name) {
		for (Animal animal : animals) {
			if (animal.getName().equalsIgnoreCase(name)) {
				// Print the animal details if found
				return "Animal found: " + animal.toString();
			}
		}
		return "Animal not found.";
	}
    // Add ticket
    public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

    // Generate ticket
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        Ticket ticket = new Ticket(dayOfWeek, basePrice, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
        addTicket(ticket);
        return ticket;
    }
    // Below are getter methods needed for testing purposes
	public List<Animal> getAnimals() {
		return animals;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public List<Building> getBuildings() {
		return buildings;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
}
