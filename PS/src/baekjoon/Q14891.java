package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] MAP = new int[5][8];
		String strIn;
		for (int i=1; i<5; i++) {
			strIn = in.readLine();
			for (int j=0; j<8; j++) {
				MAP[i][j] = strIn.charAt(j) - 48;
			}
		}
		int count = Integer.parseInt(in.readLine());
		int[][] rotate = new int[count][2];
		String[] arrIn;
		for (int i=0; i<count; i++) {
			arrIn = in.readLine().split(" ");
			rotate[i][0] = Integer.parseInt(arrIn[0]);
			rotate[i][1] = Integer.parseInt(arrIn[1]);
		}
		//print(MAP);
		System.out.println(solution(MAP, rotate));
	}
	
	public static void print(int[][] MAP) {
		for (int i=1; i<MAP.length; i++) {
			for (int j=0; j<MAP[i].length; j++) 
				System.out.print(MAP[i][j]+ "");
			System.out.println();
		}
		System.out.println("--------");
	}

	// 으.. ㅡㅡ 서로 맞닺는 건 
	// 2번 6번
 	public static int solution(int[][] MAP, int[][] rotate) {
		int[] idx_2 = new int[5];
		int[] idx_6 = new int[5];
		for (int i=1; i<5; i++) {
			idx_2[i] = 2;
			idx_6[i] = 6;
		}
		
		for (int i=0; i<rotate.length; i++) {
			int target = rotate[i][0];
			int targetDirect = rotate[i][1];
			// 타겟의 톱니 상태 저장
			int targetState_2 = MAP[target][idx_2[target]];
			int targetState_6 = MAP[target][idx_6[target]];
			// 타겟 회전시키기
			idx_2[target] -= targetDirect;
			idx_6[target] -= targetDirect;
			if (idx_2[target] < 0) idx_2[target] = 7;
			if (idx_2[target] > 7) idx_2[target] = 0;
			if (idx_6[target] < 0) idx_6[target] = 7;
			if (idx_6[target] > 7) idx_6[target] = 0;
			
			int state_2 = targetState_2;
			int state_6 = targetState_6;
			int direct = targetDirect;
			// 타겟기준 왼쪽으로 전파
			for (int t=target-1; t>0; t--) {
				if (state_6 == MAP[t][idx_2[t]]) {
					break;
				} else {	
					state_6 = MAP[t][idx_6[t]];
					// 회전
					idx_2[t] +=direct;
					idx_6[t] +=direct;
					if (idx_2[t] < 0) idx_2[t] = 7;
					if (idx_2[t] > 7) idx_2[t] = 0;
					if (idx_6[t] < 0) idx_6[t] = 7;
					if (idx_6[t] > 7) idx_6[t] = 0;
					// 상태변화					
					direct = -direct;
				}
			}
			state_2 = targetState_2;
			state_6 = targetState_6;
			direct = targetDirect;
			// 타겟기준 오른쪽으로 전파
			for (int t=target+1; t<5; t++) {
				if (state_2 == MAP[t][idx_6[t]]) {
					break;
				} else {	
					state_2 = MAP[t][idx_2[t]];
					// 회전
					idx_2[t] +=direct;
					idx_6[t] +=direct;
					if (idx_2[t] < 0) idx_2[t] = 7;
					if (idx_2[t] > 7) idx_2[t] = 0;
					if (idx_6[t] < 0) idx_6[t] = 7;
					if (idx_6[t] > 7) idx_6[t] = 0;
					// 상태변화					
					direct = -direct;
				}
			}
		}
		
		int cal = 1;
		int index;
		int ans = 0;
		for (int i=1; i<5; i++) {
			index = idx_2[i];
			for (int j=0; j<2; j++) {
				index--;
				if (index < 0) index = 7;
				if (index > 7) index = 0;
			}
			ans += MAP[i][index] * cal;
			cal *=2;
		}
		
		return ans;
	}
 
}
