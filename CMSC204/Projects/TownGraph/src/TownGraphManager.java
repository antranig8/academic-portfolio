import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * TownGraphManager class manages a graph of towns and roads.
 */
public class TownGraphManager implements TownGraphManagerInterface {
	// Create graph object
	private Graph graph;
	// default constructor
	public TownGraphManager() {
		this.graph = new Graph();
	}
	/**
	 * method to add town to a graph
	 * @param town name of town
	 * @return true if the town was added otherwise false
	 */
	@Override
	public boolean addTown(String town) {
		// check for null
		if(town == null) {
			return false;
		}
		// create the town
		Town newTown = new Town(town);
		// return the town being added (true)
		return graph.addVertex(newTown);
	}
	/**
	 * checks if a town is already in the graph
	 * @param town the town name
	 * @return true if the town is already in the graph otherwise false
	 */
	@Override
	public boolean containsTown(String town) {
		// check for null
		if(town == null) {
			return false;
		}
		// create the town
		Town check = new Town(town);
		// check if the town is contained
		return graph.containsVertex(check);
	}
	/**
	 * returns the town object if it exists in the graph
	 * @param town name of town
	 * @return town object if it exists
	 */
	public Town getTown(String town) {
		// do a null check of town names
		if(town == null) {
			return null;
		}
		// create the town object
		Town town1 = null;
		// now check the vertex set for the towns
		for(Town towns : graph.vertexSet()) {
			if(towns.getName().equals(town)) {
				town1 = towns;
			}
		}
		// return the town
		return town1;
	}
	/**
	 * creates an arraylist of all the town in alphabetical order
	 * @return the list of all the towns in alphabetical order
	 */
	@Override
	public ArrayList<String> allTowns(){
		// create arrayList to store the vertex set
		ArrayList<String> towns = new ArrayList<>();
		// traverse through the set
		for(Town town : graph.vertexSet()) {
			towns.add(town.getName());
		}
		// sort alphabertically
		Collections.sort(towns);
		return towns;
	}
	/**
	 * addRoad method that adds a road with 2 towns and a road name
	 * not creating new towns, just adding a road between 2 already existing towns
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @param roadName name of road
	 * @return true if the road was added otherwsie false
	 */
	@Override
	public boolean addRoad(String t1, String t2, int weight, String roadName) {
		// do a null check of town names
		if(t1 == null || t2 == null || roadName == null) {
			return false;
		}
		// do a null check for the weight 
		if(weight < 0) {
			return false;
		}
		// create the two town objects
		Town town1 = null;
		Town town2 = null;
		// now check the vertex set for the towns
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(t1)) {
				town1 = town;
			}
			if(town.getName().equals(t2)) {
				town2 = town;
			}
		}
		// check if they were found (not still null)
		if(town1 == null || town2 == null) {
			return false;
		}
		// if they were found, add the edge between them
		graph.addEdge(town1,town2,weight,roadName);
		// return true
		return true;
	}
	/**
	 * checks if a road is in the graph
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @return true if the road is in the graph otherwise false
	 */
	@Override
	public boolean containsRoadConnection(String t1, String t2) {
		// do a null check of town names
		if(t1 == null || t2 == null) {
			return false;
		}
		// create the two town objects
		Town town1 = null;
		Town town2 = null;
		// now check the vertex set for the towns
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(t1)) {
				town1 = town;
			}
			if(town.getName().equals(t2)) {
				town2 = town;
			}
		}
		// check if they were found (not still null)
		if(town1 == null || town2 == null) {
			return false;
		}
		// if they were found return the result of containsEdge
		return graph.containsEdge(town1,town2);
	}
	/**
	 * returns the name of a road that two towns are connected to
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String t1, String t2) {
		// do a null check of town names
		if(t1 == null || t2 == null) {
			return null;
		}
		// create the two town objects
		Town town1 = null;
		Town town2 = null;
		// now check the vertex set for the towns
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(t1)) {
				town1 = town;
			}
			if(town.getName().equals(t2)) {
				town2 = town;
			}
		}
		// check if they were found (not still null)
		if(town1 == null || town2 == null) {
			return null;
		}
		// get the road between the towns name
		Road road = graph.getEdge(town1, town2);
		if(road != null) {
			// return the roadName
			return road.getName();
		}
		// otherwise return null
		return null;
	}
	/**
	 * deletes a road from the graph
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String t1, String t2, String road) {
		// do a null check of town names
		if(t1 == null || t2 == null || road == null) {
			return false;
		}
		// create the two town objects
		Town town1 = null;
		Town town2 = null;
		// now check the vertex set for the towns
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(t1)) {
				town1 = town;
			}
			if(town.getName().equals(t2)) {
				town2 = town;
			}
		}
		// check if they were found (not still null)
		if(town1 == null || town2 == null) {
			return false;
		}
		// check if the edge is between them
		Road edge = null;
		if(!graph.containsEdge(town1,town2)){
			return false;
		}
		edge = graph.getEdge(town1,town2);
		// make sure its the right road
		if(!edge.getName().equals(road)) {
			return false;
		}
		// if it is the right road, remove it
		if(graph.removeEdge(town1, town2, edge.getDistance(), road) != null) {
			return true;
		}
		// otherwise return false
		return false;		
	}
	/**
	 * delete a town from the graph
	 * @param town name of town
	 * @return true if the town was deleted, false if not
	 */
	@Override
	public boolean deleteTown(String town) {
		// null check
		if(town == null) {
			return false;
		}
		// find the town
		Town t1 = null;
		for(Town towns : graph.vertexSet()) {
			if(towns.getName().equals(town)) {
				t1 = towns;
			}
		}
		// if town is found, remove and return true
		if(t1 != null) {
			graph.removeVertex(t1);
			return true;
		}
		// otherwise return false
		return false;
	}
	/**
	 * creates an arraylist of all the roads in sorted order by road name
	 * @return the list of all the towns in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads(){
		// create arrayList to store the vertex set
		ArrayList<String> roads = new ArrayList<>();
		// traverse through the set
		for(Road road : graph.edgeSet()) {
			roads.add(road.getName());
		}
		// sort sorted order
		Collections.sort(roads);
		return roads;
	}
	/**
	 * returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @return an Arraylist of roads connecting the two towns together, otherwise an empty arrayList
	 */
	@Override
	public ArrayList<String> getPath(String t1, String t2){
		// Create the arrayList 
		ArrayList<String> path = new ArrayList<>();
		// do a null check of town names
		if(t1 == null || t2 == null) {
			return path;
		}
		// create the two town objects
		Town town1 = null;
		Town town2 = null;
		// now check the vertex set for the towns
		for(Town town : graph.vertexSet()) {
			if(town.getName().equals(t1)) {
				town1 = town;
			}
			if(town.getName().equals(t2)) {
						town2 = town;
			}
		}
		// check if they were found (not still null)
		if(town1 == null || town2 == null) {
			return path;
		}		
		// get the shortest path
		path = graph.shortestPath(town1, town2);
		// return the path
		return path;
	}
	/**
	 * method that takes input from a file and converts it into a graph
	 * @param file the file being used for input
	 */
	public void populateTownGraph(File file) throws IOException, FileNotFoundException{
		// check for null
		if(file == null) {
			throw new FileNotFoundException("File not found.");
		}
		// check if file has any issues
		if(!file.canRead()) {
			throw new IOException("File cannot be read.");
		}
		// create file scanner
		try(Scanner input = new Scanner(file)){
			// go through every line
			while(input.hasNextLine()) {
				// trim line
				String line = input.nextLine().trim();
				//skip empty lines
				if(line.isEmpty()) {
					continue;
				}
				// make sure the format is correct
				// roadName, miles; town1; town2
				// split by comma and semicolon
				String[] arr = line.split("[,;]");
				// Should be split into 4 parts now
				if(arr.length != 4) {
					continue;
				}
				// Now store all values
				String road = arr[0].trim();
				int distance = Integer.parseInt(arr[1].trim());
				String town1 = arr[2].trim();
				String town2 = arr[3].trim();
				// now create their respective objects
				addTown(town1);
				addTown(town2);
				addRoad(town1,town2,distance,road);
			}
		}
		
	}
}
