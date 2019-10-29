package baekjoon;


import java.util.*;
public class Q1463 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.print(getMinMakeOne(N));
	}
	
	public static int getMinMakeOne(int N) {
		int[] DP = new int[N+1];
		DP[1] = 0;
		int min;
		for (int i=2; i<N+1; i++) {
			min = DP[i-1] + 1;
			if (i%2 == 0) {
				min = min > DP[i/2] + 1 ? DP[i/2] + 1 : min;
			}
			if (i%3 == 0) {
				min = min > DP[i/3] + 1 ? DP[i/3] + 1 : min;
			}
			DP[i] = min;
		}
		return DP[N];
	}
}
