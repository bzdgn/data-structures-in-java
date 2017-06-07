package ds_005_sorting;

/*
 * TO BE IMPLEMENTED!
 */
public class InsertionSortLinkedListDemo {

	public static void main(String[] args) {
		
		int[] array = { 2, 1, 3, 4, 5, 7, 6 };
//		int[] array = { 5, 3, 4, 4, 8, 6, 7 };
//		int[] array = { 5, 3, 4, 4, 8, 6, 7, 1 };
//		int[] array = { 5, 4, 3, 2, 1 };
//		int[] array = { 1 ,2, -5, 3, 2 } ;
		
//		int[] array = { 1, 2, 3, 4, 5 };
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
//		int[] array = { 5, 1, 2, 3, 4 };
//		int[] array = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
//		int[] array = { 5, 4, 3, 2, 1 };
//		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		printArray(array);
		
		insertionSort(array);
		
		printArray(array);
	}
	
	/*
	 * Worst Case  : O(N^2)	Items begin in sorted order
	 * Best Case   : O(N)	Items begin in reverse sorted order
	 * Random Case : O(N^2) Items begin arranged randomly
	 */
	private static void insertionSort(int[] array) {
		int times = 0;
		
		for(int i = 1; i < array.length; i++) {
			for(int k = i-1; k >= 0 && (array[k+1] < array[k]); k--) {
				// swap k 
				int temp = array[k];
				array[k] = array[k+1];
				array[k+1] = temp;
				
				times++;
			}
		}
		
		System.out.println("Times : " + times);
	}

	private static void printArray(int[] array) {
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.print("\n");
	}

}
