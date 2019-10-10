package question;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q12100 {
	static int N;
	static int[][] MAP;
	static final int LEFT = 1;
	static final int RIGHT = 2;
	static final int UP = 3;
	static final int DOWN = 4;
	static int MAX = 0;
	static int[] random = {0,2,4,8,16,32,64,128,512,1024};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		MAP = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] tmp = in.readLine().split(" ");
			for(int j=0; j<N; j++) {
				//MAP[i][j] = random[(int) (Math.random() * 10) % 10];
				MAP[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		move(LEFT);
		print(MAP);
		move(LEFT);
		print(MAP);
		move(LEFT);
		print(MAP);
		move(LEFT);
		print(MAP);
		move(LEFT);
		print(MAP);
		//bfs(0);
		out.write(MAX + "");
		out.close();
		in.close();	

	}

	public static void print(int[][] TMPMAP) {
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(TMPMAP[i][j] + " ");
			System.out.println();
		}
		System.out.println("----------------------");
	}
	public static void print(boolean[][] TMPMAP) {
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(TMPMAP[i][j] + " ");
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void move(int type) {
		if (type == UP) {
			// 0 없애기
			for (int i=0; i<N; i++) {
				int idx = 0;
				for (int j=0; j<N; j++) {
					if (MAP[j][i] > 0) {
						MAP[idx][i] = MAP[j][i];
						idx++;
					}
				}
				for (int j=idx; j<N; j++) {
					MAP[j][i] = 0;
				}
			}
			// 합치기!
			for (int i=0; i<N; i++) {
				int idx = 0;
				for (int j=1; j<N; j++) {
					if (MAP[idx][i] == 0) {
						MAP[idx][i] = MAP[j][i];
						MAP[j][i] = 0;
					} else if (MAP[idx][i] == MAP[j][i] ) {
						MAP[idx][i] *=2;
						MAP[j][i] = 0;
						idx++;
					} else if (MAP[idx][i] != MAP[j][i]) {						
						idx++;
						if (Math.abs(idx - j) == 1) j--;
					}
				}
			}
			
		} else if (type == DOWN) {
			// 0 없애기
			for (int i=0; i<N; i++) {
				int idx = N-1;
				for (int j=N-1; j>=0; j--) {
					if (MAP[j][i] > 0) {
						MAP[idx][i] = MAP[j][i];
						idx--;
					}
				}
				for (int j=idx; j>=0; j--) {
					MAP[j][i] = 0;
				}
			}
			// 합치기!
			for (int i=0; i<N; i++) {
				int idx = N-1;
				for (int j=N-2; j>=0; j--) {
					if (MAP[idx][i] == 0) {
						MAP[idx][i] = MAP[j][i];
						MAP[j][i] = 0;
					} else if (MAP[idx][i] == MAP[j][i] ) {
						MAP[idx][i] *=2;
						MAP[j][i] = 0;
						idx--;
					} else if (MAP[idx][i] != MAP[j][i]) {
						idx--;
						if (Math.abs(idx - j) == 1) j++;
						
					}
				}
			}

		} else if (type == LEFT) {
			// 0 없애기
			for (int i=0; i<N; i++) {
				int idx = 0;
				for (int j=0; j<N; j++) {
					if (MAP[i][j] > 0) {
						MAP[i][idx] = MAP[i][j];
						idx++;
					}
				}
				for (int j=idx; j<N; j++) {
					MAP[i][j] = 0;
				}
			}
			// 합치기!
			for (int i=0; i<N; i++) {
				int idx = 0;
				for (int j=1; j<N; j++) {
					if (MAP[i][idx] == 0) {
						MAP[i][idx] = MAP[i][j];
						MAP[i][j] = 0;
					} else if (MAP[i][idx] == MAP[i][j] ) {
						MAP[i][idx] *=2;
						MAP[i][j] = 0;
						idx++;
					} else if (MAP[i][idx] != MAP[i][j]) {
						idx++;
						if (Math.abs(idx - j) == 1) j--;
					}
				}
			}

		} else if (type == RIGHT) {
			// 0 없애기
			for (int i=0; i<N; i++) {
				int idx = N-1;
				for (int j=N-1; j>=0; j--) {
					if (MAP[i][j] > 0) {
						MAP[i][idx] = MAP[i][j];
						idx--;
					}
				}
				for (int j=idx; j>=0; j--) {
					MAP[i][j] = 0;
				}
			}
			
			// 합치기!
			for (int i=0; i<N; i++) {
				int idx = N-1;
				for (int j=N-2; j>=0; j--) {
					if (MAP[i][idx] == 0) {
						MAP[i][idx] = MAP[i][j];
						MAP[i][j] = 0;
					} else if (MAP[i][idx] == MAP[i][j] ) {
						MAP[i][idx] *=2;
						MAP[i][j] = 0;
						idx--;
					} else if (MAP[i][idx] != MAP[i][j]) {
						idx--;
						if (Math.abs(idx - j) == 1) j++;
					}
				}
			}

		}
	}
	public static int[][] makeCopyMap() {
		int[][] copyMap = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)
				copyMap[i][j] = MAP[i][j];
		}
		return copyMap;
	}

	public static void backMap(int[][] copyMap) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)
				MAP[i][j] = copyMap[i][j];
		}
	}

	public static void bfs(int count) {
		if (count == 5) {
			int returnVal = getMax(MAP);
			MAX = MAX < returnVal ? returnVal : MAX;
			return;
		}
		
		// 현재 MAP 백업
		int[][] copyMap = makeCopyMap();
		
		// UP, DOWN, LEFT, RIGHT
		for (int i=1; i<5; i++) {
			// 현재 맵(copyMap)에서 각 UP, DOWN, LEFT, RIGHT 한번 이동!	
//			System.out.println("----" + i + "-------");
//			print(copyMap);
			move(i);
//			print(MAP);
			
			// 위에서 이동한 맵을 가지고 bfs 실행! --> 또 4번 이동하려고!!
			bfs(count+1);
			// move를 통해 현재 맵에 바뀌있으니깐! 원복!!
			backMap(copyMap);
			
		}
		
	}
	public static int getMax(int[][] map) {
		int MAX = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (map[i][j] > MAX) MAX = map[i][j];
			}
		}
		return MAX;
	}

}