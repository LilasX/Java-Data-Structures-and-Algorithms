package graph;

public class MainGraph 
{

	public static void main(String[] args) 
	{
//		Graph myGraph = new Graph();
//		
//		myGraph.addVertex("A");
//		myGraph.addVertex("B");
//		myGraph.addVertex("C");
//		
//		myGraph.addEdge("A", "B");
//		myGraph.addEdge("A", "C");
//		myGraph.addEdge("B", "C");
//		
//		myGraph.printGraph();
//		
//		myGraph.removeEdge("A", "B");
//		myGraph.printGraph();
		
		Graph myGraph = new Graph();
		
		myGraph.addVertex("A");
		myGraph.addVertex("B");
		myGraph.addVertex("C");
		myGraph.addVertex("D");
		
		myGraph.addEdge("A", "B");
		myGraph.addEdge("A", "C");
		myGraph.addEdge("A", "D");
		myGraph.addEdge("B", "D");
		myGraph.addEdge("C", "D");
		
		myGraph.printGraph();
		
		myGraph.removeVertex("D");
		myGraph.printGraph();
	}

}
