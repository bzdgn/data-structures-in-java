package ds_005_sorting;

public class HeapTreeDemo {

	public static void main(String[] args) {
		HeapTree<Integer> heap = new HeapTree<>();
		
//		int[] values = {1, 9, 2, 3, 4, 6, 5};
//		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//		int[] values = {1, 2, 3, 4};
		
//		int[] values = {9, 8, 2, 3, 7, 1};
//		heap.add(values);
//		heap.print();
//		heap.add(4);
//		heap.print();
		
		int[] values = {9, 8, 2, 3, 7, 1, 4};
//		heap.add(values);
//		heap.print();
		
//		int[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] sorted = heap.heapSort(values);
		for(int i = 0; i < sorted.length; i++) {
			System.out.printf("%s ", sorted[i]);
		}
		
//		System.out.print("Sorted: ");
//		while(!heap.isEmpty()) {
//			Integer temp = heap.remove();
//			
//			if(temp != null)
//				System.out.printf("%s ", temp);
//		}
//		System.out.print("\n");
//		
//		heap.print();
		
		
		
		
		
		
//		Heap.Node<Integer> root = new Heap.Node<Integer>(1);
//		
//		// level 2
//		root.left = new Heap.Node<Integer>(2);
//		root.right = new Heap.Node<Integer>(3);
//		
//		// level 3
//		root.left.left = new Heap.Node<Integer>(4);
//		root.left.right = new Heap.Node<Integer>(5);
//		root.right.left = new Heap.Node<Integer>(6);
//		root.right.right = new Heap.Node<Integer>(7);
//		
//		System.out.println();
//		heap.printLevels(root);
	}

}
