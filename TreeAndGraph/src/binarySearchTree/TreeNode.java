package binarySearchTree;

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data) {
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
	
	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeftSubNode(TreeNode node) {
		this.left = node;
	}
	
	public void setRightSubNode(TreeNode node) {
		this.right = node;
	}
}
