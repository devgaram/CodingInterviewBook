package question;

import java.util.*;

// # ≥ª«Æ¿Ã
public class Question02Stack {
	private int[] values;
	private int size = 100;
	private int top;
	private Stack<Integer> minStack;
	
	public Question02Stack() {
		values = new int[size];
		top = -1;
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (top < size) {
			if (minStack.isEmpty()) minStack.push(value);
			else {
				int min = minStack.peek();
				if (value < min) minStack.push(value);
				else minStack.push(min);
			}
			top++;
			values[top] = value;
			size++;
		}
	}
	
	public int pop() {
		if (top < 0) throw new EmptyStackException();
		int deletedData = values[top];
		values[top] = 0;
		top--;
		size--;
		minStack.pop();
		return deletedData;
	}
	
	public int min() {
		return minStack.peek();
	}
	
	public int peek() {
		if (top < 0) throw new EmptyStackException();
		int deletedData = values[top];
		return deletedData;
	}
	
	public String printStack() {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			strBuilder.append(values[i] + " ");
		}
		strBuilder.append("\n");
		return strBuilder.toString();
	}
}
