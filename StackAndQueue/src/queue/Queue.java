package queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;


public class Queue {
	private QueueNode first;
	private QueueNode last;
	private int size;
	
	class QueueNode {
		Object data;
		QueueNode next;
		
		public QueueNode(Object data) {
			this.data = data;
		}
		
		public String toString() {			
			return String.valueOf(this.data);
		}		
	}
	
	public Queue() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void add(Object item) {
		QueueNode newNode = new QueueNode(item);
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;			
		}	
		size++;
	}
	
	public Object remove() {
		if (first == null) 
			throw new NoSuchElementException();
		else {
			QueueNode deletedNode = first;
			Object deletedData = deletedNode.data;
			first = deletedNode.next;
			deletedNode = null;
			if (first == null) last = first;
			size--;
			return deletedData;
		}
	}
	
	public Object peek() {
		if (first == null) 
			throw new NoSuchElementException();
		else 		
			return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
		
	public String toString() {
		QueueNode current = first;
		StringBuffer sbuf = new StringBuffer("first ");
		while (current != null) {
			sbuf.append(current.data + " ");
			current = current.next;
		}
		sbuf.append("last ");
		return sbuf.toString();
	}
	
	public int search(Object o) {
		QueueNode current = first;
		int index=0;
		while (current != null) {
			if (current.data == o) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
}
