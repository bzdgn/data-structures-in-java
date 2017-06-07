package ds_002_linkedlists;

public class SortedLinkedList {
	
	private Cell SENTINEL_BEGIN;
	private Cell SENTINEL_END;
	private int size;
	
	public SortedLinkedList() {
		SENTINEL_BEGIN = new Cell();
		SENTINEL_END = new Cell();
		
		SENTINEL_BEGIN.next = SENTINEL_END;
	}
	
	public void add(int value) {
		Cell before = SENTINEL_BEGIN;
		Cell newCell = new Cell(value);
		
		while(before.next != SENTINEL_END && before.next.value < newCell.value) {
			before = before.next;
		}
		
		if(before.next == SENTINEL_END) {
			newCell.next = SENTINEL_END;
			before.next = newCell;
		} else {
			newCell.next = before.next;
			before.next = newCell;
		}
		
		size++;
	}
	
	public void remove(int value) {
		Cell before = SENTINEL_BEGIN;
		
		while(before.next.value < value && before.next != SENTINEL_END) {
			before = before.next;
		}
		
		if(before.next.value == value) {
			before.next = before.next.next;
			
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
		
		for(Cell current = SENTINEL_BEGIN.next; current != SENTINEL_END; current = current.next) {
			System.out.printf("%2d ", current.value);
		}
		System.out.printf("\n");
	}
	
}
