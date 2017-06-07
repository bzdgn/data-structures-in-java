package ds_005_sorting;

public class SQueue<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public SQueue() {
		head = tail = null;
		size = 0;
	}
	
	public void enqueue(T value) {
		Node<T> newNode = new Node(value);
		
		if(size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			
			tail = tail.next;
		}
		
		size++;
	}
	
	public T dequeue() {
		if(size == 0) {
			return null;
		}
		
		T value = head.value;
		
		head = head.next;
		
		size--;
		
		return value;
	}
	
	// trivial methods
	public boolean isEmpty() {
		return 0 == size ? true : false;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		System.out.print("Queue: ");
		
		for(Node<T> temp = head; temp != null; temp = temp.next) {
			System.out.printf("%s ", temp);
		}
	}
	
	
	private static class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("%s", value);
		}
	}
	
}
