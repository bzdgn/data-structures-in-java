package ds_013_network_algorithms;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathLabelCorrectingDemo {

	/*
	 *
	 *  [A] -- 05 -> [B] -- 05 -> [C] -- 07 -> [D]
	 *   | \          |            |            |
	 *   |  \__       |            |            |
	 *   10    12__   11           10           11
	 *   |         \  |            |            |
	 *   |          \ |            |            |
	 *  [E] -- 05 -> [F] -- 05 -> [G] -- 06 -> [H]
	 *   |            | \          |            |
	 *   |            |  \__       |            |
	 *   09           11    12__   12           14
	 *   |            |         \  |            |
	 *   |            |          \ |            |
	 *  [I] -- 06 -> [J] -- 06 -> [K] -- 10 -> [L]
	 *   |            |            |            |
	 *   |            |            |            |
	 *   10           12           15           07
	 *   |            |            |            |
	 *   |            |            |            |
	 *  [M] -- 07 -> [N] -- 06 -> [O] -- 09 -> [P]
	 *
	 *
	 */
	private static int count = 0;
	
	public static void main(String[] args) {
		// Nodes
		SPNode nodeA = new SPNode("A");
		SPNode nodeB = new SPNode("B");
		SPNode nodeC = new SPNode("C");
		SPNode nodeD = new SPNode("D");
		SPNode nodeE = new SPNode("E");
		SPNode nodeF = new SPNode("F");
		SPNode nodeG = new SPNode("G");
		SPNode nodeH = new SPNode("H");
		SPNode nodeI = new SPNode("I");
		SPNode nodeJ = new SPNode("J");
		SPNode nodeK = new SPNode("K");
		SPNode nodeL = new SPNode("L");
		SPNode nodeM = new SPNode("M");
		SPNode nodeN = new SPNode("N");
		SPNode nodeO = new SPNode("O");
		SPNode nodeP = new SPNode("P");
		
		// Links
		nodeA.addNodeLink(nodeB,  5.0f);
		nodeA.addNodeLink(nodeF, 12.0f);
		nodeA.addNodeLink(nodeE, 10.0f);
		
		nodeB.addNodeLink(nodeC,  5.0f);
		nodeB.addNodeLink(nodeF, 11.0f);
		
		nodeC.addNodeLink(nodeD,  7.0f);
		nodeC.addNodeLink(nodeG, 10.0f);
		
		nodeD.addNodeLink(nodeH, 11.0f);
		
		nodeE.addNodeLink(nodeF,  5.0f);
		nodeE.addNodeLink(nodeI,  9.0f);
		
		nodeF.addNodeLink(nodeG,  5.0f);
		nodeF.addNodeLink(nodeK, 12.0f);
		nodeF.addNodeLink(nodeJ, 11.0f);
		
		nodeG.addNodeLink(nodeH,  6.0f);
		nodeG.addNodeLink(nodeK, 12.0f);
		
		nodeH.addNodeLink(nodeK, 14.0f);
		
		nodeI.addNodeLink(nodeJ,  6.0f);
		nodeI.addNodeLink(nodeM, 10.0f);
		
		nodeJ.addNodeLink(nodeK,  6.0f);
		nodeJ.addNodeLink(nodeN, 12.0f);
		
		nodeK.addNodeLink(nodeL, 10.0f);
		nodeK.addNodeLink(nodeO, 15.0f);
		
		nodeL.addNodeLink(nodeP,  7.0f);
		
		nodeM.addNodeLink(nodeN,  7.0f);
		
		nodeN.addNodeLink(nodeO,  6.0f);
		
		nodeO.addNodeLink(nodeP,  9.0f);
		
		
		// nodeList to store all nodes
		List<SPNode> nodeList = new LinkedList<>();
		nodeList.add(nodeA);
		nodeList.add(nodeB);
		nodeList.add(nodeC);
		nodeList.add(nodeD);
		nodeList.add(nodeE);
		nodeList.add(nodeF);
		nodeList.add(nodeG);
		nodeList.add(nodeH);
		nodeList.add(nodeI);
		nodeList.add(nodeJ);
		nodeList.add(nodeK);
		nodeList.add(nodeL);
		nodeList.add(nodeM);
		nodeList.add(nodeN);
		nodeList.add(nodeO);
		nodeList.add(nodeP);
		
		handleShortestPath(nodeList, nodeA);
		
		printShortestPath(nodeP);
		
		System.out.println("Count: " + count);
	}
	
	private static void printShortestPath(SPNode node) {
		printShortestPathRecursive(node);
		System.out.print("\n");
	}
	
	private static void printShortestPathRecursive(SPNode node) {
		if(node == null) {
			return;
		}
		
		if(node.shortestPathLink != null) {
			printShortestPathRecursive(node.shortestPathLink.fromNode);
			System.out.print("--> ");
		}
		
		System.out.printf("%s ", node);
	}
	
	private static void handleShortestPath(List<SPNode> nodes, SPNode startNode) {
		initializeNodeDistances(nodes);
		
		startNode.distance = 0;
		List<SPLink> candidateList = new LinkedList<>();
		// add all links of start node to the candidateList
		for(SPLink link : startNode.links) {
			candidateList.add(link);
		}
		
		findShortestPathWithLabelCorrecting(candidateList);
	}
	
	private static void initializeNodeDistances(List<SPNode> nodes) {
		for(SPNode node : nodes) {
			node.distance = Float.MAX_VALUE;	// initial distance is infinity
		}
	}
	
	private static void findShortestPathWithLabelCorrecting(List<SPLink> candidateList) {
		// while candidateList not empty
		while(!candidateList.isEmpty()) {
			count++;
			printList(candidateList);	//TODO: debug
			
			SPLink firstLink = candidateList.get(0);
			float newDistance = firstLink.fromNode.distance + firstLink.cost;
			
			if(newDistance < firstLink.toNode.distance) {
				firstLink.toNode.shortestPathLink = firstLink;
				firstLink.toNode.distance = newDistance;
				
//				for(SPLink link : firstLink.toNode.links) {
//					if(!candidateList.contains(link)) {
//						candidateList.add(link);
//					}
//				}
				candidateList.addAll(firstLink.toNode.links);		//TODO: check if should only add if not added already?
			}
			
			candidateList.remove(0);
		}
	}
	
	private static void printList(List<SPLink> list) {
		System.out.print("\tCL: ");
		for(SPLink link : list) {
			System.out.printf("%s ", link);
		}
		System.out.print("\n");
	}
	
	/*
	 * Node class for Shortest Path
	 */
	private static class SPNode {
		
		private final String label;
		private final List<SPLink> links;
		private SPLink shortestPathLink;
		private float distance;
		
		public SPNode(final String label) {
			this.label = label;
			this.links = new LinkedList<>();
		}
		
		public void addNodeLink(SPNode node, final float cost) {
			this.links.add(new SPLink(this, node, cost));
//			node.links.add(new SPLink(node, this, cost));
		}
		
		@Override
		public String toString() {
			return String.format("%s", label);
//			return String.format("[Node: %s]:[Distance: %s]", label, distance == Float.MAX_VALUE ? "Infinity" : distance);
		}
		
	}
	
	/*
	 * Link class for Shortest Path
	 */
	private static class SPLink {
		
		private final SPNode fromNode;
		private final SPNode toNode;
		private float cost;
		
		public SPLink(final SPNode fromNode, final SPNode toNode) {
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.cost = 0.0f;
		}
		
		public SPLink(final SPNode fromNode, final SPNode toNode, final float cost) {
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return String.format("[%s --> %s](%2.0f)", fromNode, toNode, cost);
		}
		
	}

}