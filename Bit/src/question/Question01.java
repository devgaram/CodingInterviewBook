package question;

/*
 * 삽입 : 두 개의 32비트 수 N과 M이 주어지고, 비트 위치 i와 j가 주어졌을 때, M을 N에 삽입하는 메서드를 구현하라.
 * M은 N의 j번째 비트에서 시작하여 i번째 비트에서 끝난다. j번째 비트에서 i번째 비트까지에는 M을 담기 충분한 공간이 있다고 가정한다.
 * 다시 말해, M = 10011 이라면, j와 i 사이에 적어도 다섯 비트가 있다고 가정해도 된다는 것이다.
 * j=3, i=2 인 경우처럼 M을 삽입할 수 없는 상황은 생기지 않는다고 봐도 된다.
 * 
 */
public class Question01 {
	
	public static void main(String[] args) {
		insertBit((int) Math.pow(2, 10), 19, 2, 6);
	}

	// 32비트(4바이트) N,M .. 비트 위치 i, j
	public static void insertBit(int N, int M, int i, int j) {
		System.out.println("N : " + Integer.toBinaryString(N));
		System.out.println("M : " + Integer.toBinaryString(M));
		
		int result = (N & ((-1 << j) | ((1 << i+1) -1))) | (M << i);
		
		System.out.println("RESULT : " + Integer.toBinaryString(result));
	}
}
