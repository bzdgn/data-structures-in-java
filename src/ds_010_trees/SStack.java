package ds_010_trees;

public class SStack<T> {
	
	private final Node<T> TOP;
	private int size;
	
	public SStack(){
		TOP = new Node<>(null, null); 
		size = 0;
	}
	
	public void push(T value) {
		Node<T> newNode = new Node<>(value, TOP.next);
		
		TOP.next = newNode;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		
		T val = TOP.next.value;
		
		TOP.next = TOP.next.next;
		size--;
		
		return val;
	}
	
	// trivial methods
	public void print() {
		System.out.print("STACK: ");
		if(size == 0) {
			System.out.print("EMPTY\n");
			
			return;
		}
		
		for(Node<T> node = TOP.next; node != null; node = node.next) {
			System.out.printf("%s ", node.value);
		}
		
		System.out.print("\n");
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	// inner class
	private static class Node<T> {
		
		public final T value;
		public Node<T> next;
		
		public Node(final T value) {
			this.value = value;
		}
		
		public Node(final T value, final Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
	}

}
