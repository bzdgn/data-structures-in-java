package ds_001_intro;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizatinDemo {

	public static void main(String[] args) {
		int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		printArray(intArray);
		randomizeArray(intArray);
		printArray(intArray);
	}

	private static void printArray(int[] intArray) {
		System.out.print("Array: ");
		for(int i = 0; i < intArray.length; i++) {
			System.out.printf("%2d", intArray[i]);
		}
		System.out.printf("\n");
	}

	private static void randomizeArray(int[] intArray) {
		for(int i = 0; i < intArray.length; i++) {
			// Random number between i and N
			int j = getRandom(i, intArray.length);
			
			// swap
			int temp = intArray[i];
			intArray[i] = intArray[j];
			intArray[j] = temp;
		}
	}

	private static int getRandom(int i, int length) {
		return ThreadLocalRandom.current().nextInt(i, length);
	}

}
