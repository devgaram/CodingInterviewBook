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


		// ù ��ġ �ֱ�
		queue.add(point);

		while(!queue.isEmpty()) {			

			Point poll = queue.poll();			


			// �� : left, right, up, down �̵� ó��
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
					// red �� �̵�
					if (redFlag) {
						redi += di[i];
						redj += dj[i];
						redMove++;
					}
					// blue �� �̵�
					if (blueFlag) {
						bluei += di[i];
						bluej += dj[i];
						blueMove++;
					}

					// red # ������ ��, �ѹ��ڱ� ������
					if (MAP[redi][redj] == '#') {
						redi -= di[i];
						redj -= dj[i];
						redFlag = false;
					}

					// blue # ������ ��, �ѹ��ڱ� ������
					if (MAP[bluei][bluej] == '#') {
						bluei -= di[i];
						bluej -= dj[i];
						blueFlag = false;
					}

					// red Ż����!
					if (MAP[redi][redj] == 'O') {
						redSuccess = true;
						redFlag = false;
					}

					// blue Ż����! --> �� ������ ���� �� �� ����!! ť�� ���� �ʿ䵵 ����!!
					if (MAP[bluei][bluej] == 'O') {
						blueSuccess = true;
						break;					
					}
				}
				if (!blueSuccess) {
					// �ش� �������� ������ �̵��ߴµ�, red�� blue ���� ���� ��ġ�� ��, �� ���� ������ �� �ѹ��ڱ� �ڷ� �̵���Ŵ.
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
					// red�� Ż�� ����! ���� �̵� ���� point ����!!
					if (redSuccess) {
						if (minResult.moveCount > poll.moveCount) {
							minResult.moveCount = nextPoint.moveCount;
							minResult.endPoint = nextPoint;
						}
					} else {				
						// ť�� �ֱ�! (��,��,��,�� �� �� �ִ� ��ǥ ��)
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
