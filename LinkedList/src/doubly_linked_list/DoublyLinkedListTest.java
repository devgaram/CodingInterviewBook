package doubly_linked_list;

import doubly_linked_list.DoublyLinkedList.ListIterator;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();		
		System.out.println(list);
		list.addLast(10);
		list.addLast(20);
		System.out.println(list);
		list.addFirst(30);
		System.out.println(list);
		list.add(0,40);
		System.out.println(list);
		list.add(4,50);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);

		
		ListIterator li = list.listIterator();
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.next()); li.add(10);
		System.out.println(list);
		System.out.println(li.previous()); li.add(10);
		
		       
		       
		  
		
		System.out.println(list);
	


	}

}
