package question03;

import java.util.EmptyStackException;

public class Stack {
	private int capacity;
	private Node top;
	private int size;
	private Node bottom;

	public class Node {
		Node prev;
		int data;
		Node next;

		public Node(int value) {
			data = value;
		}

		public String toString() {
			return String.valueOf(data);
		}
	}

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean push(int value) {
		if (size >= capacity) return false;
		
		Node newNode = new Node(value);			
		
		if (size == 0) { // ∫Û Ω∫≈√
			bottom = newNode;			
		} else {
			top.prev = newNode;
		}
		
		newNode.next = top;
		top = newNode;
		size++;	
		return true;
	}

	public int pop() {
		if (size == 0) throw new EmptyStackException();
		Node popNode = top;
		int popValue = popNode.data;
		top.next.prev = null;
		top = top.next;
		popNode = null;
		size --;
		return popValue;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}

	public int removeBottom() {
		if (size == 0) throw new EmptyStackException();		
		Node returnValue = bottom;
		bottom = bottom.prev;
		if (bottom != null) bottom.next = null;
		size--;
		return returnValue.data;
	}




}
