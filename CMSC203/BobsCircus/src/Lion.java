/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Lion class that implements the Animal interface
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.util.Objects;

public class Lion implements Animal {
	//instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    //constructor
    public Lion(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	public void move() {
    	System.out.println(name + " slowly analyzes its targets.");
    }
	
    @Override
	public void makeSound() {
		System.out.println(name + " roars.");
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
    	// first make other an instance of Lion
    	Lion otherLion = (Lion) other;
    	if (this.age == otherLion.age && this.name.equals(otherLion.name) &&
			this.species.equals(otherLion.species) && this.color.equals(otherLion.color)) {
    		isEqual = true;
    	}
    	return isEqual;
    }

    @Override
    public String toString(){
    	return "Lion [Name: " + name + ", age: " + age + 
		       ", species: " + species + ", color: " + color + "]";
    }
    
}    