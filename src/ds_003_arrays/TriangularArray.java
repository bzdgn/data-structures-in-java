package ds_003_arrays;

public class TriangularArray<T> {
	
	private int numRows;
	private T[] values;
	
	@SuppressWarnings("unchecked")
	public TriangularArray(int numRows) {
		this.numRows = numRows;
		values = (T[])new Object[numRows * (numRows-1) / 2];
	}
	
	private int mapRowAndCol(int row, int col) {
		if(row < col) {
			int temp = col;
			col = row;
			row = temp;
		}
		
		return row*(row-1)/2 + col;
	}
	
	public void set(T value, int row, int col) {
		values[mapRowAndCol(row, col)] = value;
	}
	
	public T get(int row, int col) {
		return values[mapRowAndCol(row, col)];
	}
	
	public int size() {
		return values.length;
	}
	
	public void printArray() {
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numRows; j++) {
				if(i == j) {
					System.out.printf(". ");
				} else {
					System.out.printf("%s ", values[mapRowAndCol(i, j)]);
				}
				
			}
			System.out.print("\n");
		}
	}
	
}
