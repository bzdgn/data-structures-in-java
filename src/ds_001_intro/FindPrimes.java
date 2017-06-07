package ds_001_intro;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindPrimes {

	public static void main(String[] args) {
//		int number = 13349452;
		int number = 10000;
		
		List<Integer> primes = getPrimesUpToNumber(number);
		
		for(Integer i : primes) {
			System.out.printf("%d\n", i);
		}
		System.out.println("Num of Primes: " + primes.size());
	}

	private static List<Integer> getPrimesUpToNumber(int number) {
		boolean[] isPrime = new boolean[number+1];
		Arrays.fill(isPrime, true); // Default array value is true
		List<Integer> primes = new LinkedList<>();
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		// Handle 2
		for(int i = 4; i < isPrime.length; i+=2)
			isPrime[i] = false;
		
		// Handle 3 to Math.sqrt(n)
		for(int i = 3; i < Math.sqrt(number); i+=2) {
			if(isPrime[i]) {
				for(int j = i*i; j < number; j+= 2*i) {
					isPrime[j] = false;
				}
			}
		}
		
		for(int i = 0; i < isPrime.length; i++)
			if(isPrime[i])
				primes.add(i);
		
		return primes;
	}

}
