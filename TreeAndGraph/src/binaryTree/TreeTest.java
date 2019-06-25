package binaryTree;

public class TreeTest {

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

		System.out.println(n1.getLeftSubNode().getData());
		System.out.println(n1.getRightSubNode().getData());
		
		BinaryTree binaryTree = new BinaryTree();
		//binaryTree.preOrderTraversal(n1);
		binaryTree.levelOrerTraversal(n1);
		
	}

}
