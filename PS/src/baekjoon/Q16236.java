package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/*
 * 1) 아기상어 처음 크기는 2
 * 2) 1초에 상하좌우 인접한 한 칸 이동
 * 3) 
 * 	물고기 > 상어 : 못 지나감
 *  물고기 = 상어 : 지나갈 수 있음
 *  물고기 < 상어 : 먹음
 * 4) 종료조건 : 먹을 수 있는 물고기 없을 때
 * 5) 먹을 수 있는 물고기 1마리 -> 그걸 먹으러 가
 * 6) 먹을 수 있는 물고기가 1마리 이상 
 *    - 거리가 가장 가까운 물고기(칸 최소) => row-row + col-col
 *      - 가까운 물고기가 많으면 가장 위에 있는 물고기 - > 가장 왼쪽
 *      ---> 우선순위 가장 위의 맨 왼쪽
 * 
 */

public class Q16236 {
	
	static int[][] MAP;
	static int[] dRow = {0, 0, -1, 1};
	static int[] dCol = {-1, 1, 0, 0};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		MAP = new int[N][N];
		
		String[] arr;
		int sRow = 0, sCol = 0;
		for (int i=0; i<N; i++) {
			arr = in.readLine().split(" ");
			for (int j=0; j<N; j++) {				
				MAP[i][j] = Integer.parseInt(arr[j]);
				if (MAP[i][j] == 9) {
					sRow = i;
					sCol = j;
					MAP[i][j] = 0;
				}
			}
		}
		
		System.out.println(solution(sRow, sCol));
		
		in.close();
	}
	
	
	public static int solution(int sRow, int sCol) {
		
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.dis != o2.dis) return o1.dis-o2.dis;
				if (o1.row != o2.row) return o1.row-o2.row;
				return o1.col-o2.col;
			}
		});
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited;
		int sharkSize = 2;
		int MinDis;
		int ansTime = 0;
		int eatCount = 0;
		
		while(true) {
			visited = new boolean[N][N];
			// 상어 넣기
			q.add(new Point(sRow, sCol, 0));
			visited[sRow][sCol] = true;
			MinDis = Integer.MAX_VALUE;
			
			// 거리가 가깝고 먹을 수 있는 상어(들) 찾기
			while (!q.isEmpty()) {
				Point poll = q.poll();
				int r = poll.row;
				int c = poll.col;
				int d = poll.dis;
				
				// 먹이감 찾음!
				if (MAP[r][c] > 0 && MAP[r][c] < sharkSize && MinDis >= d) {
					pq.add(poll);
					MinDis = d;
				}
				for (int i=0; i<4; i++) {
					int nextR = r + dRow[i];
					int nextC = c + dCol[i];
					int nextD = d + 1;
					
					if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;
					if (visited[nextR][nextC]) continue;
					// 이동할 수 있음!
					if (MAP[nextR][nextC] >= 0 && MAP[nextR][nextC] <= sharkSize && MinDis >= nextD) {
						visited[nextR][nextC] = true;
						q.add(new Point(nextR, nextC, nextD));
					}						
				}
			}
			
			if (pq.isEmpty()) break;
			else {
				Point target = pq.poll();
				MAP[target.row][target.col] = 0;
				ansTime += target.dis;	
				eatCount++;
				pq.clear();
				sRow = target.row;
				sCol = target.col;
				if (eatCount == sharkSize) {
					sharkSize++;
					eatCount = 0;
				}
			}
			
		}
		return ansTime;
	}
	
	static class Point {
		int row, col, dis;
		
		public Point(int row, int col, int dis) {
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
		
	}
}
