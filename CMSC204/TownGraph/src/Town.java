import java.util.ArrayList;
import java.util.List;

/**
 * Holds name of a town and list of adjacent towns
 * Acts as a vertex in the graph
 */
public class Town implements Comparable<Town> {
	// String to hold town name
	private String name;
	// ArrayList to hold the adjacent towns
	private List<Town> adjacentTowns;
	/**
	 * Constructor to create name
	 * @param name of the town
	 */
	public Town(String name) {
		this.name = name;
		this.adjacentTowns = new ArrayList<>();
	}
	/**
	 * sets the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/* 
	 * The adjacent town methods are never used, but are inside the project requirements doc.
	 * I added the methods for design purposes, and to satisfy all the requirements, but it is redundant 
	 * as using Dijkstras algorithm in Graph is what stores the edges and adjacency.
	 */

	/**
	 * getAdjacentTowns returns a list of the adjacent towns
	 * @return list of adjacent towns
	 */
	public List<Town> getAdjacentTowns(){
		return adjacentTowns;
	}
	/**
	 * addAdjacentTown method to add an adjacent town
	 * @param town adjacent town to add
	 */
	public void addAdjacentTown(Town town) {
		// check for null
		if(town == null) {
			return;
		}
		// check if the town is already in the list
		if(adjacentTowns.contains(town)) {
			return;
		}
		// if both checks pass, add the town
		adjacentTowns.add(town);
	}
	
	
	/**
	 * equals method to compare objects
	 */
	@Override
	public boolean equals(Object obj) {
		// check if they are the same object
		if(this == obj) {
			return true;
		}
		// check if obj is null or not the same class
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		// cast obj to Town and compare names
		Town other = (Town) obj;
		// compare the names for equality
		return this.name.equals(other.name);
	}
	/**
	 * returns the hashCode of the name
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	/**
	 * compareTo method to compare the towns
	 */
	@Override
	public int compareTo(Town other) {
		return this.name.compareTo(other.name);
	}
	/**
	 * toString to return name
	 */
	@Override
	public String toString() {
		return name;
	}
}
