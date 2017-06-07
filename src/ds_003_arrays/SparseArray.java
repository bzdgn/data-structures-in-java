package ds_003_arrays;

public class SparseArray<T> {
	
	private final int MAX_NUMBER;	// max row/col index
	private int size = 0;
	private final RowCell<T> START;
	private final RowCell<T> END;
	private final T DEFAULT_VALUE;
	
	public SparseArray(final int maxNumber, T defaultValue){
		MAX_NUMBER = maxNumber;
		DEFAULT_VALUE = defaultValue;
		
		START	= new RowCell<>(Integer.MIN_VALUE, MAX_NUMBER, DEFAULT_VALUE);
		END		= new RowCell<>(Integer.MAX_VALUE, MAX_NUMBER, DEFAULT_VALUE);
		
		START.next = END;
	}
	
	public void insertCol(int rowNum, int colNum, T value) {
		RowCell<T> r = findRowCell(rowNum);
		
		if(r == null) {
			return;
		}
		
		r.insertCol(colNum, value);
	}
	
	public boolean findRow(int rowNum) {
		if(!checkRowCol(rowNum, MAX_NUMBER)) {
			return false;
		}
		
		return findRowCell(rowNum) != null ? true : false;
	}
	
	private RowCell<T> findRowCell(int rowNum) {
		for(RowCell<T> r = START; r != END; r = r.next) {
			if(r.rowNum == rowNum)
				return r;
		}
		
		return null;
	}
	
	public void deleteRow(int rowNum) {
		if(!checkRowCol(rowNum, MAX_NUMBER)) {
			return;
		}
		
		for(RowCell<T> r = START; r != END; r = r.next) {
			if(r.next.rowNum == rowNum) {
				deleteRowCell(r);
				break;
			}
		}
	}
	
	private void deleteRowCell(RowCell<T> ref) {
		ref.next = ref.next.next;
	}
	
	public void insertRow(int rowNum) {
		if(rowNum < 0) {
			return;
		}
		
		if(!checkRowCol(rowNum, MAX_NUMBER)) {
			return;
		}
		
		// short circuit if size == 0
		if(size == 0) {
			insertAfterRowCell(START, new RowCell<T>(rowNum, MAX_NUMBER, DEFAULT_VALUE));
			return;
		}
		
		RowCell<T> r = START;
		while( r.next != END ) {
			if(rowNum > r.next.rowNum)
				r = r.next;
			else
				break;
		}
		
		insertAfterRowCell(r, new RowCell<>(rowNum, MAX_NUMBER, DEFAULT_VALUE));
	}
	
	private void insertAfterRowCell(RowCell<T> ref, RowCell<T> newCell) {
		newCell.next = ref.next;
		ref.next = newCell;
		size++;
	}
	
	public void printRows() {
		System.out.print("Rows: ");
		
		if(size == 0) {
			System.out.print("EMPTY\n");
			return;
		}
		
		for(RowCell<T> r = START.next; r != END; r = r.next) {
			System.out.printf("%2d ", r.rowNum);
		}

		System.out.print("\n");
	}
	
	public void printArray() {
		System.out.print("   ");
		
		// top index
		for(int i = 1; i <= MAX_NUMBER; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.print("\n");

		RowCell<T> r = START.next;
		
		for(int i = 1; i <= MAX_NUMBER ; i++) {
			if(i == r.rowNum) {
				System.out.printf("%2d ", r.rowNum);
				r.printCols();
				r = r.next;
			} else {
				System.out.printf("%2d ", i);
				for(int j = 0; j < MAX_NUMBER; j++) {
					System.out.printf("%2d ", DEFAULT_VALUE);
				}
				System.out.printf("\n");
			}
		}

		System.out.print("\n");
	}
	
	private static class RowCell<T> {
		public final int rowNum;
		private RowCell<T> next;
		
		private final ColCell<T> R_START	= new ColCell<>(Integer.MIN_VALUE, null);
		private final ColCell<T> R_END		= new ColCell<>(Integer.MAX_VALUE, null);
		private int size = 0;
		
		private final int MAX_NUMBER;	// max row/col index
		private final T DEFAULT_VALUE;
		
		public RowCell(final int rowNum, final int maxNumber, final T defaultValue) {
			this.rowNum = rowNum;
			this.R_START.next = this.R_END;
			this.MAX_NUMBER = maxNumber;
			this.DEFAULT_VALUE = defaultValue;
		}
		
		public void insertCol(int colNum, T value) {
			if(colNum < 0) {
				return;
			}
			
			if(!checkRowCol(colNum, MAX_NUMBER)) {
				return;
			}
			
			// short circuit if size == 0
			if(size == 0) {
				insertAfterColCell(R_START, new ColCell<T>(colNum, value));
				return;
			}
			
			ColCell<T> r = R_START;
			while( r.next != R_END ) {
				if(colNum > r.next.colNum)
					r = r.next;
				else
					break;
			}
			
			insertAfterColCell(r, new ColCell<T>(colNum, value));
		}
		
		private void insertAfterColCell(ColCell<T> ref, ColCell<T> newCell) {
			newCell.next = ref.next;
			ref.next = newCell;
			size++;
		}
		
		private void printCols() {
			ColCell<T> c = R_START.next;
			
			for(int i = 1; i <= MAX_NUMBER && c != R_END; i++) {
				if(i == c.colNum) {
					System.out.printf("%2d ", c.value);
					c = c.next;
				} else {
					System.out.printf("%2d ", DEFAULT_VALUE);
				}
			}
			System.out.print("\n");
		}
		
	}
	
	private static class ColCell<T> {
		public final int colNum;
		private ColCell<T> next;
		public final T value;
		
		public ColCell(final int colNum, T value) {
			this.colNum = colNum;
			this.value = value;
		}
	}
	
	private static boolean checkRowCol(int num, int max) {
		if(num <= max)
			return true;
		
		return false;
	}
	
}
