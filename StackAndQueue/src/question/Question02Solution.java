package question;

/*
 * 책 풀이 ) 내 풀이에서는 stack에 push 할때마다, minstack에도 비교연산 후 push 했는데,
 * 책 풀이에서는 최소값보다 작거나 같을 때만 push 한다.
 * pop에서는 min과 pop한 값이 같을 때만 minstack을 pop한다.
 * 이때 push 할 때, min과 value의 값이 같을 때도 push를 해야 같은 최소값을 여러개 push 했을 때를 방지할 수 있다.
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
