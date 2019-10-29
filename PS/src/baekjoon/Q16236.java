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
 * 1) �Ʊ��� ó�� ũ��� 2
 * 2) 1�ʿ� �����¿� ������ �� ĭ �̵�
 * 3) 
 * 	����� > ��� : �� ������
 *  ����� = ��� : ������ �� ����
 *  ����� < ��� : ����
 * 4) �������� : ���� �� �ִ� ����� ���� ��
 * 5) ���� �� �ִ� ����� 1���� -> �װ� ������ ��
 * 6) ���� �� �ִ� ����Ⱑ 1���� �̻� 
 *    - �Ÿ��� ���� ����� �����(ĭ �ּ�) => row-row + col-col
 *      - ����� ����Ⱑ ������ ���� ���� �ִ� ����� - > ���� ����
 *      ---> �켱���� ���� ���� �� ����
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
			// ��� �ֱ�
			q.add(new Point(sRow, sCol, 0));
			visited[sRow][sCol] = true;
			MinDis = Integer.MAX_VALUE;
			
			// �Ÿ��� ������ ���� �� �ִ� ���(��) ã��
			while (!q.isEmpty()) {
				Point poll = q.poll();
				int r = poll.row;
				int c = poll.col;
				int d = poll.dis;
				
				// ���̰� ã��!
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
					// �̵��� �� ����!
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
