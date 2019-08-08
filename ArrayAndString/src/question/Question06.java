package question;

/*
 * 문자열 압축 : 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
 * 예를 들어 문자열 aabccccaaa를 압축하면 a2b1c5a3이 된다. 
 * 만약 압축된 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야한다.
 * 문자열은 대소문자 알파벳(a~z)으로만 이루어져 있다.
 */
import java.util.*;
public class Question06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		while (!input.equals("exit")) {
			System.out.println("문자열을 입력하세요.");
			input = scanner.nextLine();
			System.out.println("압축된 문자열 : " + getCompressedString(input));
		}
	}
	
	// #내 풀이
	// String이 아닌 StringBuilder(가변크기배열을 이용해 필요한 경우에만 문자열 복사)를 이용한다.
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
