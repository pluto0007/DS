package org.com.exam.module1;

import java.util.LinkedList;
import java.util.List;

/*undirected weighted graph implementation using array of linkedlist*/
public class GraphUsingArrayOfLinkedList {
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

	// defining array of type linkedlist
	LinkedList<Edge>[] edgeArray;

	// constructor
	public GraphUsingArrayOfLinkedList(int n) {
		edgeArray = new LinkedList[n];

		for (int i = 0; i < edgeArray.length; i++) {
			// initializing the array
			edgeArray[i] = new LinkedList<>();
		}
	}

	public void addEdge(int startVertex, int endVertex, int weight) {
		edgeArray[startVertex].add(0, new Edge(endVertex, weight));
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < edgeArray.length; i++)
			result += i + "=>" + edgeArray[i] + "\n";
		return result;
	}

	public boolean isConnected(int startVertex, int endVertex) {
		for (Edge i : edgeArray[startVertex]) {
			if (i.endVertex == endVertex) {
				return true;
			}
		}
		return false;
	}

	public void getAdjacenancyNodes(int vertex) {
		for (Edge i : edgeArray[vertex]) {
			System.out.println(i.endVertex);
		}
	}

	public static void main(String[] args) {
		GraphUsingArrayOfLinkedList g = new GraphUsingArrayOfLinkedList(10);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		g.addEdge(2, 5, 10);
		g.addEdge(9, 3, 16);

		System.out.println(g);
		System.out.println(g.isConnected(9, 3));
		g.getAdjacenancyNodes(0);
	}
}
