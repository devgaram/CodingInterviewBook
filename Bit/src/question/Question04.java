package question;

/*
 * ���� ���� : ���� ������ �ϳ� �־�����. �� ���ڸ� 2������ ǥ������ �� 1��Ʈ�� ������ ���� ���� �߿��� ���� ���� ���� ���� ū ���� ���϶�.
 */
public class Question04 {

	public static void main(String[] args) {
		question04(10);
	}
	
	public static void question04(int N) {
		int count = 0, bitCount = 0, remain = 0;
		int max = 0, min = 0;
		
		System.out.println("N : " + N);
		
		while (N > 0) {
			remain = N % 2;
			N = N / 2;
			count++;
			if (remain == 1) bitCount++;
		}
		
//		for (int i = 0; i< bitCount; i++) {
//			max += Math.pow(2, count-1-i);
//			min += Math.pow(2, i);
//		}
		 min = ((1<<bitCount)-1);
		 
		 max = ((1 << count) -1) & ~((1 << count-bitCount) -1 );
			
		
		System.out.println("max : " + max);
		System.out.println("min :" + min);
	}
	
}
