import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphStudentTest {
	private Graph graph;
	private Town town1,town2,town3;
	
	@BeforeEach
	public void setUp() throws Exception {
		graph = new Graph();
		town1 = new Town("Town1");
		town2 = new Town("Town2");
		town3 = new Town("Town3");
		graph.addVertex(town1);
		graph.addVertex(town2);
		graph.addVertex(town3);
		graph.addEdge(town1, town2, 5, "Road1");
		graph.addEdge(town2, town3, 10, "Road2");
	}
	@AfterEach
	public void tearDown() throws Exception {
		graph = null;
		town1 = null;
		town2 = null;
		town3 = null;
	}

	@Test
	final void testGraphAddEdge() {
		Town town4 = new Town("Town4");
		graph.addVertex(town4);
		graph.addEdge(town3, town4, 15, "Road3");
		assertTrue(graph.containsEdge(town3, town4));
	}
	
	@Test
	final void testGraphContainsEdge() {
		assertTrue(graph.containsEdge(town1, town2));
		assertFalse(graph.containsEdge(town1, town3));
	}
	
	@Test
	final void testGraphEdgeSet() {
		assertEquals(2, graph.edgeSet().size());
	}
	
	@Test
	final void testGraphRemoveEdge() {
		graph.removeEdge(town1, town2, 5, "Road1");
		assertFalse(graph.containsEdge(town1, town2));
	}
	
	@Test
	final void testGraphVertexSet() {
		assertEquals(3, graph.vertexSet().size());
	}
	
	@Test
	final void testGraphRemoveVertex() {
		graph.removeVertex(town3);
		assertFalse(graph.vertexSet().contains(town3));
	}
	
	@Test
	final void testGraphShortestPath() {
		ArrayList<String> path = graph.shortestPath(town1, town3);
		assertEquals(2, path.size());
		assertEquals("Town1 via Road1 to Town2 5 mi", path.get(0));
		assertEquals("Town2 via Road2 to Town3 10 mi", path.get(1));
		// add another town and road
		Town town4 = new Town("Town4");
		graph.addVertex(town4);
		graph.addEdge(town3, town4, 2, "Road3");
		// find shortest path from town1 to town4
		path = graph.shortestPath(town1, town4);
		assertEquals(3, path.size());
		assertEquals("Town1 via Road1 to Town2 5 mi", path.get(0));
		assertEquals("Town2 via Road2 to Town3 10 mi", path.get(1));
		assertEquals("Town3 via Road3 to Town4 2 mi", path.get(2));
	}
	
	@Test
	final void testRemoveVertexAndEdge() {
		graph.removeEdge(town1, town2, 5, "Road1");
		assertFalse(graph.containsEdge(town1, town2));
		graph.removeVertex(town2);
		assertFalse(graph.vertexSet().contains(town2));
	}
}
