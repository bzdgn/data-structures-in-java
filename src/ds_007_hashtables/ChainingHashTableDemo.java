package ds_007_hashtables;

public class ChainingHashTableDemo {

	public static void main(String[] args) {
		ChainingHashTable hashTable = new ChainingHashTable();
		
		hashTable.print();
		hashTable.put(1);
		hashTable.put(2);
		hashTable.put(3);
		hashTable.put(4);
		hashTable.put(5);
		hashTable.put(6);
		hashTable.put(7);
		hashTable.put(8);
		hashTable.put(9);
		hashTable.put(10);
		hashTable.print();
		hashTable.printVerbose();
		hashTable.put(17);
		hashTable.print();
		
		hashTable.remove(7);
		hashTable.print();
		hashTable.remove(17);
		hashTable.print();
		hashTable.remove(5);
		hashTable.print();
	}

}
