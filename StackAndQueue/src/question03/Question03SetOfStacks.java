package question03;

/*
 * Q. ���� ������
 */

// ��Ǯ��..popat�� ������ ���� ����.. stack�� ���� �����ؾ���.
import java.util.*;
import java.util.Stack;
public class Question03SetOfStacks {
	private ArrayList<Stack<Integer>> stacks;
	private int stackCapacity; // �� ���ø��� ������
	private int listTopIndex;	// ���� ž
	private int size;	// ��ü ������
	
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
	
	// Ư���� ���� ���ÿ� ���ؼ� pop�� �����ϴ� �Լ��� �����϶�
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
