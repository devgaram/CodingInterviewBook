package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 드래곤 커브의 규칙 찾는 게 포인트!!
public class Q15685 {
	// R U L D
	static int[] dRow = {0, -1, 0, 1};
	static int[] dCol = {1, 0, -1, 0};
	static boolean[][] MAP = new boolean[101][101];
	static int[] D = new int[1024];
	static int[][] C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		C = new int[N][4];
		String[] arrIn;
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			C[i][0] = Integer.parseInt(arrIn[0]);
			C[i][1] = Integer.parseInt(arrIn[1]);
			C[i][2] = Integer.parseInt(arrIn[2]);
			C[i][3] = Integer.parseInt(arrIn[3]);				
		}
		for (int i=0; i<N; i++) {
			drawDragon(C[i][0], C[i][1], C[i][2], C[i][3]);
			//print();
		}
		System.out.println(solution());
		
		in.close();
	}
	/*
	 * R U L D
	 * 0 1 2 3
	 * 
	 * 0세대 : 0
	 * 1세대 : 0 1
	 * 2세대 : 0 1 - 2 1
	 * 3세대 : 0 1 2 1 -  2 3 2 1
	 * 4세대 : 0 1 2 1 2 3 2 1 -   2 3 0 3 2 3 2 1
	 * ...10
	 *
	 */
	public static void makeDirect(int d, int g) {		
		int size;
		D[0] = d;
		for (int i=1; i<g+1; i++) {
			size = (1<< i);
			for (int j=(1<<(i-1)); j<size; j++) {
				D[j] = (D[size-j-1] + 1) % 4 ;
			}
		}
		
//		for (int i=0; i<g+1; i++) {
//			System.out.print(i + "세대 : ");
//			for (int j=0; j<(1<<g); j++)
//				System.out.print(D[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println("------");
	}
	
	// 0 1 99 100
	public static void drawDragon(int x, int y, int d, int g) {
		makeDirect(d, g);
		MAP[y][x] = true;
		for (int i=0; i<(1<<g); i++) {
			y = y+dRow[D[i]];
			x = x+dCol[D[i]];
			MAP[y][x] = true;			
		}
		
	}
	
	public static void print() {
		for (int i=0; i<101; i++) {
			for (int j=0; j<101; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}
		System.out.println("-----");
	}
	
	public static int solution() {
		int count = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if(MAP[i][j] && MAP[i+1][j] && MAP[i][j+1] && MAP[i+1][j+1]) count++;
			}
		}
		return count;
	}
	
	
	
	
}
