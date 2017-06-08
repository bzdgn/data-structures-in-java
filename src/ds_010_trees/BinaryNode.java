package ds_010_trees;

public class BinaryNode<T> {
	
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public T data;
	
	public BinaryNode(T data) {
		this.data	= data;
		
		this.left	= null;
		this.right	= null;
	}
	
}
