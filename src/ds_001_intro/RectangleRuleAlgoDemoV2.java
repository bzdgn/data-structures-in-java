package ds_001_intro;

public class RectangleRuleAlgoDemoV2 {

	public static void main(String[] args) {
		int x1 = 0;
		int x2 = 5;
		int N = 10;
		
		System.out.printf("[%d..%d] for 1 + x + sin(2*x) = %.2f\n", x1, x2, calculateArea(x1, x2, N, new Curve() {

			@Override
			public double getValue(double x) {
				return 1 + x + Math.sin(2*x);
			}
			
		}));
	}
	
	private static double calculateArea(double x1, double x2, int N, Curve c) {
		
		if(x1 > x2) {
			double temp = x2;
			x2 = x1;
			x1 = temp;
		}
		
		double dx = (Math.abs(x1 - x2))/N;
		double totalArea = 0;
		
		for(double i = x1; i < x2; i += dx) {
			totalArea += c.getValue(i);
		}
		
		return totalArea*dx;
	}

}
