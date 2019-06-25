package binaryTree;
import java.util.LinkedList;

public class BinaryTree {
	
	public BinaryTree() {
		
	}	
	
	// 루트 -> 왼쪽 서브트리 -> 오른쪽 서브트리 
	public void preOrderTraversal(TreeNode root) {
		if(root != null) {
			visit(root);
			preOrderTraversal(root.getLeftSubNode());
			preOrderTraversal(root.getRightSubNode());
		}		
	}
	
	// 왼쪽 서브트리 -> 루트 -> 오른쪽 서브트리 
	public void inOrderTraversal(TreeNode root) {
		if(root != null) {			
			inOrderTraversal(root.getLeftSubNode());
			visit(root);
			inOrderTraversal(root.getRightSubNode());
		}	
	}
	
	// 왼쪽 서브트리 -> 오른쪽 서브트리 -> 루트 (자식 노드를 처리한 다음에 부모 노드 처리해야되는 경우 예, 디렉토리 용량 계산)
	public void postOrderTraversal(TreeNode root) {
		if(root != null) {			
			postOrderTraversal(root.getLeftSubNode());
			postOrderTraversal(root.getRightSubNode());
			visit(root);
		}	
	}
	
	// 레벨순회
	public void levelOrerTraversal(TreeNode root) {
		// 스택은 클래스로 구현되어있으나, 큐는 인터페이스 형태로 제공된다.
		// Deque 인터페이스를 구현한 LinkedList 클래스를 이용하여 큐 형태를 구현하면 된다.
		// add()로 넣고 peek()으로 빼기
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
