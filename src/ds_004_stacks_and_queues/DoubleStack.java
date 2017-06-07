package ds_004_stacks_and_queues;

public class DoubleStack<T> {
	
	private static final int DEFAULT_CAPACITY = 8;
	private int capacity;
	
	private int leftIndex;
	private int rightIndex;
	private T[] collection;
	
	public DoubleStack(int capacity) {
		this.capacity = capacity;
		collection = (T[]) new Object[capacity];
		leftIndex = 0;
		rightIndex = collection.length-1;
	}
	
	public DoubleStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public void pushLeft(T value) {
		check();
		if(!isAvailable()) {
			System.out.println("ERROR: DoubleStack is FULL!");
			return;
		}
		
		collection[leftIndex++] = value;
	}
	
	public void pushRight(T value) {
		check();
		if(!isAvailable()) {
			System.out.println("ERROR: DoubleStack is FULL!");
			return;
		}
		
		collection[rightIndex--] = value;
	}
	
	public T popLeft() {
		check();
		if(leftIndex == 0) {
			return null;
		}
		
		T value = collection[--leftIndex];
		collection[leftIndex] = null;
		
		return value;
	}
	
	public T popRight() {
		check();
		if(rightIndex == capacity-1) {
			return null;
		}
		
		T value = collection[++rightIndex];
		collection[rightIndex] = null;
		
		return value;
	}
	
	private boolean isAvailable() {
		if(isFull())
			return false;
		
		return true;
	}
	
	private void check() {
		if(isFull()) {
			refresh(capacity*2);
			
			return;
		}
		
		if((rightIndex - leftIndex) > (capacity/2)) {
			refresh(capacity/2);
			
			return;
		}
	}
	
	private void refresh(int newCapacity) {
		capacity = newCapacity;
		T[] newCollection = (T[]) new Object[capacity];
		
		// left
		for(int i = 0; i < leftIndex; i++) {
			newCollection[i] = collection[i];
		}
		
		// right
		int oldCapacity = collection.length;
		int diff = oldCapacity - 1 - rightIndex;
		for(int i = 0; i < diff; i++) {
			newCollection[capacity-1-i] = collection[oldCapacity-1-i];
		}
		
		int newRightIndex = capacity - (oldCapacity - rightIndex);
		rightIndex = newRightIndex;
		
		collection = newCollection;
	}
	
	// trivial methods
	public int capacity() {
		return capacity;
	}
	
	public boolean isFull() {
		return rightIndex == leftIndex ? true: false;
	}
	
	public int leftSize() {
		return leftIndex;
	}
	
	public int rightSize() {
		return rightIndex;
	}
	
	public boolean isLeftEmpty() {
		return leftIndex == 0;
	}
	
	public boolean isRightEmpty() {
		return (collection.length - rightIndex) == 0;
	}
	
	public void printLeft() {
		System.out.print("Left : ");
		for(int i = leftIndex-1; i >= 0; i--) {
			System.out.printf("%s ", collection[i]);
		}
		System.out.print("\n");
	}
	
	public void printRight() {
		System.out.print("Right: ");
		for(int i = rightIndex+1; i < collection.length; i++) {
			System.out.printf("%s ", collection[i]);
		}
		System.out.print("\n");
	}
	
	public void print() {
		printLeft();
		printRight();
	}
	
}
