package question;

/*
 * Q. �� ���� �� �� : �迭 �Ѱ��� ���� �� ���� ��� �������� �����϶�.
 * 
 * A.
 * **1) �� ������ ����ũ�⸦ �����ٰ� ����
 * 2) �� ������ ũ�Ⱑ �����ϰ� ���ϴ� ���
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
