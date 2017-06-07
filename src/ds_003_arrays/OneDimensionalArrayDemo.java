package ds_003_arrays;

public class OneDimensionalArrayDemo {

	public static void main(String[] args) {
		int[] array = { 1, 5, 9, 3, 2, 7, 6, 0 };
		
		int index = findMinimumIndex(array);
		
		printArray(array);
		
		if(index != -1)
			System.out.println("Minimum: " + array[index]);
		else
			System.out.println("Minimum: Array is EMPTY");
		
		index = findMaximumIndex(array);
		
		if(index != -1)
			System.out.println("Maximum: " + array[index]);
		else
			System.out.println("Maximum: Array is EMPTY");
		
		int total = getTotal(array);
		System.out.println("Total: " + total);
		
		double average = getAverage(array);
		System.out.printf("Average: %.3f\n", average);
		
		double variance = getVariance(array);
		System.out.printf("Variance: %.3f\n", variance);
		
		double standartDeviation = getStandardDeviation(array);
		System.out.printf("Standard Deviation: %.3f\n", standartDeviation);
	}

	private static int findMinimumIndex(int[] array) {
		if(array.length == 0) {
			return -1;
		} else if(array.length == 1)
			return 0;

		int index = 0;

		for(int i = 0; i < array.length; i++) 
			if(array[i] < array[index]) {
				index = i;
			}
		
		return index;
	}
	
	private static int findMaximumIndex(int[] array) {
		if(array.length == 0) {
			return -1;
		} else if(array.length == 1)
			return 0;

		int index = 0;

		for(int i = 0; i < array.length; i++) 
			if(array[i] > array[index]) {
				index = i;
			}
		
		return index;
	}
	
	private static int getTotal(int[] array) {
		int total = 0;
		
		for(int i = 0; i < array.length; i++)
			total += array[i];
		
		return total;
	}
	
	private static double getAverage(int[] array) {
		return getTotal(array)/(double)array.length;
	}
	
	private static double getVariance(int[] array) {
		double sum = 0;
		double mean = getAverage(array);
		
		for(int i = 0; i < array.length; i++) {
			sum += ((double)array[i] - mean)*((double)array[i] - mean);
		}
		
		return sum/(double)array.length;
	}
	
	private static double getStandardDeviation(int[] array) {
		return Math.sqrt(getVariance(array));
	}

	private static void printArray(int[] array) {
		System.out.print("Array: ");
		
		if(array.length == 0) {
			System.out.print("EMPTY\n");
			return;
		}
		
		for(int i = 0; i < array.length; i++)
			System.out.printf("%2d ", array[i]);
		System.out.print("\n");
	}

}
