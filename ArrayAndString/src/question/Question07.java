package question;

/*
 * Q. ���ȸ�� : �̹����� ǥ���ϴ� N x N ����� �ִ�. �̹����� �� �ȼ��� 4����Ʈ�� ǥ���ȴ�.
 * �̶�, �̹����� 90�� ȸ����Ű�� �޼��带 �ۼ��϶�. ����� �߰��� ������� �ʰ��� �� �� �ְڴ°�?
 */
import java.util.*;
public class Question07 {
	
	public static void main(String[] args) {
		
		int[][] matrix = makeMatrix(5,5);
		
		printMatrix(matrix);
		int[][] clone = rotate90(matrix);
		printMatrix(clone);
		boolean result = rotate90V2(matrix);
		printMatrix(matrix);
		
	}
	
	// ��� �߰��ؼ� Ǯ��
	public static int[][] rotate90(int[][] matrix) {
		int N = matrix.length;
		int[][] clone = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				clone[j][N - 1 - i] = matrix[i][j];
			}
		}
		
		return clone;
		
		
	}
	
	// ��� ���� Ǯ��
	// �ð����⵵ O(N^2)
	public static boolean rotate90V2(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int N = matrix.length;
		
		int tmp;
		for (int i=0; i<N/2; i++) { //��
			for (int j=i; j<N-1-i; j++) {
				tmp = matrix[i][j];
				
				//��<-��
				matrix[i][j] = matrix[N-1-j][i];
				//��<-�Ʒ���
				matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
				//�Ʒ���<-������
				matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
				//������<-��
				matrix[j][N-1-i] = tmp;
				
			}
		}
		return true;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
	
	public static int[][] makeMatrix(int M, int N) {
		int[][] matrix = new int[M][N];
		int cnt = 1;
		for (int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = cnt;
				cnt++;
			}
		}
		return matrix;
	}
}
