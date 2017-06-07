package ds_005_sorting;

public class HeapArray {
	
	private final int HEAP_SIZE;
	private int size;
	private Integer[] heap;
	
	public HeapArray(int heapSize) {
		HEAP_SIZE = heapSize;
		size = 0;
		heap = new Integer[HEAP_SIZE];
	}
	
	public HeapArray(int[] array) {
		HEAP_SIZE = array.length;
		size = 0;
		heap = new Integer[HEAP_SIZE];
		add(array);
	}
	
	public void add(int[] values) {
		for(int i = 0; i < values.length; i++) {
			add(values[i]);
		}
	}
	
	public Integer[] heapSort() {
		Integer[] sorted = new Integer[heap.length];
		
		int last = heap.length-1;
		int index = 0;
		
		while(heap[0] != null) {
			sorted[index++] = heap[0];
			heap[0] = heap[last];
			heap[last--] = null;
			handleDown(0);
		}
		
		return sorted;
	}
	
	private void handleDown(int index) {
		if(heap[index] == null) {
			return;
		}
		
		// get max child index
		Integer maxChildIndex = getMaxChildIndex(index);
		
		if(maxChildIndex != null) {
			if(heap[index] < heap[maxChildIndex]) {
				swap(index, maxChildIndex);
				handleDown(maxChildIndex);
			}
		}
	}
	
	private Integer getMaxChildIndex(int index) {
		int child1 = 2*index + 1;
		int child2 = 2*index + 2;
		
		// both in the heap size
		if(child1 < HEAP_SIZE && child2 < HEAP_SIZE) {			
			// each one is valid
			if(heap[child1] != null && heap[child2] != null) {
				if(heap[child1] > heap[child2]) {
					return child1;
				} else {
					return child2;
				}
			}
			
			// one of them is not null
			if(heap[child1] != null) {
				return child1;
			}
			
			if(heap[child2] != null) {
				return child2;
			}
		}
		
		if(child1 < HEAP_SIZE && heap[child1] != null) {
			return child1;
		}
		
		if(child2 < HEAP_SIZE && heap[child2] != null) {
			return child2;
		}
		
		return null;
		
	}
	
	private void swap(int a, int b) {
		Integer temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	private void add(int value) {
		heap[size] = value;	// add to last
		
		handleParent(size);		// handle up
		size++;
	}
	
	private void handleParent(int index) {
		if(index == 0)
			return;
		
		int parent = (index - 1)/2;
		if(parent >= 0) {
			if(heap[parent] < heap[index]) {
				swap(parent, index);
				handleParent(parent);
			}
		}
	}
	
	/*
	 * child #1: 2*index + 1
	 * child #2: 2*index + 2
	 * parent  : (index - 1)/2
	 */
	private int getParent(int index) {
		return (index-1)/2;
	}
	
	// trivial methods
	public void print() {
		System.out.print("Heap: ");
		if(size == 0) {
			System.out.print("EMPTY\n");
		} else {
			for(int i = 0; i < size; i++) {
				System.out.printf("%d ", heap[i]);
			}
		}

		System.out.print("\n");
	}
	
	public void printPretty() {
		System.out.println("Heap;");
		System.out.println("*****");
		
		if(size == 0) {
			System.out.print("EMPTY\n");
		} else {
			int counter = 0;
			int nextDiff = 2;
			for(int i = 0; i < size; i++) {
				System.out.printf("\t%s ", heap[i]);
				if(i == counter) {
					System.out.print("\n");
					counter += nextDiff;
					nextDiff *= 2;
				}
			}
		}
	}
	
}
