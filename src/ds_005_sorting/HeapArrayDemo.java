package ds_005_sorting;

public class HeapArrayDemo {

	public static void main(String[] args) {
		int[] array = { 5, 3, 1, 2, 9, 8, 6, 7 };
		
		HeapArray heap = new HeapArray(array.length);
		heap.add(array);
		heap.print();
//		heap.printPretty();
		
		Integer[] sorted = heap.heapSort();
		System.out.println("SORTED: ");
		for(int i = 0; i < sorted.length; i++) {
			System.out.printf("%d ", sorted[i]);
		}
	}

}
