package doubly_linked_list;

import java.util.NoSuchElementException;


/*
 * 양방향 연결 리스트 구현
 */
public class DoublyLinkedList {
	// 첫번째 노드를 가리키는 참조값
		private Node head;
		// tail과 size를 사용하면 마지막 노드를 찾거나 크기를 구할 때 연산 횟수를 줄일 수 있다.
		private Node tail;
		private int size;
		
		class Node {
			private Object data;
			// 다음 노드 참조값
			private Node next;
			// 이전 노드 참조값
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
		 * index 위치의 Node 객체 얻기
		 * index >= list 크기/2 : 끝에서 부터 왼쪽으로
		 * index < list 크기/2 : 앞에서부터 오른쪽으로
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
		 * 리스트의 맨 앞에 새로운 노드 삽입
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
		 * 리스트의 맨 뒤에 새로운 노드 삽입
		 */
		public void addLast(Object data) {
			Node newNode = new Node(data);
			
			// 리스트에 노드가 없을 때
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
		 * 특정 위치(index)에 새로운 노드 삽입
		 * index >= 0
		 * index > list의 크기
		 * index == size 맨 뒤 삽입
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
		 * 맨 앞 노드 삭제
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
				if (deletedNode.next != null) deletedNode.next.prev = prevNode;
				deletedNode = null;
				size--;
				if(prevNode.next == null) tail = prevNode;
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
		 * 모든 노드 값 출력
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
		 * 반복 ListIterator 사용
		 * 모든 리스트의 값을 출력할 때
		 * for (int i = 0; i < size; i++) {
		 *  System.out.println(list.get(i));
		 * }
		 * 위와 같은 방식으로 출력하는 것은 get() 메서드 내부에서도 반복문을 실행하기 때문에 바람직하지않다.
		 * Iterator는 내부적으로 반복 처리 된 노드가 무엇인지에 대한 정보를 유지하므로 Iterator를 사용하는 것이 유리하다.
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
			 * 다음 노드 존재 여부(다음에 출력할 노드가 있는지 즉 현재 next의 위치가 null이 아닌지. 크기를 넘지 않는지.
			 */
			public boolean hasNext() {			
				return nextIndex < getSize();
			}
			
			/*
			 * 이전 노드 존재 여부
			 */
			public boolean hasPrevious() {			
				return nextIndex > 0;
			}
			
			/*
			 * 다음 노드의 값 리턴
			 * NoSuchElementException : 비어있는 공간의 값을 꺼내려고 하면 발생한다.
			 */
			public Object next() {
				if (next == null) {
					throw new NoSuchElementException("더 이상 반환할 노드가 없습니다.");
				} else {
					lastReturned = next;
					next = next.next;
					nextIndex++;			
					return lastReturned.data;
				}
				
			}
			
			/*
			 * 이전 노드의 값 리턴
			 * NoSuchElementException : 비어있는 공간의 값을 꺼내려고 하면 발생한다.
			 */
			public Object previous() {
				if (lastReturned.prev == null) {
					throw new NoSuchElementException("더 이상 반환할 노드가 없습니다.");
				} else {
					next = lastReturned;
					lastReturned = lastReturned.prev;
					nextIndex--;	
				}						
				return lastReturned.data;				
			}
			
			/*
			 * 가장 최근에 반환된 노드의 뒤에 데이터 삽입
			 */
			public void add(Object data) {

				Node newNode = new Node(data);
				// next() 한번도 호출 안되었을 때,
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
			 * 가장 최근에 반환된 노드 삭제
			 * IllegalStateException : 객체의 상태가 메소드 호출에는 부적절할 경우
			 */
			public void remove() {
				// next() 한번도 호출 안되었을 때, 아무런 element도 선택하지않은 상태
				if (nextIndex == 0) {
					throw new IllegalStateException();
				} 
				DoublyLinkedList.this.remove(nextIndex-1);
				nextIndex--;
			}
		}
}
