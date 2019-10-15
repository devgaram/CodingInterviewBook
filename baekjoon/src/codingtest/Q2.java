package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		//String[] size = in.readLine().split(" ");
		int[] v = {20,8,10};
		solution(v);
		in.close();
	}

	// 음 그니깐.. 첫번째 최대 첫번째 최소 + 두번째 최대 두번째 최소...
	static int[] p;
	static int MAX = Integer.MIN_VALUE;
	static int[] V;
	static boolean[] visited;
	public static void solution(int[] v) {
		
		V = v;
		p = new int[v.length];
		visited =new boolean[p.length];
		DFS(0);
		System.out.println(MAX);

	}
	 	
	public static void DFS(int index) {
		if (index == p.length) {
			MAX = Math.max(MAX,cal());
			print();
			return;
		}
		
		for (int i=0; i<V.length; i++) {
			if (!visited[i]) {
				p[index] = V[i];
				visited[i] = true;
				DFS(index + 1);	
				visited[i] = false;
			}
		}
	}
	
	public static void print() {
		for (int i=0; i<p.length; i++) {
			System.out.print(p[i] + " ");
			
		}
		System.out.println();
	}
	

	public static int cal() {
		int sum = 0;
		for (int i=1; i<p.length; i++) {
			sum += Math.abs(p[i-1] - p[i]);
		}
		return sum;
	}
}
