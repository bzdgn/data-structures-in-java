package ds_006_searching;

public class LinearSearchDemo {

	public static void main(String[] args) {
		int[] array = { 32, 91, 45, 3, 5, 39, 1, 4, 12, 2  };

		checkIndex(array, 39);
		checkIndex(array, 40);
	}

	private static int linearSearch(int[] array, int value) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value)
				return i;
		}
		return -1;
	}
	
	private static void checkIndex(int[] array, int value) {
		int index = linearSearch(array, value);
		if(index != -1) {
			System.out.printf("%2d found at index: %2d\n", value, index);
		} else {
			System.out.printf("%2d not found!\n", value, index);
		}
	}

}
