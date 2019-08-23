package question;

/*
 * Q. 중복 없애기 : 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라.
 * 연관문제 ) 임시 버퍼를 사용할 수 없다면 어떻게 풀 수 있을까?
 */
import java.util.*;
public class Question01 {

	public static void main(String[] args) {
		// 라이브러리 사용시
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(5);
		list.add(4);
		printList(list);
		removeDuplicate(list);
		printList(list);

		// 직접 연결리스트 구현		
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
		removeDuplicateNoBuffer(head);
		printListNode(head);

	}

	// 라이브러리 O, 버퍼 O
	public static void removeDuplicate(LinkedList<Integer> list) {
		HashSet<Integer> hashSet = new HashSet<>();

		Iterator<Integer> iterator = list.iterator();
		int value = 0;

		while(iterator.hasNext()) {
			value = iterator.next();
			if (hashSet.contains(value)) {
				iterator.remove();
			} else {
				hashSet.add(value);
			}
		}
	}

	// 라이브러리 X, 버퍼 O
	// 시간복잡도 : O(n)
	public static void removeDuplicate2(LinkedListNode head) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		LinkedListNode node = head;
		LinkedListNode preNode = head;

		while (node != null) {
			if (hashSet.contains(node.data)) {
				preNode.next = node.next;		
			} else {
				hashSet.add(node.data);
				preNode = node;
			}
			node = node.next;

		}
	}

	// 라이브러리 X, 버퍼 X
	// 시간복잡도 : O(n^2) 공간복잡도 : O(1)
	public static void removeDuplicateNoBuffer(LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode node = head;
		LinkedListNode preNode = head;

		while (current != null) {			
			node = current.next;
			preNode = current;
			while (node != null) {
				if (current.data == node.data) {
					preNode.next = node.next;
				} 
				node = node.next;
			}
			
			current = current.next;
		}
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
