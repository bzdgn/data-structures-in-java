package ds_010_trees;

public class NaryTreeTraversalDemo {

	public static void main(String[] args) {
		/*
		 *                                  200
		 *                                   |
		 *                 __________________|__________________________________
		 *                |                  |                  |               |
		 *                |                  |                  |               |
		 *                30                 60                 90              120
		 *            ____|____          ____|____          ____|____ ___       |_____
		 *           |    |    |        |    |    |        |    |    |   |      |     |
		 *          12    17   28       35   39   55       67   78   88  89     110   115
		 *           |                             |
		 *      __ __|__ __                        |__
		 *     |  |  |  |  |                       |  |
		 *     1  3  5  9  11                      51 52
		 *           
		 */
		
		// Level 0
		NaryNode<Integer> root = new NaryNode<>(200, 4);
		
		// Level 1
		root.addChild(30,  3);
		root.addChild(60,  3);
		root.addChild(90,  4);
		root.addChild(120, 2);
		
		// Level 2
		root.getChild(30).addChild(12,  5);
		root.getChild(30).addChild(17,  0);
		root.getChild(30).addChild(28,  0);
		
		root.getChild(60).addChild(35,  5);
		root.getChild(60).addChild(39,  0);
		root.getChild(60).addChild(55,  2);
		
		root.getChild(90).addChild(67,  0);
		root.getChild(90).addChild(78,  0);
		root.getChild(90).addChild(88,  0);
		root.getChild(90).addChild(89,  0);
		
		root.getChild(120).addChild(110,  0);
		root.getChild(120).addChild(115,  0);
		
		// Level 3
		root.getChild(30).getChild(12).addChild(1 , 0);
		root.getChild(30).getChild(12).addChild(3 , 0);
		root.getChild(30).getChild(12).addChild(5 , 0);
		root.getChild(30).getChild(12).addChild(9 , 0);
		root.getChild(30).getChild(12).addChild(11, 0);
		
		root.getChild(60).getChild(55).addChild(51, 0);
		root.getChild(60).getChild(55).addChild(52, 0);
		
		
		printPreOrder(root);		// first data
		printPostOrder(root);		// first children
		printInOrder(root);			// children-first-half data children-second-half
		printBreadthFirst(root);	// breadth-first level order
	}
	
	/*
	 * PreOrder Traversal Helper and Implementation
	 */
	private static <T extends Comparable<T>> void printPreOrder(NaryNode<T> root) {
		System.out.printf("Tree PreOrder              : ");
		preOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T extends Comparable<T>> void preOrderTraversal(NaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		System.out.printf("%4s ", node.data);
		for(NaryNode<T> childNode: node.children) {
			preOrderTraversal(childNode);
		}
	}
	
	/*
	 * PostOrder Traversal Helper and Implementation
	 */
	private static <T extends Comparable<T>> void printPostOrder(NaryNode<T> root) {
		System.out.printf("Tree PostOrder             : ");
		postOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T extends Comparable<T>> void postOrderTraversal(NaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		for(NaryNode<T> childNode: node.children) {
			postOrderTraversal(childNode);
		}
		System.out.printf("%4s ", node.data);
	}
	
	/*
	 * InOrder Traversal Helper and Implementation
	 * Middle Child Processed last
	 * 
	 */
	private static <T extends Comparable<T>> void printInOrder(NaryNode<T> root) {
		System.out.printf("Tree InOrder Middle Last   : ");
		InOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T extends Comparable<T>> void InOrderTraversal(NaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		if(node.size == 0) {
			System.out.printf("%4s ", node.data);
			
			return;
		}
		
		int len = node.size/2;
		
		for(int i = 0; i < len; i++) {
			InOrderTraversal(node.children[i]);
		}
		
		System.out.printf("%4s ", node.data);
		
		for(int i = len; i < node.size; i++) {
			InOrderTraversal(node.children[i]);
		}
	}
	
	/*
	 * Breadth-First Traversal
	 */
	private static <T extends Comparable<T>> void printBreadthFirst(NaryNode<T> root) {
		System.out.print("Tree BreadthFirst          : ");
		
		SQueue<NaryNode<T>> queue = new SQueue<>();
		
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			NaryNode<T> curr = queue.dequeue();
			System.out.printf("%4s ", curr.data);
			
			if(curr.size != 0) {
				for(int i = 0; i < curr.size; i++) {
					queue.enqueue(curr.children[i]);
				}
			}
		}
		
		System.out.print("\n");
	}

}
