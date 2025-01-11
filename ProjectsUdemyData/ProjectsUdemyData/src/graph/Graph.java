package graph;

import java.util.*;

public class Graph 
{
	// graph represented by a map where the key represents the vertex
	// and the ArrayList lists the vertices connected by an edge with the vertex (key)
	private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
	
	// prints the graph as an adjacent list
	public void printGraph()
	{
		System.out.println(adjList);
	}
	
	// adds a vertex in the graph
	public boolean addVertex(String vertex)
	{
		// if the vertex doesn't exist in the graph
		if(adjList.get(vertex) == null)
		{
			// add the vertex into the adjacent list with an empty ArrayList
			adjList.put(vertex, new ArrayList<String>());
			// return true since we successfully added a vertex into the graph
			return true;
		}
		
		// return false since we didn't add a new vertex into the graph
		return false;
	}
	
	// connect two vertices together by an edge (bidirectional)
	public boolean addEdge(String vertex1, String vertex2)
	{
		// if both vertices to be connected exist in the graph
		if(adjList.get(vertex1) != null && adjList.get(vertex2) != null)
		{
			// add the second vertex into the ArrayList of the first vertex to represent
			// that there's an edge from the first vertex to the second vertex
			adjList.get(vertex1).add(vertex2);
			// add the first vertex into the ArrayList of the second vertex to represent 
			// that there's an edge from the second vertex to the first vertex
			adjList.get(vertex2).add(vertex1);
			// we successfully created an edge between the two vertices
			return true;
		}
		
		// no edge was added to the graph
		return false;
	}
	
	// remove an edge in the graph
	public boolean removeEdge(String vertex1, String vertex2)
	{
		// if the edge to be removed is between two existing vertices in the graph
		if(adjList.get(vertex1) != null && adjList.get(vertex2) != null)
		{
			// remove the second vertex from the ArrayList of the first vertex
			adjList.get(vertex1).remove(vertex2);
			// remove the first vertex from the ArrayList of the second vertex
			adjList.get(vertex2).remove(vertex1);
			// we successfully removed the edge between the two given vertices
			return true;
		}
		
		// we failed to remove an edge
		return false;
	}
	
	// remove a vertex from the graph
	public boolean removeVertex(String vertex)
	{
		// if the vertex exists in the graph
		if(adjList.get(vertex) != null)
		{
			// for every other vertex who has an edge with the vertex to be removed
			for(String otherVertex : adjList.get(vertex))
			{
				// remove every edge that is connected to the vertex to be removed
				adjList.get(otherVertex).remove(vertex);
			}
			
			// remove the vertex itself from the graph
			adjList.remove(vertex);
			
			// we successfully removed the vertex from the graph
			return true;
		}
		
		// there's no vertex to be removed from the graph
		return false;
	}
}
