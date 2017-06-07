package ds_008_recursion;

public class PermutationDemo {

	public static void main(String[] args) {
		int numberOfChoices = 3;
		int[] permutations = new int[2];
		
		makePermutation(numberOfChoices, permutations);
	}
	
	// Helper method
	private static void makePermutation(int numberOfChoices, int[] permutations) {
		makePermutation(0, numberOfChoices, permutations);
	}

	private static void makePermutation(int index, int numberOfChoices, int[] permutations) {
		if(index == permutations.length) {
			printArray(permutations);
		} else {
			for(int i = 1; i <= numberOfChoices; i++) {
				permutations[index] = i;
				makePermutation(index + 1, numberOfChoices, permutations);
			}
		}
	}
	
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.print("\n");
	}

}
