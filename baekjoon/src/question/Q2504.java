package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		System.out.println(solution(str));
	}
	public static int solution(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[') {
				stack.add((int) str.charAt(i));
			} else if (str.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
						stack.add(2);
					} else if (isDigit(stack.peek())) {
						int num = stack.pop(); 
						while (!stack.isEmpty()) {
							if (isDigit(stack.peek())) {
								num += stack.pop(); 
							} else if (stack.peek() == '(') {
								stack.pop();
								stack.add(num*2);
								break;
							} else {
								stack.add((int) str.charAt(i));
								break;
							}
						}						
					}
				} else
					stack.add((int) str.charAt(i));
				
			} else if (str.charAt(i) == ']') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '[') {
						stack.pop();
						stack.add(3);
					} else if (isDigit(stack.peek())) {
						int num = stack.pop();
						while (!stack.isEmpty()) {
							if (isDigit(stack.peek())) {
								num += stack.pop(); 
							} else if (stack.peek() == '[') {
								stack.pop();
								stack.add(num*3);
								break;
							} else {
								stack.add((int) str.charAt(i));
								break;
							}
						}
					}
				}
				 else
					stack.add((int) str.charAt(i));
			}
		}
		int ans = 0;
		while (!stack.isEmpty()) {
			if (isDigit(stack.peek())) {
				ans += stack.pop();
			} else return 0;
		}
		return ans;
	}
	
	public static boolean isDigit(int c) {
		if (c == '(' || c == '[' || c == ')' || c == ']') return false;
		return true;
	}
}
