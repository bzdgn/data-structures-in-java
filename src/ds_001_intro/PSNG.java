package ds_001_intro;

public class PSNG {
	
	private static final int CONSTANT_A = 5;
	private static final int CONSTANT_B = 3;
	private static final int MODULO = 7;
	
	public static void main(String[] args) {
		printPseudoRandomNumber(6);
	}
	
	private static int generatePseudoRandomNumber(int prevNum, int constNumA, int constNumB, int modulo) {
		if(prevNum == Integer.MIN_VALUE) {
			return 0;
		}
		
		return (prevNum*constNumA + constNumB)%modulo;
	}
	
	private static void printPseudoRandomNumber(int n) {
		int prev = Integer.MIN_VALUE;
		int next;
		
		for(int i = 0; i <= n; i++) {
			next = generatePseudoRandomNumber(prev, CONSTANT_A, CONSTANT_B, MODULO);
			prev = next;
			
			System.out.printf("[%2d]: %d\n", i, next);
		}
	}

}
