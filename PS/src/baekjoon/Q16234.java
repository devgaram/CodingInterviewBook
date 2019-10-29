package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import baekjoon.Q15686.Pos;

public class Q16234 {
	static int[][] MAP;
	static int N, L, R;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		L = Integer.parseInt(arrIn[1]);
		R = Integer.parseInt(arrIn[2]);
		MAP = new int[N][N];
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<N; j++) {	
				MAP[i][j] = Integer.parseInt(arrIn[j]);
			}
		}

		System.out.println(solution());

	}

	public static int solution() {
		boolean movePeople = true;
		int moveCount = 0;
		while (movePeople) {
			movePeople = false;
			Queue<Pos> q = new LinkedList<>();
			ArrayList<Pos> union = new ArrayList<>();		
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 연합 생성 시작
					if (!visited[i][j]) {
						q.add(new Pos(i, j));
						visited[i][j] = true;
						int union_count = 1;
						int union_people = MAP[i][j];
						union.add(new Pos(i,j));
						while (!q.isEmpty()) {
							Pos poll = q.poll();
							for (int k=0; k<4; k++) {
								int nextRow = poll.row + dRow[k];
								int nextCol = poll.col + dCol[k];
								// 연합 가능할 경우
								if (isPosible(nextRow, nextCol, poll.row, poll.col)) {
									q.add(new Pos(nextRow,nextCol));
									visited[nextRow][nextCol] = true;
									union_count++;
									union_people += MAP[nextRow][nextCol];
									union.add(new Pos(nextRow, nextCol));
								}							
							}
						}

						// 연합이 한번이라도 있었는지..
						if (union_count > 1) movePeople = true;
						// 인구 이동! 인구 수 계산
						int r = union_people/union_count;
						for (Pos p : union) {
							MAP[p.row][p.col] = r;
						}

						union.clear();					
					}
				}
			}

			if (movePeople) {
				// 인구이동 1회 완료, visited 초기화
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						visited[i][j] = false;
					}
				}
				moveCount++;
			}

		}

		return moveCount;

	}

	public static boolean isPosible(int nextRow, int nextCol, int row, int col) {
		if (nextRow < 0 || nextRow >= N) return false;
		if (nextCol < 0 || nextCol >= N) return false;
		if (visited[nextRow][nextCol]) return false;

		int diff = Math.abs(MAP[nextRow][nextCol] - MAP[row][col]);
		if (diff >= L && diff <= R) return true;
		else return false;
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
