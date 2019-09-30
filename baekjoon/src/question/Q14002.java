package question;


import java.util.Scanner;
import java.util.Stack;

public class Q14002 {
	static int[] set;
	static int N;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		set = new int[N+1];
		for (int i=1; i<N+1; i++) {
			set[i] = sc.nextInt();
		}
		getMaxLength();		
	}
	public static void getMaxLength() {
		int[] dp = new int[N+1];
		int[][] vector = new int[4][N+1];
		int len = 0;
		for (int i=1; i<N+1; i++) {
			for (int j=len; j>=0; j--) {
				if (vector[1][j] < set[i]) {
					vector[2][j+1] = vector[2][j] + 1;
					dp[i] = vector[2][j] + 1;
					vector[1][j+1] = set[i];
					if (vector[3][j+1] == 0 ) vector[3][j+1] = set[i];
					if (len < j+1) len = j+1;
					break;
				}
			}
		}
		System.out.println(len);
		
		Stack stack = new Stack();
		for (int i=N; i>0; i--) {
			if (dp[i] == len) {
				stack.add(set[i]);
				len--;
			}
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() +" ");
		}
		System.out.println();
	}	
	
}
