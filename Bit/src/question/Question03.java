package question;

/*
 * ��Ʈ ������ : � ������ �־����� �� �������� �� ������ ��Ʈ �ϳ��� 0���� 1�� �ٲ� �� �ִ�. 
 * �̶� 1�� �������� ���� �� �ִ� ���� �� ���̸� ���ϴ� �ڵ带 �ۼ��϶�.
 * �Է� 1775 (11011101111)
 * ��� 8
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(reversalBit(602));
	}

	public static int reversalBit(int N) {
		if (~N == 0) return Integer.BYTES * 8; // ���� 1�� ��
		
		int curLen = 0, preLen = 0, maxLen = 0;
		System.out.println(Integer.toBinaryString(N));
		while (N > 0) {
			if ((N & 1) == 1) {	// ���ڸ� 1
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
