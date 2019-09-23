package dp;

import java.util.Scanner;

public class Q10164 {
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
        if (x == 0) return way(1, 1, r, c);
        else {
            int xr = (int) Math.ceil((double)x/(double)c);
            int xc = (x % c == 0) ? c : x % c;
            return way(1, 1, xr, xc) * way(xr, xc, r, c);
        }
    }
    
    public static int way(int sr, int sc, int er, int ec) {
    	int[][] cache = new int[er+1][ec+1];
        for (int cr=1; cr<er+1; cr++) {
        	for (int cc=1; cc<ec+1; cc++) {
        		cache[cr][cc] = -1;        		
        	}
        }
        return way(sr, sc, er, ec, cache);
    }
    
    public static int way(int sr, int sc, int er, int ec, int[][] cache) {    	 
        if (er < sr || ec < sc) return 0;
        else if (er == sr && ec == sc) return 1;
        else if (cache[er][ec] < 0) {
            cache[er][ec] = way(sr, sc, er-1, ec, cache) + way(sr, sc, er, ec-1, cache);
            return cache[er][ec];
        } else return cache[er][ec];
    }
}
