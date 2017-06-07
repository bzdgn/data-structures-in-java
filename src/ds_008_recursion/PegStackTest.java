package ds_008_recursion;

public class PegStackTest {

	public static void main(String[] args) {
		PegStack peg = new PegStack();
		
		peg.push(3);
		peg.push(2);
		peg.push(1);
		peg.printPeg();
		
		Integer popped = peg.pop();
		System.out.println("\t\tPopped: " + popped);
		peg.printPeg();
		
		popped = peg.pop();
		System.out.println("\t\tPopped: " + popped);
		peg.printPeg();
		
		popped = peg.pop();
		System.out.println("\t\tPopped: " + popped);
		peg.printPeg();
		
		popped = peg.pop();
		System.out.println("\t\tPopped: " + popped);
		peg.printPeg();
	}

}
