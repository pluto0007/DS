package org.com.exam.module1;

import java.util.ArrayList;
import java.util.List;
/*
 * http://www.letscodethemup.com/graph-representation-adjacency-list/
 */

public class GraphAdjacencyMatrixWeighted {
	// 2-D array to store adjacency matrix
	private int[][] adjacencyMatrix;

	// variable to store size of 2-D array/adjacency matrix
	private int size;

	public GraphAdjacencyMatrixWeighted(int size) {
		this.size = size;
		adjacencyMatrix = new int[size][size];
	}

	public void add(int source, int destination, int weight) {
		adjacencyMatrix[source][destination] = weight;
		adjacencyMatrix[destination][source] = weight;
	}

	public ArrayList<Integer> findAdjacent(int index) {
		ArrayList<Integer> adjList = new ArrayList<>();
		for (int i =1; i < size; i++) {
			if (adjacencyMatrix[index][i] != Integer.MIN_VALUE) {
				adjList.add(i);
			}
		}
		return adjList;
	}
	
	public boolean isConnected(int src, int dst) {
		if (adjacencyMatrix[src][dst] != Integer.MIN_VALUE || adjacencyMatrix[dst][src] != Integer.MIN_VALUE) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] vertices = {1, 2, 3, 4, 5, 6};
		GraphAdjacencyMatrixWeighted graph = new GraphAdjacencyMatrixWeighted(vertices.length+1);
		
		//Add edges of the graph.
		graph.add(1,2,5);
		graph.add(1,4,6);
		graph.add(1,5,10);
		graph.add(2,3,1);
		graph.add(2,5,2);
		graph.add(2,6,7);
		graph.add(3,6,8);
		graph.add(4,5,3);
		graph.add(5,6,4);
		
		//Find adjacent of vertex 1 and print them.
		ArrayList<Integer> adjacent = graph.findAdjacent(1);
		System.out.print("Adjacent of 1 are: ");
		for(int i: adjacent)
			System.out.print(i + " ");
		
		//Find whether vertices 2 and 1 are connected.
		System.out.println();
		System.out.println("2 and 1 are connected: "+graph.isConnected(2,1));

	}

}
