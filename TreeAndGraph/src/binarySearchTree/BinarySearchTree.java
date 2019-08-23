package binarySearchTree;

/*
 * ���� Ž�� Ʈ��
 * - ��� ����� Ű�� �����ϴ�.
 * - ���� ���� Ʈ���� Ű���� ��Ʈ�� Ű���� �۴�.
 * - ������ ���� Ʈ���� Ű���� ��Ʈ�� Ű���� ũ��.
 * - ���ʰ� ������ ���� Ʈ���� ���� Ž�� Ʈ���̴�.
 * 
 * - �ߺ� Ű ������
 * - Ž��, ����, ���� ������ �ð� ���⵵�� Ʈ���� ���̰� h�϶�  O(h)
 * - ����� ���� N, ���� ���� ����Ʈ���� ���̴� log��N
 * - ���� ġ��ġ�� ��� ���� Ʈ���� ��� Ʈ���� ���̰� N�̹Ƿ�, ����Ž�� ���⵵(O(N))�� ����
 */
import java.util.*;
public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}	

	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// data Ž��
	public boolean search(int data) {
		TreeNode node = root;
		while(node != null) {
			if(node.getData() < data ) node = node.getRightSubNode();
			else if(node.getData() > data) node = node.getLeftSubNode();
			else return true;
		}		
		return false;
	}

	// ����
	public boolean insert(int data) {
		TreeNode node = root;
		TreeNode parent = null;

		while(node != null) {
			parent = node;
			if(node.getData() < data) node = node.getRightSubNode();
			else if(node.getData() > data) node = node.getLeftSubNode();
			else {
				System.out.println("�ߺ� ������ ������ �Ұ����մϴ�.");
				return false;						
			}
		}
		TreeNode newNode = new TreeNode(data);
		if(parent == null) root = newNode;
		else if(parent.getData() > data) parent.makeLeftSubNode(newNode);
		else if(parent.getData() < data) parent.makeRightSubNode(newNode);		
		else return false;

		return true;
	}

	public boolean delete(int data) {
		if(root == null) {
			System.out.println("Ʈ���� ����ֽ��ϴ�.");
			return false;
		} 

		TreeNode targetNode = root;
		TreeNode parentNode = null;
		boolean isLeftFlag = false;
		while(targetNode != null) {
			if(targetNode.getData() > data){
				parentNode = targetNode;
				targetNode = targetNode.getLeftSubNode();
				isLeftFlag = true;
			}
			else if(targetNode.getData() < data){
				parentNode = targetNode;
				targetNode = targetNode.getRightSubNode();
				isLeftFlag = false;
			}
			else break;
			
		}
		if(targetNode == null) {
			System.out.println("�����Ͱ� Ʈ���� ���������ʽ��ϴ�.");
			return false;
		}

		// Ÿ�ٳ���� ����Ʈ���� 0��
		if(targetNode.getLeftSubNode() == null && targetNode.getRightSubNode() == null) {
			// Ÿ�ٳ�Ʈ�� ��Ʈ�� ��
			if(parentNode == null) root = null;
			else {				
				// �θ��� ���ʳ�尡 Ÿ�ٳ����
				if(isLeftFlag) 
					parentNode.setLeftSubNode(null);					
				else
					parentNode.setRightSubNode(null);
			}
			targetNode = null;

		} 
		// Ÿ�ϳ���� ����Ʈ���� �����ʿ� 1��
		else if(targetNode.getLeftSubNode() == null && targetNode.getRightSubNode() != null) {
			if(parentNode == null) root = targetNode.getRightSubNode();
			else {
				// �θ��� ���ʳ�尡 Ÿ�ٳ����
				if(isLeftFlag)
					parentNode.setLeftSubNode(targetNode.getRightSubNode());
				else
					parentNode.setRightSubNode(targetNode.getRightSubNode());
			}
			targetNode = null;
		} 
		// Ÿ�ٳ���� ����Ʈ���� ���ʿ� 1��
		else if(targetNode.getLeftSubNode() != null && targetNode.getRightSubNode() == null) {
			if(parentNode == null) root = targetNode.getLeftSubNode();
			else {
				// �θ��� ���ʳ�尡 Ÿ�ٳ����
				if(isLeftFlag)
					parentNode.setLeftSubNode(targetNode.getLeftSubNode());
				else
					parentNode.setRightSubNode(targetNode.getLeftSubNode());
			}
			targetNode = null;
		} 
		// Ÿ�ٳ���� ����Ʈ���� 2��
		else {
			TreeNode replaceNode = targetNode.getLeftSubNode();
			TreeNode replaceParentNode = targetNode;
			while(replaceNode.getRightSubNode() != null) {
				replaceParentNode = replaceNode;
				replaceNode = replaceNode.getRightSubNode();				
			}
			if(replaceParentNode.equals(targetNode)){
				if(replaceNode.getLeftSubNode() != null) {
					replaceParentNode.setLeftSubNode(replaceNode.getLeftSubNode());				
				} else {
					replaceParentNode.setLeftSubNode(null);
				}
			} else {
				if(replaceNode.getLeftSubNode() != null) {
					replaceParentNode.setRightSubNode(replaceNode.getLeftSubNode());				
				} else {
					replaceParentNode.setRightSubNode(null);
				}
			}
			targetNode.setData(replaceNode.getData());
			replaceNode = null;
		}
		return true;

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
	
	public void levelOrderTraversal() {
		if (root != null) {
			TreeNode node;
			LinkedList q = new LinkedList();
			q.add(root);
			while (!q.isEmpty()) {
				node= (TreeNode) q.removeFirst();
				visit(node);
				
				if (node.getLeftSubNode() != null) q.add(node.getLeftSubNode());
				if (node.getRightSubNode() != null) q.add(node.getRightSubNode());
			}
		}
	}

	public void visit(TreeNode node) {
		if (node != null)
			System.out.print(node.getData() + " ");
	}


}
