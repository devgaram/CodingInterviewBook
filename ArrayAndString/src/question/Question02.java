package question;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Q. ���� Ȯ�� : ���ڿ� �� ���� �־����� �� �� ���� ���� ���� ���迡 �ִ��� Ȯ���ϴ� �޼��带 �ۼ��϶�. (�ߺ�X)
 * 
 * �����̶�?
 * ���� �ٸ� n������ r���� ���Ͽ� �Ϸķ� �迭�ϴ� ��(nPr)
 * 
 * ���ڿ� A,B�� ���� ���迡 �ִ°�? 
 * -> ���ڿ� B�� ���ڵ��� ��� ���ڿ� A�� �ִ� or ���ڿ� A�� ���ڵ��� ��� ���ڿ� B�� �ִ�.
 * -> ���ڿ� A,B�� ���� ���ڷ� �����Ǿ� �ְ� ������ �ٸ���.
 *
 */
public class Question02 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(isPermutation("abcdefg","gfedcb") + "," + (System.currentTimeMillis()-time));
		time = System.currentTimeMillis();
		System.out.println(isPermutationSort("abcdefg","gfedcb") + "," + (System.currentTimeMillis()-time));
	}

	// #Ǯ��1 : ���� �� ��
	// �ð����⵵ : O(nlogn) + O(nlogn) = O(nlogn)
	// �������⵵ : O(n)
	public static boolean isPermutationSort(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		return sort(str1).equals(sort(str2));
	}

	public static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return String.valueOf(content);

	}

	// #Ǯ��2 : ���ľ��� �������� ���� �˾Ƴ��� (�ƽ�Ű�ڵ��� ��)
	// ���ڿ��� ���Ե� ������ ���� Ƚ���� ������ �˻��ϱ�
	// �ð����⵵ : O(n)
	// �������⵵ : O(n) or O(1)
	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		int[] checker = new int[128];	// �ƽ�Ű�ڵ�� 128���� �����Ǿ�����.
		char[] arr_str1 = str1.toCharArray();
		for (char c : arr_str1) {
			checker[c]++;
		}

		for(int i = 0; i < str2.length(); i++) {
			checker[str2.charAt(i)]--;
			if (checker[str2.charAt(i)] < 0) return false;
		}
		return true;	

	}
}
