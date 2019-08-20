package question;

/*
 * ���� : �� ���� 32��Ʈ �� N�� M�� �־�����, ��Ʈ ��ġ i�� j�� �־����� ��, M�� N�� �����ϴ� �޼��带 �����϶�.
 * M�� N�� j��° ��Ʈ���� �����Ͽ� i��° ��Ʈ���� ������. j��° ��Ʈ���� i��° ��Ʈ�������� M�� ��� ����� ������ �ִٰ� �����Ѵ�.
 * �ٽ� ����, M = 10011 �̶��, j�� i ���̿� ��� �ټ� ��Ʈ�� �ִٰ� �����ص� �ȴٴ� ���̴�.
 * j=3, i=2 �� ���ó�� M�� ������ �� ���� ��Ȳ�� ������ �ʴ´ٰ� ���� �ȴ�.
 * 
 */
public class Question01 {
	
	public static void main(String[] args) {
		insertBit((int) Math.pow(2, 10), 19, 2, 6);
	}

	// 32��Ʈ(4����Ʈ) N,M .. ��Ʈ ��ġ i, j
	public static void insertBit(int N, int M, int i, int j) {
		System.out.println("N : " + Integer.toBinaryString(N));
		System.out.println("M : " + Integer.toBinaryString(M));
		
		int result = (N & ((-1 << j) | ((1 << i+1) -1))) | (M << i);
		
		System.out.println("RESULT : " + Integer.toBinaryString(result));
	}
}
