package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1767 {
	static int LEFT = 0;
	static int RIGHT = 1;
	static int UP = 2;
	static int DOWN = 3;
	static int ANS;
	static int[][] MAP = new int[13][13];
	static int[][] CORES = new int[13][2];
	static int CORELEN;
	static int MAXCORE;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i=0; i<T; i++) {
			N = Integer.parseInt(in.readLine());
			int coreIdx = 0;
			for (int j=0; j<N; j++) {
				String[] arr = in.readLine().split(" ");
				for (int k=0; k<N; k++) {
					MAP[j][k] = Integer.parseInt(arr[k]);
					if (MAP[j][k] == 1 && j>0 && k>0) {
						CORES[coreIdx][0] = j;
						CORES[coreIdx][1] = k;
						coreIdx++;
					}
				}
			}
			ANS = Integer.MAX_VALUE;
			MAXCORE = Integer.MIN_VALUE;
			CORELEN = coreIdx;
			solution(0, 0);
			if (ANS == Integer.MAX_VALUE) ANS = 0;
			System.out.println("#" + (i+1) + " " + ANS);
		}	
	}
	public static void solution(int startIdx, int coreCnt) {
		if (startIdx == CORELEN) {
			int count = getWireCount();
			if (MAXCORE < coreCnt) {
				MAXCORE= coreCnt;
				ANS = count;
			} else if (MAXCORE == coreCnt) {
				if (ANS > count) ANS = count;
			}			
			return;
		}
		int[][] orgMap = makeBackUpMap();
		int falseCount = 0;
		for (int j=0; j<4; j++) {
			if (connectWire(CORES[startIdx][0], CORES[startIdx][1], j)) {					
				solution(startIdx+1, coreCnt+1);
			} else falseCount++;
			rollBack(orgMap, MAP);
		}
		if (falseCount == 4 ) solution(startIdx+1, coreCnt);
	}

	public static void printMap(int N) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

	public static int getWireCount() {
		int count = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (MAP[i][j] == 2) count++;
			}
		}
		return count;
	}


	public static int[][] makeBackUpMap() {
		int[][] orgMap = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				orgMap[i][j] = MAP[i][j];
			}
		}
		return orgMap;
	}

	public static void rollBack(int[][] orgMap, int[][] targetMap) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				targetMap[i][j] = orgMap[i][j];
			}
		}
	}	

	public static boolean connectWire(int i, int j, int direction) {
		if (direction == LEFT) {
			for (int k=j-1; k>=0; k--) {
				if (MAP[i][k] > 0) return false;
				MAP[i][k] = 2;
			}
		} else if (direction == RIGHT) {
			for (int k=j+1; k<N; k++) {
				if (MAP[i][k] > 0) return false;
				MAP[i][k] = 2;
			}
		} else if (direction == UP) {
			for (int k=i-1; k>=0; k--) {
				if (MAP[k][j] > 0) return false;
				MAP[k][j] = 2;
			}
		} else if (direction == DOWN) {
			for (int k=i+1; k<N; k++) {
				if (MAP[k][j] > 0) return false;
				MAP[k][j] = 2;
			}
		}

		return true;
	}


}
