package ds_008_recursion;

public class TailRecursionFixedDemo {

	/*
	 * No StackOverflow @20000 on my machine
	 */
	public static void main(String[] args) {
		int N = 20_000;
		int result = addSmaller(N);
		System.out.printf("Result for [%d] = [%d]\n", N, result);
	}
	
	/*
	 * Iterative version
	 * Needs no big stack space like recursion
	 */
	private static int addSmaller(int N) {
		int result = 0;
		while(N > 0) {
			result += N--;
		}
		
		return result;
	}

}
