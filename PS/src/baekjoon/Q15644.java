package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Q15644 {
	static int N, M;
	static char[][] MAP;
	// left, right, up, down
	static int[] di = {0, 0, -1, 1};
	static int[] dj = {-1, 1, 0, 0};
	static char[] DIRECT = {'L', 'R', 'U', 'D'};
	static final int MAX_MOVE = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String[] size = in.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		MAP = new char[N][M];
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

		Result result = getMinMove(new Point(ri, rj, bi, bj, 0, 'S', null));
		System.out.println(result.moveCount);
		if (result.endPoint != null)
			print(result.endPoint);
		in.close();	

	}
	public static void print(Point point) {
		if (point.prePoint == null) return;
		print(point.prePoint);
		System.out.print(DIRECT[point.direction]);
	}


	public static Result getMinMove(Point point) {
		Queue<Point> queue = new LinkedList<Point>();
		int redi, redj, bluei, bluej;
		boolean redFlag, blueFlag, redSuccess, blueSuccess;
		int redMove, blueMove;		
		Result minResult = new Result(null, Integer.MAX_VALUE);


		// 첫 위치 넣기
		queue.add(point);

		while(!queue.isEmpty()) {			

			Point poll = queue.poll();			


			// 공 : left, right, up, down 이동 처리
			for (int i=0; i<4; i++) {
				redFlag = true;
				blueFlag = true;
				redSuccess = false;
				blueSuccess = false;
				redMove = 0;
				blueMove = 0;
				redi = poll.ri;
				redj = poll.rj;
				bluei = poll.bi;
				bluej = poll.bj;				

				while (redFlag || blueFlag) {
					// red 공 이동
					if (redFlag) {
						redi += di[i];
						redj += dj[i];
						redMove++;
					}
					// blue 공 이동
					if (blueFlag) {
						bluei += di[i];
						bluej += dj[i];
						blueMove++;
					}

					// red # 만났을 때, 한발자국 전으로
					if (MAP[redi][redj] == '#') {
						redi -= di[i];
						redj -= dj[i];
						redFlag = false;
					}

					// blue # 만났을 때, 한발자국 전으로
					if (MAP[bluei][bluej] == '#') {
						bluei -= di[i];
						bluej -= dj[i];
						blueFlag = false;
					}

					// red 탈출함!
					if (MAP[redi][redj] == 'O') {
						redSuccess = true;
						redFlag = false;
					}

					// blue 탈출함! --> 이 방향의 길은 갈 수 없어!! 큐에 넣을 필요도 없어!!
					if (MAP[bluei][bluej] == 'O') {
						blueSuccess = true;
						break;					
					}
				}
				if (!blueSuccess) {
					// 해당 방향으로 끝까지 이동했는데, red랑 blue 공이 같은 위치일 때, 더 많이 움직인 걸 한발자국 뒤로 이동시킴.
					if (redi == bluei && redj == bluej) {
						if (redMove < blueMove) {
							bluei -= di[i];
							bluej -= dj[i];					
						} else {
							redi -= di[i];
							redj -= dj[i];
						}
					}

					Point nextPoint = new Point(redi, redj, bluei, bluej, poll.moveCount+1, i,poll);
					// red공 탈출 성공! 현재 이동 값과 point 저장!!
					if (redSuccess) {
						if (minResult.moveCount > poll.moveCount) {
							minResult.moveCount = nextPoint.moveCount;
							minResult.endPoint = nextPoint;
						}
					} else {				
						// 큐에 넣기! (상,하,좌,우 갈 수 있는 좌표 끝)
						if (nextPoint.moveCount < 10)
							queue.add(nextPoint);
					}	
				}
			}
		}
		if (minResult.moveCount == Integer.MAX_VALUE) minResult.moveCount = -1;

		return minResult;

	}

	static class Point {
		int ri;
		int rj;
		int bi;
		int bj;		
		int moveCount;
		int direction; // 0, 1, 2, 3 
		Point prePoint;

		public Point(int ri, int rj, int bi, int bj, int moveCount, int direction, Point prePoint) {
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
			this.moveCount = moveCount;
			this.direction = direction;
			this.prePoint = prePoint;
		}
	}

	static class Result {
		Point endPoint;
		int moveCount;

		public Result(Point point, int count) {
			this.endPoint = point;
			this.moveCount = count;
		}
	}
}
