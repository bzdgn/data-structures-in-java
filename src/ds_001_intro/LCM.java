package ds_001_intro;

public class LCM {

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		
		System.out.printf("LCM(%d, %d) = %d\n", a, b, getLCM(a,b));
	}
	
	private static int getLCM(int a, int b) {
		return (a/getGCD(a,b)) * b;	// Division must be applied first, then multiplication to fit in 32 bit integer
									// for large numbers
	}
	
	private static int getGCD(int a, int b) {
		while(b != 0) {
			int remainder = a%b;
			a = b;
			b = remainder;
		}
		
		return a;
	}

}
