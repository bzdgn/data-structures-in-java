package ds_007_hashtables;

public class BasicHashTable {
	
	private static final int DEFAULT_CAPACITY = 10;
	private Integer[] data;
	private int capacity;
	private int size;
	
	public BasicHashTable() {
		this(DEFAULT_CAPACITY);
	}
	
	public BasicHashTable(int capacity) {
		this.capacity = capacity;
		init();
	}
	
	private void init() {
		data = new Integer[capacity];
		size = 0;
	}
	
	public boolean put(int element) {
		if(data[hashFunction(element)] != null) {
			System.out.printf("\t\tError: [%d] which mapped to [%d] is already occupied!\n", element, hashFunction(element));
			return false;
		}
		
		data[hashFunction(element)] = new Integer(element);
		size++;
		
		return true;
	}
	
	public Integer get(int element) {
		return data[hashFunction(element)];
	}
	
	public Integer remove(int element) {
		Integer removed = data[hashFunction(element)];
		
		if(removed != null) {
			data[hashFunction(element)] = null;
			size--;
		}
		
		return removed;
	}
	
	private int hashFunction(int element) {
		int hashValue = element%capacity;
		
		return hashValue;
	}
	
	// trival
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void print() {
		System.out.print("Hash Table: ");
		if(isEmpty()) {
			System.out.print("Empty");
		} else {
			for(int i = 0; i < capacity; i++) {
				if(data[i] != null) {
					System.out.printf("%2d ", data[i]);
				}
			}
		}
		System.out.print("\n");
	}
	
	public void printVerbose() {
		System.out.print("Hash Table: ");
		if(isEmpty()) {
			System.out.print("Empty");
		} else {
			for(int i = 0; i < capacity; i++) {
				if(data[i] != null) {
					System.out.printf("%2d ", data[i]);
				} else {
					System.out.print(" -  ");
				}
			}
		}
		System.out.print("\n");
	}
	
}
