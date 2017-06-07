package ds_005_sorting;

public class SStackDemo {

	public static void main(String[] args) {
		SStack<Integer> stack = new SStack<>();
		
		stack.push(1);
		stack.push(5);
		stack.push(10);
		
		System.out.println(stack.size());
		
		stack.print();
		
		System.out.print("Popped: ");
		while(!stack.isEmpty()) {
			Integer curr = stack.pop();
			
			System.out.printf(curr + " ");
		}
	}

}
