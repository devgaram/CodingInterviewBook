package stack;

import java.util.EmptyStackException;

public class Stack {
	private StackNode top;
	private int size;
	
	class StackNode {
		Object data;
		StackNode next;
		
		public StackNode(Object data) {
			this.data = data;
		}
		
		public String toString() {			
			return String.valueOf(this.data);
		}		
	}
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	// ������ ž ���� ����
	public Object pop() {
		if (top == null) 
			throw new EmptyStackException();
		else {
			StackNode deletedNode = top;
			Object deletedData = deletedNode.data;
			top = deletedNode.next;
			deletedNode = null;	
			size--;
			return deletedData;
		}			
	}
	
	// ������ ž ��ġ�� ������ ����
	public void push(Object item) {
		StackNode newNode = new StackNode(item);		
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	// ������ ž ���� ���ž��� ��ȯ
	public Object peek() {
		if (top == null) 
			throw new EmptyStackException();
		else 
			return top.data;		
	}
	
	// ���� �� ����
	public boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		StackNode current = top;
		StringBuffer sbuf = new StringBuffer("TOP \n");
		while (current != null) {
			sbuf.append(current.data + " \n");
			current = current.next;
		}
		sbuf.append("BOTTOM ");
		return sbuf.toString();
	}
	
	public int search(Object o) {
		StackNode current = top;
		int index=0;
		while (current != null) {
			if (current.data == o) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
}
