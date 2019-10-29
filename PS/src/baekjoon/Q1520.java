package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1520 {
	static int[][] map;
	static int[][] D;
	static int M, N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strs = in.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		map = new int[M+1][N+1];
		for (int i=1; i<M+1; i++) {
			strs = in.readLine().split(" ");
			for (int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
		
		
		
		out.write(getDownWay() + "");
		
//		for (int i=1; i<M+1; i++) {
//			for (int j=1; j<N+1; j++) {
//				System.out.print(D[i][j] + " ");
//			}
//			System.out.println();
//		}
		out.close();
		in.close();
	}
	
	public static int getDownWay() {
		D = new int[M+1][N+1];
		for (int i=1; i<M+1; i++) {
			for (int j=1; j<N+1; j++) {
				D[i][j] = -1;
			}
		}
		return getDownWayDFS(1, 1);
	}
	
	public static int getDownWayDFS(int i, int j) {
		if (i == M && j == N ) return 1;		
		int count = 0;
		int pi, pj, mi, mj;
		if (D[i][j] < 0) {
			pi = i+1;
			pj = j+1;
			mi = i-1;
			mj = j-1;
			if (pj <= N && map[i][j] > map[i][pj]) count += getDownWayDFS(i, pj);
			if (pi <= M && map[i][j] > map[pi][j]) count += getDownWayDFS(pi, j);
			if (mi > 0 && map[i][j] > map[mi][j]) count += getDownWayDFS(mi, j);
			if (mj > 0 && map[i][j] > map[i][mj]) count += getDownWayDFS(i, mj);
			D[i][j] = count;
		} 		
		return D[i][j];			
		
	}
}
