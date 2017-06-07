package ds_008_recursion;

public class RecursionFailDemo {

	/*
	 * Stack Overflow
	 */
	public static void main(String[] args) {
		int N = 100_000;
		System.out.printf("Sum[%d] = %d\n", N, addRecursive(N));
	}
	
	private static long addRecursive(int N) {
		if(N == 0) {
			return 0;
		} else {
			return N + addRecursive(N-1);
		}
	}

}
