package ds_010_trees;

public class Children<T> {
	
	private LinkNode<T> START_SENTINEL	= new LinkNode<>(null);
	private LinkNode<T> END_SENTINEL	= new LinkNode<>(null);
	private int size = 0;
	
	public Children() {
		START_SENTINEL.next	= END_SENTINEL;
		END_SENTINEL.prev	= START_SENTINEL;
	}
	
	public void add(T data) {
		LinkNode<T> newNode = new LinkNode<>(data);
		
		newNode.prev = END_SENTINEL.prev;
		newNode.next = END_SENTINEL;
		
		END_SENTINEL.prev.next = newNode;
		END_SENTINEL.prev = newNode;
		
		size++;
	}
	
	public T remove(T data) {
		LinkNode<T> removed = findNode(data);
		
		if(removed == null) {
			return null;
		} else {
			removed.next.prev = removed.prev;
			removed.prev.next = removed.next;
			size --;
			
			return removed.data;
		}
	}
	
	public LinkNode<T> findNode(T data) {
		for(LinkNode<T> curr = START_SENTINEL.next; curr != END_SENTINEL; curr = curr.next) {
			if(curr.data.equals(data)) {
				return curr;
			}
		}
		
		return null;
	}
	
	public T find(T data) {
		for(LinkNode<T> curr = START_SENTINEL.next; curr != END_SENTINEL; curr = curr.next) {
			if(curr.data.equals(data)) {
				return curr.data;
			}
		}
		
		return null;
	}
	
	public LinkNode<T> findByIndex(int index) {
		LinkNode<T> curr = START_SENTINEL.next;
		for(int i = 0; curr != END_SENTINEL; curr = curr.next, i++) {
			if(i == index) {
				return curr;
			}
		}
		
		return null;
	}
	
	// trivial
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void printChildren() {
		System.out.print("Children: ");
		if(isEmpty()) {
			System.out.print("No children!");
		} else {
			for(LinkNode<T> curr = START_SENTINEL.next; curr != END_SENTINEL; curr = curr.next) {
				System.out.printf("%s ", curr.data);
			}
		}
		System.out.print("\n");
	}
	
	static class LinkNode<T> {
		private T data;
		private LinkNode<T> prev;
		private LinkNode<T> next;
		
		public LinkNode(T data) {
			this.data	= data;
			
			this.prev	= null;
			this.next	= null;
		}
	}
	
}
