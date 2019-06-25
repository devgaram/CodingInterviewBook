package string_builder;

public class StringBuilderTest {

	public static void main(String[] args) {
		// 문자열의 리스트가 주어졌을 때, 하나로 이어붙이는 방법
		String[] words = {"aaa", "bbb", "ccc", "ddd", "eee"};
		System.out.println(joinWords(words));
		System.out.println(joinWords_stringBuilder(words));
	}
	
	/*
	 * 스트링은 불변객체라서 스트링 합하기를 하면 새로운 스트링을 만들어내야한다.
	 * 즉, String 객체 + String 객체는 메모리 해제와 할당을 만들어내는 연산
	 * O(n²) = 1 + 2 + 3 + ... + n = (1+n)n/2
	 */
	public static String joinWords(String[] words) {
		String sentence = "";
		for (String w : words) {
			sentence += w;
		}
		return sentence;
	}
	/*
	 * StringBuilder 단순하게 가변 크기 배열을 이용해서 필요한 경우에만 문자열을 복사하게끔 해준다.
	 * 새로운 객체 생성이 아니라 단순히 배열 크기 증가해서 저장
	 */
	public static String joinWords_stringBuilder(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for(String w :words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	

}
