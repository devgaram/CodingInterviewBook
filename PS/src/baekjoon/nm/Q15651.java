package baekjoon.nm;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * N과 M (3)
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 */

/*
 * 시간 초과가 떴네...?
 * 음??...
 * 자바라서 그런 듯....? System.out.println 보다 BufferdWriter을 써주자
 */
public class Q15651 {
	static int[] value;
	static BufferedWriter out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = sc.nextInt();
		int M = sc.nextInt();
		value = new int[M];		
		solution(N, M, 0);
		out.flush();
		out.close();

	}
	public static void solution(int N, int M, int count) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			
			return;
		}
		
		for (int i=1; i<=N; i++) {
				value[count] = i;
				solution(N, M, count + 1);
		}
	}
}
