package ds_003_arrays;

public class TriangularArrayDemo {
	
	private final static int NUMROWS = 4;
	
	public static void main(String[] args) {
		TriangularArray<String> array = new TriangularArray<>(NUMROWS);
		
		System.out.println("Size: " + array.size());
		
		array.set("A", 0, 1);
		array.set("B", 0, 2);
		array.set("C", 0, 3);
		array.set("D", 1, 2);
		array.set("E", 1, 3);
		array.set("F", 2, 3);
		
		System.out.println();
		
		array.printArray();
	}

}
