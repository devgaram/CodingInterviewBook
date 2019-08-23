package question;

import java.util.EmptyStackException;

// 각 스택마다 고정크기 할당
public class FixedMultiStack {
	private int numberOfStacks = 3;
	private int[] values;
	private int[] sizes;
	private int[] top;
	private int stackSize;
	
	public FixedMultiStack(int stackSize) {
		this.stackSize = stackSize;
		values = new int[stackSize*numberOfStacks];
		sizes = new int[numberOfStacks];
		top = new int[numberOfStacks];
		setDefaultTop(stackSize);
	}
	
	public void setDefaultTop(int stackSize) {
		for (int i = 0; i < numberOfStacks; i++) {
			top[i] = i * stackSize - 1;
		}
		
	}
	
	public void push(int stackNum, int value) {
		if (sizes[stackNum] < stackSize) {
			values[top[stackNum] + 1] = value;
			sizes[stackNum]++;
			top[stackNum]++;
		}
	}
	
	public int pop(int stackNum) {
		if (sizes[stackNum] == 0) throw new EmptyStackException();
		int deletedData = values[top[stackNum]];
		values[top[stackNum]] = 0;
		sizes[stackNum]--;
		top[stackNum]--;
		
		return deletedData;
	}
	
	public int peek(int stackNum) {
		if (sizes[stackNum] == 0) throw new EmptyStackException();
		int deletedData = values[top[stackNum]];	
		
		return deletedData;
	}
	
	public boolean isEmpty(int stackNum) {
		if (sizes[stackNum] == 0) return true;
		else return false;
	}
	
	public String printValuesOfStack(int stackNum) {
		StringBuilder strBuilder = new StringBuilder(stackNum + " : ");
		for (int i = stackNum * stackSize; i < stackNum * stackSize + stackSize; i++) {
			strBuilder.append(values[i] + " ");
		}
		strBuilder.append("\n");
		return strBuilder.toString();
	}
	
	
}
