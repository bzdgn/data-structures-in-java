package ds_001_intro;

/*
 * GCD is cutting half on each step
 * Then Euclid's GCD is O(Log N)
 */    
public class GCD {

	public static void main(String[] args) {
//		int a = 66;
//		int b = 78;
		int a = 6623424;
		int b = 78343443;
		
		int gcd = getGCD(a, b);
		System.out.printf("GCD(%d, %d) = %d\n", a, b, gcd);
	}

	private static int getGCD(int a, int b) {
		while(b != 0) {
			int remainder = a%b;
			System.out.printf("\t a = %d, b = %d\n", a, b);
			System.out.printf("\t%d %% %d = %d\n\n", a, b, remainder);
			a = b;
			b = remainder;
		}
		
		return a;
	}

}
