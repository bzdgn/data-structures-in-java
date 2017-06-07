package ds._008.recursion;

public class CombinationNestedLoopDemo {

	public static void main(String[] args) {
		int N = 2;
		int count = 1;
		
		for(int i1 = 1; i1 <= N; i1++) {
			for(int i2 = 1; i2 <= N; i2++ ) {
				for(int i3 = 1; i3 <= N; i3++) {
					for(int i4 = 1; i4 <= N; i4++) {
						for(int i5 = 1; i5 <= N; i5++) {
							System.out.printf("[Combination: %3d]: [%d]-[%d]-[%d]-[%d]-[%d]\n", count++, i1, i2, i3, i4, i5);
						}
					}
				}
			}
		}
	}

}
