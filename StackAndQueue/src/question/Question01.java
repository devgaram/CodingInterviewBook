package question;

/*
 * Q. 한 개로 세 개 : 배열 한개로 스택 세 개를 어떻게 구현할지 설명하라.
 * 
 * A.
 * **1) 각 스택이 고정크기를 가진다고 가정
 * 2) 각 스택의 크기가 유연하게 변하는 방법
 */
import java.util.*;
public class Question01 {
	
	public static void main(String[] args) {
		FixedMultiStack fixedMultiStack = new FixedMultiStack(10);
		System.out.println(fixedMultiStack.printValuesOfStack(0));
		System.out.println(fixedMultiStack.printValuesOfStack(1));
		System.out.println(fixedMultiStack.printValuesOfStack(2));
		fixedMultiStack.push(0, 1);
		fixedMultiStack.push(1, 11);
		fixedMultiStack.push(0, 2);
		fixedMultiStack.push(2, 22);
		fixedMultiStack.push(2, 25);
		fixedMultiStack.push(2, 27);
		fixedMultiStack.push(1, 13);
		System.out.println(fixedMultiStack.printValuesOfStack(0));
		System.out.println(fixedMultiStack.printValuesOfStack(1));
		System.out.println(fixedMultiStack.printValuesOfStack(2));
		fixedMultiStack.pop(1);
		fixedMultiStack.pop(1);
		System.out.println(fixedMultiStack.printValuesOfStack(0));
		System.out.println(fixedMultiStack.printValuesOfStack(1));
		System.out.println(fixedMultiStack.printValuesOfStack(2));
		
	}
}
