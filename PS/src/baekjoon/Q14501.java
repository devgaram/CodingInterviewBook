package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q14501 {
	static int N;
	static int[] T;
	static int[] P;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		T = new int[N+1];
		P = new int[N+1];
		for(int i=1; i<N+1; i++) {
			String[] tmp = in.readLine().split(" ");
			T[i] = Integer.parseInt(tmp[0]);
			P[i] = Integer.parseInt(tmp[1]);
		}
		initCannot();
		out.write(getMaxPay() + "");
		out.close();
		in.close();	

	}

	public static void printJob(int[] tmp) {
		for (int i=1; i<N+1; i++)
			System.out.print(tmp[i]+ " ");
		System.out.println();
	}

	public static void initCannot() {
		for (int i=N; i>0; i--) {			
			if(T[i] - (N+1-i) > 0) {
				T[i] = 0;
				P[i] = 0;
			}
		}
	}

	public static int getMaxPay() {
		int maxPay = 0;

		for (int i=1; i<(1<<N); i++) {
			int bitMask = i;
			int pay = 0;
			for (int j=1; j<N+1; j++) {
				if ((bitMask & 1) == 1) {
					// 상담이 있고, 퇴사 전까시 완료할 수 있는 지
					if (T[j] > 0 && T[j] - (N+1-j) <= 0) {
						pay += P[j]; // 급여
						// 다음에 가능한 것 -1하는 이유는 for문 때메 j++ 이고 bitmask >>> 1 해서						
						bitMask = (bitMask >>> (T[j]-1));
						j = j + (T[j]-1);
					}
				}
				bitMask = (bitMask >>> 1);
			}
			if (maxPay < pay) maxPay = pay;
		}	

		return maxPay;
	}
}
