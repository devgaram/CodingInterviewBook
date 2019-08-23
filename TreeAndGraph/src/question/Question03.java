package question;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;

/*
 * ������ ����Ʈ : ����Ʈ���� �־����� �� ���� ���̿� �ִ� ��带 ���Ḯ��Ʈ�� ������ �ִ� �˰����� �����϶�.
 * ��, Ʈ���� ���̰� D��� D���� ���Ḯ��Ʈ�� �������Ѵ�.
 */
import java.util.*;
public class Question03 {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode("1");
		TreeNode n2 = new TreeNode("2");
		TreeNode n3 = new TreeNode("3");
		TreeNode n4 = new TreeNode("4");
		TreeNode n5 = new TreeNode("5");
		
		n1.makeLeftSubNode(n2);
		n1.makeRightSubNode(n3);
		n2.makeLeftSubNode(n4);
		n3.makeLeftSubNode(n5);
		
		TreeNode root = n1;
		
		List<LinkedList> depthList = makeDepthLinkedList(root);
		for (int i = 0; i < depthList.size(); i++) {
			System.out.print("depth " + i + " : ");
			Iterator<TreeNode> nodes = depthList.get(i).iterator();
			while (nodes.hasNext()) {
				System.out.print(nodes.next().getData() + " ");
			}
			System.out.println();
			
		}
		System.out.println("DFS");
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedListDFS(root, result, 0);
		for (int i = 0; i < result.size(); i++) {
			System.out.print("depth " + i + " : ");
			Iterator<TreeNode> nodes = result.get(i).iterator();
			while (nodes.hasNext()) {
				System.out.print(nodes.next().getData() + " ");
			}
			System.out.println();
			
		}
	}
	
	public static List<LinkedList> makeDepthLinkedList(TreeNode root) {
		
		LinkedList q = new LinkedList();
		List<LinkedList> depthList = new ArrayList<LinkedList>();
		int prevCount = 0, count = 0;
		TreeNode node;
		
		q.add(root);
		count++;
		
		while (!q.isEmpty()) {
			prevCount = count;
			count = 0;
			LinkedList<TreeNode> depth = new LinkedList<TreeNode>();
			while (prevCount > 0) {
				node = (TreeNode) q.removeFirst();
				depth.add(node);
				prevCount--;
				if (node.getLeftSubNode() != null) {
					q.add(node.getLeftSubNode());
					count++;
				}
				if (node.getRightSubNode() != null) {
					q.add(node.getRightSubNode());
					count++;
				}
			}
			depthList.add(depth);
			
		}
		
		return depthList;
	}
	
	// å �ش� : ���̿켱Ž�� �̿� (��ȸ��ȸ�� ����)
	// �ð����⵵ : O(N)
	// �������⵵ : ���� Ʈ���� ��� ���ȣ�� �ϹǷ� O(logN)
	// ��������� ������ �� �䱸�Ǵ� ������ �ᱹ ��ȯ�ؾ��ϴ� ��ũ�� ����Ʈ O(N)�� ���ϸ� �󸶵��� �ʾƼ� �ؿ� ����� ���� ȿ���� ���鿡���� �����ϴٰ� ��������.
	public static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
		if (root != null) {
			LinkedList<TreeNode> list = null;
			if (level == result.size()) {
				list = new LinkedList<TreeNode>();
				result.add(list);
			} else list = result.get(level);
			
			list.add(root);			
			createLevelLinkedListDFS(root.getLeftSubNode(), result, level + 1);
			createLevelLinkedListDFS(root.getRightSubNode(), result, level + 1);
		}
	}
	
	// å �ش� : �ʺ�켱Ž�� �̿�
	// �ð����⵵ : O(N)
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
		if (root == null) return null;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for (TreeNode node : parents) {
				if (node.getLeftSubNode() != null)
					current.add(node.getLeftSubNode());
				if (node.getRightSubNode() != null) 
					current.add(node.getRightSubNode());
			}			
		}
		return result;
	}
}
