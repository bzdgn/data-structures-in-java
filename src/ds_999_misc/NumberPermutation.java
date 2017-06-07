package ds_999_misc;

public class NumberPermutation {

	public static void main(String[] args) {
		int N = 3;
		int[] permutations = new int[N];
		int numberOfChoices = 5;
		
		makePermutations(numberOfChoices, permutations);
	}

	private static void makePermutations(int numberOfChoices, int[] permutations) {
		makePermutations(0, numberOfChoices, permutations);
	}

	private static void makePermutations(int index, int numberOfChoices, int[] permutations) {
		if(index == permutations.length) {
			printPermutations(permutations);
		} else {
			int startIndex;
			if(index > 0) {
				startIndex = permutations[index-1] + 1;
			} else {
				startIndex = 1;
			}
			for(int i = startIndex; i <= numberOfChoices; i++) {
				permutations[index] = i;
				makePermutations(index+1, numberOfChoices, permutations);
			}
		}
	}
	
	private static void printPermutations(int[] permutations) {
		for(int i = 0; i < permutations.length; i++) {
			System.out.printf("%d ", permutations[i]);
		}
		System.out.printf("\n");
	}

}
