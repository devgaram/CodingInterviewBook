package question;

/*
 * Q. ȸ������ : �־��� ���ڿ��� ȸ���� �������� �ƴ��� Ȯ���ϴ� �Լ��� �ۼ��϶�.
 * ȸ���̶� ������ ������ �ڷ� ������ ���� �ܾ� Ȥ�� ������ �ǹ��ϸ�, �����̶� ���ڿ��� ���ġ�ϴ� ���� ���Ѵ�.
 * ȸ���� �� ������ �����ϴ� �ܾ�� ���ѵ� �ʿ�� ����.
 */
import java.util.*;

public class Question04 {

	public static void main(String[] args) {
		String input = "";
		Scanner scanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out.println("���ڿ��� �Է��ϼ���.");
			input = scanner.nextLine();
			System.out.println(isPalindrome2(input));
		}
	}
	
	// #�� Ǯ��
	// �ƽ�Ű�ڵ�� �������� ��
	// �ð����⵵ : O(n)
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
	
	// ��Ʈ���ͷ� �����ϱ�
	public static boolean isPalindrome3(String str) {
		
		return true;
	}
	
	
}
