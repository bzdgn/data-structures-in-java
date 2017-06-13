package ds_013_network_algorithms;

public class SQueue<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	public SQueue() {}
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		
		if(isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			
			tail = newNode;
		}
		
		size++;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		
		Node<T> removed = head;
		
		head = head.next;
		
		if(head != null) {
			head.prev = null;
		}
		
		removed.next = removed.prev = null;
		size--;
		
		return removed.data;
	}
	
	// trivial
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		System.out.print("Queue: ");
		if(isEmpty()) {
			System.out.print("Empty");
		} else {
			for(Node<T> curr = head; curr!=null; curr = curr.next) {
				System.out.printf("%4s ", curr.data);
			}
		}
		System.out.print("\n");
	}
	
	private class Node<G> {
		private T data;
		private Node<G> prev;
		private Node<G> next;
		
		public Node(T data) {
			this.data = data;
		}
	}

}
