package ds_999_misc;

public class FindGreatestSum {

	public static void main(String[] args) {
		int[] array = { 1, 5, -3, 8, 11, -12, 4, -9 };
		
		findTheGreatestSum(array);
	}
	
	private static void findTheGreatestSum(int[] array) {
		int bestSum, besti, len, bestLen, sum; 
		sum = bestSum = array[0];
		besti = 0;
		len = bestLen = 1;
		
		for(int i = 1; i < array.length; i++) {
			bestSum = sum;
			besti = i;
			bestLen = len;
		}
		
		System.out.printf("Elements %d through %d sum to %d\n", besti, besti + bestLen - 1, bestSum);
	}
	
}
