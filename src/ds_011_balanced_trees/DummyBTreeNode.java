package ds_011_balanced_trees;

public class DummyBTreeNode<T extends Comparable<T>> {
	
	private final int order;
	public T[] values;
	public DummyBTreeNode<T>[] branches;
	private int bucketSize;
	
	public DummyBTreeNode(int order) {
		this.order = order;
		values		= (T[]) new Comparable[2*this.order];
		branches	= new DummyBTreeNode[2*this.order + 1];
//		System.out.printf("Order of %d Node is created: Min: %d, Max: %d\n", order, order, values.length);
	}
	
	public void add(T value) {
		if(isFull()) {
			return;
		}
		
		values[bucketSize++] = value;
	}
	
	public void remove(T value) {
		if(isEmpty()) {
			return;
		}
		
		values[bucketSize--] = null;
		
		if(bucketSize < order) {
			// balance operations
			;
		}
	}
	
	public boolean find(T value) {
		if(find(this, value) != null) {
			return true;
		}
		
		return false;
	}
	
	private DummyBTreeNode<T> find(DummyBTreeNode<T> node, T value) {	
		if(node == null) {
			return null;
		}
		
		int i = 0;
		for(; i < node.bucketSize; i++) {
			// TODO: to be deleted, for debug purposes only
//			System.out.printf("\t\tValue: %s, Node_Value: %s\n", value, node.values[i]);
			if(value.equals(node.values[i])) {
				return this;
			}
			
			if(value.compareTo(node.values[i]) < 0) {
				return find(node.branches[i], value);
			}
		}
		
		if(i == node.bucketSize) {
			return find(node.branches[bucketSize], value);
		}
		
		return null;
	}
	
	// trivial
	private boolean isFull() {
		return bucketSize == values.length;
	}
	
	private boolean isEmpty() {
		return bucketSize == 0;
	}
	
	public void printBucket() {
		printBucket(this);
	}
	
	private void printBucket(DummyBTreeNode<T> bucket) {
		if(bucket == null) {
			return;
		}
		
		for(int i = 0; i < bucket.bucketSize; i++) {
			printBucket(bucket.branches[i]);
			System.out.printf("%s ", bucket.values[i]);
		}
		printBucket(bucket.branches[bucketSize]);
	}
	
}
