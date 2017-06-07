package ds_005_sorting;

public class BubbleSortDemo {

	public static void main(String[] args) {
		int[] array = { 2, 4, 6, 7, 5, 8 };
		
		printArray(array);
		bubbleSort(array);
		printArray(array);
	}

	private static void bubbleSort(int[] array) {
		boolean finished = false;
		int len = array.length;
		while(!finished) {
			finished = true;
			for(int i = 0; (i+1) < len; i++) {
				if(array[i] > array[i+1]) {
					swap(array, i, i+1);
					finished = false;
				}
			}
		}
	}

	private static void swap(int[] array, int index1, int index2) {
		if(index1 >= array.length || index2 >= array.length) {
			return;
		}
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static void printArray(int[] array) {
		System.out.print("Array: ");
		int len = array.length;
		if(len == 0) {
			System.out.print("EMPTY");
		} else {
			for(int i = 0; i < len; i++) {
				System.out.printf("%d ", array[i]);
			}
		}
		System.out.print("\n");
	}

}
