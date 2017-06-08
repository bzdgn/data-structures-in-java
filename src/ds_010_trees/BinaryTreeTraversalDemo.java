package ds_010_trees;

public class BinaryTreeTraversalDemo {

	public static void main(String[] args) {
		/*
		 *          10
		 *         /  \
		 *        /    \
		 *       5      15
		 *      / \      \
		 *     3   7      20
		 */
		
		// Level 0
		BinaryNode<Integer> root = new BinaryNode<>(10);
		
		// Level 1
		root.left	= new BinaryNode<>(5);
		root.right	= new BinaryNode<>(15);
		
		// Level 2
		root.left.left	= new BinaryNode<>(3);
		root.left.right = new BinaryNode<>(7);
		
		root.right.right	= new BinaryNode<>(20);
		
		
		printPreOrder(root);		// first data
		printPostOrder(root);		// first children
		printInOrder(root);			// left-order-right
		printBreadthFirst(root);	// breadth-first level order
	}
	
	/*
	 * PreOrder Traversal Helper and Implementation
	 */
	private static <T> void printPreOrder(BinaryNode<T> root) {
		System.out.printf("Tree PreOrder    : ");
		preOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T> void preOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		System.out.printf("%3s ", node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	/*
	 * PostOrder Traversal Helper and Implementation
	 */
	private static <T> void printPostOrder(BinaryNode<T> root) {
		System.out.printf("Tree PostOrder   : ");
		postOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T> void postOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.printf("%3s ", node.data);
	}
	
	/*
	 * PreOrder Traversal Helper and Implementation
	 */
	private static <T> void printInOrder(BinaryNode<T> root) {
		System.out.printf("Tree InOrder     : ");
		InOrderTraversal(root);
		System.out.print("\n");
	}
	
	private static <T> void InOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		InOrderTraversal(node.left);
		System.out.printf("%3s ", node.data);
		InOrderTraversal(node.right);
	}
	
	/*
	 * Breadth-First Traversal
	 */
	private static <T> void printBreadthFirst(BinaryNode<T> root) {
		System.out.print("Tree BreadthFirst: ");
		
		SQueue<BinaryNode<T>> queue = new SQueue<>();
		
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			BinaryNode<T> curr = queue.dequeue();
			System.out.printf("%3s ", curr.data);
			
			if(curr.left != null) {
				queue.enqueue(curr.left);
			}
			
			if(curr.right != null) {
				queue.enqueue(curr.right);
			}
		}
		
		System.out.print("\n");
	}
	
}
