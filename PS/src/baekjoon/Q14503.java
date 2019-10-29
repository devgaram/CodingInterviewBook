package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q14503 {
	static int N, M;
	static int[][] MAP;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		M = Integer.parseInt(arrIn[1]);
		arrIn = in.readLine().split(" ");
		int r = Integer.parseInt(arrIn[0]);
		int c = Integer.parseInt(arrIn[1]);
		int d = Integer.parseInt(arrIn[2]);
		MAP = new int[N][M];
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<M; j++) 
				MAP[i][j] = Integer.parseInt(arrIn[j]);
		}
		System.out.println(solution(r, c, d));
		in.close();

	}
	public static int solution(int r, int c, int d) {
		int rotateCount, ansCount = 0;
		int[] dRow = {-1, 0, 1, 0};
		int[] dCol = {0, 1, 0, -1};
		int[] dRowBack = {1, 0, -1, 0};
		int[] dColBack = {0, -1, 0, 1};

		while (true) {
			if (MAP[r][c] == 0) {
				MAP[r][c] = 2; // 현재 위치 청소
				ansCount++;
			}
			rotateCount = 0;
			int nextD = d;
			int nextRow;
			int nextCol;
			while (rotateCount < 4) {
				nextD--;
				if (nextD < 0) nextD = 3;	
				nextRow = r + dRow[nextD];
				nextCol = c + dCol[nextD];
				if (isMovePosible(nextRow, nextCol)) {
					r = nextRow;
					c = nextCol;
					d = nextD;
					break;
				}
				rotateCount++;
			}
			if (rotateCount == 4) {
				nextRow = r + dRowBack[nextD];
				nextCol = c + dColBack[nextD];
				if (nextRow < 0 || nextRow >= N) break;
				if (nextCol < 0 || nextCol >= M) break;
				if (MAP[nextRow][nextCol] == 1) break;
				r = nextRow;
				c = nextCol;

			}

		}
		return ansCount;
	}
	public static boolean isMovePosible(int row, int col) {		
		if (row < 0 || row >= N) return false;
		if (col < 0 || col >= M) return false;
		if (MAP[row][col] != 0) return false;
		return true;
	}

	public static void print() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) 
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}
		System.out.println("----");
	}
}
