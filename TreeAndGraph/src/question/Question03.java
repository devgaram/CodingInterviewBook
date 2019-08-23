package question;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;

/*
 * 깊이의 리스트 : 이진트리가 주어졌을 때 같은 깊이에 있는 노드를 연결리스트로 연결해 주는 알고리즘을 설계하라.
 * 즉, 트리의 깊이가 D라면 D개의 연결리스트를 만들어야한다.
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
	
	// 책 해답 : 깊이우선탐색 이용 (전회순회를 변형)
	// 시간복잡도 : O(N)
	// 공간복잡도 : 균형 트리일 경우 재귀호출 하므로 O(logN)
	// 재귀적으로 구현할 때 요구되는 공간은 결국 반환해야하는 링크드 리스트 O(N)과 비교하면 얼마되지 않아서 밑에 방법과 공간 효율성 측면에서는 동일하다고 볼수있음.
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
	
	// 책 해답 : 너비우선탐색 이용
	// 시간복잡도 : O(N)
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
