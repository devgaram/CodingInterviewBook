package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2293 {
	static int[] coin;
	static int N;
	static int K;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strs = in.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		coin = new int[N+1];
		for (int i=1; i<N+1; i++)
			coin[i] = Integer.parseInt(in.readLine());
		
		out.write(getCountCoin() + "");
		out.close();
		in.close();
	}
	
	public static int getCountCoin() {
		int[] D = new int[K+1];
		D[0] = 1;
		for (int i=1; i<N+1; i++) {
			for (int j=coin[i]; j<K+1; j++) {
				D[j] += D[j-coin[i]];
			}
		}
		
//		for (int i=0; i<K+1; i++) {
//			System.out.print(D[i] + " ");
//		}
		
		return D[K];
	}
}
