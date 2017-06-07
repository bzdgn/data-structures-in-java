package ds_002_linkedlists;

public class SortedLinkedListDemo {

	public static void main(String[] args) {
		SortedLinkedList list = new SortedLinkedList();
		
		list.add(5);		
		list.remove(5);
		
		list.add(1);
		list.remove(1);
		
		list.add(9);
		list.add(6);
		list.add(3);
		
		list.printList();
	}

}
