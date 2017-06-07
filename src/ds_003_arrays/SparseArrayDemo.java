package ds_003_arrays;

public class SparseArrayDemo {

	public static void main(String[] args) {
		SparseArray<Integer> arr = new SparseArray<>(5, 0);
		
//		arr.printRows();
		
//		arr.insertRow(5);
//		arr.insertRow(4);
//		arr.insertRow(3);
//		arr.insertRow(2);
//		arr.insertRow(1);
		
		arr.insertRow(2);
		
//		arr.printRows();
//		
//		System.out.println("5 : " + arr.findRow(5));
//		
//		arr.deleteRow(5);
//		System.out.println("5 deleted");
//		
//		System.out.println("5 : " + arr.findRow(5));
		
//		arr.printRows();
//		arr.printArray();
		
		arr.insertCol(2, 5, 10);
		arr.insertCol(2, 4, 15);
		arr.insertCol(2, 3, 12);
		arr.insertCol(2, 2, 9);
		
		arr.printArray();
	}

}
