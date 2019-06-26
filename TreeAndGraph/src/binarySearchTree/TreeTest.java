package binarySearchTree;

public class TreeTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(35);
		bst.insert(18);
		bst.insert(7);
		bst.insert(26);
		bst.insert(3);
		bst.insert(12);
		bst.insert(22);
		bst.insert(30);
		bst.insert(68);
		bst.insert(99);
		bst.preOrderTraversal(bst.getRoot());
		bst.delete(30);
		System.out.println(" ");
		bst.preOrderTraversal(bst.getRoot());
		bst.delete(68);
		System.out.println(" ");
		bst.preOrderTraversal(bst.getRoot());
		bst.delete(18);
		System.out.println(" ");
		bst.preOrderTraversal(bst.getRoot());


	}

}
