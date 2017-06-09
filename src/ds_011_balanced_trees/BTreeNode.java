package ds_011_balanced_trees;

public class BTreeNode<T extends Comparable<T>> {
	
	public T[] values;
	public BTreeNode<T>[] branches;
	int size;
	
	public BTreeNode(int order) {
		values		= (T[]) new Comparable[2*order];
		branches	= new BTreeNode[2*order + 1];
	}
	
	public void add(T value) {
		if(isFull()) {
			return;
		}
		
		values[size++] = value;
	}
	
	public boolean find(T value) {
		if(find(this, value) != null) {
			return true;
		}
		
		return false;
	}
	
	private BTreeNode<T> find(BTreeNode<T> node, T value) {	
		if(node == null) {
			return null;
		}
		
		int i = 0;
		for(; i < node.size; i++) {
			System.out.printf("\t\tValue: %s, Node_Value: %s\n", value, node.values[i]);
			if(value.equals(node.values[i])) {
				return this;
			}
			
			if(value.compareTo(node.values[i]) < 0) {
				return find(node.branches[i], value);
			}
		}
		
		if(i == node.size) {
			return find(node.branches[size], value);
		}
		
		return null;
	}
	
	// trivial
	public boolean isFull() {
		return size == values.length;
	}
	
}
