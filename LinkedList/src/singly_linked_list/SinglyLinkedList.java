package singly_linked_list;

import java.util.NoSuchElementException;

/*
 * �ܹ��� ���Ḯ��Ʈ
 */
public class SinglyLinkedList {
	// ù��° ��带 ����Ű�� ������
	private Node head;
	// tail�� size�� ����ϸ� ������ ��带 ã�ų� ũ�⸦ ���� �� ���� Ƚ���� ���� �� �ִ�.
	private Node tail;
	private int size;
	
	class Node {
		private Object data;
		// ���� ��� ������
		private Node next;
		
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	 * index ��ġ�� Node ��ü ���
	 */
	public Node getNode(int index) {
		Node returnNode = head;
		for(int i = 0; i < index; i++) {
			returnNode = returnNode.next;
		}
		return returnNode;
	}
	
	/*
	 * ����Ʈ�� �� �տ� ���ο� ��� ����
	 */
	public void addFirst(Object data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) tail = head;
	}
	
	/*
	 * ����Ʈ�� �� �ڿ� ���ο� ��� ����
	 */
	public void addLast(Object data) {
		Node newNode = new Node(data);
		
		// ����Ʈ�� ��尡 ���� ��
		if (size == 0){
			addFirst(data);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}		
	}
	
	/*
	 * Ư�� ��ġ(index)�� ���ο� ��� ����
	 * index >= 0
	 * index > list�� ũ��
	 */
	public void add(int index, Object data) {
		if (index < 0 || index >= size) {
			// ���� ���� �߻���Ű��
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		} else if (index == 0) {
			addFirst(data);
		} else {
			Node newNode = new Node(data);
			Node prevNode = getNode(index-1);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
			size++;
			if (newNode.next == null) tail = newNode;
		}
	}
	
	/*
	 * �� �� ��� ����
	 */	
	public Object removeFirst() {
		if (head != null) {
			Node deletedNode = head;
			Object deletedData = deletedNode.data;
			head = deletedNode.next;
			deletedNode = null;
			size--;
			if (head == null) tail = null;			
			return deletedData;
		} else return -1;
	}
	
	/*
	 * Ư�� ��ġ(index)�� ��� ����
	 * index >= 0
	 * index > list�� ũ��
	 */
	public Object remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		} else if (index == 0) {
			return removeFirst();
		} else {
			Node prevNode = getNode(index-1);
			Node deletedNode = prevNode.next;
			Object deletedData = deletedNode.data;
			prevNode.next = deletedNode.next;
			deletedNode = null;
			size--;
			if(prevNode.next == null) tail = prevNode;
			return deletedData;
		}		
	}
	
	/*
	 * ������ ��� ����
	 */
	public Object removeLast() {
		return remove(size-1);
	}
	
	/*
	 * ����Ʈ ũ�� ���
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * index ��ġ�� ������ ���
	 */
	public Object get(int index) {
		return getNode(index).data;
	}
	
	/*
	 * Ư�� �������� index ���
	 */
	public int indexOf(Object data) {
		Node current = head;
		int index = 0;
		while (current != null) {
			if (current.data == data) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * ��� ��� �� ���
	 */
	public String toString() {
		StringBuffer sbuf = new StringBuffer("List{ ");
		Node current = head;
		while (current != null) {
			sbuf.append(current.data + " ");
			current = current.next;
		}
		sbuf.append(" }");
		return sbuf.toString();
	}
	
	/*
	 * �ݺ� Iterator ���
	 * ��� ����Ʈ�� ���� ����� ��
	 * for (int i = 0; i < size; i++) {
	 *  System.out.println(list.get(i));
	 * }
	 * ���� ���� ������� ����ϴ� ���� get() �޼��� ���ο����� �ݺ����� �����ϱ� ������ �ٶ��������ʴ�.
	 * Iterator�� ���������� �ݺ� ó�� �� ��尡 ���������� ���� ������ �����ϹǷ� Iterator�� ����ϴ� ���� �����ϴ�.
	 */
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	class ListIterator{
		private Node lastReturned;
		private Node next;
		private int nextIndex;
		
		public ListIterator() {
			next = head;
			nextIndex = 0;	
			lastReturned = null;
		}
		
		/*
		 * ���� ��� ���� ����
		 */
		public boolean hasNext() {			
			return nextIndex < getSize();
		}
		
		/*
		 * ���� ����� �� ����
		 * NoSuchElementException : ����ִ� ������ ���� �������� �ϸ� �߻��Ѵ�.
		 */
		public Object next() {
			if (next == null) {
				throw new NoSuchElementException("���� ���� �������� �ʽ��ϴ�.");
			} else {
				lastReturned = next;
				next = next.next;
				nextIndex++;			
				return lastReturned.data;
			}
			
		}
		
		/*
		 * ���� �ֱٿ� ��ȯ�� ����� �ڿ� ������ ����
		 */
		public void add(Object data) {
			Node newNode = new Node(data);
			// next() �ѹ��� ȣ�� �ȵǾ��� ��,
			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				newNode.next = next;
				lastReturned.next = newNode;				
			}
			nextIndex++;
			size++;
			lastReturned = newNode;	
			if (newNode.next == null) tail = newNode;
		}
		
		/*
		 * ���� �ֱٿ� ��ȯ�� ��� ����
		 * IllegalStateException : ��ü�� ���°� �޼ҵ� ȣ�⿡�� �������� ���
		 */
		public void remove() {
			// next() �ѹ��� ȣ�� �ȵǾ��� ��, �ƹ��� element�� ������������ ����
			if (nextIndex == 0) {
				throw new IllegalStateException();
			} 
			SinglyLinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
	
	
	
}
