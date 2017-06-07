package ds_007_hashtables;

import java.util.LinkedList;
import java.util.List;

public class ChainingHashTable {
	
	private static final int DEFAULT_CAPACITY = 10;
	private List<Integer>[] data;
	private int capacity;
	private int size;
	
	public ChainingHashTable() {
		this(DEFAULT_CAPACITY);
	}
	
	public ChainingHashTable(int capacity) {
		this.capacity = capacity;
		init();
	}
	
	private void init() {
		data = new LinkedList[capacity];
		size = 0;
	}
	
	public boolean put(int element) {
		if(data[hashFunction(element)] == null) {
			data[hashFunction(element)] = new LinkedList<>();
		}
		
		data[hashFunction(element)].add(element);
		size++;
		
		return true;
	}
	
	public Integer get(int element) {
		return find(element);
	}
	
	private Integer find(int element) {
		List<Integer> list = data[hashFunction(element)];
		if(list != null) {
			for(Integer temp : list) {
				if(temp.equals(element)) {
					return temp;
				}
			}
		}
		
		return null;
	}
	
	public Integer remove(int element) {
		Integer removed = find(element);
		
		if(removed != null) {
			data[hashFunction(element)].remove(removed);
			size--;
			
			if( data[hashFunction(element)].isEmpty() ) {
				data[hashFunction(element)] = null;
			}
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
					for(Integer temp: data[i]) {
						System.out.printf("%2d ", temp);
					}
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
					for(Integer temp : data[i]) {
						System.out.printf("%2d ", temp);
					}
				} else {
					System.out.print(" -  ");
				}
			}
		}
		System.out.print("\n");
	}
	
}
