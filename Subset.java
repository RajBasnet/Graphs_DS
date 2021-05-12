package edu.wmich.CS3310.PA6.RajBasnet;

/**
 * This class contains all the information to create the subset required for union and find and implement its functions.
 * Initialize variables integer parent and integer rank
 */
public class Subset {

	private int parent, rank;

	/**
	 * Sets the parent root needed for graph
	 * @param parent Integer represents the parent root
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}

	/**
	 * @return Returns the parent root in graph
	 */
	public int getParent() {
		return parent;
	}

	/**
	 * Sets the rank for the tree required in graph
	 * @param rank Integer represents the rank 
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return Returns the rank for tree required in graph
	 */
	public int getRank() {
		return rank;
	}
}
