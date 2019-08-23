package question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.TreeNode;

/*
 * �ּ� Ʈ�� : ������������ ���ĵ� �迭���ִ�. �� �迭�ȿ� ����ִ� ���Ҵ� �����̸� �ߺ��� ���� ���ٰ� ���� ��
 * ���̰� �ּҰ� �Ǵ� ���� Ž�� Ʈ���� ����� �˰����� �ۼ��϶�
 */

// �� �߰����� ��Ʈ������ ���ָ� �ɰͰ�����
public class Question02 {

	public static void main(String[] args) {
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		BinarySearchTree bst = new BinarySearchTree();
		makeBalancedBST(array, bst, 0, array.length-1);
		bst.levelOrderTraversal();
		System.out.println();
		
		BinarySearchTree bst2 = new BinarySearchTree();
		TreeNode root = createMinimalBST(array);
		bst2.setRoot(root);
		bst.levelOrderTraversal();

	}

	// �� Ǯ���� ������
	// insert�� Ʈ���� ��ȸ�ϹǷ� logN�� �ð����⵵�� �߻��ϰ�, �̸� �迭�� ���̸�ŭ �ݺ��ϹǷ� �� �ð� ���⵵�� NlogN�� �Ǿ� ȿ�������� �ʴ�.
	public static void makeBalancedBST(int[] array, BinarySearchTree bst, int start, int end) {
		if (start <= end) { 
			int midIndex = (start + end)/2;
			bst.insert(array[midIndex]);
			makeBalancedBST(array, bst, start, midIndex - 1);
			makeBalancedBST(array, bst, midIndex + 1, end);
		}
	}
	

	public static TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createMinimalBST(int array[], int start, int end) {
		if (end < start) return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(array[mid]);
		n.setLeftSubNode(createMinimalBST(array, start, mid - 1));
		n.setRightSubNode(createMinimalBST(array, mid + 1, end));
		return n;
		
	}
	
	
}
