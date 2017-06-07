package ds_008_recursion;

public class FibonacciWithStackDemo {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.printf("Fib(%2d) = %3d\n", i, fibonacci(i));
		}
		
		System.out.printf("Fib(43) = %d\n", fibonacci(43));	// F(43): 701408733
		System.out.printf("Fib(80) = %d\n", fibonacci(80));	// F(80): 37889062373143906
	}
	
	private static long fibonacci(int N) {
		if(N == 0 || N == 1) {
			return 1;
		}
		
		SimpleStack stack = new SimpleStack();
		stack.push(1);	// f(0)
		stack.push(1);	// f(1)
		
		while(N != 1) {
			long prev1 = stack.pop();
			long prev2 = stack.pop();
			long fib = prev1 + prev2;
			stack.push(prev1);
			stack.push(fib);
			N--;
		}
		
		return stack.pop();
	}
	
	private static class SimpleStack {
		
		private Node START_SENTINEL;
		private long size;
		
		public SimpleStack() {
			START_SENTINEL = new Node(Long.MIN_VALUE);
			size = 0;
		}
		
		public void push(long value) {
			Node newNode = new Node(value);
			if(isEmpty()) {
				START_SENTINEL.next = newNode;
			} else {
				newNode.next = START_SENTINEL.next;
				START_SENTINEL.next = newNode;
			}
			
			size++;
		}
		
		public Long pop() {
			if(isEmpty()) {
				return null;
			}
			
			Node popped = START_SENTINEL.next;
			
			START_SENTINEL.next = popped.next;
			
			size--;
			
			return popped.data;
		}
		
		public Long peek() {
			if(isEmpty()) {
				return null;
			}
			
			return START_SENTINEL.next.data;
		}
		
		private boolean isEmpty() {
			return size == 0;
		}
		
		private class Node {
			private long data;
			private Node next;
			
			public Node(long data) {
				this.data = data;
				this.next = null;
			}
		}
		
		private void printStack() {
			System.out.print("Stack: ");
			if(isEmpty()) {
				System.out.print("EMPTY");
			} else {
				for(Node temp = START_SENTINEL.next; temp != null; temp = temp.next) {
					System.out.printf("%d ", temp.data);
				}
			}
			System.out.print("\n");
		}
		
	}

}
