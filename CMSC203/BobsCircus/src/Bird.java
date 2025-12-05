/*
 * Class: CMSC203 40438
 * Instructor: Prof. Grinberg
 * Description: Bird class that tests the Bird class
 * Due: 08/04/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
import java.util.Objects;

public class Bird implements Animal {
	//instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    //constructor
    public Bird(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	public void move() {
		System.out.println(name + " flies through the circus.");
	}
    
    @Override
	public void makeSound() {
		System.out.println(name + " chirps.");
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
       	// first make other an instance of Bird
       	Bird otherBird = (Bird) other;
       	if (this.age == otherBird.age && this.name.equals(otherBird.name) &&
   			this.species.equals(otherBird.species) && this.color.equals(otherBird.color)) {
       		isEqual = true;
       	}
       	return isEqual;
       }

       @Override
       public String toString(){
       	return "Bird [Name: " + name + ", age: " + age + 
   		       ", species: " + species + ", color: " + color + "]";
       }
       
   }