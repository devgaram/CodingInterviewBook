package binaryTree;
import java.util.LinkedList;

public class BinaryTree {
	
	public BinaryTree() {
		
	}	
	
	// ��Ʈ -> ���� ����Ʈ�� -> ������ ����Ʈ�� 
	public void preOrderTraversal(TreeNode root) {
		if(root != null) {
			visit(root);
			preOrderTraversal(root.getLeftSubNode());
			preOrderTraversal(root.getRightSubNode());
		}		
	}
	
	// ���� ����Ʈ�� -> ��Ʈ -> ������ ����Ʈ�� 
	public void inOrderTraversal(TreeNode root) {
		if(root != null) {			
			inOrderTraversal(root.getLeftSubNode());
			visit(root);
			inOrderTraversal(root.getRightSubNode());
		}	
	}
	
	// ���� ����Ʈ�� -> ������ ����Ʈ�� -> ��Ʈ (�ڽ� ��带 ó���� ������ �θ� ��� ó���ؾߵǴ� ��� ��, ���丮 �뷮 ���)
	public void postOrderTraversal(TreeNode root) {
		if(root != null) {			
			postOrderTraversal(root.getLeftSubNode());
			postOrderTraversal(root.getRightSubNode());
			visit(root);
		}	
	}
	
	// ������ȸ
	public void levelOrerTraversal(TreeNode root) {
		// ������ Ŭ������ �����Ǿ�������, ť�� �������̽� ���·� �����ȴ�.
		// Deque �������̽��� ������ LinkedList Ŭ������ �̿��Ͽ� ť ���¸� �����ϸ� �ȴ�.
		// add()�� �ְ� peek()���� ����
		if(root == null)
			throw new NullPointerException();
	
		LinkedList<TreeNode> qu = new LinkedList<TreeNode>();
		TreeNode node;
		qu.add(root);
		
		
		while(!qu.isEmpty()) {		
			node = qu.poll();			
			visit(node);
			if(node.getLeftSubNode() != null) qu.add(node.getLeftSubNode());
			if(node.getRightSubNode() != null) qu.add(node.getRightSubNode());
		}		
	}
	
	public void visit(TreeNode node) {
		System.out.print(node.getData() + " ");
	}
}
