package ds_005_sorting;

public class SelectionSortDemo {

	public static void main(String[] args) {
		
//		int[] array = { 4, 9, 3, 7, 8, 2, 1} ;
		int[] array = { 3, 8, 2, 1, 5, 4, 6, 7 };
		
//		int[] array = { 1, 2, 3, 4, 5 };
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
//		int[] array = { 5, 1, 2, 3, 4 };
//		int[] array = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
//		int[] array = { 5, 4, 3, 2, 1 };
//		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		
		
		printArray(array);
		System.out.println("************");
		quickSort(array);
		System.out.println("************");
		printArray(array);
	}
	
	/*
	 *  Worst Case     = O(N^2)
	 *  Average Case   = O(N*LogN)
	 *  Best Case      = O(N*LogN)
	 * 
	 *  Space Required = O(N)
	 *  Stack Space must be considered as well as Array Space
	 */
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int[] tempArray = new int[(end-start)+1];
		
		int pivotIndex = start;
//		int pivotIndex = end;	//	*1
		
		int left = 0;
		int right = end-start;
		
		for(int i = start+1; i <= end; i++) {
//		for(int i = start; i <= (end-1); i++) {	//	*2
			if( array[i] < array[pivotIndex] ) {
				tempArray[left++] = array[i];
			} else {
				tempArray[right--] = array[i];
			}
		}
		
		// left == right
		tempArray[left] = array[pivotIndex];
		pivotIndex = start + left;
		
		for(int i = start, j = 0; i <= end; i++, j++) {
			array[i] = tempArray[j];
		}
		
		if( (pivotIndex-1) != end) {
			quickSort(array, start, pivotIndex-1);
		}
		if( (pivotIndex+1) != start) {
			quickSort(array, pivotIndex+1, end);
		}
		
	}

	private static void printArray(int[] array) {
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.print("\n");
	}
	
	private static void printArray(int[] array, int start, int end) {
		System.out.print("Array: ");
		for(int i = start; i <= end; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.print("\n");
	}

}
