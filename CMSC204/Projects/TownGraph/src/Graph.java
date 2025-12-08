import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Main graph class that implements the given graphInterface
 * The town acts as a vertex, the road as the edge
 */
public class Graph implements GraphInterface<Town, Road>{
	// Create lists
	private ArrayList<Town> towns;
	private ArrayList<Road> roads;
	// Maps for Dijkstra
	private Map<Town, Integer> distance;
	private Map<Town, Town> previous;
	
	/**
	 * default no arg constructor
	 */
	public Graph() {
		this.towns = new ArrayList<>();
		this.roads = new ArrayList<>();
		this.distance = new HashMap<>();
		this.previous = new HashMap<>();
	}
	// 													Vertex methods
	/**
	 * adds a vertex to the graph
	 * @param vertex the town as vertex
	 */
	@Override
	public boolean addVertex(Town vertex) {
		//null check
		if(vertex == null) {
			throw new NullPointerException("Null Vertex cannot be added.");
		}
		// check if it already exists and is in the list
		if(towns.contains(vertex)) {
			return false;
		}
		// if neither of those two are the case then add and return true
		towns.add(vertex);
		return true;
	}
	/***
	 * creates a hashSet of the towns to see all the towns (vertex)
	 * @return new hashSet of the towns 
	 */
	@Override
	public Set<Town> vertexSet(){
		return new HashSet<>(towns);
	}
	/**
	 * checks to see if the Town is in the list
	 * @param vertex the town
	 * @return true or false if it is contained
	 */
	@Override
	public boolean containsVertex(Town vertex) {
		//null check
		if(vertex == null) {
			return false;
		}
		// otherwise check if its contained
		return towns.contains(vertex);
	}
	/**
	 * remove a town from the graph
	 * @param vertex the town targeted
	 */
	@Override
	public boolean removeVertex(Town vertex) {
		// null check
		if(vertex == null) {
			return false;
		}
		// check if town exists in graph
		if(!towns.contains(vertex)) {
			return false;
		}
		// Remove all the roads in contact
		roads.removeAll(edgesOf(vertex));
		// remove and return true
		towns.remove(vertex);
		return true;
	}
	//													Edge methods
	/**
	 * checks if there is an edge between two towns(vertices)
	 * @param source
	 * @param destination
	 * @return null if it doesnt exist
	 */
	@Override
	public Road getEdge(Town source, Town destination) {
		// check for null
		if(source == null || destination == null) {
			// if towns dont exist, neither does the edge
			return null;
		}
		// Traverse through all roads(edges)
		for(Road road : roads) {
			// create placeholders
			Town roadSource = road.getSource();
			Town roadDestination = road.getDestination();
			// now check both ways 
			if((roadSource.equals(source) && roadDestination.equals(destination)) ||
			   (roadSource.equals(destination) && roadDestination.equals(source))){
					// return a road if found
					return road;
				}
		}
		// otherwise return null
		return null;
	}
	 /**
	  * adds an edge to the graph from one vertex to another
	  * @param source the source of the edge
	  * @param destination the destination of the edge
	  * @param weight the weight of the edge
	  * @param description the description of the edge
	  */
	@Override
	public Road addEdge(Town source, Town destination, int weight, String description) {
		// Check if the vertices exist
		if(source == null || destination == null) {
			throw new NullPointerException("Vertices cannot be null.");
		}
		// check if the vertices exist
		if(!towns.contains(source) || !towns.contains(destination)) {
			throw new IllegalArgumentException("Both vertices must exist in the graph.");
		}
		// check if the edge already exists
		if(getEdge(source,destination) != null) {
			// if it does, return it
			return getEdge(source, destination);
		}
		// otherwise add the new road(edge), and return it
		Road newRoad = new Road(source, destination, weight, description);
		roads.add(newRoad);
		return newRoad;
	}
	/**
	 * checks if an edge exists between two vertices
	 * @param source the source vertex
	 * @param destination the vertex being went to
	 * @return true if there is an edge between them, otherwise false
	 */
	@Override
	public boolean containsEdge(Town source, Town destination) {
		return getEdge(source,destination) != null;
	}
	/**
	 * find all the edges of a town
	 * @param vertex the town
	 * @return all roads that touch the vertex
	 */
	@Override
	public Set<Road> edgesOf(Town vertex){
		// null check
		if(vertex == null) {
			throw new NullPointerException("Vertex cannot be null.");
		}
		// check if town exists
		if(!towns.contains(vertex)) {
			throw new IllegalArgumentException("Vertex does not exist in graph.");
		}
		// create HashSet to store all roads where the vertex is the source or the destination
		Set<Road> incident = new HashSet<>();
		// step through all roads to find the edges
		for (Road road : roads) {
			if(road.getSource().equals(vertex) || road.getDestination().equals(vertex)) {
				incident.add(road);
			}
		}
		// return the set of the edges
		return incident;
	}
	/**
	 * removes an edge from the source vertex to the target vertex
	 * @param source the source vertex of the edge
	 * @param destination the destination of the edge
	 * @param weight the weight of the edge
	 * @param description the name of the edge
	 * @return the removed edge or null if nothing was removed
	 */
	@Override
	public Road removeEdge(Town source, Town destination, int weight, String description) {
		// check source and destination exist
		if(source == null || destination == null) {
			return null;
		}
		// check weight and description
		if(weight < 0 || description == null) {
			return null;
		}
		// check if edge exists, return null if not
		Road road = getEdge(source, destination);
		if(road == null) {
			return null;
		}
		// do final checks then remove
		if(road.getDistance() != weight || !road.getName().equals(description)) {
			return null;
		}
		// remove and return the edge
		roads.remove(road);
		return road;
	}
	/**
	 * returns the set of edges contained in the graph in hashSet
	 */
	@Override
	public Set<Road> edgeSet(){
		return new HashSet<>(roads);
	}
	//												DijkstraShortestPath method
	/**
	 * dijkstraShortestPath algorithm using method 2 from slides
	 * (open and closed set)
	 * @param source the selected vertex
	 */
	@Override
	public void dijkstraShortestPath(Town source) {
		// start by clearing maps from previous runs
		distance.clear();
		previous.clear();
		// check if source is null or if the town doesnt exist
		if(source == null || !towns.contains(source)) {
			return;
		}
		// create open and closed sets
		Set<Town> open = new HashSet<>(towns);
		Set<Town> closed = new HashSet<>();
		// initialize distances
		for(Town town : towns) {
			distance.put(town, Integer.MAX_VALUE);
			previous.put(town, null);
		}
		distance.put(source, 0);
		// move the source to the closed set
		closed.add(source);
		// remove it from open if it exists
		open.remove(source);
		// repeat until all towns are in closed set
		while(!open.isEmpty()) {
			// starting setup
			Town bestVertex = null;
			int bestDistance = Integer.MAX_VALUE;
			// check each vertex in the closed set
			for(Town town : closed) {
				// get the distance to the town
				int distanceToTown = distance.get(town);
				// check if its reachable, if its not it will be the integer Max Value
				if(distanceToTown == Integer.MAX_VALUE) {
					continue;
				}
				// now check the neighbors of town
				for(Road road : edgesOf(town)) {
					// get the neighboring town
					Town neighbor = null;
					if(road.getSource().equals(town)) {
						// neighbor is destination
						neighbor = road.getDestination();
					}
					// neighbor is source
					else {
						neighbor = road.getSource();
					}
					// if neighbor is already in open set, skip
					if(!open.contains(neighbor)) {
						continue;
					}
					// calculate new distance
					int newDistance = distanceToTown + road.getDistance();
					// check if new distance is better (greedy choice)
					if(newDistance < bestDistance) {
						bestDistance = newDistance;
						bestVertex = neighbor;
						// update previous map
						previous.put(neighbor, town);
					}
				}
			}
			// if there is no best vertex, break
			if(bestVertex == null) {
				break;
			}
			// update distance map and move best vertex to closed set
			distance.put(bestVertex, bestDistance);
			open.remove(bestVertex);
			closed.add(bestVertex);
		}
	}
	
