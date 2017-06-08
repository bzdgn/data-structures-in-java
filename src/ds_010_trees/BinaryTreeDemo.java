package ds_010_trees;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		
		tree.add(new Integer[]{10, 5, 15, 3, 7, 20});
		tree.print();
		
		boolean isFound = tree.find(17);
		System.out.println("17 exist? : " + isFound);
		
		isFound = tree.find(10);
		System.out.println("10 exist? : " + isFound);
		
		isFound = tree.find(20);
		System.out.println("20 exist? : " + isFound);
	}

}
