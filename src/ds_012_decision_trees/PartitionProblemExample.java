package ds_012_decision_trees;

public class PartitionProblemExample {

	public static void main(String[] args) {
//		int[] values = { 4, 2, 1, 1 };
//		int[] values = { 1, 4, 2, 1 };
		int[] values = { 9, 7, 8, 8, 32, 3, 1, 5 , 6, 7, 8, 12, 13, 14, 15, 16, 16, 88, 32, 12 };

		handleSolution(values);
	}
	
	public static void handleSolution(int[] values) {
		int[] testSolution = new int[values.length];
		findSolution(0, values, testSolution);
		int[][] subsets = prepareSubsets(values, testSolution);
		
		System.out.print("Subset1: ");
		for(int i = 0; i < subsets[0].length; i++) {
			System.out.printf("%s ", subsets[0][i]);
		}
		System.out.print("\n");
		System.out.print("Subset2: ");
		for(int i = 0; i < subsets[1].length; i++) {
			System.out.printf("%s ", subsets[1][i]);
		}
		System.out.print("\n");
	}
	
	public static boolean findSolution(int index, int[] values, int[] solution) {
		if(index == solution.length) {
			if(isSolutionValid(values, solution)) {
				return true;
			}
			return false;
		}
		
		solution[index] = 0;
		if(findSolution(index+1, values, solution)) {
			return true;
		}
		
		solution[index] = 1;
		if(findSolution(index+1, values, solution)) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * Validate that sum of two subsets are equal
	 */
	private static boolean isSolutionValid(int[] values, int[] solution) {
		int total0 = 0;
		int total1 = 0;
		
		for(int i = 0; i < solution.length; i++) {
			if(solution[i] == 0) {
				total0 += values[i];
			} else {
				total1 += values[i];
			}
		}
		
		return total0 == total1;
	}
	
	private static int[][] prepareSubsets(int[] values, int[] solution) {
		int count = 0;
		for(int i = 0; i < solution.length; i++) {
			if(solution[i] == 0) {
				count++;
			}
		}
		int[] subset1 = new int[count];
		int[] subset2 = new int[values.length - count];
		
		
		for(int i = 0, index1 = 0, index2 = 0; i < solution.length; i++) {
			if(solution[i] == 0) {
				subset1[index1++] = values[i];
			} else if(solution[i] == 1) {
				subset2[index2++] = values[i];
			}
		}
		
		int[][] subsets = new int[2][];
		subsets[0] = subset1;
		subsets[1] = subset2;
		
		return subsets;
	}

}
