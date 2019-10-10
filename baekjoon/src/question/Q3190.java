package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q3190 {
	static int[][] board;
	static int[][] direction;
	static Deque<Pos> snake = new ArrayDeque<Pos>();
	static int N;
	static int A;
	static int LEFT = 0;
	static int RIGHT = 1;
	static int UP = 2;
	static int DOWN = 3;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N+1][N+1];
		A = Integer.parseInt(in.readLine());
		for (int i=0; i<A; i++) {
			String[] pos = in.readLine().split(" ");
			board[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = -1;
		}
		board[1][1] = 1;
		A = Integer.parseInt(in.readLine());
		direction = new int[A+1][3];
		for (int i=1; i<A+1; i++) {
			String[] dir = in.readLine().split(" ");
			direction[i][1] = Integer.parseInt(dir[0]);
			direction[i][2] = (int) dir[1].toCharArray()[0];
		}		
		//		printBoard();
		System.out.println(solution());

		in.close();
	}

	public static void printBoard() {
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public static int solution() {
		int timer = 0;
		int snakeDir = RIGHT;
		int dirIndex = 1;
		
		snake.add(new Pos(1,1));
		
		while(true) {
			timer++;
			
			int nextRow = snake.getFirst().row + dRow[snakeDir];
			int nextCol = snake.getFirst().col + dCol[snakeDir];
			
			// 벽에 부딪힘
			if (nextRow <= 0 || nextRow > N || nextCol <= 0 || nextCol > N) {
				return timer;
			} 
			// 자기 몸에 부딪힘
			if (board[nextRow][nextCol] == 1) {
				return timer;
			}
			// 사과 있으면
			if (board[nextRow][nextCol] == -1) {
				snake.addFirst(new Pos(nextRow, nextCol));
				board[nextRow][nextCol] = 1;
			} 
			// 사과 업으면
			else if (board[nextRow][nextCol] == 0) {
				// 꼬리 제거
				Pos pos = snake.removeLast();
				board[pos.row][pos.col] = 0;
				// 머리 넣기
				snake.addFirst(new Pos(nextRow, nextCol));
				board[nextRow][nextCol] = 1;
			}
			// 방향 전환
			if (dirIndex <= A &&timer == direction[dirIndex][1] ) {					
				snakeDir = changeDirection(snakeDir, direction[dirIndex][2]);
				dirIndex++;
			}			
		}
	}

	public static boolean isPosibleMove(int row, int col) {
		if (row < 0 || col < 0) return false;
		if (row > N || col > N) return false;
		if (board[row][col] == 1) return false;
		return true;
	}
	
	public static boolean isChkTail(int row, int col) {
		if (row < 0 || col < 0) return false;
		if (row > N || col > N) return false;
		if (board[row][col] != 1) return false;
		return true;
	}

	public static int changeDirection(int current, int future) {
		if (current == LEFT) {
			if (future == 'L') return DOWN;
			if (future == 'D') return UP;
		} else if (current == RIGHT) {
			if (future == 'L') return UP;
			if (future == 'D') return DOWN;
		} else if (current == UP) {
			if (future == 'L') return LEFT;
			if (future == 'D') return RIGHT;
		} else if (current == DOWN) {
			if (future == 'L') return RIGHT;
			if (future == 'D') return LEFT;
		} 

		return current;
	}
	
	static class Pos {
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
