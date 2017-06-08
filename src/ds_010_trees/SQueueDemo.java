package ds_010_trees;

public class SQueueDemo {

	public static void main(String[] args) {
		SQueue<Integer> queue = new SQueue<>();
		
		queue.print();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.print();
		
		Integer removed = queue.dequeue();
		System.out.println("\t\tRemoved: " + removed);
		queue.print();
		
		removed = queue.dequeue();
		System.out.println("\t\tRemoved: " + removed);
		queue.print();
		
		removed = queue.dequeue();
		System.out.println("\t\tRemoved: " + removed);
		queue.print();
	}

}
