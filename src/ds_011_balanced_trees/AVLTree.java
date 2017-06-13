package ds_011_balanced_trees;

public class AVLTree<T extends Comparable<T>> {
	
	private class Node<G extends Comparable<G>> {
		
		private G data;
		private Node<G> left;
		private Node<G> right;
		
		public Node(G data) {
			this.data	= data;
			this.left	= null;
			this.right	= null;
		}
		
		public boolean isBalanced() {
			return height() < 2;
		}
		
		public int height() {
			return height(this);
		}
		
		private int height(Node<G> node) {
			if(node == null) {
				return -1;
			}
			
			return Integer.max(height(node.left), height(node.right)) + 1;
		}
		
		public void rightRotation() {
			rightRotation(this);
		}
		
		private Node<G> rightRotation(Node<G> root) {
			if(root.left == null) {
				System.out.print("\tError: Unable to rightRotate: No Left Child!\n");
				return null;
			}
			
			Node<G> newLeftChild = root.left.right;
			Node<G> newRoot = root.left;
			
			root.left = newLeftChild;
			newRoot.right = root;
			
			return newRoot;
		}
		
		public void leftRotation() {
			leftRotation(this);
		}
		
		private Node<G> leftRotation(Node<G> root) {
			if(root.right == null) {
				System.out.print("\tError: Unable to leftRotate: No Right Child!\n");
				return null;
			}
			
			Node<G> newRightChild = root.right.left;
			Node<G> newRoot = root.right;
			
			root.right = newRightChild;
			newRoot.left = root;
			
			return newRoot;
		}
		
	}
	
}
