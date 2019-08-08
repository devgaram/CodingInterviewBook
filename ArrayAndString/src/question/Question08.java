package question;

/*
 * Q. 0��� : M*N ����� �� ���Ұ� 0�� ���, �ش� ���Ұ� ���� ��� ���� ��� ���Ҹ� 0���� �����ϴ� �˰����� �ۼ��϶�.
 */
import java.util.*;
public class Question08 {

	public static void main(String[] args) {
		int[][] matrix = makeMatrix(5,5);
		matrix[2][3] = 0;
		matrix[4][0] = 0;
		printMatrix(matrix);
		setZero3(matrix);
		printMatrix(matrix);
		
	}
	
	// #��Ǯ��
	// �������⵵..?
	public static void setZero(int[][] matrix) {
		HashSet<Integer> hashSetI = new HashSet<Integer>();
		HashSet<Integer> hashSetJ = new HashSet<Integer>();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					hashSetI.add(i);
					hashSetJ.add(j);
				}
			}
		}
		for (int i=0; i<matrix.length; i++) {
			if (hashSetI.contains(i)) {
				for (int j=0; j<matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			} else {
				for (int j=0; j<matrix[i].length; j++) {
					if (hashSetJ.contains(j)) matrix[i][j] = 0;
				}
			}
			
			
		}
	}
	
	// #å Ǯ��1
	// �������⵵ O(N)
	public static void setZero2(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i=0; i<row.length; i++) {
			if (row[i]) nullifyRow(matrix, i);
		}
		
		for (int j=0; j<column.length; j++) {
			if (column[j]) nullifyColumn(matrix, j);
		}
	}
	
	// #åǮ�� - ù��° Ǯ���� �迭 ������ ����� ù��° ��,���� ����Ѵ�.
	// �������⵵ O(1)
	public static void setZero3(int[][] matrix) {
		
		boolean rowHasZero = false, columnHasZero = false;
		
		// ù��° �࿡�� 0 ã��
		for (int j=0; j<matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		//ù��° ������ ��ã��
		for (int i=0; i<matrix.length; i++) {
			if (matrix[i][0] == 0) {
				columnHasZero= true;
				break;
			}
		}
		
		for (int i=1; i<matrix.length; i++) {
			for (int j=1; j<matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for (int i=1; i<matrix.length; i++) {
			if (matrix[i][0] == 0) nullifyRow(matrix, i);
		}
		printMatrix(matrix);
		
		for (int j=1; j<matrix[0].length; j++) {
			if (matrix[0][j] == 0) nullifyColumn(matrix, j);
		}
		
		if (rowHasZero) nullifyRow(matrix, 0);
		if (columnHasZero) nullifyColumn(matrix, 0);
		
		
	}
	
	
	// �� 0���� ����
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j=0; j<matrix[row].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	// �� 0���� ����
	public static void nullifyColumn(int[][] matrix, int column) {
		for (int i=0; i<matrix.length; i++) {
			matrix[i][column] = 0;
		}
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
