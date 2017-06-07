package ds_005.sorting;

public class SQueueDemo {

	public static void main(String[] args) {
		SQueue<Integer> queue = new SQueue<>();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		queue.print();
	}

}
