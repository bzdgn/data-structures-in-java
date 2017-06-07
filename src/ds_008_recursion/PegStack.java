package ds_008_recursion;

public class PegStack {
	
	private PegNode TOP_SENTINEL;
	private PegNode BOTTOM_SENTINEL;
	
	public PegStack() {
		TOP_SENTINEL = new PegNode(Integer.MAX_VALUE);
		BOTTOM_SENTINEL = new PegNode(Integer.MIN_VALUE);
		
		TOP_SENTINEL.next = BOTTOM_SENTINEL;
		BOTTOM_SENTINEL.prev = TOP_SENTINEL;
	}
	
	public void push(int disk) {
		PegNode newNode = new PegNode(disk);
		
		if(TOP_SENTINEL.next == BOTTOM_SENTINEL && BOTTOM_SENTINEL.prev == TOP_SENTINEL) {
			newNode.prev = TOP_SENTINEL;
			newNode.next = BOTTOM_SENTINEL;
			
			TOP_SENTINEL.next = newNode;
			BOTTOM_SENTINEL.prev = newNode;
		} else {
			newNode.next = TOP_SENTINEL.next;
			newNode.prev = TOP_SENTINEL;
			
			TOP_SENTINEL.next.prev = newNode;
			TOP_SENTINEL.next = newNode;
		}
	}
	
	public Integer pop() {
		if(TOP_SENTINEL.next == BOTTOM_SENTINEL && BOTTOM_SENTINEL.prev == TOP_SENTINEL) {
			return null;
		}
		
		PegNode popped = TOP_SENTINEL.next;
		
		TOP_SENTINEL.next = popped.next;
		popped.next.prev = TOP_SENTINEL;
		
		return popped.disk;
	}
	
	public Integer bottomValue() {
		if(TOP_SENTINEL.next == BOTTOM_SENTINEL && BOTTOM_SENTINEL.prev == TOP_SENTINEL) {
			return null;
		}
		
		return BOTTOM_SENTINEL.prev.disk;
	}
	
	public Integer peek() {
		if(TOP_SENTINEL.next == BOTTOM_SENTINEL && BOTTOM_SENTINEL.prev == TOP_SENTINEL) {
			return null;
		}
		
		return TOP_SENTINEL.next.disk;
	}
	
	private class PegNode {
		
		private Integer disk;
		private PegNode prev;
		private PegNode next;
		
		public PegNode(Integer disk) {
			this.disk = disk;
			this.prev = null;
			this.next = null;
		}
		
	}
	
	// trivial
	public void printPeg() {
		System.out.print("|: ");
		for(PegNode temp = BOTTOM_SENTINEL.prev; temp != TOP_SENTINEL; temp = temp.prev) {
			System.out.printf("%d ", temp.disk);
		}
		System.out.print("\n");
	}

}
