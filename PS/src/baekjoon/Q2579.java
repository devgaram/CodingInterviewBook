package baekjoon;


import java.io.*;
import java.util.*;

public class Q2579 {
	static int[] stairScore;
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int stairCount = Integer.parseInt(in.readLine());
		stairScore = new int[stairCount+1];
		for (int i=1; i<stairCount+1; i++)
			stairScore[i] = Integer.parseInt(in.readLine());
		
		out.write(getMaxScore(stairCount) + "");
		out.close();
		in.close();
	}
	public static int getMaxScore(int stair) {
		int[] memo = new int[stair+1];
		memo[0] = 0;
		memo[1] = stairScore[1];
		memo[2] = memo[1] + stairScore[2];
		
		for (int i=3; i<stair+1; i++) {		
			memo[i] = stairScore[i-1] + memo[i-3] > memo[i-2] ? stairScore[i-1] + memo[i-3] + stairScore[i] : memo[i-2] + stairScore[i];
		}
		return memo[stair];
	}
}
