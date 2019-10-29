package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q13460 {
	static int N, M;
	static char[][] MAP;
	static final int LEFT = 1;
	static final int RIGHT = 2;
	static final int UP = 3;
	static final int DOWN = 4;
	//static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] size = in.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		MAP = new char[N][M];
		//isVisited = new boolean[N][M];
		int ri = 0, rj = 0, bi = 0, bj = 0;
		for(int i=0; i<N; i++) {
			char[] tmp = in.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				MAP[i][j] = tmp[j];
				if (tmp[j] == 'R') {
					ri = i;
					rj = j;
				}
				if (tmp[j] == 'B') {
					bi = i;
					bj = j;
				}
			}
		}
		
		out.write(getMinMove(ri, rj, bi, bj) + "");
		out.close();
		in.close();	
		
	}
	
	public static int getMinMove(int ri, int rj, int bi, int bj) {
		
		int left = getMinMove(ri, rj, bi, bj, LEFT, 1);
		int right = getMinMove(ri, rj, bi, bj, RIGHT, 1);
		int up = getMinMove(ri, rj, bi, bj, UP, 1);
		int down = getMinMove(ri, rj, bi, bj, DOWN, 1);
		
		int min = Integer.MAX_VALUE;
		if (left + right + up + down == -4) return -1;
		
		if (left > 0) min = left;
		if (right > 0 && min > right) min = right;
		if (up > 0 && min > up) min = up;
		if (down > 0 && min > down) min = down;
		if (min == Integer.MAX_VALUE) return -1;
		return min;
		
	}
	
	public static int getMinMove(int ri, int rj, int bi, int bj, int type, int moveCount) {
		
		if (moveCount > 10) return -1;
		
		boolean redFlag = true, blueFlag = true;
		int redI = ri, redJ = rj, blueI = bi, blueJ = bj;
		boolean redSuccess = false;
		
		// j--
		if (type == LEFT) {
			while (redFlag || blueFlag) {
				if (redFlag) redJ--;
				if (blueFlag) blueJ--;
				if (MAP[redI][redJ] == '#') {
					redJ++;
					redFlag = false;
				}
				if (MAP[blueI][blueJ] == '#') {
					blueJ++;
					blueFlag = false;
				}
				
				if (MAP[redI][redJ] == 'O') redSuccess = true;
				if (MAP[blueI][blueJ] == 'O') return Integer.MAX_VALUE;
				
				if (redJ == blueJ && redI == blueI) {
					if(rj < bj) blueJ++;
					else redJ++;
					
					redFlag = false;
					blueFlag = false;
				}
				
				
			}
			
			if (redSuccess) return moveCount;
			
		} 
		// j++
		else if (type == RIGHT) {
			while (redFlag || blueFlag) {
				if (redFlag) redJ++;
				if (blueFlag) blueJ++;
				if (MAP[redI][redJ] == '#') {
					redJ--;
					redFlag = false;
				}
				if (MAP[blueI][blueJ] == '#') {
					blueJ--;
					blueFlag = false;
				}
				
				if (MAP[redI][redJ] == 'O') redSuccess = true;
				if (MAP[blueI][blueJ] == 'O') return Integer.MAX_VALUE;
				
				if (redJ == blueJ && redI == blueI) {
					if(rj < bj) redJ--;
					else blueJ--;
					
					redFlag = false;
					blueFlag = false;
				}
				
				
			}
			
			if (redSuccess) return moveCount;
		} 
		// i--
		else if (type == UP) {
			while (redFlag || blueFlag) {
				if (redFlag) redI--;
				if (blueFlag) blueI--;
				if (MAP[redI][redJ] == '#') {
					redI++;
					redFlag = false;
				}
				if (MAP[blueI][blueJ] == '#') {
					blueI++;
					blueFlag = false;
				}
				
				if (MAP[redI][redJ] == 'O') redSuccess = true;
				if (MAP[blueI][blueJ] == 'O') return Integer.MAX_VALUE;
				
				if (redJ == blueJ && redI == blueI) {
					if(ri < bi) blueI++;
					else redI++;
					
					redFlag = false;
					blueFlag = false;
				}
				
				
			}
			
			if (redSuccess) return moveCount;
		} 
		// i++
		else if (type == DOWN) {
			while (redFlag || blueFlag) {
				if (redFlag) redI++;
				if (blueFlag) blueI++;
				if (MAP[redI][redJ] == '#') {
					redI--;
					redFlag = false;
				}
				if (MAP[blueI][blueJ] == '#') {
					blueI--;
					blueFlag = false;
				}
				
				if (MAP[redI][redJ] == 'O') redSuccess = true;
				if (MAP[blueI][blueJ] == 'O') return Integer.MAX_VALUE;
				
				if (redJ == blueJ && redI == blueI) {
					if(ri < bi) redI--;
					else blueI--;
					
					redFlag = false;
					blueFlag = false;
				}			
				
			}
			
			if (redSuccess) return moveCount;
		}
		
		int left = getMinMove(redI, redJ, blueI, blueJ, LEFT, moveCount+1);
		int right = getMinMove(redI, redJ, blueI, blueJ, RIGHT, moveCount+1);
		int up = getMinMove(redI, redJ, blueI, blueJ, UP, moveCount+1);
		int down = getMinMove(redI, redJ, blueI, blueJ, DOWN, moveCount+1);
		
		int min = Integer.MAX_VALUE;
		if (left + right + up + down == -4) return -1;
		
		if (left > 0) min = left;
		if (right > 0 && min > right) min = right;
		if (up > 0 && min > up) min = up;
		if (down > 0 && min > down) min = down;
		if (min == Integer.MAX_VALUE) return -1;
		return min;
		
		
	}
}
