package question03;

/*
 * Q. 접시 무더기
 */

// 내풀이..popat을 구현할 슈가 없으.. stack을 따로 구현해야함.
import java.util.*;
import java.util.Stack;
public class Question03SetOfStacks {
	private ArrayList<Stack<Integer>> stacks;
	private int stackCapacity; // 각 스택마다 사이즈
	private int listTopIndex;	// 현재 탑
	private int size;	// 전체 사이즈
	
	public Question03SetOfStacks(int stackCapacity) {
		this.stacks = new ArrayList<Stack<Integer>>();
		this.stackCapacity = stackCapacity;	
		this.size = 0;
		this.listTopIndex = -1;
	}
	
	public void push(int value) {
		if (size % stackCapacity == 0) {
			Stack<Integer> stack = new Stack<Integer>();
			stacks.add(stack);
			listTopIndex++;
		}
		stacks.get(listTopIndex).push(value);
		size++;
	}
	
	public int pop() {
		if (stacks.isEmpty()) throw new EmptyStackException();
		Stack<Integer> currentStack = stacks.get(listTopIndex);
		int popValue = currentStack.pop();
		if (size % stackCapacity == 1) {
			stacks.remove(listTopIndex);
			listTopIndex--;
		}
		size--;
		return popValue;
	}
	
	// 특정한 하위 스택에 대해서 pop을 수행하는 함수를 구현하라
	public int popAt(int index) {
		return 0;
	}
	
	public String printStacks() {
		StringBuilder builder = new StringBuilder();
		for (Stack<Integer> stack : stacks) {
			builder.append(stack.toString() + "\n");
		}
		return builder.toString();
	}
	
	public class CustomStack {
		int top;
		int bottom;
		int size;
		
		public void push(int value) {
			
		}
	}
}
