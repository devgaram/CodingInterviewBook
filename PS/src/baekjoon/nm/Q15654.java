package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * N�� M (5)
 * N���� �ڿ����� �ڿ��� M�� �־����� ��, 
 * �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * N���� �ڿ����� ��� �ٸ� ���̴�.
 * - N���� �ڿ��� �߿��� M���� �� ����
 * 
 * ��)
 * ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)
 * ��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
 */
public class Q15654 {
	
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
		for (int i=0; i<arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				value[count] = arr[i];
				solution(M, count + 1);
				visited[i] = false;
			}
		}
	}
}
