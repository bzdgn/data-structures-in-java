package ds_008_recursion;

public class FactorialDemo {

	public static void main(String[] args) {
		long N = 20;
		System.out.printf("Factorian %d = %d\n", N, factorial(N));
	}
	
	/*
	 * O(N)
	 */
	private static long factorial(long N) {
		if(N == 0) {
			return 1;
		} else {
			return N*factorial(N-1);
		}
	}
	
}
