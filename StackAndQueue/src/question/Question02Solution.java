package question;

/*
 * å Ǯ�� ) �� Ǯ�̿����� stack�� push �Ҷ�����, minstack���� �񱳿��� �� push �ߴµ�,
 * å Ǯ�̿����� �ּҰ����� �۰ų� ���� ���� push �Ѵ�.
 * pop������ min�� pop�� ���� ���� ���� minstack�� pop�Ѵ�.
 * �̶� push �� ��, min�� value�� ���� ���� ���� push�� �ؾ� ���� �ּҰ��� ������ push ���� ���� ������ �� �ִ�.
 */
import java.util.*;
public class Question02Solution extends Stack<Integer> {
	Stack<Integer> minStack;
	
	public Question02Solution() {
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		int min = min();
		if (value <= min) minStack.push(value);
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) minStack.pop();		
		return super.pop();
	}
	
	public int min() {
		if (minStack.empty()) return Integer.MAX_VALUE;
		return minStack.peek();
	}
}
