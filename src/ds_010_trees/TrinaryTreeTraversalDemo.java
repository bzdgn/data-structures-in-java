package ds_010_trees;

public class TrinaryTreeTraversalDemo {

	public static void main(String[] args) {
		/*
		 *                                  100
		 *                                   |
		 *                 __________________|__________________
		 *                |                  |                  |
		 *                |                  |                  |
		 *                30                 60                 90
		 *            ____|____          ____|____          ____|____
		 *           |    |    |        |    |    |        |    |    |
		 *          12    17   28       35   39   55       67   88   89
		 *           |                             |
		 *         __|__                         __|__
		 *        |  |  |                       |  |  |
		 *        3     9                            52
		 *           
		 */
		
		// Level 0
		TrinaryNode<Integer> root = new TrinaryNode<>(100);
		
		// Level 1
		root.left	= new TrinaryNode<>(30);
		root.middle	= new TrinaryNode<>(60);
		root.right	= new TrinaryNode<>(90);
		
		// Level 2
		root.left.left		= new TrinaryNode<>(12);
		root.left.middle	= new TrinaryNode<>(17);
		root.left.right		= new TrinaryNode<>(28);
		
		root.middle.left	= new TrinaryNode<>(35);
		root.middle.middle	= new TrinaryNode<>(39);
		root.middle.right	= new TrinaryNode<>(55);
		
		root.right.left		= new TrinaryNode<>(67);
		root.right.middle	= new TrinaryNode<>(88);
		root.right.right	= new TrinaryNode<>(89);
		
		// Level 2
		root.left.left.left		= new TrinaryNode<>(3);
		root.left.left.right	= new TrinaryNode<>(9);
		
		root.middle.right.right	= new TrinaryNode<>(52);
		
		
		
		printPreOrder(root);		// first data
		printPostOrder(root);		// first children
		printInOrderMiddleFirst(root);	// left-middle-DATA-right
		printInOrderMiddleLast(root);	// left-DATA-middle-right
		printBreadthFirst(root);		// breadth-first level order
	}
	
	/*
	 * PreOrder Traversal Helper and Implementation
	 */
	private static <T> void printPreOrder(TrinaryNode<T> root) {
		System.out.printf("Tree PreOrder              : ");
		preOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T> void preOrderTraversal(TrinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		System.out.printf("%3s ", node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.middle);
		preOrderTraversal(node.right);
	}
	
	/*
	 * PostOrder Traversal Helper and Implementation
	 */
	private static <T> void printPostOrder(TrinaryNode<T> root) {
		System.out.printf("Tree PostOrder             : ");
		postOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T> void postOrderTraversal(TrinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.middle);
		postOrderTraversal(node.right);
		System.out.printf("%3s ", node.data);
	}
	
	/*
	 * InOrder Traversal Helper and Implementation
	 * Mod 1: Middle Child Processed First
	 */
	private static <T> void printInOrderMiddleFirst(TrinaryNode<T> root) {
		System.out.printf("Tree InOrder Middle First  : ");
		InOrderTraversalMiddleFirst(root);
		System.out.print("\n");
	}
	
	private static <T> void InOrderTraversalMiddleFirst(TrinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		InOrderTraversalMiddleFirst(node.left);
		InOrderTraversalMiddleFirst(node.middle);
		System.out.printf("%3s ", node.data);
		InOrderTraversalMiddleFirst(node.right);
	}
	
	/*
	 * InOrder Traversal Helper and Implementation
	 * Mod 2: Middle Child Processed Last
	 */
	private static <T> void printInOrderMiddleLast(TrinaryNode<T> root) {
		System.out.printf("Tree InOrder Middle Last   : ");
		InOrderTraversalMiddleLast(root);
		System.out.print("\n");
	}
	
	private static <T> void InOrderTraversalMiddleLast(TrinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		InOrderTraversalMiddleLast(node.left);
		System.out.printf("%3s ", node.data);
		InOrderTraversalMiddleLast(node.middle);
		InOrderTraversalMiddleLast(node.right);
	}
	
	/*
	 * Breadth-First Traversal
	 */
	private static <T> void printBreadthFirst(TrinaryNode<T> root) {
		System.out.print("Tree BreadthFirst          : ");
		
		SQueue<TrinaryNode<T>> queue = new SQueue<>();
		
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			TrinaryNode<T> curr = queue.dequeue();
			System.out.printf("%3s ", curr.data);
			
			if(curr.left != null) {
				queue.enqueue(curr.left);
			}
			
			if(curr.middle != null) {
				queue.enqueue(curr.middle);
			}
			
			if(curr.right != null) {
				queue.enqueue(curr.right);
			}
		}
		
		System.out.print("\n");
	}

}
