import java.util.Objects;

public class Horse implements Animal {
	
	//instance variables
	private String name;
    private int age;
    private String species;
    private String color;
    
    //constructor
    public Horse(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	public void move() {
		System.out.println(name + " runs around the circus.");
	}
	
    @Override
	public void makeSound() {
    	System.out.println(name + " neighs.");
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
    	// first make other an instance of Horse
    	Horse otherHorse = (Horse) other;
    	if (this.age == otherHorse.age && this.name.equals(otherHorse.name) &&
			this.species.equals(otherHorse.species) && this.color.equals(otherHorse.color)) {
    		isEqual = true;
    	}
    	return isEqual;
    }

    @Override
    public String toString(){
    	return "Horse [Name: " + name + ", age: " + age + 
		       ", species: " + species + ", color: " + color + "]";
    }
    
}    