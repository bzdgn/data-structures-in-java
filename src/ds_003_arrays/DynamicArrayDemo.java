package ds_003_arrays;

public class DynamicArrayDemo {

	public static void main(String[] args) {
		DynamicArray<Integer> array = new DynamicArray<>();
		
		array.printArray();
		
		array.add(10);
		array.add(new Integer[] {20, 30, 40});
		array.printArray();
		array.printState();
		
		array.add(50);
		array.printArray();
		array.printState();
		
		Integer removed = array.removeTail();
		System.out.println("\t\tRemoved: " + removed);
		array.printArray();
		array.printState();
		
		removed = array.removeTail();
		System.out.println("\t\tRemoved: " + removed);
		array.printArray();
		array.printState();
		
		removed = array.removeTail();
		System.out.println("\t\tRemoved: " + removed);
		array.printArray();
		array.printState();
		
		removed = array.removeTail();
		System.out.println("\t\tRemoved: " + removed);
		array.printArray();
		array.printState();
		
		removed = array.removeTail();
		System.out.println("\t\tRemoved: " + removed);
		array.printArray();
		array.printState();
		
		array.add(1);
		array.printArray();
		array.printState();
	}

}
