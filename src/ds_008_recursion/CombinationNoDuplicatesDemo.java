package ds_008_recursion;

public class CombinationNoDuplicatesDemo {

	public static void main(String[] args) {
		int numberOfChoices = 3;
		int[] selections = new int[2];
		
		makeCombination(numberOfChoices, selections);
	}
	
	private static void makeCombination(int numberOfChoices, int[] selections) {
		makeCombination(0, numberOfChoices, selections);
	}

	private static void makeCombination(int index, int numberOfChoices, int[] selections) {
		if(index == selections.length) {
			printArray(selections);
		} else {
			int start = 1;
			if(index > 0) {
				start = selections[index-1] + 1;	// No duplicates (1,1) (2,2) (3,3) ...
			}
			for(int i = start; i <= numberOfChoices; i++) {
				selections[index] = i;
				makeCombination(index + 1, numberOfChoices, selections);
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
