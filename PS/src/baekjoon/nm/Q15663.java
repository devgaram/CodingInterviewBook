package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * N�� M (9)
 * N���� �ڿ����� �ڿ��� M�� �־����� ��, 
 * �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * N���� �ڿ����� ��� �ٸ� ���̴�.
 * - N���� �ڿ��� �߿��� M���� �� ����
 * �Է� 
 * 3 1
 * 4 4 2
 * ���
 * 2 
 * 4
 * ==> �ߺ����� ==> SET ===> ��ȿ��
 * 1 1 2 1
 * 1 1 2 
 * 1 1 1
 * 1 2 1
 * 1 1 1
 * 
 */
public class Q15663 {
	static int[] arr;
	static boolean[] visited;
	static int[] value;
	static BufferedWriter out;
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		set = new HashSet<String>();
		
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
			StringBuilder sbuf = new StringBuilder();
			for (int i=0; i<M; i++) {
				sbuf.append(value[i] + " ");
			}
			if (!set.isEmpty() && !set.contains(sbuf.toString())) {
				out.append(sbuf.toString());
				out.append("\n");
				set.add(sbuf.toString());				
			} else if (set.isEmpty()) {
				out.append(sbuf.toString());
				out.append("\n");
				set.add(sbuf.toString());			
			}			
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
