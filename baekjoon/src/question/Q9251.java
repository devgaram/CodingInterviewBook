package question;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// LIS ����
/*
 * ACAYKP
 * CAPCAK
 * 
 * ���� �����ڰ� �ٸ��� ACAYKP �� CAPCAK, ���� �ʴ� --> ACAYKP�� CAPCA �� LCS ACAYK�� CAPCAK �� LCS ���ؼ� ���̰� �� �� ��
 * ���� �����ڰ� ������ ACA�� CA --> AC�� C�� LCS�� + 1
 * 
 * 
 */
public class Q9251 {
	static String s1;
	static String s2;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		s1 = in.readLine();
		s2 = in.readLine();
		
		out.write(getLength() + "");
		out.close();
		in.close();
	}
	public static int getLength() {		
		int[][] vector = new int[s2.length()+1][s1.length()+1];
		
		for (int i=1; i<s2.length()+1; i++) {
			for (int j=1; j<s1.length()+1; j++) {
				if (s2.charAt(i-1) == s1.charAt(j-1)) {
					vector[i][j] = vector[i-1][j-1] + 1;
				} else {
					vector[i][j] = Math.max(vector[i-1][j], vector[i][j-1]);
				}
			}
		}
		return vector[s2.length()][s1.length()];
	}

}
