package ds_004_stacks_and_queues;

public class StackArrayDemo {

	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray<>(1);
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.push(10);
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.print();
		
		Integer popped = stack.pop();
		System.out.println("Popped: " + popped);

		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.push(10);
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.push(20);
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.push(30);
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.push(40);
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.push(50);
		System.out.println("\tCAPACITY: " + stack.capacity());
		System.out.println("\tCAPACITY: " + stack.capacity());
		
		stack.pop();
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.pop();
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.pop();
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.pop();
		System.out.println("\tCAPACITY: " + stack.capacity());
		stack.pop();
		System.out.println("\tCAPACITY: " + stack.capacity());
		
		System.out.println("Stack is EMPTY: " + stack.isEmpty());
		
		stack.print();
	}

}
