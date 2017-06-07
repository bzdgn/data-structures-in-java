package ds_005_sorting;

public class HeapTree<T extends Comparable<T>> {
	
	private Node<T> root;
	private int size;
	
	public HeapTree() {
		this.root = null;
	}
	
	public int[] heapSort(int[] values) {
		add(values);
		int[] sorted = new int[values.length];
		for(int i = sorted.length-1; i >= 0; i--) {
			sorted[i] = (int) remove();
		}
		
		return sorted;
	}
	
	public void add(int[] values) {
		for(int i = 0; i < values.length; i++) {
			Node<T> node = add(values[i]);
		}
	}
	
	private void handleParent(Node<T> node) {
		if(node.parent == null) {
			return;
		} else if(node.parent.value.compareTo(node.value) > 0) {
			return;
		} else {
			T temp = node.value;
			node.value = node.parent.value;
			node.parent.value = temp;
			
			if(node.parent != null) {
				handleParent(node.parent);
			}
		}
	}
	
	// addBottom
	public Node<T> add(int value) {
		Node<T> newNode = new Node(value);
		
		if(root == null) {
			newNode.parent = null;
			root = newNode;
		} else {
			SQueue<Node<T>> queue = new SQueue<>();
			Node<T> parent = null;
			
			// init
			queue.enqueue(root);
			
			while(!queue.isEmpty() && newNode.parent == null) {
				int tempSize = queue.size();
				for(int i = 0; i < tempSize; i++) {
					Node<T> temp = queue.dequeue();
					if(temp.left == null) {
						newNode.parent = temp;
						temp.left = newNode;
						break;
					} else if(temp.right == null) {
						newNode.parent = temp;
						temp.right = newNode;
						break;
					} else {
						queue.enqueue(temp.left);
						queue.enqueue(temp.right);
					}
				}
			}
			
		}
		
		size++;
		
		handleParent(newNode);
		
		return newNode;
	}
	
	private T getLast() {
		if(size <= 0) {
			return null;
		}
		
		boolean isLeftChild = false;
		Node<T> last = root;
		Node<T> parent = null;
		
		while(true) {
			if(last.right != null) {
				parent = last;
				last = last.right;
				isLeftChild = false;
			} else if(last.left != null){
				parent = last;
				last = last.left;
				isLeftChild = true;
			} else {
				break;
			}
		}
		
		T value = last.value;
		
		if(parent != null) {
			if(isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else {
			// only root exist
		}
		
		return value;
	}
	
	public T remove() {
		if(size == 0 || root == null) {
			return null;
		}
		
		T rootValue = root.value;
		T lastValue = getLast();
		
		root.value = lastValue;
		
		handleDown(root);
		
		if(size == 1 && root.value == lastValue) {
			root = null;
		}
		
		size--;
		
		return rootValue;
	}
	
	private void handleDown(Node<T> node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null && node.right != null) {
			if(node.left.value.compareTo(node.right.value) > 0) {
				if(node.left.value.compareTo(node.value) > 0) {
					swap(node, node.left);
					
					handleDown(node.left);
					return;
				}
			} else {
				if(node.right.value.compareTo(node.value) > 0) {
					swap(node, node.right);
					
					handleDown(node.right);
					return;
				}
			}
		} else if(node.left != null) {
			if(node.left.value.compareTo(node.value) > 0) {
				swap(node, node.left);
				
				handleDown(node.left);
				return;
			}
		} else if(node.right != null) {
			if(node.right.value.compareTo(node.value) > 0) {
				swap(node, node.right);
				
				handleDown(node.right);
				return;
			}
		}
		
	}
	
	private void swap(Node<T> node1, Node<T> node2) {
		T temp = node1.value;
		node1.value = node2.value;
		node2.value = temp;
	}
		
	public void print() {
		System.out.println("Heap;");
		System.out.println("*****");
		
		if(root == null) {
			System.out.println("Empty\n");
		} else {
			printLevels(root);
		}
	}
	
	public void printLevels(Node<T> node) {
		SQueue<Node<T>> queue = new SQueue<>();
		
		queue.enqueue(node);
		while(!queue.isEmpty()) {
			int tempSize = queue.size();
			System.out.print("\t");
			for(int i = 0; i < tempSize; i++) {
				Node<T> temp = queue.dequeue();
				System.out.printf("%s ", temp);
				
				if(temp.left != null) {
					queue.enqueue(temp.left);
				}
				
				if(temp.right != null) {
					queue.enqueue(temp.right);
				}
			}
			System.out.println();
		}
	}
	
	private void printLMR(Node<T> node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			printLMR(node.left);
		}
		
		System.out.printf("%d ", node.value);
		
		if(node.right != null) {
			printLMR(node.right);
		}
	}
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	private static class Node<G extends Comparable<G>> {
		private G value;
		private Node<G> parent;
		private Node<G> left;
		private Node<G> right;
		
		public Node(G value) {
			this.parent = null;
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		@Override
		public String toString() {
			return "" + value;
		}
		
	}
	
}
