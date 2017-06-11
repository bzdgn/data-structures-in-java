package ds_011_balanced_trees;

public class BTree<T extends Comparable<T>> {
	
	private final int			order;
	private BTreeBucket<T>		root;
	
	public BTree(int order) {
		this.order = order;
		this.root = new BTreeBucket<>(this.order);
	}
	
	public void add(T value) {
		root.add(value);
	}
	
	public void remove(T value) {
		root.remove(value);
	}
	
	public void printTree() {
		root.printBucket();
	}
	
}
