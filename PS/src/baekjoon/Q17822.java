package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17822 {
	static int[][] MAP, TASK;
	static int N, M, T;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static int totalSum = 0, totalCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		M = Integer.parseInt(arrIn[1]);
		T = Integer.parseInt(arrIn[2]);
		MAP = new int[N+1][M];
		for(int i=1; i<N+1; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<M; j++) {
				MAP[i][j] = Integer.parseInt(arrIn[j]);
				totalSum += MAP[i][j];
				if (MAP[i][j] > 0 ) totalCount++;
			}
		}
		TASK = new int[T][3];
		for (int i=0; i<T; i++) {
			arrIn = in.readLine().split(" ");
			TASK[i][0] = Integer.parseInt(arrIn[0]); 
			TASK[i][1] = Integer.parseInt(arrIn[1]); 
			TASK[i][2] = Integer.parseInt(arrIn[2]); 
		}
		
		System.out.println(solution());
	}
	
	public static int solution() {
		int ct, cd, cc;
		for (int i=0; i<T; i++) {
			ct = TASK[i][0];
			cd = TASK[i][1];
			cc = TASK[i][2];
			
			while (cc > 0) {
				rotate(ct, cd);				
				cc--;
			}
			if (!delete()) {
				adjust();
			}
		}
		
		int sum = 0;
		for (int i=1; i<N+1; i++) {
			for (int j=0; j<M; j++) {
				sum +=MAP[i][j];
			}
		}
		return sum;
	}
	
	public static void rotate(int ct, int cd) {
		for (int i=ct; i<N+1; i=i+ct) {
			if (cd == 0) {
				int temp = MAP[i][M-1];
				for (int j=M-1; j>0; j--) {
					MAP[i][j] = MAP[i][j-1];
				}
				MAP[i][0] = temp;
			} else {
				int temp = MAP[i][0];
				for (int j=0; j<M-1; j++) {
					MAP[i][j] = MAP[i][j+1];
				}
				MAP[i][M-1] = temp;
				
			}
		}
	}
	
	public static boolean delete() {
		Queue<Point> q = new LinkedList<Point>();
		int nextR, nextC, value;
		boolean dchk = false;
		boolean totalchk = false;
		for (int i=1; i<N+1; i++) {
			for (int j=0; j<M; j++) {
				if (MAP[i][j] > 0) {
					q.add(new Point(i,j));
					value = MAP[i][j];		
					dchk=false;
					while (!q.isEmpty()) {
						Point poll = q.poll();
						for (int k=0; k<4; k++) {
							nextR = poll.row + dRow[k];
							nextC = poll.col + dCol[k];
							if (nextC < 0 ) nextC = M-1;
							else if (nextC >= M) nextC = 0;
							if (nextR < 1 || nextR >= N+1) continue;
							if (nextR == i && nextC == j) continue;
							if (MAP[nextR][nextC] == value) {
								totalSum -=MAP[nextR][nextC];
								totalCount--;
								MAP[nextR][nextC] = 0;							
								q.add(new Point(nextR, nextC));
								dchk = true;
								
							}
						}						
					}
					if (dchk) {
						totalSum -=MAP[i][j];
						totalCount--;
						MAP[i][j] = 0;
						totalchk = true;
					}
				}
			}
		}
		return totalchk;
	}
	
	public static void adjust() {
		float avg = 0;
		if (totalSum > 0 && totalCount > 0) avg = (float) totalSum/(float)totalCount;
		
		for (int i=1; i<N+1; i++) {
			for (int j=0; j<M; j++) {
				if (MAP[i][j] > 0) {
					if (MAP[i][j] < avg) {
						MAP[i][j]++;
						totalSum++;
					}
					else if (MAP[i][j] > avg) {
						MAP[i][j]--;
						totalSum--;
						if (MAP[i][j] == 0) {
							totalCount--;
						}
					}
				}
			}
		}
	}
	
	static class Point {
		int row, col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
