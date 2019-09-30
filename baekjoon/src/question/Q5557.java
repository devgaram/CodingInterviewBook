package question;


import java.util.Scanner;

// 2^63 이라서 변수로 long 써야함.

public class Q5557 {
	static int[] numbers;
	static int N;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for (int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(getCountEquality());
		
	}
	
	public static long getCountEquality() {
		long[][] memo = new long[N][21];
		memo[0][numbers[0]] = 1;

		for (int i=1; i<N; i++) {		
			
			for (int j=0; j<21; j++) {
				if (memo[i-1][j] > 0) {
					if (j + numbers[i] < 21) {
						memo[i][j + numbers[i]] += memo[i-1][j];
					}
					if (j - numbers[i] >= 0) {
						memo[i][j - numbers[i]] += memo[i-1][j];
					}
				}
			}
		}
		
		return memo[N-2][numbers[N-1]];
	}
	
}
