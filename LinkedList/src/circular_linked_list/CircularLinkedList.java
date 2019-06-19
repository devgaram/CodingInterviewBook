package circular_linked_list;



public class CircularLinkedList {
	// 첫번째 노드를 가리키는 참조값
	private Node head;
	// tail과 size를 사용하면 마지막 노드를 찾거나 크기를 구할 때 연산 횟수를 줄일 수 있다.
	private Node tail;
	private int size;

	class Node {
		private Object data;
		// 다음 노드 참조값
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
	 * index 위치의 Node 객체 얻기
	 */
	public Node getNode(int index) {
		Node returnNode = head;
		for(int i = 0; i < index; i++) {
			returnNode = returnNode.next;
		}
		return returnNode;
	}

	/*
	 * 리스트의 맨 앞에 새로운 노드 삽입
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
	 * 리스트의 맨 뒤에 새로운 노드 삽입
	 */
	public void addLast(Object data) {
		Node newNode = new Node(data);
		// 리스트에 노드가 없을 때
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
	 * 특정 위치(index)에 새로운 노드 삽입
	 * index >= 0
	 * index > list의 크기
	 */
	public void add(int index, Object data) {
		if (index < 0 || index > size) {
			// 강제 예외 발생시키기
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
	 * 맨 앞 노드 삭제
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
	 * 특정 위치(index)의 노드 삭제
	 * index >= 0
	 * index > list의 크기
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
	 * 마지막 노드 삭제
	 */
	public Object removeLast() {
		return remove(size-1);
	}

	/*
	 * 리스트 크기 출력
	 */
	public int getSize() {
		return size;
	}

	/*
	 * index 위치의 데이터 출력
	 */
	public Object get(int index) {
		return getNode(index).data;
	}

	/*
	 * 특정 데이터의 index 출력
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
	 * 모든 노드 값 출력
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
