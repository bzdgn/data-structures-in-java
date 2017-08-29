package ds_013_network_algorithms;

import java.util.LinkedList;
import java.util.List;

/*
 * A -- 10 -> B
 * \         / \
 *  \       /   \
 *   4     4     4
 *    \   /       \
 *     \ /         \
 *      C -- 10 --> D
 * 
 */
public class FloydWarshallAllPairsShortestPathDemo {
	
	private static final int NUMBER_OF_NODES = 4;
	
	public static void main(String[] args) {
		String[] labels = { "A", "B", "C", "D" };
		
		int[][] distances	= new int[NUMBER_OF_NODES][NUMBER_OF_NODES];
		Integer[][] via		= new Integer[NUMBER_OF_NODES][NUMBER_OF_NODES];
		Integer[][] links	= {
			{null, 10  , 4   , null}, 
			{null, null, null, 4   }, 
			{null, 4   , null, 10  }, 
			{null, null, null, null}			
		};
		
		initialization(distances, via, links);
		printDistancesAndVia(distances, via, labels);
		floydWarshallAlgorithm(distances, via, labels);
		printDistancesAndVia(distances, via, labels);
	}
	
	/*
	 * O(N^3)
	 */
	private static void floydWarshallAlgorithm(int[][] distances, Integer[][] via, String[] labels) {
		int numNodes = distances.length;
		
		if(numNodes != via.length || numNodes != labels.length || via.length != labels.length) {
			System.out.println("\tERROR: distances, via matrix N must be equal to labels.length!");
			return;
		}
		
		for(int k = 0; k < numNodes; k++) {
			for(int a = 0; a < numNodes; a++) {
				for(int b = 0; b < numNodes; b++) {
					int distanceAB = distances[a][b];
					int distanceAK = distances[a][k];
					int distanceKB = distances[k][b];
					if(distanceAK == Integer.MAX_VALUE || distanceKB == Integer.MAX_VALUE) {
						continue;	// there is no link in one of legs
					}
					int distanceAKKB = distanceAK + distanceKB;
					
					if(distanceAKKB < distanceAB) {
						distances[a][b] = distanceAKKB;
						via[a][b] = k;
					}
				}
			}
		}

	}
	
	private static void printDistancesAndVia(int[][] distances, Integer[][] via, String[] labels) {
		printDistances(distances, labels);
		System.out.println();
		printVia(via, labels);
		System.out.println();
	}
	
	private static void initialization(int[][] distances, Integer[][] via, Integer[][]links) {
		initializeDistances(distances, links);
		initializeVia(via, links);
	}
	
	private static void initializeVia(Integer[][] via, Integer[][] links) {
		for(int i = 0; i < via.length; i++) {
			for(int j = 0; j < via[i].length; j++) {
				if(i == j) {
					via[i][j] = i;
				} else {
					if(links[i][j] != null) {
						via[i][j] = j;
					} else {
						via[i][j] = null;
					}
				}
			}
		}
	}
	
	private static void initializeDistances(int[][] distances, Integer[][] links) {
		for(int i = 0; i < distances.length; i++) {
			for(int j = 0; j < distances[i].length; j++) {
				if(i == j) {
					distances[i][j] = 0;
				} else {
					if(links[i][j] != null) {
						distances[i][j] = links[i][j];
					} else {
						distances[i][j] = Integer.MAX_VALUE;
					}
				}
			}
		}
	}
	
	private static void printDistances(int[][] distances, String[] labels) {
		if(distances.length != labels.length) {
			System.out.println("\tERROR: distances matrix N must be equal to labels.length!");
			return;
		}
		
		System.out.print("   ");
		for(int i = 0; i < labels.length; i++) {
			System.out.printf("%2s ", labels[i]);
		}
		System.out.print("\n");
		
		for(int i = 0; i < distances.length; i++) {
			System.out.printf("%2s ", labels[i]);
			for(int j = 0; j < distances[i].length; j++) {
				if(distances[i][j] == Integer.MAX_VALUE) {
					System.out.print(" * ");
				} else {
					System.out.printf("%2d ", distances[i][j]);
				}
			}
			System.out.print("\n");
		}
	}
	
	private static void printVia(Integer[][] via, String[] labels) {
		if(via.length != labels.length) {
			System.out.println("\tERROR: via matrix N must be equal to labels.length!");
			return;
		}
		
		System.out.print("   ");
		for(int i = 0; i < labels.length; i++) {
			System.out.printf("%2s ", labels[i]);
		}
		System.out.print("\n");
		
		for(int i = 0; i < via.length; i++) {
			System.out.printf("%2s ", labels[i]);
			for(int j = 0; j < via[i].length; j++) {
				if(via[i][j] == null) {
					System.out.print(" - ");
				} else {
					System.out.printf("%2s ", labels[via[i][j]]);
				}
			}
			System.out.print("\n");
		}
	}
	
	private static void print2DArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == Integer.MAX_VALUE) {
					System.out.print(" * ");
				} else {
					System.out.printf("%2d ", array[i][j]);
				}
			}
			System.out.print("\n");
		}
	}
	
	private static void print2DArray(Integer[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == null) {
					System.out.print(" - ");
				} else if(array[i][j] == Integer.MAX_VALUE) {
					System.out.print("** ");
				} else {
					System.out.printf("%2d ", array[i][j]);
				}
			}
			System.out.print("\n");
		}
	}
	
	private static class Node {
		private final String label;
		private List<Node> links;
		private Link[] nextLink;
		
		public Node(final int N, final String label) {
			this.label = label;
			links = new LinkedList<>();
			nextLink = new Link[N];
		}
		
		@Override
		public String toString() {
			return String.format("%s", label);
		}
		
	}
	
	private static class Link {
		private final Node fromNode;
		private final Node toNode;
		private final int cost;
		
		public Link(Node fromNode, Node toNode, final int cost) {
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return String.format("[%s --> %s](%2d)", fromNode, toNode, cost);
		}
	}
	
}
