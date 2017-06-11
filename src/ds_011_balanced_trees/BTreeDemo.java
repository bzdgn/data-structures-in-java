package ds_011_balanced_trees;

public class BTreeDemo {

	public static void main(String[] args) {
		BTree<Integer> tree = new BTree<>(2);
		
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(50);
		
		tree.printTree();
	}

}
