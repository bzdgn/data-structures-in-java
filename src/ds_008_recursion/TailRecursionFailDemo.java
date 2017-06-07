package ds_008_recursion;

public class TailRecursionFailDemo {
	
	/*
	 * StackOverflow @20000 on my machine
	 */
	public static void main(String[] args) {
		int N = 20_000;
		int result = addSmaller(N);
		System.out.printf("Result for [%d] = [%d]\n", N, result);
	}
	
	/*
	 * Recursive version
	 */
	private static int addSmaller(int N) {
		if(N == 0) {
			return 0;
		}
		
		return N + addSmaller(N-1);
	}

}
