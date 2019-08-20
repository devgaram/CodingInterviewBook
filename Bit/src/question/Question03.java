package question;

/*
 * 비트 뒤집기 : 어떤 정수가 주어졌을 때 여러분은 이 정수의 비트 하나를 0에서 1로 바꿀 수 있다. 
 * 이때 1이 연속으로 나올 수 있는 가장 긴 길이를 구하는 코드를 작성하라.
 * 입력 1775 (11011101111)
 * 출력 8
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(reversalBit(602));
	}

	public static int reversalBit(int N) {
		if (~N == 0) return Integer.BYTES * 8; // 전부 1일 때
		
		int curLen = 0, preLen = 0, maxLen = 0;
		System.out.println(Integer.toBinaryString(N));
		while (N > 0) {
			if ((N & 1) == 1) {	// 끝자리 1
				curLen++;
			} else {	
				if ((N & 2) == 2) preLen = curLen;
				else preLen = 0;
				curLen = 0;				
			}
			if (maxLen < curLen + preLen) maxLen = curLen + preLen;
			N = N >>> 1;
		}
		return maxLen + 1;
		
	}
}
