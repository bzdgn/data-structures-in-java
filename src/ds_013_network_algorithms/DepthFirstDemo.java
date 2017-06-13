package ds_013_network_algorithms;

import java.util.LinkedList;
import java.util.List;

/*
 *      J --- 10 --- D --- 10 --- A --- 10 --- B --- 10 --- E
 *                   |            |            |
 *                   |            |            |
 *                   |            |            |
 *                   I            C            F
 *                               / \
 *                              /   \
 *                             /     \
 *                            H       G
 *                            
 */
public class DepthFirstDemo {

	public static void main(String[] args) {
		// Nodes
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		
		// Links
		Link linkAB = new Link(10, nodeB);
		Link linkAC = new Link(10, nodeC);
		Link linkAD = new Link(10, nodeD);

		Link linkBE = new Link(10, nodeE);
		Link linkBF = new Link(10, nodeF);

		Link linkCH = new Link(10, nodeH);
		Link linkCG = new Link(10, nodeG);

		Link linkDJ = new Link(10, nodeJ);
		Link linkDI = new Link(10, nodeI);
		
		// Connection
		nodeA.links.add(linkAB);
		nodeA.links.add(linkAC);
		nodeA.links.add(linkAD);
		
		nodeB.links.add(linkBE);
		nodeB.links.add(linkBF);
		
		nodeC.links.add(linkCG);
		nodeC.links.add(linkCH);
		
		nodeD.links.add(linkDI);
		nodeD.links.add(linkDJ);
		
		depthFirstTraversal(nodeA);
	}
	
	private static class Node {
		private final String label;
		private List<Link> links;
		
		public Node(final String label) {
			this.label = label;
			this.links = new LinkedList<>();
		}
		
		@Override
		public String toString() {
			return String.format("Node %s", label);
		}
	}
	
	private static class Link {
		private final int cost;
		private Node fromNode;
		private Node toNode;
		
		public Link(final int cost) {
			this.cost = cost;
		}
		
		public Link(final int cost, Node toNode) {
			this.cost = cost;
			this.toNode = toNode;
		}
	}
	
	private static void depthFirstTraversal(Node node) {
		
		visitNode(node);
		
		for(Link link : node.links) {
			depthFirstTraversal(link.toNode);
		}
		
	}
	
	private static void visitNode(Node node) {
		System.out.printf("%s ", node);
	}

}
