package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * SET 사용 안하기
 * 같은 COUNT(=깊이) 에서 이미 사용된 숫자라면 또 조합을 할 필요 없음
 * 예를 들어 1 1 2 라고 할 때, 
 * count 1에서 1(index=0)을 썼다. 그럼 나머지 1, 2로 조합하는 경우를 구하면 됨
 * 그다음 count 1에서 1(index=1)로 시작하는 조합을 만들거다, 그럼 나머지 1(index=0)과 2를 조합하는 경우다.
 * 다시 살펴보면 결국 조합의 숫자가 같기 때문에 index=1인 1은 안해줘도 됨!..
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
		//boolean[] used = new boolean[10001]; // 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
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
