package ds_007_hashtables;

import java.util.LinkedList;
import java.util.List;

public class ChainingHashTableGeneric<T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private List<T>[] data;
	private int capacity;
	private int size;
	
	public ChainingHashTableGeneric() {
		this(DEFAULT_CAPACITY);
	}
	
	public ChainingHashTableGeneric(int capacity) {
		this.capacity = capacity;
		init();
	}
	
	private void init() {
		data = new LinkedList[capacity];
		size = 0;
	}
	
	public boolean put(T element) {
		if(data[hashFunction(element)] == null) {
			data[hashFunction(element)] = new LinkedList<>();
		}
		
		data[hashFunction(element)].add(element);
		size++;
		
		return true;
	}
	
	public T get(T element) {
		return find(element);
	}
	
	private T find(T element) {
		List<T> list = data[hashFunction(element)];
		if(list != null) {
			for(T temp : list) {
				if(temp.equals(element)) {
					return temp;
				}
			}
		}
		
		return null;
	}
	
	public T remove(T element) {
		T removed = find(element);
		
		if(removed != null) {
			data[hashFunction(element)].remove(removed);
			size--;
			
			if( data[hashFunction(element)].isEmpty() ) {
				data[hashFunction(element)] = null;
			}
		}
		
		return removed;
	}

	private int hashFunction(T element) {
		if(element instanceof Integer) {
			return hashFunction((Integer)element);
		} else if(element instanceof String) {
			return hashFunction((String)element);
		}
		
		return -1;
	}
	
	// HashFunc for Integer
	private int hashFunction(String element) {
		int elementValue = element.toCharArray()[element.length()-1]-'0';
		
		return hashFunction(elementValue);
	}
	
	// HashFunc for Integer
	private int hashFunction(Integer element) {
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
					for(T temp: data[i]) {
						System.out.printf("%s ", temp);
					}
				}
			}
		}
		System.out.print("\n");
	}
	
//	public void printVerbose() {
//		System.out.print("Hash Table: ");
//		if(isEmpty()) {
//			System.out.print("Empty");
//		} else {
//			for(int i = 0; i < capacity; i++) {
//				if(data[i] != null) {
//					for(T temp : data[i]) {
//						System.out.printf("%s ", temp);
//					}
//				} else {
//					System.out.print(" -  ");
//				}
//			}
//		}
//		System.out.print("\n");
//	}
	
	public void printVerbose() {
		System.out.println("Hash Table;");
		System.out.println("***********");
		if(isEmpty()) {
			System.out.println("Empty");
		} else {
			for(int i = 0; i < capacity; i++) {
				if(data[i] != null) {
					for(T temp : data[i]) {
						System.out.printf("%s ", temp);
					}
					System.out.print("\n");
				} else {
					System.out.println(" - ");
				}
			}
		}
		System.out.println("***********");
	}
	
}
