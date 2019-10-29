package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15684 {
	static int[][] MAP;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");

		int N = Integer.parseInt(arrIn[0]);
		int M = Integer.parseInt(arrIn[1]);
		int H = Integer.parseInt(arrIn[2]);
		// 2 0 3
		/*   1(1->2사다리)
		 * 1
		 * 2
		 * 3
		 */
		MAP = new int[H+1][N];
		for (int i=0; i<M; i++) {
			arrIn = in.readLine().split(" ");
			int a = Integer.parseInt(arrIn[0]);
			int b = Integer.parseInt(arrIn[1]);
			MAP[a][b] = 1;
		}
		solution(0, 1);
		if (MIN == Integer.MAX_VALUE) MIN = -1;
		System.out.println(MIN);
		in.close();
	}

	// 사다리 이동!!
	public static boolean check() {
		//print();
		int moveI;
		// 각 세로 줄 탐색
		for (int i=1; i<MAP[0].length; i++) {
			moveI = i;
			// 가로 층 이동
			for (int h=1; h<MAP.length; h++) {
				// moveI -> moveI+1로 이동 가능
				if (moveI < MAP[0].length && MAP[h][moveI] == 1) {
					moveI++;
				} 
				// moveI -> moveI-1로 이동가능
				else if (moveI > 1 && MAP[h][moveI-1] == 1) {
					moveI--;
				}
			}
			if (moveI != i) return false;
		}
		return true;
	}
	// 2 0 3
	/*   1(1->2사다리)
	 * 1
	 * 2
	 * 3
	 */
	public static void solution(int lineCount, int H) {
		if (lineCount > 3) {
			return;
		}
		
		if (check()) {
			MIN = Math.min(MIN, lineCount);
		}		

		for (int h=H; h<MAP.length; h++) {
			for (int i=1; i<MAP[h].length; i++) {
				// i -> i+1 사다리 추가하는 곳, 
				// i -> i+1 사다리 없음!
				if (MAP[h][i] == 0) {
					// 왼쪽 세로선과 연결되어 있지 않음!
					if (MAP[h][i-1] == 0) {
						// 오른쪽 세로선과 연결되어 있지 않음 || 맨끝 세로선일 경우
						if ((i+1 < MAP[h].length && MAP[h][i+1] == 0) || (i+1 >= MAP[h].length)) {
							MAP[h][i] = 1;
							solution(lineCount+1, h);
							MAP[h][i] = 0;
						} 
					}
				}
			}
		}
	}



	public static void print() {
		for (int i=1; i<MAP.length; i++) {
			for (int j=1; j<MAP[i].length; j++)
				System.out.print(MAP[i][j]+ " ");
			System.out.println();
		}
		System.out.println("--------");
	}

}
