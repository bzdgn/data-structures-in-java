package ds_012_decision_trees;

public class PartitionProblemGenericSolution {

	public static void main(String[] args) {
//		int[] values = { 4, 2, 1, 1 };
//		int[] values = { 1, 4, 2, 1 };
		int[] values = { 9, 7, 8, 8, 32, 3, 1, 5 , 6, 7, 8, 12, 13, 14, 15, 16, 16, 88, 32, 12 };

		handleSolution(values, 3);
	}
	
	public static void handleSolution(int[] values, int numberOfSubsets) {
		String header = String.format("Dividing Values Array Into Equal Sum Of %d Subsets", numberOfSubsets);
		char[] line = new char[header.length()];
		for(int i = 0; i < line.length; i++) {
			line[i] = '*';
		}
		System.out.println(header);
		System.out.println(line);
		
		int[] testSolution = new int[values.length];
		findSolution(0, values, testSolution, numberOfSubsets);
		int[][] subsets = prepareSubsets(values, testSolution, numberOfSubsets);
		
		for(int i = 0; i < subsets.length; i++) {
			System.out.printf("Subset #%d: ", (i+1));
			for(int j = 0; j < subsets[i].length; j++) {
				System.out.printf("%s ", subsets[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static boolean findSolution(int index, int[] values, int[] solution, int numberOfSubsets) {
		if(index == solution.length) {
			if(isSolutionValid(values, solution, numberOfSubsets)) {
				return true;
			}
			return false;
		}
		
		for(int i = 0; i < numberOfSubsets; i++) {
			solution[index] = i;
			if(findSolution(index+1, values, solution, numberOfSubsets)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Validate that sum of two subsets are equal
	 */
	private static boolean isSolutionValid(int[] values, int[] solution, int numberOfSubsets) {
		int[] subsets = new int[numberOfSubsets];
		
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < numberOfSubsets; j++) {
				if(solution[i] == j) {
					subsets[j] += values[i];
				}
			}
		}
		
		return areSubsetsEqual(subsets);
	}
	
	private static boolean areSubsetsEqual(int[] subsets) {
		for(int i = 1; i < subsets.length; i++) {
			if(subsets[i] != subsets[i-1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int[][] prepareSubsets(int[] values, int[] solution, int numberOfSubsets) {
		int[] counts = new int[numberOfSubsets];
		
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < numberOfSubsets; j++) {
				if(solution[i] == j) {
					counts[j]++;
				}
			}
		}
		
		int[][] subsets = new int[numberOfSubsets][];
		for(int i = 0; i < counts.length; i++) {
			subsets[i] = new int[counts[i]];
		}
		
		int[] indexes = new int[numberOfSubsets];
		
		for(int i = 0; i < solution.length; i++) {
			subsets[solution[i]][indexes[solution[i]]++] = values[i];
		}
		
		return subsets;
	}

}
