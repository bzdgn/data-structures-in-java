package ds_003_arrays;

public class WordPatternWith2DArrayDemo {

	public static void main(String[] args) {
//		checkWords("levo", "olev");
		
		checkWords("llvo", "olev");
		checkWords("olev", "llvo");
		checkWords("levo", "evol");
		checkWords("levo", "levol");
		
	}
	
	private static void checkWords(String word1, String word2) {
		boolean result = isSameCharactersUsed(word1, word2);
		
		if(result) {
			System.out.printf("\"%s\" and \"%s\" has same characters\n", word1, word2);
		} else {
			System.out.printf("\"%s\" and \"%s\" don't use same characters\n", word1, word2);
		}
	}
	
	private static boolean isSameCharactersUsed(String word1, String word2) {
		if(word1.length() != word2.length()) {
			return false;
		}
		
		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();
		
		int[][] patternArray = new int[array1.length][array2.length];
		
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if(array1[i] == array2[j]) {
					patternArray[i][j]++;
				}
			}
		}
		
		// rows
		for(int i = 0; i < patternArray.length; i++) {
			int count = 0;
			for(int j = 0; j < patternArray[i].length; j++) {
				count += patternArray[i][j];
			}
			if(count != 1) {
				return false;
			}
		}
		
		// columns
		for(int i = 0; i < patternArray.length; i++) {
			int count = 0;
			for(int j = 0; j < patternArray[i].length; j++) {
				count += patternArray[j][i];
			}
			if(count != 1) {
				return false;
			}
		}
		
		return true;
	}

	public static void print2DArray(int[][] patternArray) {
		for(int i = 0; i < patternArray.length; i++) {
			for(int j = 0; j < patternArray[i].length; j++) {
				System.out.printf("%d ", patternArray[i][j]);
			}
			System.out.print("\n");
		}
	}

}
