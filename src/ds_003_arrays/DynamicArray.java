package ds_003_arrays;

public class DynamicArray<T> {
	
	private final int DEFAULT_CAPACITY = 4;
	private T[] data;
	private int size;
	private int capacity;
	
	public DynamicArray() {
		this.capacity = DEFAULT_CAPACITY;
		init();
	}
	
	public DynamicArray(final int capacity) {
		this.capacity = capacity;
		init();
	}
	
	private void init() {
		data = (T[])new Object[capacity];
		size = 0;
	}
	
	public void add(T[] elements) {
		for(int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}
	}
	
	public void add(T element) {
		ensureCapacity();
		data[size++] = element;
	}
	
	public T removeTail() {
		T removed = data[--size];
		shrinkCapacity();
		
		return removed;
	}
	
	public T remove(int index) {
		if(index >= size) {
			return null;
		}
		
		T removed = data[size--];
		
		return removed;
	}
	
	// dynamic
	private void ensureCapacity() {
		if(size == 0) {
			capacity = DEFAULT_CAPACITY;
			changeCapacity();
		}
		
		if(size < capacity) {
			return;
		}
		
		this.capacity *= 2;
		changeCapacity();
	}
	
	private void shrinkCapacity() {
		if(size > (capacity/2)) {
			return;
		}
		
		this.capacity /=2;
		changeCapacity();
	}
	
	private void changeCapacity() {
		T[] newData = (T[]) new Object[capacity];
		
		for(int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		
		data = newData;
	}
	
	// trivial
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public void printArray() {
		System.out.print("Array: ");
		if(size == 0) {
			System.out.print("EMPTY");
		} else {
			for(int i = 0; i < size; i++) {
				System.out.printf("%s ", data[i]);
			}
		}
		System.out.print("\n");
	}
	
	public void printState() {
		System.out.printf("\tCapacity: %d\n\tSize: %d\n", capacity, size);
	}
	
}
