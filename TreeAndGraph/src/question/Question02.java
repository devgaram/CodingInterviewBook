package question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.TreeNode;

/*
 * 최소 트리 : 오름차순으로 정렬된 배열이있다. 이 배열안에 들어있는 원소는 정수이며 중복된 값이 없다고 했을 때
 * 높이가 최소가 되는 이진 탐색 트리를 만드는 알고리즘을 작성하라
 */

// 음 중간값을 루트식으로 해주면 될것같은디
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

	// 이 풀이의 문제점
	// insert는 트리를 순회하므로 logN의 시간복잡도가 발생하고, 이를 배열의 길이만큼 반복하므로 총 시간 복잡도가 NlogN이 되어 효율적이지 않다.
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
