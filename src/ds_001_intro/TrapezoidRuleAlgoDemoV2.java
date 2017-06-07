package ds_001_intro;

public class TrapezoidRuleAlgoDemoV2 {

	public static void main(String[] args) {
		int x1 = 0;
		int x2 = 3;
		int N = 1000;
		
		System.out.printf("[%d..%d] for x^2 = %.2f\n", x1, x2, calculateArea(x1, x2, N, new Curve() {

			@Override
			public double getValue(double x) {
				return x*x;
			}
			
		}));
	}
	
	private static double calculateArea(double x1, double x2, int N, Curve c) {
		
		if(x1 > x2) {
			double temp = x2;
			x2 = x1;
			x1 = temp;
		}
		double dx = (Math.abs(x1 - x2)) / N;
		double totalArea = 0;
		
		for(double i = x1; i < x2; i += dx) {
			totalArea += c.getValue(i) + c.getValue(i + dx);
		}
		
		return totalArea*dx/2;
	}

}
