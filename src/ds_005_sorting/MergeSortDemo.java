package ds_005_sorting;

/*
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
 */
public class MergeSortDemo {

	public static void main(String[] args) {
		int[] array = {4, 5, 9, 8, 1, 2, 7, 6, 3 };
		
		printArray(array);
		mergeSort(array);
		printArray(array);
	}
	
	private static void mergeSort(int[] array) {
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length-1);
	}
	
	private static void mergeSort(int[] array, int[] temp, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(array, temp, left, center);
			mergeSort(array, temp, center + 1, right);
			merge(array, temp, left, center + 1, right);
		}
	}
	
	private static void merge(int[] array, int[] temp, int left, int right, int rightEnd) {
		int leftEnd = right-1;
		int k = left;
		int num = rightEnd - left + 1;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[right++];
			}
		}
		
		// copy rest of first half
		while(left <= leftEnd) {
			temp[k++] = array[left++];
		}
		
		// copy rest of right half
		while(right <= rightEnd) {
			temp[k++] = array[right++];
		}
		
		// copy temp back
		for(int i = 0; i < num; i++, rightEnd--) {
			array[rightEnd] = temp[rightEnd];
		}
	}
	
	// trivial
	private static void printArray(int[] array) {
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.print("\n");
	}
	
	private static void printArray(int[] array, int begin, int end) {
		System.out.print("Array: ");
		for(int i = begin; i < end; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.print("\n");
	}

}