	@Override
	public ArrayList<String> shortestPath(Town source, Town destination){
		// create path list
		ArrayList<String> path = new ArrayList<>();
		// check if source and destination are valid, if not return empty path
		if(source == null || destination == null || !towns.contains(source) || !towns.contains(destination)) {
			return path;
		}
		// run the djikstra algorithm
		dijkstraShortestPath(source);
		// get the best distance to destination
		Integer bestDistance = distance.get(destination);
		// if best distance is infinite or null, there is no path so return an empty path
		if(bestDistance == null || bestDistance == Integer.MAX_VALUE) {
			return path;
		}
		// reconstruct the path from source to destination
		Town currentTown = destination;
		while(!currentTown.equals(source)) {
			// get the previous town from the map
			Town previousTown = previous.get(currentTown);
			// do a null check and clear path if null
			if(previousTown == null) {
				path.clear();
				return path;
			}
			// otherwise get the road between previousTown and currentTown
			Road road = getEdge(previousTown, currentTown);
			// create the path segment string
			String pathSegment = previousTown.getName() + " via " + road.getName() + " to "
								 + currentTown.getName() + " " + road.getDistance() + " mi";
			// add to the front of the path list
			path.add(0, pathSegment);
			// move to previous town
			currentTown = previousTown;
		}
		// return the constructed path
		return path;
	}
}
