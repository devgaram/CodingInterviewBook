package binaryTree;

public class TreeNode {
	private Object data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Object data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void makeLeftSubNode(TreeNode subNode) {
		this.left = subNode;
	}
	
	public void makeRightSubNode(TreeNode subNode) {
		this.right = subNode;
	}
	
	public TreeNode getLeftSubNode() {
		return this.left;
	}
	
	public TreeNode getRightSubNode() {
		return this.right;
	}
	
	public Object getData() {
		return this.data;
	}	
}
