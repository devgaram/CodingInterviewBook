package question;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11066 {
	static int[][] dp;
	static int[] sum;
	static int[] intFiles;
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		int K;
		String[] files;
		for (int i=1; i<T+1; i++) {
			K = Integer.parseInt(in.readLine());
			files = in.readLine().split(" ");			
			out.write(getMinCost(K, files)+ "\n");
		}
		
		
		out.close();
		in.close();
	}
	
	public static int getMinCost(int K, String[] files) {
		dp = new int[K+1][K+1];
		intFiles = new int[K+1];
		sum = new int[K+1];
		for (int i=1; i<K+1; i++) {
			intFiles[i] = Integer.parseInt(files[i-1]);
			sum[i] = sum[i-1] + intFiles[i];
		}
		for (int i=1; i<K+1; i++) {
			for (int j=1; j<K+1; j++)
				dp[i][j] = Integer.MAX_VALUE;
		}
		return getMinCostBinary(1, K);
	}
	
	public static int getMinCostBinary(int start, int end) {
		if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
		// K = 1, 비용 = 0
		if (start == end) return dp[start][end] = 0;
		// K = 2, 비용 = intFiles[1] + intFiles[2];
		if (start + 1 == end) return dp[start][end] = intFiles[start] + intFiles[end];
		
		// K = 3 이상, 쪼갠다!!! 
		// 만약 DP(1,4)이면
		/* 예) 40 30 30 50
		 * DP(1,1) + DP(2,4) + SUM(1,4) => DP(1,1) + { DP(2,2) + DP(3,4) + SUM(2,4) } + SUM(1,4) => 0 + { 0 + 80 + 110 } + 150 = 340
		 * DP(1,2) + DP(3,4) + SUM(1,4) => DP(1,2) + DP(3,4) + SUM(1,4) => 70 + 80 + 150 = 310
		 * DP(1,3) + DP(4,4) + SUM(1,4) => { DP(1,1) + DP(2,3) + SUM(1,3) } + DP(4,4) + SUM(1,4) => { 0 + 60 + 100 } + 0 + 150 = 310
		 * 중 최소값인 310이 DP(1,4)!!!!!!
		 */
		for (int mid=start; mid<end; mid++) {
			int left = getMinCostBinary(start, mid);
			int right = getMinCostBinary(mid+1, end);
			dp[start][end] = Math.min(dp[start][end], left+right);
			
		}
		return dp[start][end] += sum[end]-sum[start-1];
	}
}
