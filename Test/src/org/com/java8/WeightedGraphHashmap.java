package org.com.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WeightedGraphHashmap {
	private HashMap<Integer, ArrayList<Edge>> graph;

	public WeightedGraphHashmap() {
		graph = new HashMap<>();
	}

	class Edge {

		int endVertex;
		int weight;

		public Edge(int endVertex, int weight) {
			this.endVertex = endVertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + endVertex + "," + weight + ")";
		}
	}

	public void getAllAdjacent(int source) {
		System.out.println(graph.get(source));
	}

	public boolean isGraphConnected() {

		HashSet<Integer> visited = new HashSet<>();
		BFS(visited, 1);
		return visited.size() == graph.size();

	}

	public int totalNumberOfGraphs() {
		int count = 0;
		HashSet<Integer> visited = new HashSet<>();
		
		for (int i = 1; i <= graph.size(); i++) {
			if (visited.contains(i) == false) {
				count++;
				BFS(visited, i);
			}
		}
		return count;
	}
	
	public void printMembersOfGraphs() {
		HashSet<Integer> visited = new HashSet<>();

		for (int i = 1; i <= graph.size(); i++) {
			if (visited.contains(i) == false) {
				BFS(visited, i);
				//visited = new HashSet<>();
				System.out.println("\n");
			}
		}
	}

	public void addEdge(int source, int destination, int weight) {
		if (!graph.containsKey(source)) {
			graph.put(source, new ArrayList<>());
		}
		if (!graph.containsKey(destination)) {
			graph.put(destination, new ArrayList<>());
		}
		graph.get(source).add(new Edge(destination, weight));
	}

	public boolean isPathExist(int source, int destination) {

		Queue<Integer> queue = new LinkedList<>();

		HashSet<Integer> visited = new HashSet<>();

		queue.add(source);

		while (!queue.isEmpty()) {
			Integer current = queue.remove();

			ArrayList<Edge> neighbourList = graph.get(current);
			visited.add(current);

			if (current == destination) {
				return true;
			}
			if (neighbourList != null) {
				for (Edge e : neighbourList) {
					if (!visited.contains(e.endVertex)) {
						queue.add(e.endVertex);
					}
				}
			}
		}
		return false;
	}

	public void BFS(HashSet<Integer> visited, int source) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		while (!queue.isEmpty()) {
			Integer current = queue.remove();
			System.out.println(current);
			ArrayList<Edge> neighbourList = graph.get(current);
			
			
			if (neighbourList != null) {
				for (Edge e : neighbourList) {
					if (!visited.contains(e.endVertex)) {
						queue.add(e.endVertex);
						visited.add(e.endVertex);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		WeightedGraphHashmap graphs = new WeightedGraphHashmap();

		// Add edges of the graph.
		graphs.addEdge(1, 2, 5);
		graphs.addEdge(1, 4, 5);
		graphs.addEdge(1, 3, 5);
		graphs.addEdge(2, 3, 10);
		graphs.addEdge(3, 5, 5);
		graphs.addEdge(4, 5, 5);
		graphs.addEdge(6, 7, 10);
		graphs.addEdge(9, 9, 10);

		/*System.out.println("is path exist " + graphs.isPathExist(3, 4));
		graphs.getAllAdjacent(1);
		System.out.println("is graph connected : " + graphs.isGraphConnected());

		System.out.println("total number of unconnected graph : " + graphs.totalNumberOfGraphs());*/
		
		graphs.printMembersOfGraphs();

	}

}
