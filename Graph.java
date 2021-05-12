package edu.wmich.CS3310.PA6.RajBasnet;

import java.util.Arrays;

/**
 * This class represents all the information to create graph structure with edges and vertices.
 * Initializes the variables integer V and E for vertices and edges, also variable Edge edge[] array
 */
public class Graph {

	private int V, E;
	private Edge edge[];

	/**
	 * Creates a constructor with parameters integer v and e
	 * Initialize variable V to be parameter v and create array of edges
	 * @param v Integer represents the number of vertices in graph
	 * @param e Integer represents the number of edges in graph
	 */
	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[this.getE()];
		for(int i = 0; i < e; ++i) { //GeeksforGeeks
			edge[i] = new Edge();
		}
	}

	/**
	 * Sets the number of vertices for the graph
	 * @param v Integer represents the number of vertices of graph
	 */
	public void setV(int v) {
		this.V = v;
	}

	/**
	 * @return Returns the number of vertices of graph
	 */
	public int getV() {
		return V;
	}

	/**
	 * Sets the number of edges for the graph
	 * @param e Integer represents the number of edges of the graph
	 */
	public void setE(int e) {
		this.E = e;
	}

	/**
	 * @return Returns the number of edges of the graph
	 */
	public int getE() {
		return E;
	}

	/**
	 * Sets the edge array including all the edges
	 * @param edge Edge[] represents the edge of graph to be included in array
	 */
	public void setEdge(Edge[] edge) {
		this.edge = edge;
	}

	/**
	 * @return Returns the collection of edges
	 */
	public Edge[] getEdge() {
		return edge;
	}

	/**
	 * This method finds the set of element i using path compression technique
	 * @param subsets Subset represents the array of subsets of elements
	 * @param i Integer represents the element to be found
	 * @return Returns the parent node of the subset of elements 
	 */
	//GeeksforGeeks
	public int find(Subset subsets[], int i) {

		//Finds root and recursively makes  the root node as parent of i 
		if (subsets[i].getParent() != i) {

			subsets[i].setParent(find(subsets, subsets[i].getParent()));

		}
		return subsets[i].getParent();
	}

	/**
	 * This method performs the union of two sets using union by rank technique
	 * @param subsets Subset represents the array of subsets of elements
	 * @param x Integer represents the vertex of edge used for providing rank
	 * @param y Integer represents another vertex of edge used for providing rank
	 */
	//GeeksforGeeks
	public void Union(Subset subsets[], int x, int y) {

		//Initialize xroot and yroot as recursive find functions of x and y 
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		//Compares the rank of xroot and yroot and then attaches smaller rank tree under the root of higher rank tree 
		//If rank for xroot is smaller, then sets the parent of xroot to be yroot
		if (subsets[xroot].getRank() < subsets[yroot].getRank()) {
			subsets[xroot].setParent(yroot);

			//If rank for yroot is smaller, then sets the parent of yroot to be xroot
		} else if (subsets[xroot].getRank() > subsets[yroot].getRank()) {
			subsets[yroot].setParent(xroot);

			//For same ranks, makes xroot as parent of yroot and increment the rank xroot by one
		} else {
			subsets[yroot].setParent(xroot);
			subsets[xroot].setRank(subsets[xroot].getRank() + 1);
		}
	}

	/**
	 * This method includes the function to construct minimum spanning tree using Kruskal's algorithm required for graph
	 */
	//GeeksforGeeks
	public void KruskalMST() {

		//Initialize the result array to store resultant edges for minimum spanning tree
		Edge result[] = new Edge[V]; 

		//Index variable needed for result array
		int e = 0; 

		//Index variable needed for sorted edges
		int i = 0; 

		//Allocate result array with edges of the graph
		for (i = 0; i < V; ++i) {
			result[i] = new Edge();
		}
		//This function call sort the edges in ascending order according to weight
		Arrays.sort(edge);

		//Create subset array to store the subsets of elements
		Subset subsets[] = new Subset[V];

		//Allocate subset array with elements of graph
		for (i = 0; i < V; ++i) {
			subsets[i] = new Subset();
		}

		//Creates the subsets equal to number of vertices with single elements
		for (int v = 0; v < V; ++v) {
			subsets[v].setParent(v);
			subsets[v].setRank(0);

		}

		//Index for picking next edge
		i = 0; 

		// V-1 number of edges should be taken and loop until less than that number
		while (e < V - 1) 
		{
			//Smallest edge should be taken and index of edge array is incremented

			Edge next_edge = new Edge();
			next_edge = edge[i++];

			//Initializes variables x and y to find the source and destination vertices for the edge
			int x = find(subsets, next_edge.getSrc());
			int y = find(subsets, next_edge.getDest());

			//If this edge does not create a cycle, then it is included in the result array and index of result array is incremented for next edge
			//Creates union so that the cycle formed in graph could be known
			//If the edge cause cycle, it is discarded
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}

		}

		//Prints the final contents of the result array present in minimum spanning tree
		//Also, prints the minimum cost of the MST adding all the weight of edges present in the tree

		System.out.println("Following are the edges in the constructed Minimum Spanning Tree (MST)");

		int minimumCost = 0;

		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].getSrc()+ " -- " + result[i].getDest() + " == " + result[i].getWeight());
			minimumCost += result[i].getWeight();
		}
		System.out.println("Minimum Cost Spanning Tree = " + minimumCost);
	}

}
