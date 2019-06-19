package circular_linked_list;


public class CircularLinkedListTest {

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();		
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
		list.remove(2);
		System.out.println(list);
		System.out.println(list.indexOf(10));

		
	

	}

}
