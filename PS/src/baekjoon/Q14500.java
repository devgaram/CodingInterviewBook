package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 걍 동서남북 랜덤!! 으로 가면 되는듯!!...최대 4번까지
// 핵심은~~~ ㅜ ㅓ ㅏ ㅗ를 어떻게 처리하는 지!..
// 인접 인덱스 다 더한 후 더한 갯수가 4개 이상이면 각 한개씩 빼서 비교하기
// 3개면 그냥 그 합과 비교하기~
public class Q14500 {
	static int R;
	static int C;
	static int[][] MAP;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static int MAX = Integer.MIN_VALUE;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		R = Integer.parseInt(arrIn[0]);
		C = Integer.parseInt(arrIn[1]);
		MAP = new int[R][C];
		visited = new boolean[R][C];
		for (int i=0; i<R; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<C; j++) {
				MAP[i][j] = Integer.parseInt(arrIn[j]);
				visited[i][j] = false;
			}
		}
		solution();
		System.out.println(MAX);
	}

	public static void solution() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				DFS(i,j, 1, MAP[i][j]);
				visited[i][j] = false;
				except(i, j);
			}
		}	
	}
	public static void DFS(int row, int col, int count, int result) {
		visited[row][col] = true;
		if (count == 4) {
			//System.out.println(row + "," + col + "," + count + "," + result);
			//print(visited);
			if (result > MAX) MAX = result;
			return;
		}

		for (int i=0; i<4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			if (isPosible(nextRow, nextCol)) {
				DFS(nextRow, nextCol, count+1, result + MAP[nextRow][nextCol]);
				visited[nextRow][nextCol] = false;
			}			
		}
	}
	
	// 인접 4개 다 더한 후 한 개씩 빼기
	public static void except(int row, int col) {
		int sum = MAP[row][col];
		int count = 0;
		for (int i=0; i<4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			if (isPosible(nextRow, nextCol)) {
				count++;
				sum += MAP[nextRow][nextCol];
			}
		}
		if (count == 3 && sum > MAX) MAX = sum;
		
		if (count == 4) {
			for (int i=0; i<4; i++) {
				int tmpSum = sum;
				tmpSum -= MAP[row + dRow[i]][col + dCol[i]];
				if (tmpSum > MAX) MAX = tmpSum;
			}
		}
		
	
		
		
	}
	public static void print(boolean[][] arr) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

	public static boolean isPosible(int row, int col) {
		if (row < 0 || row >= R) return false;
		if (col < 0 || col >= C) return false;
		if (visited[row][col]) return false;
		return true;
	}
}
