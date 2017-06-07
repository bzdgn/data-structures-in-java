package ds_004_stacks_and_queues;

public class QueueArray<T> {
	
	private final static int DEFAULT_CAPACITY = 8;
	private int capacity;
	private T[] collection;
	private int front;
	private int back;
	private int size;
	
	public QueueArray(int capacity) {
		this.capacity = capacity;
		front = back = -1;
		collection = (T[])new Object[this.capacity];
	}
	
	public QueueArray() {
		this(DEFAULT_CAPACITY);
		this.capacity = DEFAULT_CAPACITY;
	}
	
	public void enqueue(T value){
		if(isEmpty()) {
			front = 0;
			back = -1;
		}
		collection[++back] = value;
		
		size++;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		
		T value = collection[front];
		
		collection[front] = null;
		front++;
		size--;
		
		return value;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		
		return collection[front];
	}
	
	// trivial methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	public void print() {
		System.out.print("Queue: ");
		if(isEmpty()) {
			System.out.print("EMPTY");
		} else {
			for(int i = front; i <= back; i++) {
				System.out.printf("%s ", collection[i]);
			}
		}
		System.out.print("\n");
	}
	
	public int capacity() {
		return capacity;
	}
	
	public void state() {
		System.out.println("State;");
		System.out.println("\tIsEmpty: " + isEmpty());
		System.out.println("\tSize   : " + size);
	}
	
}
