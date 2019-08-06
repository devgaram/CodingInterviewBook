package question;

/*
 * Q. �ϳ� ���� : ���ڿ��� �����ϴ� ������� ������ ������ �ִ�. ���� ����, ���ڻ���, ���ڱ�ü, ���ڿ� �� ���� �־����� ��, 
 * ���ڿ��� ���� ����� ���� ����Ƚ���� 1ȸ �̳����� Ȯ���ϴ� �Լ��� �ۼ��϶�.
 */
import java.util.*;
public class Question05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String[] inputs = new String[2];


		while(!input.equals("exit")) {
			System.out.println("���ڿ� 2���� �Է��ϼ���. ��) ù��°���ڿ�, �ι�°���ڿ�");
			input = scanner.nextLine();
			inputs = input.replaceAll(" ", "").split(",");
			if (inputs.length == 2)
				System.out.println(isEditCntOne2(inputs[0], inputs[1]));

		}
	}

	// # �� Ǯ�� --> �߸��� Ǯ��, ���ڿ� ������ �������...
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

		if (str1.length() != str2.length()) {	// ����, ���� ���̽�
			if (editCount > 1) return false;
		} else {	// ��ü ���̽�
			if (editCount > 2) return false;
		}


		return true;
	}

	// # åǮ��
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
