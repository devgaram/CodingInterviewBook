package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * N�� M (10)
 * N���� �ڿ����� �ڿ��� M�� �־����� ��, 
 * �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * N���� �ڿ����� ��� �ٸ� ���̴�.
 * - N���� �ڿ��� �߿��� M���� �� ����
 * - �� ������ �񳻸������̾�� �Ѵ�.
 * -- ���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
 */
public class Q15664 {
	static int[] arr;
	static boolean[] visited;
	static int[] value;
	static BufferedWriter out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		value = new int[M];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solution(M, 0, 0);
		out.flush();
		out.close();
	}

	public static void solution(int M, int count, int start) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			return;
		}
		HashSet<Integer> used = new HashSet<Integer>();
		//boolean[] used = new boolean[10001]; // �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
		for (int i=start; i<arr.length; i++) {
			if ((!used.isEmpty() && !used.contains(arr[i]) && !visited[i]) || (used.isEmpty() && !visited[i])) {
				visited[i] = true;
				value[count] = arr[i];
				used.add(arr[i]);
				solution(M, count + 1, i);
				visited[i] = false;
			}

		}
	}
}
