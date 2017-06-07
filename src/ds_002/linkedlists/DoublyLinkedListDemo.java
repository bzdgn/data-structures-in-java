package ds_002.linkedlists;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.printList();
		
		list.addBottom(99);
		
		list.addFront(5);
		list.addFront(10);
		list.addFront(15);
		
		list.addBottom(100);
		
		list.remove(10);
		
		list.printList();
	}

}
