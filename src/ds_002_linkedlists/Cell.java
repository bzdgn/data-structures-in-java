package ds_002_linkedlists;

public class Cell {
	
	public int value;
	public Cell next;
	
	public Cell(){
		value = Integer.MIN_VALUE;
		next = null;
	}
	
	public Cell(int value) {
		this.value = value;
	}
	
}
