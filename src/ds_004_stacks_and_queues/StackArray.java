package ds_004_stacks_and_queues;

public class StackArray<T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int capacity;
	private T[] collection;
	private int index;
	
	public StackArray(int capacity) {
		this.capacity = capacity;
		collection = (T[])new Object[capacity];
	}
	
	public StackArray() {
		this(DEFAULT_CAPACITY);
	}
	
	public void push(T value) {
		checkArray();
		collection[index++] = value;
	}
	
	public T pop() {
		checkArray();
		return collection[--index];
	}
	
	private void checkArray() {
		try {
			if( index > (capacity/2) ) {
				refresh(capacity*2);
				
				return;
			}
			
			if(index < (capacity/2)) {
				refresh(capacity/2);
				
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void refresh(int newCapacity) throws Exception {
		if(newCapacity < index) {
			throw new Exception("Invalid Collection Capacity");
		}
		
		this.capacity = newCapacity;
		T[] newCollection = (T[])new Object[capacity];
		
		for(int i = 0; i < index; i++) {
			newCollection[i] = collection[i];
		}
		collection = newCollection;
	}
	
	// trivial methods
	public int size() {
		return index;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	public void print() {
		System.out.print("Stack: ");
		
		if(index == 0) {
			System.out.print("EMPTY\n");
			
			return;
		}
		
		for(int i = 0; i < index; i++) {
			System.out.printf("%s ", collection[i]);
		}
		System.out.print("\n");
	}
	
}
