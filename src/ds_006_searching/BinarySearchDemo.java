package ds_006_searching;

public class BinarySearchDemo {

	public static void main(String[] args) {
//		int[] array = { 1, 5, 6, 6, 6, 6, 6, 15, 17, 18, 21, 25, 32, 35, 39, 39, 39, 41, 42, 47, 47, 59, 63, 63, 64, 64, 69, 72  };
//		checkIndex(array, 39);
//		checkIndex(array, 40);
//		checkIndex(array, 1);
//		checkIndex(array, 72);
		
		int[] array = { 0, 4, 7, 9, 12, 14, 18, 25, 27, 36, 46, 50, 64, 79, 88 };
		checkIndex(array, 36);
	}

	private static int binarySearch(int[] array, int value) {
		int min = 0;
		int max = array.length-1;
		while(min <= max) {
			int mid = (min + max) / 2;
			System.out.printf("\tMin: %d, Mid: %d, Max: %d\n",min, mid, max);
			
			if(array[mid] == value) {
				return mid;
			} else {
				if( value < array[mid] ) {
					max = mid-1;
				} else {
					min = mid+1;
				}
			}
		}
		
		return -1;
	}
	
	private static void checkIndex(int[] array, int value) {
		int index = binarySearch(array, value);
		if(index != -1) {
			System.out.printf("%2d found at index: %2d\n", value, index);
		} else {
			System.out.printf("%2d not found!\n", value, index);
		}
	}

}
