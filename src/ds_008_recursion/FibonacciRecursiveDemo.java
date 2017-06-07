package ds_008_recursion;

public class FibonacciRecursiveDemo {

	/*
	 * Stack Overflow
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.printf("Fibonacci[%4d] = %4d\n", i, fibonacci(i));
		}
		
		System.out.printf("Fib(43) = %d\n", fibonacci(43));	// F(43): 701408733
	}
	
	/*
	 * O(Fibonacci(N))
	 */
	private static long fibonacci(long N) {
		if(N == 0 || N == 1) {
			return 1;
		}
		
		return fibonacci(N-1) + fibonacci(N-2);
	}
	
}
