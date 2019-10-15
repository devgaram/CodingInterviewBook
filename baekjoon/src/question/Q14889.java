package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14889 {
	static int[][] S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		S = new int[N][N];
		String[] arrIn;
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(arrIn[j]);
			}
		}
		System.out.println(solution(N));
	}
	public static int solution(int N) {
		int minDiff = Integer.MAX_VALUE;
		int diff;
		int mask = 0;
		int start = (1<<N/2) - 1;
		int end = ((1<<N) -1) ^ start;
		int[] ST = new int[N/2], LT = new int[N/2];
		int stIdx, ltIdx;
		for (int i=start; i<=end/2; i++) {
			if (Integer.bitCount(i) == N/2) {
				mask = i;
				stIdx = 0;
				ltIdx = 0;
				for (int j=0; j<N; j++) {
					if ((mask & 1) == 1) {
						ST[stIdx] = j;
						stIdx++;
					} else {
						LT[ltIdx] = j;
						ltIdx++;
					}
					mask = (mask >>> 1);
				}
				diff = Math.abs(cal(ST)-cal(LT));
				minDiff = Math.min(minDiff, diff);
			}
		}
		return minDiff;
	}
	public static int cal(int[] st) {
		int sum = 0;		
		for (int i=0; i<st.length; i++) {
			for (int j=i; j<st.length; j++) {
				int ii = st[i];
				int jj = st[j];
				sum += S[ii][jj] + S[jj][ii];
			}
		}
		return sum;
	}
	
	public static void print(int[] st, int lt[]) {
		for (int i=0; i<st.length; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
		for (int i=0; i<lt.length; i++) {
			System.out.print(lt[i] + " ");
		}
		System.out.println();
		System.out.println("--------");
	}
}
