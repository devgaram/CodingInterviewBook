package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17144 {
	static int R;
	static int C;
	static int T;
	static int[][] MAP;
	static int[][] spreadMap;
	static int upRow;
	static int downRow;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] vals = in.readLine().split(" ");
		R = Integer.parseInt(vals[0]);
		C = Integer.parseInt(vals[1]);
		T = Integer.parseInt(vals[2]);
		MAP = new int[R][C];
		spreadMap = new int[R][C];
		for (int i=0; i<R; i++) {
			vals = in.readLine().split(" ");
			for (int j=0; j<C; j++) {
				MAP[i][j] = Integer.parseInt(vals[j]);
				if (MAP[i][j] == -1 && upRow == 0) {
					upRow = i;
					downRow = i+1;
				}
			}
		}	
		System.out.println(solution());
		
	}

	public static int solution() {
		for (int i=0; i<T; i++) {
			spread();
			removeDustUP();
			removeDustDOWN();
		}
		int sum = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (MAP[i][j] > 0)
					sum+=MAP[i][j];
			}
		}	
		return sum;
	}

	public static void spread() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (MAP[i][j] > 0) {
					for (int k=0; k<4; k++) {
						if (isPosibleSpread(i+dRow[k], j+dCol[k])) {
							spreadMap[i+dRow[k]][j+dCol[k]] += MAP[i][j]/5;
							spreadMap[i][j] -= MAP[i][j]/5;
							
						}
					}
				}
			}
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				MAP[i][j] += spreadMap[i][j];
				spreadMap[i][j] = 0;
			}
		}
	}

	public static boolean isPosibleSpread(int i, int j) {
		if (i < 0 || j < 0) return false;
		if (i >= R || j >= C) return false;
		if (MAP[i][j] < 0) return false;
		return true;
	}

	public static void removeDustUP() {		
		int preI=upRow-1, preJ=0;
		int i=preI, j=preJ;
		// UP
		while (preI > 0 && i == preI) {	
			i = preI+dRow[2];
			j = preJ+dCol[2];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		//RIGHT 0,0
		while (preJ < C-1 && preJ == j) {	
			i = preI+dRow[1];
			j = preJ+dCol[1];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		//DOWN			
		while (preI < upRow && i == preI) {	
			i = preI+dRow[3];
			j = preJ+dCol[3];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		//LEFT
		while (preJ > 1 && preJ == j) {	
			i = preI+dRow[0];
			j = preJ+dCol[0];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		MAP[preI][preJ] = 0;

	}
	public static void removeDustDOWN() {		
		int preI=downRow+1, preJ=0;
		int i=preI, j=preJ;

		//DOWN			
		while (preI < R-1 && i == preI) {	
			i = preI+dRow[3];
			j = preJ+dCol[3];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		//RIGHT
		while (preJ < C-1 && preJ == j) {	
			i = preI+dRow[1];
			j = preJ+dCol[1];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		// UP
		while (preI > downRow && i == preI) {	
			i = preI+dRow[2];
			j = preJ+dCol[2];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		//LEFT
		while (preJ > 1 && preJ == j) {	
			i = preI+dRow[0];
			j = preJ+dCol[0];
			MAP[preI][preJ] = MAP[i][j];
			preI = i;
			preJ = j;
		}
		MAP[preI][preJ] = 0;

	}

	public static void printMap() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}	
		System.out.println("----------------------");
	}
}
