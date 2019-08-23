package question;
/*
 * 균형확인 : 이진 트리가 균형 잡혀있는 지 확인하는 함수를 작성하라.
 * 이 문제에서 균형 잡힌 트리란 모든 노드에 대해서 왼쪽 부분 트리의 높이와 오른쪽 부분 트리의 높이의 차이가 최대 하나인 트리를 의미한다.
 */
// 음.. 갯수가 두배씩 늘어나야함..갯수가 두배씩 늘어나지 않는 경우가 2번 연속 발생시 균형x
import java.util.*;

import binaryTree.TreeNode;
public class Question04 {
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode("1");
		TreeNode n2 = new TreeNode("2");
		TreeNode n3 = new TreeNode("3");
		TreeNode n4 = new TreeNode("4");
		TreeNode n5 = new TreeNode("5");
		TreeNode n6 = new TreeNode("6");
		n1.makeLeftSubNode(n2);
		n1.makeRightSubNode(n3);
		n2.makeLeftSubNode(n4);
		n3.makeLeftSubNode(n5);
		n4.makeLeftSubNode(n6);
		
		TreeNode root = n1;
		System.out.println(isBalanced(root));
	}

	/*
	 * 현재 노드를 기준으로 왼쪽 서브트리의 MAX높이와 오른쪽 서브트리의 MAX높이의 차이가 2이상이면 불균형!!!
	 * 이진트리의 모든 노드에 대해서 각 서브트리의 높이를 비교하는 작업을 반복해야되니깐 재귀호출을 사용해야됨!!
	 * ---> 각 노드에서 전체 하위 트리를 재귀적 탐색하므로, 같은 노드에 대해 반복적으로 건드려서 O(NlogN)임. 비효율적
	 * 
	 * 재귀를 통해 트리의 말단 노드부터 양쪽 서브트리의 높이를 체크해나가면 노드를 반복 체크할 필요가 없다.
	 * 높이가 2이상 차이날때 에러 값으로 Integer.MIN_VALUE를 사용하는 게 적절하다.
	 * 최종 반환 값이 MIN_VALUE면 하위 트리 중에서 불균형한 트리가 있었다는 의미! 
	 */
	public static boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static int checkHeight(TreeNode root) {
		if (root == null) return -1;
		int leftHeight = checkHeight(root.getLeftSubNode());
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(root.getRightSubNode());
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
