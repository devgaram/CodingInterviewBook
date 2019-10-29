package baekjoon.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N과 M (1)
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 입력) 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * 출력) 
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * 
 * 예)
 * 입력
 * 3 1
 * 출력
 * 1
 * 2
 * 3
 */

/*
 * 백트래킹 문제 
 */
public class Q15649 {
	static boolean[] check;
	static int[] value;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		check = new boolean[N+1];
		value = new int[M];
		solution(N, M, 0);

	}
	public static void solution(int N, int M, int count) {
		if (count == M) {
			for (int i=0; i<M; i++) {
				System.out.print(value[i] + " ");
			}
			System.out.println();
			
			return;
		}

		for (int i=1; i<=N; i++) {
			if (!check[i]) {
				check[i] = true;
				value[count] = i;
				solution(N, M, count + 1);
				check[i] = false;
			}
		}
	}
}
