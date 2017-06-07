package ds_006_searching;

public class InterpolationSearchDemo {

	public static void main(String[] args) {
//		int[] array = { 1, 5, 6, 6, 6, 6, 6, 15, 17, 18, 21, 25, 32, 35, 39, 39, 39, 41, 42, 47, 47, 59, 63, 63, 64, 64, 69, 72  };
//		checkIndex(array, 39);
//		checkIndex(array, 40);
//		checkIndex(array, 1);
//		checkIndex(array, 72);
		
//		int[] array = { 0, 4, 7, 9, 12, 14, 18, 25, 27, 36, 46, 50, 64, 79, 88 };
//		checkIndex(array, 36);
		
		int[] array = { 0, 7, 12, 17, 21, 26, 31, 33, 40, 43, 49, 51, 64, 66, 72, 73, 81, 87, 95, 99 };
		checkIndex(array, 64);
		checkIndex(array, 65);
		checkIndex(array, 150);
		checkIndex(array, -10);
		checkIndex(array, 7);
		checkIndex(array, 0);
		checkIndex(array, 1);
		checkIndex(array, 98);
		checkIndex(array, 100);
		checkIndex(array, 99);
	}

	private static int interpolationSearch(int[] array, int value) {
		int min = 0;
		int max = array.length-1;
		
		if(value > array[max] || value < array[min]) {
			return -1;
		}
		
		int indexRange = max - min;
		int valueRange = array[max] - array[min];
		int distance = value - array[min];
		double fraction = ((double)distance)/(valueRange);
		int guess = min + (int)(fraction*indexRange);
		
		if(array[guess] == value) {
			return guess;
		} else {
			if(array[guess] < value) {
				min = guess;
				int increment = 1;
				while(array[guess] < value) {
//					System.out.println("\t\t\tGuess: " + guess);
					guess += increment;
					increment *= 2;
				}
				// guess > value
				max = guess;
				
//				System.out.printf("\tMin: %d, Max: %d\n",min, max);
				return binarySearch(array, value, min, max);
			} else {
				max = guess;
				int increment = -1;
				while(array[guess] > value) {
					guess += increment;
					increment *= 2;
				}
				// guess < value
				min = guess;
				
//				System.out.printf("\tMin: %d, Max: %d\n",min, max);
				return binarySearch(array, value, min, max);
			}
		}
	}
	
	private static void checkIndex(int[] array, int value) {
		int index = interpolationSearch(array, value);
		if(index != -1) {
			System.out.printf("%2d found at index: %2d\n", value, index);
		} else {
			System.out.printf("%2d not found!\n", value, index);
		}
	}
	
	private static int binarySearch(int[] array, int value, int min, int max) {
		while(min <= max) {
			int mid = (min + max) / 2;
//			System.out.printf("\tMin: %d, Mid: %d, Max: %d\n",min, mid, max);
			
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

}
