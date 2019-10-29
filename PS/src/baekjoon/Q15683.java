package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Q15683 {
	static int N, M;
	static char[][] MAP;
	static ArrayList<Point> CCTV = new ArrayList<Point>();
	static int[] dRow = {0, 1, 0, -1};
	static int[] dCol = {-1, 0, 1, 0};
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		M = Integer.parseInt(arrIn[1]);
		MAP = new char[N][M];
		String strIn;
		ArrayList<Point> five = new ArrayList<Point>();
		for (int i=0; i<N; i++) {
			strIn = in.readLine().replace(" ", "");
			for (int j=0; j<M; j++) {
				MAP[i][j] = strIn.charAt(j);
				if (MAP[i][j] >= '1' && MAP[i][j] <= '4') {
					CCTV.add(new Point(i,j));
				} else if (MAP[i][j] == '5') {
					five.add(new Point(i, j));

				}
			}
		}
		for (int i=0; i<five.size(); i++) {
			Point p = five.get(i);
			for (int k=0; k<4; k++) {
				write(p.row,p.col,k);
			}
		}
		five = null;
		
		solution(0);
		System.out.println(MIN);
	}

	public static void print() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}
		System.out.println("--------------");
	}

	// 아 dfs
	public static void solution(int startIdx) {
		if (startIdx == CCTV.size()) {
//			if (MIN > findAns()) {
//				System.out.println(findAns());
//				print();
//			}
			MIN = Math.min(MIN, findAns());
			
			
			
			return;
		}
		Point p;
		char[][] org = new char[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++)
				org[i][j] = MAP[i][j];
		}
		for (int i=startIdx; i<CCTV.size(); i++) {
			p = CCTV.get(i);
			if (MAP[p.row][p.col] == '1') {
				for (int j=0; j<4; j++) {
					write(p.row, p.col, j);
					solution(i+1);
					back(org);
					
				}
			} else if (MAP[p.row][p.col] == '2') {
				for (int j=0; j<2; j++) {
					write(p.row, p.col, j);
					write(p.row, p.col, j+2);
					solution(i+1);
					back(org);
				}
			} else if (MAP[p.row][p.col] == '3') {
				int d;
				for (int j=0; j<4; j++) {
					int count = 0;
					d = j;
					while (count < 2) {
						write(p.row, p.col, d);
						d++;
						if (d == 4) d = 0;
						count++;
					}
					solution(i+1);	
					back(org);
				}

			} else if (MAP[p.row][p.col] == '4') {
				int d;
				for (int j=0; j<4; j++) {
					int count = 0;
					d = j;
					while (count < 3) {
						write(p.row, p.col, d);
						d++;
						if (d == 4) d = 0;
						count++;
					}
					solution(i+1);
					back(org);
				}
			}

		}
	}
	// 잠깐,,
	// 보니깐 시작 위치, 방향,, 그리면 되겠네..

	// dir L D R U
	// dir 0 1 2 3
	public static void write(int row, int col, int dir) {
		int nextRow = row + dRow[dir];
		int nextCol = col + dCol[dir];
		while (isPosible(nextRow, nextCol)) {
			if (MAP[nextRow][nextCol] == '0')
				MAP[nextRow][nextCol] = '#';
			nextRow += dRow[dir];
			nextCol += dCol[dir];
		}
	}
	
	public static void back(char[][] org) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++)
				MAP[i][j] = org[i][j];
		}
	}

	public static int findAns() {
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (MAP[i][j] == '0') ans++;
			}

		}
		return ans;
	}
	public static boolean isPosible(int row, int col) {
		if (row < 0 || row >= N) return false;
		if (col < 0 || col >= M) return false;
		if (MAP[row][col] == '6') return false;
		return true;
	}

	static class Point {
		int row;
		int col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
