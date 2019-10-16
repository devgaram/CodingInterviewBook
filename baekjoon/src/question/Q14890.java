package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14890 {
	static int N, L;
	static int[][] rowMap, colMap;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn = in.readLine().split(" ");
		N = Integer.parseInt(arrIn[0]);
		L = Integer.parseInt(arrIn[1]);
		rowMap = new int[N][N];
		colMap = new int[N][N];
		for (int i=0; i<N; i++) {
			arrIn = in.readLine().split(" ");
			for (int j=0; j<N; j++) { 
				rowMap[i][j] = Integer.parseInt(arrIn[j]);
				colMap[j][i] = rowMap[i][j];
			}
		}
		System.out.println(solution(rowMap) + solution(colMap));
		in.close();
	}
	public static void print(int[][] map) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) { 
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("------");
	}

	public static int solution(int[][] MAP) {
		int count = 0;
		int i,j;
		for (i=0; i<N; i++) {
			int len = 1;
			//System.out.print(i + " : " + MAP[i][0]+ " ");
			for (j=1; j<N; j++) {
				//System.out.print(MAP[i][j] + " ");
				int diff = MAP[i][j-1] - MAP[i][j];
				
				// 높이 2 차이 날 경우
				if (Math.abs(diff) > 1) break;
				
				// 올라가는 경사, 현재까지의 반복길이 체크해서 경사로 놓을 수 있는지.
				if (diff < 0) {
					// 길이가 경사로 넒이 보다 좁다. 
					if (len < L) break;
					else {
						len = 1;
					}
				} 
				// 내려가는 경사, 경사로 길이 체크 시작하기
				else if (diff > 0) {
					len = 1;
					int k;
					for (k=j+1; k<N; k++) {
						if (MAP[i][k-1] == MAP[i][k]) len++;
						else break;
					}
					if (len < L) break;
					j = k-1;
					len = len - L;
				} 
				// 같을 때
				else {
					len++;
				}
				
			}
			
			if (j == N) {
				count++;
				//System.out.print("->" + count);
			}
			//System.out.println();
		}
		return count;
	}
}
