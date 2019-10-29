package baekjoon.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N�� M (2)
 * �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * - 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
 * - �� ������ ���������̾�� �Ѵ�.
 */
public class Q15650 {
	static boolean[] check;
	static int[] value;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		check = new boolean[N+1];
		value = new int[M];
		solution(N, M, 0, 1);

	}
	public static void solution(int N, int M, int count, int start) {
		if (count == M) {
			for (int i=0; i<M; i++) {
				System.out.print(value[i] + " ");
			}
			System.out.println();
			
			return;
		}

		for (int i=start; i<=N; i++) {
			if (!check[i]) {
				check[i] = true;
				value[count] = i;
				solution(N, M, count + 1, i+1);
				check[i] = false;
			}
		}
	}
}
