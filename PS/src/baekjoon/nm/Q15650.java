package baekjoon.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N과 M (2)
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * - 고른 수열은 오름차순이어야 한다.
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
