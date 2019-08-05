package question;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Q. 순열 확인 : 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라. (중복X)
 * 
 * 순열이란?
 * 서로 다른 n개에서 r개를 택하여 일렬로 배열하는 것(nPr)
 * 
 * 문자열 A,B가 순열 관계에 있는가? 
 * -> 문자열 B의 문자들이 모두 문자열 A에 있다 or 문자열 A의 문자들이 모두 문자열 B에 있다.
 * -> 문자열 A,B는 같은 문자로 구성되어 있고 순서만 다르다.
 *
 */
public class Question02 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(isPermutation("abcdefg","gfedcb") + "," + (System.currentTimeMillis()-time));
		time = System.currentTimeMillis();
		System.out.println(isPermutationSort("abcdefg","gfedcb") + "," + (System.currentTimeMillis()-time));
	}

	// #풀이1 : 정렬 후 비교
	// 시간복잡도 : O(nlogn) + O(nlogn) = O(nlogn)
	// 공간복잡도 : O(n)
	public static boolean isPermutationSort(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		return sort(str1).equals(sort(str2));
	}

	public static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return String.valueOf(content);

	}

	// #풀이2 : 정렬없이 순열관계 여부 알아내기 (아스키코드일 때)
	// 문자열에 포함된 문자의 출현 횟수가 같은지 검사하기
	// 시간복잡도 : O(n)
	// 공간복잡도 : O(n) or O(1)
	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		int[] checker = new int[128];	// 아스키코드는 128개로 구성되어있음.
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
