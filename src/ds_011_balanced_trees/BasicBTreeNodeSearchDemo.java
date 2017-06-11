package ds_011_balanced_trees;

public class BasicBTreeNodeSearchDemo {
	
	/*
	 *                         |11|25|-|-|
	 *                        /   |   \
	 *         ______________/    |    \______________
	 *         |                  |                  |
	 *     |2|5|-|-|        |13|15|16|18|        |32|37|-|-|
	 */
	public static void main(String[] args) {
		DummyBTreeNode<Integer> root = prepareRoot();
		
		System.out.println("Found: " + root.find(37));
		
		root.printBucket();
	}
	
	private static DummyBTreeNode<Integer> prepareRoot() {
		DummyBTreeNode<Integer> root = new DummyBTreeNode<>(2);
		
		// level 0
		root.add(11);
		root.add(25);
		
		// level 1
		// child1
		DummyBTreeNode<Integer> child1 = new DummyBTreeNode<>(2);
		child1.add(2);
		child1.add(5);
		
		root.branches[0] = child1;
		
		// child2
		DummyBTreeNode<Integer> child2 = new DummyBTreeNode<>(2);
		child2.add(13);
		child2.add(15);
		child2.add(16);
		child2.add(18);
		
		root.branches[1] = child2;
		
		// child3
		
		DummyBTreeNode<Integer> child3 = new DummyBTreeNode<>(2);
		child3.add(32);
		child3.add(37);
		
		root.branches[2] = child3;
		
		return root;
	}

}
