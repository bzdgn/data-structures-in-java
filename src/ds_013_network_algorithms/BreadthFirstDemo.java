package ds_013_network_algorithms;

import java.util.LinkedList;
import java.util.List;

/*
 *      A - 10 - B - 10 - E - 10 - J
 *      | \      |        |        |
 *      |  \____ |        |        |
 *      |       \|        |        |
 *      D - 10 - C - 10 - F - 10 - K
 *      |        | \      |        |
 *      |        |  \____ |        |
 *      |        |       \|        |
 *      I - 10 - H - 10 - G - 10 - L
 *      |        |        |        |
 *      |        |        |        |
 *      |        |        |        |
 *      P - 10 - O - 10 - N - 10 - M
 *                            
 */
public class BreadthFirstDemo {

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
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		Node nodeM = new Node("M");
		Node nodeN = new Node("N");
		Node nodeO = new Node("O");
		Node nodeP = new Node("P");
		
		// connections
		nodeA.connectNode(nodeB);
		nodeA.connectNode(nodeC);
		nodeA.connectNode(nodeD);
		
		nodeB.connectNode(nodeE);
		nodeB.connectNode(nodeC);
		
		nodeC.connectNode(nodeF);
		nodeC.connectNode(nodeG);
		nodeC.connectNode(nodeH);
		
		nodeD.connectNode(nodeI);
		
		nodeE.connectNode(nodeJ);
		nodeE.connectNode(nodeF);
		
		nodeF.connectNode(nodeK);
		nodeF.connectNode(nodeG);
		
		nodeG.connectNode(nodeL);
		nodeG.connectNode(nodeN);
		
		nodeH.connectNode(nodeO);
		nodeH.connectNode(nodeI);
		
		nodeI.connectNode(nodeP);
		
		nodeJ.connectNode(nodeK);
		
		nodeK.connectNode(nodeL);
		
		nodeL.connectNode(nodeM);
		
		nodeM.connectNode(nodeN);
		
		nodeN.connectNode(nodeO);
		
		nodeO.connectNode(nodeP);
		
//		depthFirstTraversal(nodeA);
		breadthFirstTraversal(nodeA);
	}
	
	private static class Node {
		private final String label;
		private List<Link> links;
		private boolean isVisisted;
		
		public Node(final String label) {
			this.label = label;
			this.links = new LinkedList<>();
			isVisisted = false;
		}
		
		public void connectNode(Node other) {
			this.connectNode(other, 0);
		}
		
		public void connectNode(Node other, int cost) {
			links.add(new Link(this, other, cost));
			other.links.add(new Link(other, this, cost));
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
		
		public Link(Node fromNode, Node toNode) {
			this.cost = 0;
			this.fromNode = fromNode;
			this.toNode = toNode;
		}
		
		public Link(Node fromNode, Node toNode, final int cost) {
			this.cost = cost;
			this.fromNode = fromNode;
			this.toNode = toNode;
		}
	}
	
	private static void breadthFirstTraversal(Node startNode) {
		SQueue<Node> queue = new SQueue<>();
		queue.enqueue(startNode);
		while(!queue.isEmpty()) {
			Node node = queue.dequeue();
			visitNode(node);
			for(Link link : node.links) {
				if(!link.toNode.isVisisted) {
					queue.enqueue(link.toNode);
					link.toNode.isVisisted = true;
				}
			}
		}
	}
	
	private static void depthFirstTraversal(Node node) {
		if(node.isVisisted) {
			return;
		}
		
		visitNode(node);
		
		for(Link link : node.links) {
			depthFirstTraversal(link.toNode);
		}
	}
	
	private static void visitNode(Node node) {
//		if(node.isVisisted) {
//			return;
//		}
		System.out.printf("%s ", node);
		node.isVisisted = true;
	}

}
