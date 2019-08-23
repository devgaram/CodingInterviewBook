package binarySearchTree;

/*
 * 이진 탐색 트리
 * - 모든 노드의 키는 유일하다.
 * - 왼쪽 서브 트리의 키들은 루트의 키보다 작다.
 * - 오른쪽 서브 트리의 키들은 루트의 키보다 크다.
 * - 왼쪽과 오른쪽 서브 트리도 이진 탐색 트리이다.
 * 
 * - 중복 키 허용안함
 * - 탐색, 삽입, 삭제 연산의 시간 복잡도는 트리의 높이가 h일때  O(h)
 * - 노드의 갯수 N, 균형 잡힌 이진트리의 높이는 log₂N
 * - 한쪽 치우치는 경사 이진 트리의 경우 트리의 높이가 N이므로, 선형탐색 복잡도(O(N))와 같다
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

	// data 탐색
	public boolean search(int data) {
		TreeNode node = root;
		while(node != null) {
			if(node.getData() < data ) node = node.getRightSubNode();
			else if(node.getData() > data) node = node.getLeftSubNode();
			else return true;
		}		
		return false;
	}

	// 삽입
	public boolean insert(int data) {
		TreeNode node = root;
		TreeNode parent = null;

		while(node != null) {
			parent = node;
			if(node.getData() < data) node = node.getRightSubNode();
			else if(node.getData() > data) node = node.getLeftSubNode();
			else {
				System.out.println("중복 데이터 삽입은 불가능합니다.");
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
			System.out.println("트리가 비어있습니다.");
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
			System.out.println("데이터가 트리에 존재하지않습니다.");
			return false;
		}

		// 타겟노드의 서브트리가 0개
		if(targetNode.getLeftSubNode() == null && targetNode.getRightSubNode() == null) {
			// 타겟노트가 루트일 때
			if(parentNode == null) root = null;
			else {				
				// 부모의 왼쪽노드가 타겟노드임
				if(isLeftFlag) 
					parentNode.setLeftSubNode(null);					
				else
					parentNode.setRightSubNode(null);
			}
			targetNode = null;

		} 
		// 타켓노드의 서브트리가 오른쪽에 1개
		else if(targetNode.getLeftSubNode() == null && targetNode.getRightSubNode() != null) {
			if(parentNode == null) root = targetNode.getRightSubNode();
			else {
				// 부모의 왼쪽노드가 타겟노드임
				if(isLeftFlag)
					parentNode.setLeftSubNode(targetNode.getRightSubNode());
				else
					parentNode.setRightSubNode(targetNode.getRightSubNode());
			}
			targetNode = null;
		} 
		// 타겟노드의 서브트리가 왼쪽에 1개
		else if(targetNode.getLeftSubNode() != null && targetNode.getRightSubNode() == null) {
			if(parentNode == null) root = targetNode.getLeftSubNode();
			else {
				// 부모의 왼쪽노드가 타겟노드임
				if(isLeftFlag)
					parentNode.setLeftSubNode(targetNode.getLeftSubNode());
				else
					parentNode.setRightSubNode(targetNode.getLeftSubNode());
			}
			targetNode = null;
		} 
		// 타겟노드의 서브트리가 2개
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
