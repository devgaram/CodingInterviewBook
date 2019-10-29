package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * SET ��� ���ϱ�
 * ���� COUNT(=����) ���� �̹� ���� ���ڶ�� �� ������ �� �ʿ� ����
 * ���� ��� 1 1 2 ��� �� ��, 
 * count 1���� 1(index=0)�� ���. �׷� ������ 1, 2�� �����ϴ� ��츦 ���ϸ� ��
 * �״��� count 1���� 1(index=1)�� �����ϴ� ������ ����Ŵ�, �׷� ������ 1(index=0)�� 2�� �����ϴ� ����.
 * �ٽ� ���캸�� �ᱹ ������ ���ڰ� ���� ������ index=1�� 1�� �����൵ ��!..
 */
public class Q15663_E {
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
		solution(M, 0);
		out.flush();
		out.close();
	}

	public static void solution(int M, int count) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			return;
		}
		HashSet<Integer> used = new HashSet<Integer>();
		//boolean[] used = new boolean[10001]; // �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
		for (int i=0; i<arr.length; i++) {
			if ((!used.isEmpty() && !used.contains(arr[i]) && !visited[i]) || (used.isEmpty() && !visited[i])) {
				visited[i] = true;
				value[count] = arr[i];
				used.add(arr[i]);
				solution(M, count + 1);
				visited[i] = false;
			}

		}
	}
}
