package edu.wmich.CS3310.PA6.RajBasnet;

/**
 * This class contains all the information to create the edge required in graph and implement its functions.
 * Implements the Comparable (Edge) interface to utilize the comparison method.
 * Initialize the variables integer src, integer dest and integer weight required in graph
 */
public class Edge implements Comparable<Edge> {

	private int src, dest, weight;

	/**
	 * This method compares the edges in graph according to their weights to sort the edges
	 * @param compareEdge Edge represents the edge for the graph for comparison
	 * @return Returns the required value needed by inbuilt sort algorithm
	 */
	public int compareTo(Edge compareEdge) {

		return getWeight() - compareEdge.getWeight(); //GeeksforGeeks
	}

	/**
	 * Sets the source for the edge and vertices in graph
	 * @param src Integer represents the source vertices 
	 */
	public void setSrc(int src) {
		this.src = src;
	}

	/**
	 * @return Returns the source vertices of graph
	 */
	public int getSrc() {
		return src;
	}

	/**
	 * Sets the destination for the edge and vertices in graph
	 * @param dest Integer represents the destination vertices
	 */
	public void setDest(int dest) {
		this.dest = dest;
	}

	/**
	 * @return Returns the destination vertices of graph
	 */
	public int getDest() {
		return dest;
	}

	/**
	 * Sets the weight for the edge in graph
	 * @param weight Integer represents the weight of the edge
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return Returns the weight of the edge of graph
	 */
	public int getWeight() {
		return weight;
	}

}
