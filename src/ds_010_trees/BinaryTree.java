package ds_010_trees;

public class BinaryTree<T extends Comparable<T>> {
	
	private BinaryNode<T> root;
	private int size;
	
	public BinaryTree() {}
	
	public void add(T[] data) {
		for(int i = 0; i < data.length; i++) {
			add(data[i]);
		}
	}
	
	public void add(T data) {
		if(isEmpty()) {
			root = new BinaryNode<T>(data);
		} else {
			add(root, data);
		}
		
		size++;
	}
	
	private void add(BinaryNode<T> node, T data) {
		if(data.compareTo(node.data) < 0) {
			if(node.left != null) {
				add(node.left, data);
			} else {
				node.left = new BinaryNode<T>(data);
				size++;
				
				return;
			}
		} else if(data.compareTo(node.data) > 0) {
			if(node.right != null) {
				add(node.right, data);
			} else {
				node.right = new BinaryNode<T>(data);
				size++;
				
				return;
			}
		} else {
			return;
		}
	}
	
	public boolean find(T data) {
		if(isEmpty()) {
			return false;
		} else {
			return find(root, data) == null ? false : true;
		}
	}
	
	private BinaryNode<T> find(BinaryNode<T> node, T data) {
		if(data.compareTo(node.data) < 0) {
			if(node.left != null) {
				return find(node.left, data);
			} else {
				return null;
			}
		} else if(data.compareTo(node.data) > 0) {
			if(node.right != null) {
				return find(node.right, data);
			} else {
				return null;
			}
		} else {
			return node;
		}
	}
	
	public boolean remove(T data) {
		if(isEmpty()) {
			return false;
		}
		
		if(root.data.equals(data) && size == 1) {
			root = null;
			size--;
			
			return true;
		}
		
		/*
		 * From this point the height of the tree > 0
		 * and also it is guaranteed that we won' remove
		 * root so every removed object will have a parent
		 * The parent is guaranteed not to be null
		 * 
		 * Cases;
		 *    1 - If node is a leaf, just remove
		 *    2 - If node has only a one child, replace it with its child
		 *    3 - If node has two children;
		 *        a - If left child hasn't right-child, replace the node with its left child
		 *        b - If left child has a right-child, find the right-most child of the
		 *            left sub-tree and replace it with the node
		 */
		return remove(root, data);
	}
	
	private boolean remove(BinaryNode<T> node, T data) {
		BinaryNode<T> parent		= null;
		BinaryNode<T> removed		= root;
		Boolean isLeftChildOfParent	= null;
		
		while(removed != null) {
			if(data.compareTo(removed.data) < 0) {
				parent = removed;
				removed = removed.left;
				isLeftChildOfParent = true;
			} else if(data.compareTo(removed.data) > 0 ) {
				parent = removed;
				removed = removed.right;
				isLeftChildOfParent = false;
			} else {
				delete(parent, removed, isLeftChildOfParent);
				size--;
				
				return true;
			}
		}
		
		return false;
	}
	
	public void delete(BinaryNode<T> parent, BinaryNode<T> removed, Boolean isLeftChildOfParent) {
		BinaryNode<T> replaced = null;
		
		if(removed.left == null && removed.right == null) {
			// case 1: removed is a leaf
			replaced = null;
		} else if(removed.left == null || removed.right == null) {
			// case 2: removed has only one child
			if(removed.left != null) {
				replaced = removed.left;
			} else {
				replaced = removed.right;
			}
		} else {
			// case 3: removed has two children
			if(removed.left.right == null) {
				// case 3-a: removed has a left child with no right child
				replaced = removed.left;
				replaced.right = removed.right;
			} else {
				// case 3-b: removed has a left child right child
				BinaryNode<T> parentOfRightMost	= removed.left;
				BinaryNode<T> rightMost			= removed.left.right;
				while(rightMost.right != null) {
					parentOfRightMost = rightMost;
					rightMost = rightMost.right;
				}
				
				parentOfRightMost.right = rightMost.left;
				
				rightMost.left	= removed.left;
				rightMost.right	= removed.right;
				
				replaced = rightMost;
			}
		}
		
		if(parent == null && isLeftChildOfParent == null) {
			root = replaced;
		} else {
			if(isLeftChildOfParent) {
				parent.left = replaced;
			} else {
				parent.right = replaced;
			}
		}

	}
	
	public int height() {
		return height(root);
	}
	
	private int height(BinaryNode<T> node) {
		if(node == null) {
			return -1;		// height is number of layers - 1
		}
		
		return Integer.max(height(node.left), height(node.right)) + 1;
	}
	
	// trivial
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		System.out.print("Binary Tree: ");
		if(isEmpty()) {
			System.out.print("Empty");
		} else {
			printInOrder(root);
		}
		System.out.print("\n");
	}
	
	private void printInOrder(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		printInOrder(node.left);
		System.out.printf("%3d ", node.data);
		printInOrder(node.right);
	}
	
	private void printPreOrder(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		System.out.printf("%3d ", node.data);
		printInOrder(node.left);
		printInOrder(node.right);
	}
	
	private void printPostOrder(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		
		printInOrder(node.left);
		printInOrder(node.right);
		System.out.printf("%3d ", node.data);
	}
	
	private class BinaryNode<G> {
		
		private G data;
		private BinaryNode<G> left;
		private BinaryNode<G> right;
		
		public BinaryNode(G data) {
			this.data = data;
		}
		
	}
	
}
