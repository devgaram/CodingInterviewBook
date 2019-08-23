package question;

import java.util.EmptyStackException;

/*
 * 스택 Min : 기본적인 push와 pop 기능이 구현된 스택에서 최솟값을 반환하는 min 함수를 추가하려고 한다.
 * 어떻게 설계할 수 있겠는가? push, pop, min 연산은 모두 O(1) 시간에 동작해야한다. --> 반복안됨.
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
