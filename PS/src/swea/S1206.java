package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.border.MatteBorder;

public class S1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arrIn;
		int[] arrTest;
		int N;
		int[] answer = new int[10];
		for (int i=0; i<10; i++) {
			N = Integer.parseInt(in.readLine());
			arrTest = new int[N];
			arrIn = in.readLine().split(" ");
			for (int j=0; j<N; j++) {
				arrTest[j] = Integer.parseInt(arrIn[j]);
			}
			answer[i] = solution(arrTest);
		}
		
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + answer[i]);
		}
	}
	
	public static int solution(int[] arr) {
		int answer = 0;
		for (int i=2; i<arr.length-2; i++) {
			if (arr[i] - arr[i-2] > 0 && arr[i] - arr[i-1] > 0 && arr[i] - arr[i+2] > 0 && arr[i] - arr[i+1] > 0) {
				answer += Math.min(Math.min(arr[i] - arr[i+2], arr[i] - arr[i+1]), Math.min(arr[i] - arr[i-2], arr[i] - arr[i-1]));
			}
		}
		return answer;
	}
}
