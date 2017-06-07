package ds_004_stacks_and_queues;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.push(10);
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.print();
		
		Integer popped = stack.pop();
		System.out.println("Popped: " + popped);

		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.print();
	}

}
