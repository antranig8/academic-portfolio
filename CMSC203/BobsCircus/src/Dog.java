/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Dog class that implements the Animal interface
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.util.Objects;

public class Dog implements Animal, Cloneable {
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    public Dog(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	public void move() {
    	System.out.println(name + " runs around the cricus.");
    }
	
    @Override
	public void makeSound() {
    	System.out.println(name + " barks.");
    }

    @Override
	public String getName() {
		return name;
	}
	
    @Override
	public int getAge() {
    		return age;
    }

    @Override
	public Animal clone() {
    	try {
			return (Dog) 
			super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Cloning not supported for Dog", e);
		}
    }

    @Override
	public boolean equals(Object other) {
    	boolean isEqual = false;
    	
    	// Check for reference equality
    	if (this == other) {
			isEqual = true; 
		}
    	// Check for null or different class
    	if (other == null) {
    	// null is not equal to any object so return false
    		return false;
    	}
    	// Compare fields for logical equality
    	// first make other an instance of Dog
    	Dog otherDog = (Dog) other;
    	if (this.age == otherDog.age && this.name.equals(otherDog.name) &&
			this.species.equals(otherDog.species) && this.color.equals(otherDog.color)) {
    		isEqual = true;
    	}
    	return isEqual;
    }

    @Override
    public String toString(){
    	return "Dog [Name: " + name + ", age: " + age + 
		       ", species: " + species + ", color: " + color + "]";
    }
    
}    
