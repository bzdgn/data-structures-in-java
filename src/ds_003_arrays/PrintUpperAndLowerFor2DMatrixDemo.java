package ds_003_arrays;

public class PrintUpperAndLowerFor2DMatrixDemo {

	public static void main(String[] args) {
		int[][] matrix = {
				{  1,  2,  3,  4 },
				{  5,  6,  7,  8 },
				{  9, 10, 11, 12 },
				{ 13, 14, 15, 16 }
		};
		
		printMatrix(matrix);
		printUpperMatrix(matrix);
		printLowerMatrix(matrix);
		printMatrixDiagonal(matrix);
		
	}
	
	private static void printUpperMatrix(int[][] matrix) {
		System.out.println("Upper Matrix");
		System.out.println("************");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(j > i) {
					System.out.printf("%2d ", matrix[i][j]);
				} else {
					System.out.print("   ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	private static void printLowerMatrix(int[][] matrix) {
		System.out.println("Lower Matrix");
		System.out.println("************");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(i > j) {
					System.out.printf("%2d ", matrix[i][j]);
				} else {
					System.out.print("   ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	private static void printMatrixDiagonal(int[][] matrix) {
		System.out.println("Matrix Diagonal");
		System.out.println("***************");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(i == j) {
					System.out.printf("%2d ", matrix[i][j]);
				} else {
					System.out.print("   ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	private static void printMatrix(int[][] matrix) {
		System.out.println("Matrix");
		System.out.println("******");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
}
