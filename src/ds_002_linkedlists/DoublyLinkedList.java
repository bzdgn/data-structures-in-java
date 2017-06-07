package ds_002_linkedlists;

public class DoublyLinkedList {
	
	private DCell SENTINEL_BEGIN;
	private DCell SENTINEL_END;
	private int size;
	
	public DoublyLinkedList() {
		SENTINEL_BEGIN = new DCell();
		SENTINEL_END = new DCell();
		
		SENTINEL_BEGIN.next = SENTINEL_END;
		SENTINEL_END.prev = SENTINEL_BEGIN;
	}
	
	public DCell find(int value) {
		DCell before = SENTINEL_BEGIN;
		
		while(before.next.value != value && before.next != SENTINEL_END) {
			before = before.next;
		}
		
		if(before.next.value == value) {
			return before.next;
		}
		
		return null;
	}
	
	public void addFront(int value) {
		addAfter(SENTINEL_BEGIN, value);
	}
	
	public void addBottom(int value) {
		addBefore(SENTINEL_END, value);
	}
	
	public void addAfter(int ref, int value) {
		DCell newCell = new DCell(value);
		
		DCell refCell = this.find(ref);
		if(refCell != null) {
			refCell.addAfter(newCell);
			size++;
		}
	}
	
	public void addAfter(DCell refCell, int value) {
		DCell newCell = new DCell(value);
		
		if(refCell != null) {
			refCell.addAfter(newCell);
			size++;
		}
	}
	
	public void addBefore(DCell refCell, int value) {
		DCell newCell = new DCell(value);
		
		if(refCell != null) {
			refCell.addBefore(newCell);
			size++;
		}
	}
	
	public void remove(int value) {
		DCell r = this.find(value);
		
		if(r != null) {
			r.remove();
			size--;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void printList() {
		System.out.print("List: ");
		
		if(this.isEmpty()) {
			System.out.print("EMPTY");
		}
		
		for(DCell current = SENTINEL_BEGIN.next; current != SENTINEL_END; current = current.next) {
			System.out.printf("%2d ", current.value);
		}
		System.out.printf("\n");
	}
	
}
