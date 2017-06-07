package ds_008_recursion;

public class FibonacciWithArrayDemo {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.printf("Fib(%2d) = %3d\n", i, fibonacci(i));
		}
		
		System.out.printf("Fib(43) = %d\n", fibonacci(43));	// F(43): 701408733
		System.out.printf("Fib(80) = %d\n", fibonacci(80));	// F(80): 37889062373143906
	}
	
	/*
	 * O(N)
	 */
	private static long fibonacci(int N) {
		if(N == 0 || N == 1) {
			return 1;
		}
		
		// init array
		long[] array = new long[N+1];
		
		array[0] = 1;
		array[1] = 1;
		
		for(int i = 2; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		return array[array.length-1];
	}
	
}
