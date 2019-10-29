package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Q14502 {
	public static int[][] MAP;
	static Queue<Pos> virus = new LinkedList<Pos>();
	static int N, M;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static int MAX = Integer.MIN_VALUE;
	static int zeroCount;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		M = Integer.parseInt(arrIn[1]);
		MAP = new int[N][M];
		zeroCount = 0;
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<M; j++) {
				MAP[i][j] = Integer.parseInt(arrIn[j]);
				if (MAP[i][j] == 2) 
					virus.add(new Pos(i,j));
				if (MAP[i][j] == 0)
					zeroCount++;
			}
		}
		solution(0);
		System.out.println(MAX);

	}
	public static void solution(int count) {
		if (count == 3) {
			int[][] orgMap = new int[N][M];
			Queue<Pos> orgVirus = new LinkedList<Pos>();
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					orgMap[i][j] = MAP[i][j];
				}
			}
			orgVirus.addAll(virus);
			int ans = zeroCount - spread(orgVirus);
			if (MAX < ans) MAX = ans;
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					MAP[i][j] = orgMap[i][j];
				}
			}
			return;
		}

		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (MAP[i][j] == 0) {
					MAP[i][j] = 1;
					solution(count+1);
					MAP[i][j] = 0;
				}
			}
		}

	}
	
	public static int spread(Queue<Pos> orgVirus) {
		int count = 3;
		while (!orgVirus.isEmpty()) {
			Pos poll = orgVirus.poll();
			for (int i=0; i<4; i++) {
				int nextRow = poll.row + dRow[i];
				int nextCol = poll.col + dCol[i];
				if (isPosible(nextRow, nextCol)) {
					MAP[nextRow][nextCol] = 2;
					orgVirus.add(new Pos(nextRow, nextCol));
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isPosible(int row, int col) {
		if (row < 0 || row >= N) return false;
		if (col < 0 || col >= M) return false;
		if (MAP[row][col] != 0) return false;
		return true;
	}
	
	public static void print() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
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
