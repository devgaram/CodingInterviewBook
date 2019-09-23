package dp;

import java.util.Scanner;

public class Q10164_E {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int r, c, x;
		r = sc.nextInt();
		c = sc.nextInt();
        x = sc.nextInt();
        int countWay = way(r, c, x);
        System.out.println(countWay);
	}
	
	public static int way(int r, int c, int x) {     
		int[][] map = new int[r+1][c+1];
		map[0][1] = 1;
		for (int i=1; i<r+1; i++) {
			for (int j=1; j<c+1; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
        if (x == 0) return map[r][c];
        else {
            int xr = (int) Math.ceil((double)x/(double)c);
            int xc = (x % c == 0) ? c : x % c;
            return map[xr][xc] * map[r-xr+1][c-xc+1];
        }
    }
}
