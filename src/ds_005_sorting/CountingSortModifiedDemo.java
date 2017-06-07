package ds_005_sorting;

public class CountingSortModifiedDemo {

	public static void main(String[] args) {
//		int[] array = {1, 4, 3, 2, 5, 9, 7, 17, 13 };	// N = 20
//		int[] array = {4, 1, 2, 4, 3, 2, 2, 4};
		int[] array = {6, 9, 12, 15, 12, 12, 9, 7};
		
		
		printArray(array);
		int[] sorted = countingSort(array, 6, 15);
		printArray(sorted);
	}
	
	private static int[] countingSort(int[] array, int min, int max) {
		/*
		 * Step #1: Allocate an array count[1 to M]
		 * Step #2: Initialize count entries to 0
		 */
		int[] count = new int[max-min+1];
		
		/*
		 * Step #3: Count the values (and also count number of elements
		 */
		int N = 0;
		for(int i = 0; i < array.length; i++) {
			count[array[i]-min]++;
			N++;
		}
		
		/*
		 * Step #4: Read out the items for v = 1 to M,
		 * write v into the results count[v] times
		 */
		int[] sorted = new int[N];
		int index = 0;
		for(int i = 0; i < count.length; i++) {
			for(int j = 0; j < count[i]; j++) {
				sorted[index++] = i+min;
			}
		}
		
		return sorted;
	}
	
	private static void printArray(int[] array) {
		System.out.print("Array: ");
		int len = array.length;
		if(len == 0) {
			System.out.print("EMPTY");
		} else {
			for(int i = 0; i < len; i++) {
				System.out.printf("%2d ", array[i]);
			}
		}
		System.out.print("\n");
	}

}
