package ds_004_stacks_and_queues;

public class Queue<T> {
	
	private final Node<T> head;
	private final Node<T> tail;
	private int size;
	
	public Queue() {
		head = new Node<T>(null);
		tail = new Node<T>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void enqueue(T value) {
		Node<T> newNode = new Node<>(value);
		
		newNode.next = head.next;
		newNode.prev = head;
		
		head.next.prev = newNode;
		head.next = newNode;
		
		size++;
	}
	
	/*
	 * ...... -> prev -> last -> tail
	 */
	public T dequeue() {
		if(tail.prev == null) {
			return null;
		}
		
		Node<T> last = tail.prev;
		
		last.prev.next = tail;
		tail.prev = last.prev;
		
		T value = last.value;
		last = null;
		
		size--;
		
		return value;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		
		return head.next.value;
	}
	
	// trivial methods
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		System.out.print("Stack: ");
		
		if(size == 0) {
			System.out.print("EMPTY");
		} else {
			for(Node<T> curr = head.next; curr != tail; curr = curr.next) {
				System.out.printf("%s " , curr.value);
			}
		}
		System.out.print("\n");
	}
	
	public void state() {
		System.out.println("State;");
		System.out.println("\tIsEmpty: " + isEmpty());
		System.out.println("\tSize   : " + size);
	}
	
	/*
	 * static nested class
	 * we don't need any reference to parent class
	 */
	private static class Node<T> {
		
		public final T value;
		public Node<T> prev;
		public Node<T> next;
		
		public Node(final T value) {
			this.value = value;
			this.prev = this.next = null;
		}
		
	}

}
