package question;

/*
 * Q. 행렬회전 : 이미지를 표현하는 N x N 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
 * 이때, 이미지를 90도 회전시키는 메서드를 작성하라. 행렬을 추가로 사용하지 않고서도 할 수 있겠는가?
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
	
	// 행렬 추가해서 풀이
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
	
	// 행렬 없이 풀이
	// 시간복잡도 O(N^2)
	public static boolean rotate90V2(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int N = matrix.length;
		
		int tmp;
		for (int i=0; i<N/2; i++) { //행
			for (int j=i; j<N-1-i; j++) {
				tmp = matrix[i][j];
				
				//위<-왼
				matrix[i][j] = matrix[N-1-j][i];
				//왼<-아래쪽
				matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
				//아래쪽<-오른쪽
				matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
				//오른쪽<-위
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
