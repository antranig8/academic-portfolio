/**
 * Generic TreeNode class
 */
public class TreeNode<T> {
	// Fields to hold the tree nodes and data
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	// default treeNode constructor that calls the main
	public TreeNode() {
		this(null,null,null);
	}
	// TreeNode constructor with data parameter that calls the main
	public TreeNode(T data) {
		this(data, null, null);
	}
	/**
	 * Fully parameterized constructor
	 * @param T data
	 * @param TreeNode<T> left the left tree node
	 * @param TreeNode<T> right the right tree node
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	// Methods
	
	/**
	 * getData method that returns the nodes data
	 */
	public T getData() {
		return data;
	}
	/**
	 * setData method that sets the node data
	 * @param 
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * getLeft method that returns the left child
	 */
	public TreeNode<T> getLeft() {
		return left;
	}
	/**
	 * getRight method that returns the right child
	 */
	public TreeNode<T> getRight() {
		return right;
	}
	/**
	 * setLeft method that sets the left child
	 * @param left sets left child
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	/**
	 * setRight method that sets the right child
	 * @param right sets right child
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}
