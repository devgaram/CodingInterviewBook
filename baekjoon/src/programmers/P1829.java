package programmers;

import java.util.LinkedList;
import java.util.Queue;

// Ä«Ä«¿ÀÇÁ·»Áî ÄÃ·¯¸µºÏ
public class P1829 {
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1, 1, 1, 0},
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};

		int[] answer = solution(m, n, picture);
		System.out.println(answer[0] + "," + answer[1]);

	}
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static int M, N;
	static int[][] P;
	static boolean[][] visited;
	public static int[] solution(int m, int n, int[][] picture) {
		M = m;
		N = n;
		P = picture;
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visited = new boolean[m][n];
		Queue<Point> q = new LinkedList<Point>();
		int sizeOfOneArea;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {				
				if (!visited[i][j] && picture[i][j] > 0) {
					q.add(new Point(i, j));	
					visited[i][j] = true;
					sizeOfOneArea = 1;
					while (!q.isEmpty()) {
						Point poll = q.poll();
						for (int k=0; k<4; k++) {
							int nextRow = poll.row + dRow[k];
							int nextCol = poll.col + dCol[k];
							if (check(nextRow, nextCol, P[poll.row][poll.col])) {								
								q.add(new Point(nextRow, nextCol));
								visited[nextRow][nextCol] = true;
								sizeOfOneArea++;
							}
						}
					}
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
				} 
				visited[i][j] = true;
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static boolean check(int row, int col, int v) {
		if (row < 0 || row >= M) return false;
		if (col < 0 || col >= N) return false;
		if (visited[row][col]) return false;
		if (P[row][col] == v) return true;
		return false;
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
