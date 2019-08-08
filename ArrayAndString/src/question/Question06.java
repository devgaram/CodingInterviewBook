package question;

/*
 * ���ڿ� ���� : �ݺ��Ǵ� ������ ������ ���� ����� �⺻���� ���ڿ� ���� �޼��带 �ۼ��϶�.
 * ���� ��� ���ڿ� aabccccaaa�� �����ϸ� a2b1c5a3�� �ȴ�. 
 * ���� ����� ���ڿ��� ���̰� ���� ���ڿ��� ���̺��� ��ٸ� ���� ���ڿ��� ��ȯ�ؾ��Ѵ�.
 * ���ڿ��� ��ҹ��� ���ĺ�(a~z)���θ� �̷���� �ִ�.
 */
import java.util.*;
public class Question06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		while (!input.equals("exit")) {
			System.out.println("���ڿ��� �Է��ϼ���.");
			input = scanner.nextLine();
			System.out.println("����� ���ڿ� : " + getCompressedString(input));
		}
	}
	
	// #�� Ǯ��
	// String�� �ƴ� StringBuilder(����ũ��迭�� �̿��� �ʿ��� ��쿡�� ���ڿ� ����)�� �̿��Ѵ�.
	public static String getCompressedString(String str) {
		if (str.length() <= 1) return str;
		
		StringBuilder compressedStr = new StringBuilder();
		int count = 0;
		char preChar = str.charAt(0);
		
		for (char c : str.toCharArray()) {
			if (c != preChar) {
				if (str.length() < compressedStr.length() + 2) return str;
				compressedStr.append(preChar);
				compressedStr.append(count);				
				count = 0;
			}
			preChar = c;
			count++;
		}
		if (str.length() < compressedStr.length() + 2) return str;
		compressedStr.append(preChar);
		compressedStr.append(count);
		return compressedStr.toString();
		
	}
}
