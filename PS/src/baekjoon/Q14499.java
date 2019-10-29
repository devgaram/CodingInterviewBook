package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14499 {
	static int Col;
	static int Row;
	static int[][] MAP;
	static int K;
	static int[] command;
	static int[] dice = new int[6];
	static int EAST = 1;
	static int WEST = 2;
	static int NORTH = 3;
	static int SOUTH = 4;
	static int[] dCol = {0, 1, -1, 0, 0};
	static int[] dRow = {0, 0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		Row = Integer.parseInt(arrIn[0]);
		Col = Integer.parseInt(arrIn[1]);
		MAP = new int[Row][Col];
		int x = Integer.parseInt(arrIn[2]);
		int y = Integer.parseInt(arrIn[3]);
		K = Integer.parseInt(arrIn[4]);
		command = new int[K];
		
		for (int i=0; i<Row; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<Col; j++) {
				MAP[i][j] = Integer.parseInt(arrIn[j]);
			}
		}
		
		arrIn = in.readLine().split(" ");
		for (int i=0; i<K; i++) {
			command[i] = Integer.parseInt(arrIn[i]);
		}
		
		solution(x, y);
		in.close();
	}
	
	public static void solution(int row, int col) {
		int nextRow, nextCol;
		for (int i=0; i<K; i++) {
			nextRow = row + dRow[command[i]];
			nextCol = col + dCol[command[i]];
			if (isPosibleMove(nextRow, nextCol)) {
				row = nextRow;
				col = nextCol;
				moveDice(command[i]);
				if (MAP[row][col] == 0) {
					MAP[row][col] = dice[2];
				} else {
					dice[2] = MAP[row][col];
					MAP[row][col] = 0;
				}
				
				System.out.println(dice[0]);				
			}
		}		
	}
	
	public static boolean isPosibleMove(int row, int col) {
		if (row < 0 || row >= Row) return false;
		if (col < 0 || col >= Col) return false;
		return true;
	}
	
	public static void moveDice(int direction) {
		// À§ ³² ¹Ø ºÏ µ¿ ¼­
		// 0 1 2 3 4 5
		
		int[] tDice = new int[6];
		for (int i=0; i<6; i++)
			tDice[i] = dice[i];
		
		if (direction == EAST) {
			dice[0] = tDice[5];
			dice[5] = tDice[2];
			dice[2] = tDice[4];
			dice[4] = tDice[0];
		} else if (direction == WEST) {
			dice[0] = tDice[4];
			dice[4] = tDice[2];
			dice[2] = tDice[5];
			dice[5] = tDice[0];			
		} else if (direction == NORTH) {
			dice[0] = tDice[1];
			dice[1] = tDice[2];
			dice[2] = tDice[3];
			dice[3] = tDice[0];
		} else if (direction == SOUTH) {
			dice[0] = tDice[3];
			dice[3] = tDice[2];
			dice[2] = tDice[1];
			dice[1] = tDice[0];
		}
	}
	
	public static void print() {
		for (int i=0; i<Row; i++) {
			for (int j=0; j<Col; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
		for (int i=0; i<K; i++) {
			System.out.print(command[i] + " ");
		}
		System.out.println("--------------");
	}
}
