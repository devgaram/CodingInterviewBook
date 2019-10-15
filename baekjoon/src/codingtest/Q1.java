package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(in.readLine());
		//String[] size = in.readLine().split(" ");
		int[] a = solution(N);
		for (int i=0; i<2; i++)
			System.out.print(a[i] + " ");
		in.close();
	}
	/*
	 * 10 /4 = 2 ....2
	 */
	
	public static int[] solution(int N) {
		int[] answer = new int[2];
		int K = 0;
		int r;
		int MAX = Integer.MIN_VALUE;
		for (int i=2; i<10; i++) {
			int M = N;
			int val = 1;
			System.out.print(i + " : ");
			while (M >= i) {
				r = M % i;
				if (r > 0) {
					val = val * r;
					System.out.print(r + " ");
				}
				M = M/i;					
			}
			val *=M;
			System.out.print(M + " ");
			System.out.println("гу:" + val);
			if (MAX <= val) {
				MAX = val;
				K = i;
			}
		}
		answer[0] = K;
		answer[1] = MAX;
		return answer;
	}
}
