package doubly_linked_list;

import java.util.NoSuchElementException;


/*
 * ����� ���� ����Ʈ ����
 */
public class DoublyLinkedList {
	// ù��° ��带 ����Ű�� ������
		private Node head;
		// tail�� size�� ����ϸ� ������ ��带 ã�ų� ũ�⸦ ���� �� ���� Ƚ���� ���� �� �ִ�.
		private Node tail;
		private int size;
		
		class Node {
			private Object data;
			// ���� ��� ������
			private Node next;
			// ���� ��� ������
			private Node prev;
			
			public Node(Object data) {
				this.data = data;
				this.next = null;
				this.prev = null;
			}
			
			public Node(Object data, Node next) {
				this.data = data;
				this.next = next;
			}
			
			public String toString() {
				return String.valueOf(this.data);
			}
		}
		
		public DoublyLinkedList() {
			head = null;
			tail = null;
			size = 0;
		}
		
		/*
		 * index ��ġ�� Node ��ü ���
		 * index >= list ũ��/2 : ������ ���� ��������
		 * index < list ũ��/2 : �տ������� ����������
		 */
		public Node getNode(int index) {
			if (index < size/2) {
				Node returnNode = head;
				for(int i = 0; i < index; i++) {
					returnNode = returnNode.next;
				}
				return returnNode;
			} else {
				Node returnNode = tail;
				for(int i = size-1; i > index; i--) {
					returnNode = returnNode.prev;
				}
				return returnNode;
			}
		}
		
		/*
		 * ����Ʈ�� �� �տ� ���ο� ��� ����
		 */
		public void addFirst(Object data) {
			Node newNode = new Node(data);
			newNode.next = head;
			if (head != null) head.prev = newNode;			
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
				newNode.prev = tail;
				tail = newNode;
				size++;
			}		
		}
		
		/*
		 * Ư�� ��ġ(index)�� ���ο� ��� ����
		 * index >= 0
		 * index > list�� ũ��
		 * index == size �� �� ����
		 */
		public void add(int index, Object data) {
			if (index < 0 || index > size) {
				// ���� ���� �߻���Ű��
				throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
			} else if (index == 0) {
				addFirst(data);
			} else {
				Node newNode = new Node(data);
				Node prevNode = getNode(index-1);
				Node currentNode = prevNode.next;
				
				prevNode.next = newNode;
				newNode.next = currentNode;
				
				if (currentNode != null) currentNode.prev = newNode;
				
				newNode.prev = prevNode;
				
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
				if (head == null) {
					tail = null;			
				} else {
					head.prev = null;
				}
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
				if (deletedNode.next != null) deletedNode.next.prev = prevNode;
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
		 * �ݺ� ListIterator ���
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
			 * ���� ��� ���� ����(������ ����� ��尡 �ִ��� �� ���� next�� ��ġ�� null�� �ƴ���. ũ�⸦ ���� �ʴ���.
			 */
			public boolean hasNext() {			
				return nextIndex < getSize();
			}
			
			/*
			 * ���� ��� ���� ����
			 */
			public boolean hasPrevious() {			
				return nextIndex > 0;
			}
			
			/*
			 * ���� ����� �� ����
			 * NoSuchElementException : ����ִ� ������ ���� �������� �ϸ� �߻��Ѵ�.
			 */
			public Object next() {
				if (next == null) {
					throw new NoSuchElementException("�� �̻� ��ȯ�� ��尡 �����ϴ�.");
				} else {
					lastReturned = next;
					next = next.next;
					nextIndex++;			
					return lastReturned.data;
				}
				
			}
			
			/*
			 * ���� ����� �� ����
			 * NoSuchElementException : ����ִ� ������ ���� �������� �ϸ� �߻��Ѵ�.
			 */
			public Object previous() {
				if (lastReturned.prev == null) {
					throw new NoSuchElementException("�� �̻� ��ȯ�� ��尡 �����ϴ�.");
				} else {
					next = lastReturned;
					lastReturned = lastReturned.prev;
					nextIndex--;	
				}						
				return lastReturned.data;				
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
					newNode.prev = lastReturned;
					lastReturned.next = newNode;
					if (next != null) {
						next.prev = newNode;
						newNode.next = next;
					}
					
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
				DoublyLinkedList.this.remove(nextIndex-1);
				nextIndex--;
			}
		}
}
