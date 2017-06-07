package ds_003_arrays;

public class Array2DWithVaryingRowNumbersDemo {

	public static void main(String[] args) {
		int[][] array = {
				{ 1, 2, 3 },
				{ 4, 5, 6, 7, 8 },
				{ 9 },
				{ 10, 11}
		};
		
		print2DArray(array);
	}
	
	private static void print2DArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.print("\n");
		}
	}

}
