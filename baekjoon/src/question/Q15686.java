package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Q15686 {
	static int N, M; // M <= 13, N<= 50
	static ArrayList<Pos> H = new ArrayList<Pos>();
	static ArrayList<Pos> C = new ArrayList<Pos>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		M = Integer.parseInt(arrIn[1]);
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<N; j++) {	
				int val = Integer.parseInt(arrIn[j]);
				if (val == 1) H.add(new Pos(i, j));
				else if (val == 2) C.add(new Pos(i, j));
			}
		}
		System.out.println(solution());
		in.close();
	}
	
	public static int solution() {		
		// C 5, M 2
		// 11111 1<<C -1
		// 00011 1<<M -1
		// 11000 
		// 11111 1<<C -1
		// 00111 1<<(C-M) -1
		// 
		int mask = 0;
		ArrayList<Pos> selectedC = new ArrayList<>();
		int start = (1 << M) -1;
		int end = ((1 << C.size()) - 1) ^ ((1 << (C.size() - M)) - 1);
		int ans = Integer.MAX_VALUE;
		for (int i=start; i<=end; i++) {
			if (Integer.bitCount(i) == M) {
				mask = i;
				// 조합
				for (int j=0; j<C.size(); j++) {
					if ((mask & 1) == 1) {
						int row = C.get(j).row;
						int col = C.get(j).col;
						selectedC.add(new Pos(row, col));
					}
					mask = mask >>> 1;
				}
				// 계산
				int cityDis = 0;
				for (int h=0; h<H.size(); h++) {
					int homeDis = Integer.MAX_VALUE;
					for (int c=0; c<selectedC.size(); c++) {
						int dis = Math.abs(H.get(h).row - selectedC.get(c).row) + Math.abs(H.get(h).col - selectedC.get(c).col);
						homeDis = Math.min(homeDis, dis);
					}
					cityDis += homeDis;
				}
				selectedC.clear();
				ans = Math.min(ans, cityDis);
			}
		}
		
		return ans;
	}

	static class Pos {
		int row;
		int col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
