package ds_001_intro;

public class TestingPrimes {

	private final static int N = 2;	// N is greater or equal to 1, 1 <= N
	
	public static void main(String[] args) {
		for(int i = 1; i < 30; i++) {
			if(testPrime(i))
				System.out.printf("%2d is prime\n", i);
		}
	}
	
	/*
	 * Fermat's Little Theorem
	 * 
	 * Let p to be a prime number;
	 * 1 <= n < p then n^(p-1) == 1      mod p
	 * 
	 */
	private static boolean testPrime(int p) {
		if(p < 2) {
			return false;	// If NOT n < p
		} else if (p == 2) {
			return true;
		}
		
		int a = (int)Math.pow(N, (p-1));
		
		if (a%p == 1)
			return true;
		
		return false;
	}

}
