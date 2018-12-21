package org.com.exam.module1;

import java.util.ArrayList;
import java.util.List;

public class GraphUsingEdgeVertexList {

	class Edge {
		private int startVertex;
		private int endVertex;

		public int getStartVertex() {
			return startVertex;
		}

		public void setStartVertex(int startVertex) {
			this.startVertex = startVertex;
		}

		public int getEndVertex() {
			return endVertex;
		}

		public void setEndVertex(int endVertex) {
			this.endVertex = endVertex;
		}

		public Edge(int startVertex, int endVertex) {
			super();
			this.startVertex = startVertex;
			this.endVertex = endVertex;
		}
		
	}
	private List<Integer> vertexList = new ArrayList<>();
	private List<Edge> edgeList = new ArrayList<>();
	
	
	public void addEdge(int startVertex, int endVertex) {
		if(!vertexList.contains(startVertex)) {
			vertexList.add(startVertex);
		}
		edgeList.add(new Edge(startVertex, endVertex));
	}
	
	public void getAdjacencyNode(int vertex) {
		for(Edge edge : edgeList) {
			if(edge.getStartVertex()==vertex) {
				System.out.println(edge.getEndVertex());
			}
			else if (edge.getEndVertex()==vertex) {
				System.out.println(edge.getStartVertex());
			}
		}
	}
	
	public boolean isConnected(int startVertex, int endVertex) {
		for(Edge edge : edgeList) {
			if((edge.startVertex==startVertex && edge.endVertex==endVertex)||edge.startVertex==endVertex&&edge.endVertex==startVertex) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GraphUsingEdgeVertexList graph = new GraphUsingEdgeVertexList();
		
		
		//Add edges of the graph.
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(1,5);
		graph.addEdge(2,3);
		graph.addEdge(2,5);
		graph.addEdge(2,6);
		graph.addEdge(3,6);
		graph.addEdge(4,5);
		graph.addEdge(5,6);
		
		//Find adjacent of vertex 1 and print them.
		graph.getAdjacencyNode(1);
		
		//Find whether vertices 2 and 1 are connected.
		System.out.println();
		System.out.println("2 and 1 are connected: "+graph.isConnected(2,1));

	}

}
