/**
 * Represents the edges between Towns in a graph
 * Acts as an edge in the graph
 */
public class Road implements Comparable<Road>{
	// fields
	private Town source;
	private Town destination;
	private int distance;
	private String name;
	// default no arg constructor
	public Road() {
		this.source = null;
		this.destination = null;
		this.distance = 0;
		this.name = null;
	}
	/**
	 * Fully paramterized constructor
	 * @param source
	 * @param destination
	 * @param distance
	 * @param name
	 */
	public Road(Town source, Town destination, int distance, String name) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.name = name;
	}
	/**
	 * returns the source
	 * @return source
	 */
	public Town getSource() {
		return this.source;
	}
	/**
	 * Sets the source
	 * @param source
	 */
	public void setSource(Town source) {
		this.source = source;
	}
	/**
	 * returns the destination
	 * @return destination
	 */
	public Town getDestination() {
		return this.destination;
	}
	/**
	 * sets the destination
	 * @param destination
	 */
	public void setDestination(Town destination) {
		this.destination = destination;
	}
	/**
	 * returns the distance
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * sets the distance
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * returns the name of road
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * sets the name of the road
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * compareTo method needed to compare between edges
	 * compares by name alphabetically
	 * @param other road
	 */
	@Override
	public int compareTo(Road other) {
		return this.name.compareTo(other.name);
	}
	/**
	 * overriden equals method for undirected graph
	 * A-B also equals B-A
	 * @param obj is the object to compare
	 */
	@Override
	public boolean equals(Object obj) {
		// check if the objects are the same
		if(this == obj) {
			return true;
		}
		// check if obj is null or not the same class
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		// cast Road onto the object
		Road other = (Road) obj;
		// check if they share the same source and destination
		boolean sameDirection = this.source.equals(other.source) && this.destination.equals(other.destination);
		// check if they share opposite 
		boolean oppositeDirection = this.source.equals(other.destination) && this.destination.equals(other.source);
		//
		return sameDirection || oppositeDirection;
	}
	/**
	 * for hashCode contract and to make sure they hash the same
	 */
	@Override
	public int hashCode() {
		return source.hashCode() + destination.hashCode();
	}
	/**
	 * toString method to show all info
	 */
	@Override
	public String toString() {
		return source.getName() + " via " + name + " to "+ destination.getName() + " " + distance + " mi";	
		}
}
