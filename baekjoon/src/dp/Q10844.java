package dp;

import java.util.Scanner;

public class Q10844 {
	static int N;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		System.out.println(getCount());
	}
	
	public static long getCount() {
		long[][] D = new long[N+1][10];
		for (int i=1; i<10; i++) 
			D[1][i] = 1;
		
		for (int i=2; i<N+1; i++) {
			for (int j=0; j<10; j++) {
				if (j-1 >= 0) D[i][j] += D[i-1][j-1] % 1000000000;
				if (j+1 < 10) D[i][j] += D[i-1][j+1] % 1000000000;
			}
		}
		long count = 0;
		for (int i=0; i<10; i++)
			count += D[N][i] % 1000000000; 
		
		return count % 1000000000;
	}
}
