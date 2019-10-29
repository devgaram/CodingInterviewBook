package baekjoon.nm;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * N�� M (3)
 * �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * - 1���� N���� �ڿ��� �߿��� M���� �� ����
 * - ���� ���� ���� �� ��� �ȴ�.
 */

/*
 * �ð� �ʰ��� ����...?
 * ��??...
 * �ڹٶ� �׷� ��....? System.out.println ���� BufferdWriter�� ������
 */
public class Q15651 {
	static int[] value;
	static BufferedWriter out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = sc.nextInt();
		int M = sc.nextInt();
		value = new int[M];		
		solution(N, M, 0);
		out.flush();
		out.close();

	}
	public static void solution(int N, int M, int count) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			
			return;
		}
		
		for (int i=1; i<=N; i++) {
				value[count] = i;
				solution(N, M, count + 1);
		}
	}
}
