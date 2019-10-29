package baekjoon;


import java.util.Scanner;

public class Q11054 {
	static int N;
	static int[] set;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		set = new int[N+1];
		for (int i=1; i<N+1; i++) {
			set[i] = sc.nextInt();
		}
		System.out.println(getBitonic());		
	}
	
	public static int getBitonic() {
		int[] dp_up = new int[N+1];
		int[][] vector = new int[3][N+1];
		int upLen = 0;
		for (int i=1; i<N+1; i++) {
			for (int j=upLen; j>=0; j--) {
				if (vector[1][j] < set[i]) {
					vector[2][j+1] = vector[2][j] + 1;
					dp_up[i] = vector[2][j] + 1;
					vector[1][j+1] = set[i];
					if (upLen < j+1) upLen = j+1;
					break;
				}
			}
		}

		int[] dp_down = new int[N+1];
		vector = new int[3][N+1];
		int downLen = 0;
		for (int i=N; i>=0; i--) {
			for (int j=downLen; j>=0; j--) {
				if (vector[1][j] < set[i]) {
					vector[2][j+1] = vector[2][j] + 1;
					dp_down[i] = vector[2][j] + 1;
					vector[1][j+1] = set[i];
					if (downLen < j+1) downLen = j+1;
					break;
				}
			}
		}
		
		
		
		for (int i=1; i<N+1; i++)
			System.out.print(dp_up[i] + " ");
		System.out.println();
		
		for (int i=1; i<N+1; i++)
			System.out.print(dp_down[i] + " ");
		System.out.println();
		
		int maxLen = 0;
		for (int i=1; i<N+1; i++) {
			if (maxLen < dp_up[i] + dp_down[i]) maxLen = dp_up[i] + dp_down[i];
		}
		
		
		return maxLen - 1;
		
	}
}
