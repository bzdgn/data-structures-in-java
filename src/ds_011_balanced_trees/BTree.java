package ds_011_balanced_trees;

public class BTree<T extends Comparable<T>> {
	
	private final short		orderOfK;
	private Bucket<T>		root;
	
	public BTree(short orderOfK) {
		this.orderOfK = orderOfK;
		Bucket<T> bucket = new Bucket();
	}
	
	private class Bucket<G> {
		private G[]			values;
		private Bucket[]	branches;
		int size;
		
		public Bucket() {
			values		= (G[]) new Comparable[2*orderOfK];
			branches	= new Bucket[2*orderOfK + 1];
			size		= 0;
		}
		
		// operations
		public G add(G value) {
			if(!isFull()) {
				values[size++] = value;
				
				return null;
			} else {
				;
				return null;
			}
		}
		
		// trivial
		private int size() {
			return size;
		}
		
		private boolean isEmpty() {
			return size == 0;
		}
		
		private boolean isFull() {
			return size == 2*orderOfK;
		}
	}
	
}
