package circular_linked_list;



public class CircularLinkedList {
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

	public CircularLinkedList() {
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
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			newNode.next = head;
			head = newNode;
		}		
		size++;
		if (head.next == head) tail = head;
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
			newNode.next = tail.next;
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
		if (index < 0 || index > size) {
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
			if (newNode.next == head) tail = newNode;
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
			if (head == head.next) tail = head;			
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
			if(prevNode.next == head) tail = prevNode;
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
		for (int i=0; i < getSize(); i++) {
			if (current.data == data) return i;
			current = current.next;			
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
		for (int i=0; i < getSize(); i++) {
			sbuf.append(current.data + " ");
			current = current.next;
		}		
		sbuf.append(" }");
		return sbuf.toString();
	}
}
