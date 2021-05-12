package edu.wmich.CS3310.PA6.RajBasnet;

/**
 * @author Raj
 * This is the main class which contains all the information required to construct minimum spanning tree from graph structure
 */
public class Main {

	/**
	 * This is the main method which initializes the graph structure and then create minimum spanning tree using Kruskal's algorithm
	 * @param args String[]
	 */
	public static void main(String[] args) {

		//Initializes the number of vertices and edges in graph
		int V = 8; // Number of vertices in graph
		int E = 16; // Number of edges in graph

		//Creates a new graph structure required for minimum spanning tree
		Graph graph = new Graph(V, E);

		//This is the graph present in PowerPoint Presentation from lecture of Week 12 and 13
		//The graph contains 8 vertices and 16 edges (For easiness 8 is replaced by 0)

		//Adding edge 1 -- 6 with weight 54 in index 0
		graph.getEdge()[0].setSrc(1);
		graph.getEdge()[0].setDest(6);
		graph.getEdge()[0].setWeight(54);

		//Adding edge 6 -- 4 with weight 74 in index 1
		graph.getEdge()[1].setSrc(6);
		graph.getEdge()[1].setDest(4);
		graph.getEdge()[1].setWeight(74);

		//Adding edge 4 -- 0 with weight 29 in index 2
		graph.getEdge()[2].setSrc(4);
		graph.getEdge()[2].setDest(0);
		graph.getEdge()[2].setWeight(29);

		//Adding edge 0 -- 7 with weight 68 in index 3
		graph.getEdge()[3].setSrc(0);
		graph.getEdge()[3].setDest(7);
		graph.getEdge()[3].setWeight(68);

		//Adding edge 7 -- 5 with weight 93 in index 4
		graph.getEdge()[4].setSrc(7);
		graph.getEdge()[4].setDest(5);
		graph.getEdge()[4].setWeight(93);

		//Adding edge 5 -- 1 with weight 80 in index 5
		graph.getEdge()[5].setSrc(5);
		graph.getEdge()[5].setDest(1);
		graph.getEdge()[5].setWeight(80);

		//Adding edge 1 -- 3 with weight 47 in index 6
		graph.getEdge()[6].setSrc(1);
		graph.getEdge()[6].setDest(3);
		graph.getEdge()[6].setWeight(47);

		//Adding edge 6 -- 3 with weight 75 in index 7
		graph.getEdge()[7].setSrc(6);
		graph.getEdge()[7].setDest(3);
		graph.getEdge()[7].setWeight(75);

		//Adding edge 3 -- 5 with weight 23 in index 8
		graph.getEdge()[8].setSrc(3);
		graph.getEdge()[8].setDest(5);
		graph.getEdge()[8].setWeight(23);

		//Adding edge 3 -- 4 with weight 88 in index 9
		graph.getEdge()[9].setSrc(3);
		graph.getEdge()[9].setDest(4);
		graph.getEdge()[9].setWeight(88);

		//Adding edge 5 -- 2 with weight 32 in index 10
		graph.getEdge()[10].setSrc(5);
		graph.getEdge()[10].setDest(2);
		graph.getEdge()[10].setWeight(32);

		//Adding edge 3 -- 7 with weight 66 in index 11
		graph.getEdge()[11].setSrc(3);
		graph.getEdge()[11].setDest(7);
		graph.getEdge()[11].setWeight(66);

		//Adding edge 4 -- 2 with weight 31 in index 12
		graph.getEdge()[12].setSrc(4);
		graph.getEdge()[12].setDest(2);
		graph.getEdge()[12].setWeight(31);

		//Adding edge 2 -- 7 with weight 74 in index 13
		graph.getEdge()[13].setSrc(2);
		graph.getEdge()[13].setDest(7);
		graph.getEdge()[13].setWeight(74);

		//Adding edge 2 -- 0 with weight 79 in index 14
		graph.getEdge()[14].setSrc(2);
		graph.getEdge()[14].setDest(0);
		graph.getEdge()[14].setWeight(79);

		//Adding edge 3 -- 2 with weight 55 in index 15
		graph.getEdge()[15].setSrc(3);
		graph.getEdge()[15].setDest(2);
		graph.getEdge()[15].setWeight(55);

		// Function call for Kruskal's algorithm

		/*
		 * First, the arrays of edges are sorted on the basis of weights in ascending order. So, first edge taken is edge 3 -- 5 == 23 of form (Source -- Destination == Weight)
		 * The first edge does not form a cycle so it is included in MST.
		 * Then, the edge taken is 4 -- 0 == 29 which also does not form a cycle, so it is included.
		 * Then, the edge taken is 4 -- 2 == 31 which does not form a cycle, so it is included.
		 * Then, the edge taken is 5 -- 2 == 32 which does not form a cycle, so it is included.
		 * Then, the edge taken is 1 -- 3 == 47 which does not form a cycle, so it is included.
		 * Then, the edge taken is 1 -- 6 == 54 which does not form a cycle, so it is included.
		 * Then, the edge taken is 3 -- 2 == 55 which forms a cycle (because of edges 3 -- 5 and 5 -- 2 causing cycle for 3 -- 2), so it is not included.
		 * Then, the edge taken is 3 -- 7 == 66 which does not form a cycle, so it is included.
		 * Then, the edge taken is 0 -- 7 == 68 which forms a cycle (because of edges 3 -- 5, 5 -- 2, 2 -- 4, 4 -- 8, 7 -- 3 causing cycle for 0 -- 7), so it is not included.
		 * Then, the edge taken is 2 -- 7 == 74 which forms a cycle (because of edges 3 -- 5, 5 -- 2, 3 -- 7 causing cycle for 2 -- 7), so it is not included.
		 * Then, the edge taken is 6 -- 4 == 74 which forms a cycle (because of edges 1 -- 6, 4 -- 2, 5 -- 2, 3 -- 5, 1 -- 3 causing cycle for 6 -- 4), so it is not included.
		 * Then, the edge taken is 6 -- 3 == 75 which forms a cycle (because of edges 1 -- 6 and 1 -- 3 causing cycle for 6 -- 3), so it is not included.
		 * Then, the edge taken is 2 -- 0 == 79 which forms a cycle (because of edges 4 -- 2 and 4 -- 0 causing cycle for 2 -- 0), so it is not included.
		 * Then, the edge taken is 1 -- 5 == 80 which forms a cycle (because of edges 1 -- 3 and 3 -- 5 causing cycle for 1 -- 5), so it is not included.
		 * Then, the edge taken is 5 -- 7 == 93 which forms a cycle (because of edges 3 -- 5 and 3 -- 7 causing cycle for 5 -- 7), so it is not included.
		 */
		System.out.println("First Graph:");
		graph.KruskalMST();

		//Finally, only the edges accepted are included in the resulting array of edges to construct minimum spanning tree (MST).
		//And above function call prints the resultant MST and minimum cost of the tree.

		System.out.println();
		
		//Initializes the number of vertices and edges for second graph
		int Vself = 7; // Number of vertices in graph
		int Eself = 10; // Number of edges in graph

		//Creates a new graph structure required for minimum spanning tree
		Graph graphSelf = new Graph(Vself, Eself);

		//This is the self-built graph for constructing minimum spanning tree (MST)
		//The graph contains 7 vertices and 10 edges. So, MST formed will have (7 - 1 = 6 edges).

		//Adding edge 0 -- 1 with weight 33 in index 0
		graphSelf.getEdge()[0].setSrc(0);
		graphSelf.getEdge()[0].setDest(1);
		graphSelf.getEdge()[0].setWeight(33);

		//Adding edge 1 -- 2 with weight 20 in index 1
		graphSelf.getEdge()[1].setSrc(1);
		graphSelf.getEdge()[1].setDest(2);
		graphSelf.getEdge()[1].setWeight(20);

		//Adding edge 2 -- 3 with weight 7 in index 2
		graphSelf.getEdge()[2].setSrc(2);
		graphSelf.getEdge()[2].setDest(3);
		graphSelf.getEdge()[2].setWeight(7);

		//Adding edge 3 -- 4 with weight 77 in index 3
		graphSelf.getEdge()[3].setSrc(0);
		graphSelf.getEdge()[3].setDest(7);
		graphSelf.getEdge()[3].setWeight(68);

		//Adding edge 4 -- 5 with weight 50 in index 4
		graphSelf.getEdge()[4].setSrc(4);
		graphSelf.getEdge()[4].setDest(5);
		graphSelf.getEdge()[4].setWeight(50);

		//Adding edge 5 -- 6 with weight 19 in index 5
		graphSelf.getEdge()[5].setSrc(5);
		graphSelf.getEdge()[5].setDest(6);
		graphSelf.getEdge()[5].setWeight(19);

		//Adding edge 6 -- 0 with weight 55 in index 6
		graphSelf.getEdge()[6].setSrc(6);
		graphSelf.getEdge()[6].setDest(0);
		graphSelf.getEdge()[6].setWeight(55);

		//Adding edge 1 -- 6 with weight 47 in index 7
		graphSelf.getEdge()[7].setSrc(1);
		graphSelf.getEdge()[7].setDest(6);
		graphSelf.getEdge()[7].setWeight(47);

		//Adding edge 2 -- 6 with weight 10 in index 8
		graphSelf.getEdge()[8].setSrc(2);
		graphSelf.getEdge()[8].setDest(6);
		graphSelf.getEdge()[8].setWeight(10);

		//Adding edge 2 -- 5 with weight 14 in index 9
		graphSelf.getEdge()[9].setSrc(2);
		graphSelf.getEdge()[9].setDest(5);
		graphSelf.getEdge()[9].setWeight(14);

		// Function call for Kruskal's algorithm

		/*
		 * First, the arrays of edges are sorted on the basis of weights in ascending order. So, first edge taken is edge 2 -- 3 == 7 of form (Source -- Destination == Weight)
		 * The first edge does not form a cycle so it is included in MST.
		 * Then, the edge taken is 2 -- 6 == 10 which does not form a cycle, so it is included.
		 * Then, the edge taken is 2 -- 5 == 14 which does not form a cycle, so it is included.
		 * Then, the edge taken is 5 -- 6 == 19 which forms a cycle (because of edges 2 -- 5 and 2 -- 6 causing cycle for 5 -- 6), so it is not included.
		 * Then, the edge taken is 1 -- 2 == 20 which does not form a cycle, so it is included.
		 * Then, the edge taken is 0 -- 1 == 33 which does not form a cycle, so it is included.
		 * Then, the edge taken is 1 -- 6 == 47 which forms a cycle (because of edges 1 -- 2 and 2 -- 6 causing cycle for 1 -- 6), so it is not included.
		 * Then, the edge taken is 4 -- 5 == 50 which does not form a cycle, so it is included.
		 * Then, the edge taken is 6 -- 0 == 55 which forms a cycle (because of edges 0 -- 1 and 1 -- 6 causing cycle for 6 -- 0), so it is not included.
		 * Then, the edge taken is 3 -- 4 == 77 which forms a cycle (because of edges 2 -- 3, 4 -- 5 and 2 -- 5 causing cycle for 3 -- 4), so it is not included.
		 */
		System.out.println("Second Graph:");
		graphSelf.KruskalMST();

		//Finally, only the edges accepted are included in the resulting array of edges to construct minimum spanning tree (MST).
		//And above function call prints the resultant MST and minimum cost of the tree. For this tree minimum cost was calculated to be 134.

	}

}
