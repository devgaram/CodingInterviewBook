package question;

/*
 * Q. 뒤에서 k번째 원소 구하기 : 단방향 연결리스트가 주어졌을 때 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 */
import java.util.*;
public class Question02 {

	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(1);
		LinkedListNode node4 = new LinkedListNode(2);
		LinkedListNode node5 = new LinkedListNode(2);
		LinkedListNode node6 = new LinkedListNode(5);
		LinkedListNode node7 = new LinkedListNode(4);
		LinkedListNode head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;	
		printListNode(head);
		System.out.println(findElement(7,head).data);
		
	}
	
	public static LinkedListNode findElement(int seq, LinkedListNode head) {
		LinkedListNode node = head;
		int len = 0, index = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		node = head;
		while (index < len - seq) {
			index++;
			node = node.next;
		}
		
		return node;
		
	}
	
	public static void printList(LinkedList<Integer> list) {
		for (Integer o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
		System.out.println("---------------");
	}

	public static void printListNode(LinkedListNode head) {
		LinkedListNode node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("---------------");
	}
}
