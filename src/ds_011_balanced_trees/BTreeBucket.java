package ds_011_balanced_trees;

public class BTreeBucket<T extends Comparable<T>> {
	
	private final int order;
	private T[] values;
	private BTreeBucket<T>[] branches;
	private int bucketSize;
	
	public BTreeBucket(int order) {
		this.order = order;
		values		= (T[]) new Comparable[2*this.order];
		branches	= new BTreeBucket[2*this.order + 1];
//		System.out.printf("Order of %d Node is created: Min: %d, Max: %d\n", order, order, values.length);
	}
	
	public void add(T value) {
		if(isFull()) {
			System.out.printf("\tError: node is full: %d is not added\n", value);
			return;
		}
		
		if(bucketSize == 0) {
			values[bucketSize++] = value;
		} else {
			if(value.compareTo(values[bucketSize-1]) > 0) {
				values[bucketSize++] = value;
			}
		}
		
	}
	
//	private BTreeBucket<T> add(BTreeBucket<T> bucket, T value) {
//		;
//	}
	
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
	
	private BTreeBucket<T> find(BTreeBucket<T> node, T value) {	
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
	public void printBucket() {
		printBucket(this);
	}
	
	private void printBucket(BTreeBucket<T> bucket) {
		if(bucket == null) {
			return;
		}
		
		for(int i = 0; i < bucket.bucketSize; i++) {
			printBucket(bucket.branches[i]);
			System.out.printf("%s ", bucket.values[i]);
		}
		printBucket(bucket.branches[bucketSize]);
	}
	
	private boolean isFull() {
		return bucketSize == values.length;
	}
	
	private boolean isEmpty() {
		return bucketSize == 0;
	}
	
}
