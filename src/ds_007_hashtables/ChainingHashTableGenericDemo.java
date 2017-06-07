package ds_007_hashtables;

public class ChainingHashTableGenericDemo {

	public static void main(String[] args) {
//		ChainingHashTableGeneric<String> hashTable = new ChainingHashTableGeneric<>();
		
//		hashTable.put("2321-15");
//		hashTable.put("1235-32");
//		hashTable.put("3231-48");
//		hashTable.put("2321-65");
//		
//		hashTable.printVerbose();
		
		ChainingHashTableGeneric<Integer> hashTable = new ChainingHashTableGeneric<>();
		
		hashTable.put(12);
		hashTable.put(26);
		hashTable.put(57);
		hashTable.put(96);
		
		hashTable.printVerbose();
	}

}
