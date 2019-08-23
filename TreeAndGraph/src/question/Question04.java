package question;
/*
 * ����Ȯ�� : ���� Ʈ���� ���� �����ִ� �� Ȯ���ϴ� �Լ��� �ۼ��϶�.
 * �� �������� ���� ���� Ʈ���� ��� ��忡 ���ؼ� ���� �κ� Ʈ���� ���̿� ������ �κ� Ʈ���� ������ ���̰� �ִ� �ϳ��� Ʈ���� �ǹ��Ѵ�.
 */
// ��.. ������ �ι辿 �þ����..������ �ι辿 �þ�� �ʴ� ��찡 2�� ���� �߻��� ����x
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
	 * ���� ��带 �������� ���� ����Ʈ���� MAX���̿� ������ ����Ʈ���� MAX������ ���̰� 2�̻��̸� �ұ���!!!
	 * ����Ʈ���� ��� ��忡 ���ؼ� �� ����Ʈ���� ���̸� ���ϴ� �۾��� �ݺ��ؾߵǴϱ� ���ȣ���� ����ؾߵ�!!
	 * ---> �� ��忡�� ��ü ���� Ʈ���� ����� Ž���ϹǷ�, ���� ��忡 ���� �ݺ������� �ǵ���� O(NlogN)��. ��ȿ����
	 * 
	 * ��͸� ���� Ʈ���� ���� ������ ���� ����Ʈ���� ���̸� üũ�س����� ��带 �ݺ� üũ�� �ʿ䰡 ����.
	 * ���̰� 2�̻� ���̳��� ���� ������ Integer.MIN_VALUE�� ����ϴ� �� �����ϴ�.
	 * ���� ��ȯ ���� MIN_VALUE�� ���� Ʈ�� �߿��� �ұ����� Ʈ���� �־��ٴ� �ǹ�! 
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
