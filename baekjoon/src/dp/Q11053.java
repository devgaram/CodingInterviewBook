package dp;
/*
 * LIS : ���� ���� �κм���, ������ ������ �־����� ��, �ش� �������� �� ���� ������ �̾� ���� �κм��� �� ������������ ���ĵ� ���� �� ����
 * DP O(n2)
 * Binary Search O(nlogn)
 * Segment Tree O(nlogn)
 */
import java.util.*;
public class Q11053 {
	static int[] set;
	static int N;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		set = new int[N+1];
		for (int i=1; i<N+1; i++) {
			set[i] = sc.nextInt();
		}
		System.out.println(getMaxLength());
		
	}
	
	public static int getMaxLength() {
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		int max = 0;
		for (int i=2; i<N+1; i++) {
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (set[j] < set[i] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
				else if (set[j] == set[i]) dp[i] = dp[j];
			}
		}
		for (int i=1; i<N+1; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		return max;
	}
}
