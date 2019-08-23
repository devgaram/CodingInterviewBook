package question;

/*
 * Q. �ߺ� ���ֱ� : ���ĵǾ� ���� ���� ���Ḯ��Ʈ�� �־����� �� �� ����Ʈ���� �ߺ��Ǵ� ���Ҹ� �����ϴ� �ڵ带 �ۼ��϶�.
 * �������� ) �ӽ� ���۸� ����� �� ���ٸ� ��� Ǯ �� ������?
 */
import java.util.*;
public class Question01 {

	public static void main(String[] args) {
		// ���̺귯�� ����
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

		// ���� ���Ḯ��Ʈ ����		
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

	// ���̺귯�� O, ���� O
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

	// ���̺귯�� X, ���� O
	// �ð����⵵ : O(n)
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

	// ���̺귯�� X, ���� X
	// �ð����⵵ : O(n^2) �������⵵ : O(1)
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
