package question;

import java.util.EmptyStackException;

/*
 * ���� Min : �⺻���� push�� pop ����� ������ ���ÿ��� �ּڰ��� ��ȯ�ϴ� min �Լ��� �߰��Ϸ��� �Ѵ�.
 * ��� ������ �� �ְڴ°�? push, pop, min ������ ��� O(1) �ð��� �����ؾ��Ѵ�. --> �ݺ��ȵ�.
 */
public class Question02 {
	
	public static void main(String[] args) {
		Question02Stack stack = new Question02Stack();
		stack.push(5);
		System.out.println(stack.min());
		stack.push(4);
		System.out.println(stack.min());
		stack.push(6);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		stack.push(7);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
	
	
}
