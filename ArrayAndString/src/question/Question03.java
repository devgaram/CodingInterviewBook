package question;

/*
 * URLȭ : ���ڿ��� ��� �ִ� ��� ������ '%20'���� �ٲ� �ִ� �޼��带 �ۼ��϶�.
 * ���������� ��� ���ڸ� �� ���� �� ���� ��ŭ ����� ������ �̹� Ȯ���Ǿ� ������ ���ڿ��� ���� ���̰� �Բ� �־����ٰ� �����ص� �ȴ�.
 * (�ڹٷ� �����Ѵٸ� �迭 �ȿ��� �۾��� �� �ֵ��� ���ڹ迭�� �̿��ϱ� �ٶ���)
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(toReplaceChange("Mr John Smith"));
		char[] input = new char[128]; // url�� ���� ����� ������ �̹� Ȯ���Ǿ�����
		String strInput = "Mr John Smith";
		for (int i = 0; i < strInput.length(); i++) {
			input[i] = strInput.charAt(i);
		}
		replaceSpaces(input, 13);
		System.out.println(input);
	}
	
	/*
	 * #�ع�
	 * ���ڿ� ���� ������ Ǯ ��, �θ� ���̴� ��� �� �ϳ��� ���ڿ��� �ڿ������� �Ųٷ� �����س����� ���̴�.
	 * �ֳ��ϸ� �̷��� �ؾ� ������ �κп� ���� ������ ����� �����ϰ� ����� �� �ֱ� �����̴�.
	 */
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i =0;
		
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') spaceCount++; // " "�� String ' '�� char
		}
		index = trueLength + spaceCount*2;	// ���鹮�ڿ� ��ü�� ���ڰ� 2�ڸ���.
		if (trueLength < str.length) str[trueLength] = '\0';	// ??? ����?
		for (i = trueLength-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index = index - 3;
			} else {
				str[index-1] = str[i];
				index--;
			}
		}
		
	}
	
	// �� Ǯ��
	public static String toReplaceChange(String str) {
		return str.replace(" ", "%20");
	}

}
