package ds_004_stacks_and_queues;

public class QueueCircularArrayDemo {

	public static void main(String[] args) {
		QueueCircularArray<Integer> queue = new QueueCircularArray<>();
		Integer value;
		
		queue.print();
		queue.state();
//		
//		queue.enqueue(10);
//		queue.print();
//		queue.state();
//		
//		value = queue.dequeue();
//		System.out.println("Dequeued: " + value);
//		queue.print();
//		queue.state();
//		
//		queue.enqueue(10);
//		queue.enqueue(20);
//				
//		queue.print();
//		queue.state();
//		
//		value = queue.dequeue();
//		System.out.println("Dequeued: " + value);
//		queue.print();
//		queue.state();
//		
//		value = queue.dequeue();
//		System.out.println("Dequeued: " + value);
//		queue.print();
//		queue.state();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		
		queue.print();
		
		queue.dequeue();
		
		queue.print();
		queue.enqueue(90);
		queue.print();
	}

}
