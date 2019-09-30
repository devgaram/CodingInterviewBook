package question;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Q16637 {
	static int N;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		str = in.readLine();
		out.write(getMaxValue() + "");
		out.close();
		in.close();
	}
	
	public static int getMaxValue() {
		if (N == 1) return str.charAt(0)-'0';
		int[] NUM = new int[N/2+1];
		char[] CAL = new char[N/2];
		int n = -1, c = -1;
		for (int i=0; i<str.length(); i++) {
			if (i % 2 == 0) NUM[++n] = str.charAt(i) - 48;
			else CAL[++c] = str.charAt(i);
		}
		
		int CntCal = N/2;
		int MaxBracket = (N/2+1)/2;
		int MaxSum = Integer.MIN_VALUE;
		boolean[] isBracketCal = new boolean[CntCal];
		for(int i=1; i<(1<<CntCal); i++) {
			if (Integer.bitCount(i) <= MaxBracket) {
				// 괄호 넣기
				for (int j=0; j<CntCal; j++) {
					if ((i & (1<<j)) > 0) {
						isBracketCal[j] = true;						
					}
				}
//				for (int j=0; j<isBracketCal.length; j++)
//					System.out.print(isBracketCal[j] + " ");
//				System.out.println();
				
				LinkedList<Integer> queue = new LinkedList<Integer>();
				queue.addLast(NUM[0]);
				
				// 실제 계산
				for (int j=0; j<CntCal; j++) {
					// 현재 연산자 우선 처리
					if (isBracketCal[j]) {
						int pullNum = queue.removeLast();
						queue.addLast(calcurate(pullNum, NUM[j+1], CAL[j]));
						if (j+1 < CntCal) isBracketCal[j+1] = false;
					} else {
						queue.addLast((int) CAL[j]);
						queue.addLast(NUM[j+1]);
					}					
				}
				int sum = queue.removeFirst();
				while (!queue.isEmpty()) {
					int pollBracket = queue.removeFirst();
					int pollNum = queue.removeFirst();
					sum = calcurate(sum, pollNum, pollBracket);
				}
				if (MaxSum < sum) MaxSum = sum;	
				
				for (int j=0; j<isBracketCal.length; j++)
					isBracketCal[j] = false;
			}
		}
		
		return MaxSum;
	}
	
	public static int calcurate(int a, int b, int c ) {		
		if (c == '+') {
			return a + b;
		} else if (c == '-') {
			return a - b;
		} else if (c == '*') {
			return a * b;
		}
		return 0;
	}
}
