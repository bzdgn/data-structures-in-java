package ds_010_trees;

public class ChildrenTest {

	public static void main(String[] args) {
		Children<Integer> children = new Children<>();
		
		children.printChildren();
		children.add(10);
		children.printChildren();
		children.add(20);
		children.printChildren();
		children.add(30);
		children.printChildren();
		
		Integer removed = children.remove(20);
		System.out.printf("\tRemoved: %s\n", removed);
		children.printChildren();
		
		removed = children.remove(1111);
		System.out.printf("\tRemoved: %s\n", removed);
		children.printChildren();
	}

}
