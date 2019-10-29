package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// �� �������� ����!! ���� ���� �Ǵµ�!!...�ִ� 4������
// �ٽ���~~~ �� �� �� �Ǹ� ��� ó���ϴ� ��!..
// ���� �ε��� �� ���� �� ���� ������ 4�� �̻��̸� �� �Ѱ��� ���� ���ϱ�
// 3���� �׳� �� �հ� ���ϱ�~
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
	
	// ���� 4�� �� ���� �� �� ���� ����
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
