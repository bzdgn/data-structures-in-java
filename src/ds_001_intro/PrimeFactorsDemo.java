package ds_001_intro;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactorsDemo {

	public static void main(String[] args) {
//		int number = 204;
		long number = 123456789012345678L;
		
		List<Long> primeFactors = getPrimeFactors(number);
		
		System.out.println("Prime Factors of " + number);
		printLongArray(primeFactors);
	}

	private static List<Long> getPrimeFactors(long number) {
		List<Long> factors = new LinkedList<>();
		long factor = 2;
		
		while(number % factor == 0) {
			factors.add(factor);
			number /= factor;
		}
		
		factor = 3;
		int stopAt = (int) Math.sqrt(number);
		while(factor <= stopAt) {
			
			while(number % factor == 0) {
				factors.add(factor);
				number /= factor;
				stopAt = (int)Math.sqrt(number);
			}
			
			factor += 2;
		}
		
		if(number > 1) {
			factors.add(number);
		}
		
		return factors;
	}
	
	private static void printLongArray(List<Long> primeFactors) {
		for(int i = 0; i < primeFactors.size(); i++) {
			System.out.printf("%3d ", primeFactors.get(i));
		}
		System.out.printf("\n");
	}

}
