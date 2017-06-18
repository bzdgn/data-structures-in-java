package ds_999_misc;

/*
 * Every integer is either a prime or a unique product of prime
 */
public class CheckAnagram {

	public static void main(String[] args) {
		String word1 = "kawabunga";
		String word2 = "bungawaka";
		
		System.out.printf("\"%s\" and \"%s\" are %sanagrams\n", word1, word2, isItAnagram(word1, word2) == true ? "" : "not ");
	}
	
	private static boolean isItAnagram(String word1, String word2) {
		if(word1 == null || word2 == null) {
			return false;
		}
		
		return isItAnagram(word1.toCharArray(), word2.toCharArray());
	}
	
	private static boolean isItAnagram(char[] word1, char[] word2) {
		if(word1.length != word2.length) {
			return false;
		}
		
		if(word1.length == 0) {
			return false;
		}
		
		long product1 = 1;
		long product2 = 1;
		
		boolean isTwoWordsSame = true;
		
		for(int i = 0; i < word1.length; i++) {
			product1 *= getLetterPrime(word1[i]);
			product2 *= getLetterPrime(word2[i]);
			
			if(isTwoWordsSame == true) {
				if(word1[i] != word2[i]) {
					isTwoWordsSame = false;
				}
			}
		}
		
		if(isTwoWordsSame) {
			return false;
		}
		
		if(product1 == product2) {
			return true;
		}
		
		return false;
	}
	
	private static int getLetterPrime(char letter) {
		if (letter >= 'A' && letter <= 'Z') {
			letter += (int)('a' - 'A');
		}
		
		return letterMapping[( (int)letter - 'a' )];
	}
	
	private static int[] letterMapping = {
			2 ,
			3 ,
			5 ,
			7 ,
			11,
			13,
			17,
			19,
			21,
			23,
			29,
			31,
			37,
			41,
			43,
			47,
			53,
			59,
			61,
			67,
			71,
			73,
			79,
			83,
			89,
			91
	};

}
