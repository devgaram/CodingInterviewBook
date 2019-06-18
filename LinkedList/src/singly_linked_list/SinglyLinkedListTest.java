package singly_linked_list;

import singly_linked_list.SinglyLinkedList.ListIterator;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();		
		System.out.println(list);
		list.addLast(10);
		list.addLast(20);
		System.out.println(list);
		list.addFirst(30);
		System.out.println(list);
		list.add(0,40);
		System.out.println(list);
		ListIterator li = list.listIterator();
		while(li.hasNext()){
		    if((int)li.next() == 10)
		        li.remove();
		    if((int)li.next() == 30)
		    	li.add(50);
		}
		System.out.println(list);
		
		list.addLast(10);
		System.out.println(list);

	}

}
