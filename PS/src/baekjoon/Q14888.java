package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14888 {
	static int N;
	static int[] num;
	static int[] math;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(in.readLine());
		num = new int[N];
		math = new int[4];
		String[] arrIn = in.readLine().split(" ");
		for (int i=0; i<arrIn.length; i++) 
			num[i] = Integer.parseInt(arrIn[i]);
		
		arrIn = in.readLine().split(" ");
		for (int i=0; i<4; i++)
			math[i] = Integer.parseInt(arrIn[i]);
			
		solution(0, new int[N-1]);
		System.out.println(MAX);
		System.out.println(MIN);
		in.close();
	}
	
	public static void solution(int useMathIdx, int[] useMath) {
		if (useMathIdx == N-1) {
			//print(useMath);
			int result = cal(useMath);
			if (result > MAX) MAX = result;
			if (result < MIN) MIN = result;
			return;
		}
		int[] orgMath = new int[4];
		for (int i=0; i<4; i++)
			orgMath[i] = math[i];
		
		for (int i=0; i<4; i++) {
			if (math[i] > 0) {
				useMath[useMathIdx] = i;
				math[i]--;
				solution(useMathIdx+1, useMath);
				for (int j=0; j<4; j++)
					math[j] = orgMath[j];
			}
		}
	}
	
	public static void print(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i]+ " ");
		System.out.println("");
		System.out.println("--------");
	}
	
	public static int cal(int[] useMath) {
		int result = num[0];
		for (int i=0; i<useMath.length; i++) {
			switch(useMath[i]) {
			case 0:
				result += num[i+1];
				break;
			case 1:
				result -= num[i+1];
				break;
			case 2:
				result *= num[i+1];
				break;
			case 3:
				result /= num[i+1];
				break;
				
			}
		}
		return result;
	}
}
