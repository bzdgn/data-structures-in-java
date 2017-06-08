package ds_010_trees;

public class TrinaryNode<T> {
	
	public TrinaryNode<T> left;
	public TrinaryNode<T> middle;
	public TrinaryNode<T> right;
	public T data;
	
	public TrinaryNode(T data) {
		this.data	= data;
		
		this.left	= null;
		this.middle	= null;
		this.right	= null;
	}
	
}
