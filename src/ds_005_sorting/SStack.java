package ds_005_sorting;

public class SStack<T> {
	
	private Node<T> head;
	private int size;
	
	public SStack() {
		head = null;
	}
	
	public void push(T value) {
		Node<T> newNode = new Node<>(value);
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		
		size++;
	}
	
	public T pop() {
		T value = null;
		
		if(head == null) {
		} else {
			value = head.value;
			
			head = head.next;
		}
		size--;
		
		return value;
	}
	
	// trivia
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		System.out.print("Stack: ");
		
		Node<T> temp = head;
		while(temp != null) {
			System.out.printf("%s ", temp.value);
			temp = temp.next;
		}
		System.out.print("\n");
	}
	
	private static class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
}
