package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2565 {
	static int[] WIRE;
	static int N;
	static int K;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));		
		N = Integer.parseInt(in.readLine());
		WIRE = new int[501];
		for (int i=1; i<N+1; i++) {
			String[] strs = in.readLine().split(" ");
			WIRE[Integer.parseInt(strs[0])] =  Integer.parseInt(strs[1]); 
		}
		
		out.write(getMinRemove() + "");
		out.close();
		in.close();
	}
	
	public static int getMinRemove() {
		int[] DP = new int[N+1];
		int[][] vector = new int[3][N+1];
		int len = 0;
		for (int i=1; i<501; i++) {
			if (WIRE[i] > 0) {
				for (int j=len; j>=0; j--) {
					if(vector[1][j] < WIRE[i]) {
						vector[1][j+1] = WIRE[i];
						vector[2][j+1] = vector[2][j] + 1;
						if (len < j+1) len = j+1;
						break;
					}
				}
			}
		}
		for (int i=0; i<=len; i++) {
			System.out.print(vector[1][i] + " ");
		}
		return N-len;
	}
	
}
