package ds_008_recursion;

public class PermutationNoDuplicatesDemo {

	public static void main(String[] args) {
		int numberOfChoices = 3;
		int[] permutations = new int[2];
		
		makePermutation(numberOfChoices, permutations);
	}
	
	// Helper method
	private static void makePermutation(int numberOfChoices, int[] permutations) {
		boolean used[] = new boolean[numberOfChoices+1];
		makePermutation(0, permutations, used);
	}

	private static void makePermutation(int index, int[] permutations, boolean[] used) {
		if(index == permutations.length) {
			printArray(permutations);
		} else {
			for(int i = 1; i < used.length; i++) {
				if(!used[i]) {
					used[i] = true;
					permutations[index] = i;
					makePermutation(index + 1, permutations, used);
					used[i] = false;
				}
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
