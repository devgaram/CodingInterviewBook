package question;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2156 {
	static int N;
	static int[] wine;
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		wine = new int[N+1];
		for (int i=1; i<N+1; i++)
			wine[i] = Integer.parseInt(in.readLine());
		
		out.write(getAmountWine()+ "");
		out.close();
		in.close();
	}
	
	public static long getAmountWine(){
		if (N == 1) return wine[1];
		if (N == 2) return wine[1] + wine[2];
		
		long[] D = new long[N+1];
		D[1] = wine[1];
		D[2] = wine[1] + wine[2];
		long max = D[2];
		for (int i=3; i<N+1; i++) {
			D[i] = wine[i-1] + D[i-3] > D[i-2] ? wine[i-1] + D[i-3] + wine[i] : D[i-2] + wine[i];
			if (D[i] < D[i-1]) D[i] = D[i-1];
			if (max < D[i]) max = D[i];			
		}
		return max;
	}
}
