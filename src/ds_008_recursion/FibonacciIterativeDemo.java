package ds_008_recursion;

public class FibonacciIterativeDemo {

	/*
	 * Stack Overflow
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.printf("Fibonacci[%4d] = %4d\n", i, fibonacci(i));
		}
		
		System.out.printf("Fib(43) = %d\n", fibonacci(43));	// F(43): 701408733
		System.out.printf("Fib(80) = %d\n", fibonacci(80));	// F(80): 37889062373143906
	}
	
	/*
	 * O(N)
	 */
	private static long fibonacci(int N) {
		if(N < 2) {
			return 1;
		}
		
		long sum = 0;
		long prev1 = 1;
		long prev2 = 1;
		
		for(long i = 2; i <= N; i++) {
			sum = (prev1 + prev2);
			prev2 = prev1;
			prev1 = sum;
			
		}
		
		return sum;
	}
	
}
