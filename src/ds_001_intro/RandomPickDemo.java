package ds_001_intro;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPickDemo {

	public static void main(String[] args) {
		// Original Array
		int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		// Number of Random Subset Elements
		int subsetNum = 5;
		
		int[] randomPicks = getRandomNArray(intArray, subsetNum);
		
		// Print Random Subset
		printArray(randomPicks);
	}
	
	//
	private static int[] getRandomNArray(int[] intArray, int N) {
		int[] randomPicks = new int[N];
		boolean[] isPicked = new boolean[intArray.length];
		
		int numPicked = 0;
		do {
			int i = getRandom(0, intArray.length);
			
			if(!isPicked[i]) {
				randomPicks[numPicked] = intArray[i];
				isPicked[i] = true;
				numPicked++;
			}
		} while(numPicked < N);
		
		return randomPicks;
	}
	
	// Generate Random number from the interval [a, b)
	private static int getRandom(int i, int length) {
		return ThreadLocalRandom.current().nextInt(i, length);
	}
	
	// Prints a 1D integer array
	private static void printArray(int[] intArray) {
		System.out.print("Array: ");
		for(int i = 0; i < intArray.length; i++) {
			System.out.printf("%2d", intArray[i]);
		}
		System.out.printf("\n");
	}
	
}
