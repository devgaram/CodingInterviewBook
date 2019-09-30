package question;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1912 {
	static int N;
	static int[] number;
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		number = new int[N+1];
		String[] strs = in.readLine().split(" ");
		for (int i=1; i<N+1; i++)
			number[i] = Integer.parseInt(strs[i-1]);
		
		out.write(getMaxSum()+ "");
		out.close();
		in.close();
	}
	public static int getMaxSum() {
		int[] DP = new int[N+1];
		int max = number[1];
		for (int i=1; i<N+1; i++) {
			if (DP[i-1] < 0) DP[i] = number[i];
			else DP[i] = DP[i-1] + number[i];
			if (max < DP[i]) max = DP[i];
		}		
				
		return max;
	}
}
