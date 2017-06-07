package ds_004_stacks_and_queues;

public class StackAlgorithmsDemo {

	public static void main(String[] args) {
		// reverse array
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		printArray(array);
		reverseArray(array);
		printArray(array);
	}
	
	private static void reverseArray(int[] array) {
		StackArray<Integer> stack = new StackArray<>();
		
		for(int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			array[i] = stack.pop();
		}
	}
	
	// trivial
	private static void printArray(int[] array) {
		System.out.print("Array: ");
		
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		
		System.out.print("\n");
	}

}
