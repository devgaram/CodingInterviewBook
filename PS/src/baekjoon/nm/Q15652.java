package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * N�� M (4)
 * - 1���� N���� �ڿ��� �߿��� M���� �� ����
 * - ���� ���� ���� �� ��� �ȴ�.
 * - �� ������ �񳻸������̾�� �Ѵ�
 * -- ���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
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
