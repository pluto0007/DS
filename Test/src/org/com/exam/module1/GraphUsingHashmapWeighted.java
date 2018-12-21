package org.com.exam.module1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphUsingHashmapWeighted {

	/*
	 * Program to represent WEIGHTED DIRECTED graph as Adjacency List using
	 * hashmap
	 */

	private static HashMap<Integer, Node> graph = new HashMap<Integer, Node>();

	class Node {

		private int id;
		private ArrayList<Edge> adjacent;

		public Node(int id) {
			this.id = id;
			this.adjacent = new ArrayList<Edge>();
		}

		// Getter method for start vertex
		public int getId() {
			return id;
		}

		// Getter method for adjacent vertices
		public ArrayList<Edge> getAdjacent() {
			return adjacent;
		}

		public void addAdjacenct(int endVertex, int weight) {
			adjacent.add(new Edge(endVertex, weight));
		}

		@Override
		public String toString() {
			String result = "";
			for (Edge edge : adjacent) {
				result += edge.endVertex + " ";
			}
			return result;
		}

	}

	class Edge {

		private int endVertex;
		private int weight;

		public Edge(int endVertex, int weight) {
			this.endVertex = endVertex;
			this.weight = weight;
		}

		// Getter method for end vertex
		public int getEndVertex() {
			return endVertex;
		}

		// Getter method for weight of the edge
		public int getWeight() {
			return weight;
		}

	}

	public Node getOrCreateNode(int id) {
		if (graph.containsKey(id)) {
			return graph.get(id);
		} else {
			Node node = new Node(id);
			graph.put(id, node);
			return node;
		}
	}

	public void addEdge(int source, int destination, int weight) {
		Node node =getOrCreateNode(source);
		node.addAdjacenct(destination, weight);
// To make graph undirected		
/*		Node destNode = getOrCreateNode(destination);
		destNode.addAdjacenct(source, weight);*/
	}

	public ArrayList<Edge> getAllAdjacenctVertices(int id) {
		Node node =getOrCreateNode(id);
		return node.getAdjacent();
	}
	
	public boolean isConnected(int source, int destination) {
		ArrayList<Edge> list = getOrCreateNode(source).getAdjacent();
		for(Edge edge : list) {
			if(edge.endVertex==destination) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPathExist(int source,int destination) {
		LinkedList<Node> queue = new LinkedList<>();
		
		HashSet<Integer> visited = new HashSet<>();
		
		Node node = getOrCreateNode(source);
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			Node parent = queue.remove();
			parent = getOrCreateNode(parent.id);
			System.out.println(parent.id);
			if(parent.getId()==destination) {
				return true;
			}
			
			visited.add(parent.id);
			
			for(Edge e : parent.getAdjacent()) {
				Node nodeNew = returnNode(e.endVertex);
				if(!visited.contains(nodeNew)) {
					queue.add(nodeNew);
				}
			}
		}
		return false;
		

		
	}
	public Node returnNode(int id) {

		if (graph.containsKey(id)) {
			Node node = new Node(id);
			return node;
		} else {
			Node node = new Node(id);
			graph.put(id, node);
			return node;
		}
	
		
	}
	public static void main(String[] args) {
		GraphUsingHashmapWeighted graphs = new GraphUsingHashmapWeighted();
		
		//Add edges of the graph.
		graphs.addEdge(1,2,5);
		graphs.addEdge(1,4,5);
		graphs.addEdge(1,3,5);
		graphs.addEdge(2,3,10);
		graphs.addEdge(3,5,5);
		graphs.addEdge(4,5,5);
		
		//Find adjacent of vertex 1 and print them.
		ArrayList<Edge> adjacent = graphs.getAllAdjacenctVertices(1);
		System.out.print("Adjacent of 1 are: ");
		for(Edge i: adjacent)
			System.out.print(i.getEndVertex() + " ");
		
		
		//Find whether vertices 2 and 1 are connected.
		System.out.println();
		System.out.println("2 and 1 are connected: "+graphs.isConnected(2,1));
		
		System.out.println(graphs.isPathExist(2, 4));
	}

}
