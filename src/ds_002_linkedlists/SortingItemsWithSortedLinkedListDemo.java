package ds_002_linkedlists;

public class SortingItemsWithSortedLinkedListDemo {

	public static void main(String[] args) {
		int[] items = {93, 34, 5, 62, 12, 99, 5, 7, 2, 45, 86, 71, 7, 93, 27, 21, 14, 68 };
		
		printArrays(items);
		
		SortedLinkedList list = new SortedLinkedList();
		for(int i = 0; i < items.length; i++)
			list.add(items[i]);
		
		list.printList();
	}
	
	private static void printArrays(int[] array) {
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.printf("\n");
	}

}
