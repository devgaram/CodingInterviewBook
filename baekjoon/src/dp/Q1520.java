package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1520 {
	static int[][] map;
	static int M, N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strs = in.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		map = new int[M+1][N+1];
		for (int i=1; i<M+1; i++) {
			strs = in.readLine().split(" ");
			for (int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
		
		out.write(getDownWay() + "");
		out.close();
		in.close();
	}
	
	public static long getDownWay() {
		int[][] D = new int[M+1][N+1];
		D[1][1] = 1;
		
		for (int i=1; i<M+1; i++) {			
			for (int j=1; j<N+1; j++) {
				System.out.print(D[i][j]+ " ");
			}
			System.out.println();
		}
		return 0;
	}
}
