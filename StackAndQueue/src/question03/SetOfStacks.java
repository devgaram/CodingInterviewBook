package question03;

import java.util.*;
import question03.Stack;
public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if (stacks.size() == 0) return null;
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int value) {
		Stack lastStack = getLastStack();
		if (lastStack != null && !lastStack.isFull()) {
			lastStack.push(value);
		} else {
			lastStack = new Stack(capacity);
			stacks.add(lastStack);
			lastStack.push(value);
		}		
	}
	
	public int pop() {
		Stack lastStack = getLastStack();
		if (lastStack == null) throw new EmptyStackException();
		int popValue = lastStack.pop();
		if (lastStack.isEmpty()) stacks.remove(stacks.size()-1);
		return popValue;
	}
	
	public int popAt(int index) {
		
		return 0;
	}
	
}
