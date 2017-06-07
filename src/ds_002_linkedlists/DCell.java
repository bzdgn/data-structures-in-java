package ds_002_linkedlists;

public class DCell {
	
	public int value;
	public DCell prev;
	public DCell next;
	
	public DCell(){
		value = Integer.MIN_VALUE;
		prev = null;
		next = null;
	}
	
	public DCell(int value) {
		this.value = value;
	}
	
	public void addAfter(DCell newCell) {
		newCell.next = this.next;
		newCell.prev = this;
		
		this.next = newCell;
		newCell.next.prev = newCell;
	}

	public void addBefore(DCell newCell) {
		// a --- b
		// a --- nC --- b
		newCell.next = this;
		newCell.prev = this.prev;
		
		this.prev.next = newCell;
		this.prev = newCell;
	}
	
	public void remove() {
		this.prev.next = this.next;
		this.next.prev = this.prev;
	}
	
}
