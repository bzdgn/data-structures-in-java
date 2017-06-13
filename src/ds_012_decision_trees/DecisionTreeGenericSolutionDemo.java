//package ds_012_decision_trees;
//
//public class DecisionTreeGenericSolutionDemo {
//	
//	private static final int LENGTH = 10;
//	
//	public static void main(String[] args) {
//		int[] testSolution = new int[LENGTH];
//		
//	}
//	
//	public static boolean findSolution(int index, int[] decisions, int[] testSolution) {
//		if(index == testSolution.length) {
//			if(isSolutionValid(testSolution)) {
//				return true;
//			}
//			
//			return false;
//		}
//		
//		// for each decision
//		for(int i = 0; i < decisions.length; i++) {
//			testSolution[index] = decisions[i];
//			if(findSolution(index + 1, decisions, testSolution)) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
//	public static boolean isSolutionValid(int[] testSolution) {
//		;
//	}
//
//}
