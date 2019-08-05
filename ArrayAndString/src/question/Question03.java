package question;

/*
 * URL화 : 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를 작성하라.
 * 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있으며 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 * (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자배열을 이용하기 바란다)
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(toReplaceChange("Mr John Smith"));
		char[] input = new char[128]; // url을 위한 충분한 공간이 이미 확보되어있음
		String strInput = "Mr John Smith";
		for (int i = 0; i < strInput.length(); i++) {
			input[i] = strInput.charAt(i);
		}
		replaceSpaces(input, 13);
		System.out.println(input);
	}
	
	/*
	 * #해법
	 * 문자열 조작 문제를 풀 때, 널리 쓰이는 방법 중 하나는 문자열을 뒤에서부터 거꾸로 편집해나가는 것이다.
	 * 왜냐하면 이렇게 해야 마지막 부분에 여유 공간을 만들어 유용하게 사용할 수 있기 때문이다.
	 */
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i =0;
		
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') spaceCount++; // " "는 String ' '는 char
		}
		index = trueLength + spaceCount*2;	// 공백문자에 대체될 문자가 2자리라서.
		if (trueLength < str.length) str[trueLength] = '\0';	// ??? 굳이?
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
	
	// 내 풀이
	public static String toReplaceChange(String str) {
		return str.replace(" ", "%20");
	}

}
