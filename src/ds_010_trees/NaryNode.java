package ds_010_trees;

public class NaryNode<T extends Comparable<T>> {
	
	public T data;
	public final NaryNode<T>[] children;
	int size = 0;
	
	@SuppressWarnings("unchecked")
	public NaryNode(T data, int numOfChildren) {
		this.data		= data;
		this.children	= (NaryNode<T>[])new NaryNode[numOfChildren];
	}
	
	public void addChild(T data, int numOfChildren) {
		if(!isFull()) {
			children[size++] = new NaryNode<>(data, numOfChildren);
		}
	}
	
	public NaryNode<T> getChild(T data) {
		for(NaryNode<T> result : children) {
			if(result.data.equals(data)) {
				return result;
			}
		}
		
		return null;
	}
	
	// trivial
	public boolean isFull() {
		return size == children.length;
	}
	
}
