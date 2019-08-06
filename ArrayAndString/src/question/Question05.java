package question;

/*
 * Q. 하나 빼기 : 문자열을 편집하는 방법에는 세가지 종류가 있다. 문자 삽입, 문자삭제, 문자교체, 문자열 두 개가 주어졌을 때, 
 * 문자열을 같게 만들기 위한 편집횟수가 1회 이내인지 확인하는 함수를 작성하라.
 */
import java.util.*;
public class Question05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String[] inputs = new String[2];


		while(!input.equals("exit")) {
			System.out.println("문자열 2개를 입력하세요. 예) 첫번째문자열, 두번째문자열");
			input = scanner.nextLine();
			inputs = input.replaceAll(" ", "").split(",");
			if (inputs.length == 2)
				System.out.println(isEditCntOne2(inputs[0], inputs[1]));

		}
	}

	// # 내 풀이 --> 잘못된 풀이, 문자열 순서를 고려안함...
	public static boolean isEditCntOne(String str1, String str2) {
		Map<Character, Integer> checkerMap = new HashMap<Character, Integer>();
		int editCount = 0;

		for (char c : str1.toCharArray()) {
			if (checkerMap.containsKey(c)) checkerMap.put(c, checkerMap.get(c) + 1);
			else checkerMap.put(c, 1);
		}

		for (char c : str2.toCharArray()) {
			if (checkerMap.containsKey(c)) checkerMap.put(c, checkerMap.get(c) - 1);
			else checkerMap.put(c,1);
		}

		Collection<Integer> values = checkerMap.values();

		for (int value : values) {
			if (value != 0) editCount++;
			if (editCount > 2) break;
		}

		if (str1.length() != str2.length()) {	// 삽입, 삭제 케이스
			if (editCount > 1) return false;
		} else {	// 교체 케이스
			if (editCount > 2) return false;
		}


		return true;
	}

	// # 책풀이
	public static boolean isEditCntOne2(String str1, String str2) {
		int i=0, j=0;		
		boolean editFlag = false;
		if (Math.abs(str1.length() - str2.length()) > 1) return false;
		
		boolean replaceFlag = (str1.length() == str2.length()) ? true : false;
		String first = str1.length() > str2.length() ? str1 : str2;
		String second = str1.length() > str2.length() ? str2 : str1;

		while (i < first.length() && j < second.length()) {			
			if (first.charAt(i) == second.charAt(j)) j++;
			else {
				if (editFlag) return false;
				editFlag = true;
				if (replaceFlag) j++;
			}
			i++;			
		}

		return true;
	}


}
