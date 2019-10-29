package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * N과 M (4)
 * - 1부터 N까지 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 * - 고른 수열은 비내림차순이어야 한다
 * -- 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */
public class Q15652 {
	static int[] value;
	static BufferedWriter out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = sc.nextInt();
		int M = sc.nextInt();
		value = new int[M];		
		solution(N, M, 0, 1);
		out.flush();
		out.close();

	}
	public static void solution(int N, int M, int count, int start) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			
			return;
		}
		
		for (int i=start; i<=N; i++) {
				value[count] = i;
				solution(N, M, count + 1, i);
		}
	}
}
