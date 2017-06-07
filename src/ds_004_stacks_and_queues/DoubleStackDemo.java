package ds_004_stacks_and_queues;

public class DoubleStackDemo {

	public static void main(String[] args) {
		DoubleStack<Integer> dstack = new DoubleStack<>();
		
		System.out.println("Left  isEmpty: " + dstack.isLeftEmpty());
		System.out.println("Rigth isEmpty: " + dstack.isRightEmpty());
		
		dstack.pushLeft(10);
		dstack.print();
		
		dstack.pushRight(90);
		dstack.print();
		
		dstack.pushLeft(20);
		dstack.pushLeft(30);
		dstack.pushRight(80);
		dstack.pushRight(70);
		
		dstack.print();
		
		dstack.pushLeft(40);
		dstack.pushLeft(50);
		dstack.pushLeft(60);
		dstack.pushLeft(70);
		dstack.pushRight(65);
		
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		System.out.println("Popped Left : " + dstack.popLeft());
		System.out.println("Popped Right: " + dstack.popRight());
		
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		System.out.println("Popped Left : " + dstack.popLeft());
		System.out.println("Popped Right: " + dstack.popRight());
		System.out.println("Popped Left : " + dstack.popLeft());
		System.out.println("Popped Right: " + dstack.popRight());
		
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		System.out.println("Popped Left : " + dstack.popLeft());
		System.out.println("Popped Right: " + dstack.popRight());
		System.out.println("Popped Left : " + dstack.popLeft());
		System.out.println("Popped Right: " + dstack.popRight());
		
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		System.out.println("Popped Left : " + dstack.popLeft());
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		System.out.println("Popped Left : " + dstack.popLeft());
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		dstack.pushLeft(55);
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
		dstack.popLeft();
		dstack.print();
		System.out.println("Capacity: " + dstack.capacity());
		
	}

}
