package question;

/*
 * Q. 회문순열 : 주어진 문자열이 회문의 순열인지 아닌지 확인하는 함수를 작성하라.
 * 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미하며, 순열이란 문자열을 재배치하는 것을 뜻한다.
 * 회문이 꼭 사전에 등장하는 단어로 제한될 필요는 없다.
 */
import java.util.*;

public class Question04 {

	public static void main(String[] args) {
		String input = "";
		Scanner scanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out.println("문자열을 입력하세요.");
			input = scanner.nextLine();
			System.out.println(isPalindrome2(input));
		}
	}
	
	// #내 풀이
	// 아스키코드로 한정했을 때
	// 시간복잡도 : O(n)
	public static boolean isPalindrome(String str) {
		Map<Character, Integer> checkerMap = new HashMap<>();
		char key;
		int oddCount = 0;
		int setLowerCase = 'a' - 'A';
		
		for (int i=0; i<str.length(); i++) {
			key = str.charAt(i);			
			if (key != ' ') {
				if (key >= 'A' && key <= 'Z') key+=setLowerCase;
				if (checkerMap.containsKey(key)) {
					checkerMap.put(key, checkerMap.get(key)+1);
				} else checkerMap.put(key, 1);
			}			
		}
		
		Collection<Integer> values = checkerMap.values();
		for (Integer value : values) {
			if (value % 2 == 1) oddCount++;
			if (oddCount > 1) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome2(String str) {
		Map<Character, Integer> checkerMap = new HashMap<>();
		char key;
		int oddCount = 0;
		int setLowerCase = 'a' - 'A';
		
		for (int i=0; i<str.length(); i++) {
			key = str.charAt(i);			
			if (key != ' ') {
				if (key >= 'A' && key <= 'Z') key+=setLowerCase;
				if (checkerMap.containsKey(key)) {
					checkerMap.put(key, checkerMap.get(key)+1);
				} else checkerMap.put(key, 1);
				if (checkerMap.get(key) % 2 == 1) oddCount++;
				else oddCount--;
			}			
		}
		if (oddCount > 1) return false;
		
		return true;
	}
	
	// 비트벡터로 구현하기
	public static boolean isPalindrome3(String str) {
		
		return true;
	}
	
	
}
