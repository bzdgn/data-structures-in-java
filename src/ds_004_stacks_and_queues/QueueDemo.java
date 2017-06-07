package ds_004_stacks_and_queues;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		
		queue.print();
		queue.state();
		
		queue.enqueue(10);
		queue.print();
		queue.state();
		
		Integer value = queue.dequeue();
		System.out.println("Dequeued: " + value);
		queue.print();
		queue.state();
		
		queue.enqueue(10);
		queue.enqueue(20);
				
		queue.print();
		queue.state();
		
		value = queue.dequeue();
		System.out.println("Dequeued: " + value);
		queue.print();
		queue.state();
		
		value = queue.dequeue();
		System.out.println("Dequeued: " + value);
		queue.print();
		queue.state();
	}

}
