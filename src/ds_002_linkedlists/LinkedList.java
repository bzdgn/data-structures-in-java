package ds_002_linkedlists;

public class LinkedList {
	
	private Cell top;
	private int size;
	
	public LinkedList() {
		size = 0;
	}
	
	public void insertAtTop(int value) {
		Cell c = new Cell();
		c.value = value;
		c.next = top;
		
		top = c;
		
		size++;
	}
	
	public void insertAtIndex(int index, int value) {
		if(index > this.size()) {
			System.out.println("Out of list bounds!");
			return;
		}
		
		if(index == 0) {
			insertAtTop(value);
			return;
		}
		
		Cell c = top;
		for(int i = 0; c != null && (i+1)!=index; c = c.next, i++) {
			;
		}
		
		Cell newCell = new Cell();
		newCell.value = value;
		
		newCell.next = c.next;
		c.next = newCell;
		
		size++;
	}
	
	public void insertAtEnd(int value) {
		Cell newCell = new Cell();
		newCell.value = value;
		
		if(size == 0) {
			top = newCell;
			return;
		}
		
		Cell c = top;
		while(c.next != null) {
			c = c.next;
		}

		c.next = newCell;
		
		size++;
	}
	
	public int find(int value) {
		int index = 0;
		for(Cell c = top; c != null; c = c.next, index++) {
			if(c.value == value) {
				return index;
			}
		}
		
		return -1;
	}
	
	public void removeFromBeginning() {
		if(this.isEmpty())
			return;
		
		top = top.next;
		size--;
	}
	
	public void removeFromEnd() {
		if(this.isEmpty()) {
			return;
		}
		
		if(this.size == 1) {
			removeFromBeginning();
		}
		
		Cell temp = top;
		Cell prev = null;
		
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		
		prev.next = null;
		size--;
	}
	
	public void removeFromMiddle(int value) {
		Cell temp = top;
		Cell prev = null;
		
		while(temp.value != value) {
			prev = temp;
			temp = temp.next;
		}
		
		if(prev == null) {
			this.removeFromBeginning();
		} else {
			prev.next = temp.next;
		}
		
		size--;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void printList() {
		Cell current = top;
		
		System.out.print("List: ");
		while(current != null) {
			System.out.printf("%2d ", current.value);
			current = current.next;
		}
		System.out.printf("\n");
	}
	
	public void printList2() {
		System.out.print("List: ");
		for(Cell current = top; current != null; current = current.next) {
			System.out.printf("%2d ", current.value);
		}
		System.out.printf("\n");
	}
	
	
}
