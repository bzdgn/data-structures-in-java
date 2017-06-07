package ds_002_linkedlists;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println("Is Empty: " + list.isEmpty());
		System.out.println("Size : " + list.size());
		System.out.println("Index of 5: " + list.find(5));
		System.out.println("Index of 7: " + list.find(7));
		
		// Insert At End
		list.insertAtEnd(8);
		list.printList2();
		
		// Insert At Top		
		list.insertAtTop(7);
		list.insertAtTop(5);
		list.insertAtTop(3);		
		list.printList2();
		
		// Insert At Middle
		list.insertAtIndex(2, 6);
		list.printList2();
		
		// Insert At End
		list.insertAtEnd(9);
		list.printList2();
		
		// Remove From Beginning
		list.removeFromBeginning();
		list.printList2();
		
		// Remove From End
		list.removeFromEnd();
		list.printList2();
		
		// Remove From Middle
		list.removeFromMiddle(6);
		list.printList2();
		
		
		System.out.println("Is Empty: " + list.isEmpty());
		System.out.println("Size : " + list.size());
		System.out.println("Index of 5: " + list.find(5));
		System.out.println("Index of 7: " + list.find(7));
	}

}
