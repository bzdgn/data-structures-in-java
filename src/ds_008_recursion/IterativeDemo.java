package ds_008_recursion;

public class IterativeDemo {

	/*
	 * Stack Overflow
	 */
	public static void main(String[] args) {
		int N = 100_000;
		System.out.printf("Sum[%d] = %d\n", N, addRecursive(N));
	}
	
	private static long addRecursive(int N) {
		int sum = 0;
		for(int i = 0; i <= N; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}
