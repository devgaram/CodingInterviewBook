package string_builder;

public class StringBuilderTest {

	public static void main(String[] args) {
		// ���ڿ��� ����Ʈ�� �־����� ��, �ϳ��� �̾���̴� ���
		String[] words = {"aaa", "bbb", "ccc", "ddd", "eee"};
		System.out.println(joinWords(words));
		System.out.println(joinWords_stringBuilder(words));
	}
	
	/*
	 * ��Ʈ���� �Һ���ü�� ��Ʈ�� ���ϱ⸦ �ϸ� ���ο� ��Ʈ���� �������Ѵ�.
	 * ��, String ��ü + String ��ü�� �޸� ������ �Ҵ��� ������ ����
	 * O(n��) = 1 + 2 + 3 + ... + n = (1+n)n/2
	 */
	public static String joinWords(String[] words) {
		String sentence = "";
		for (String w : words) {
			sentence += w;
		}
		return sentence;
	}
	/*
	 * StringBuilder �ܼ��ϰ� ���� ũ�� �迭�� �̿��ؼ� �ʿ��� ��쿡�� ���ڿ��� �����ϰԲ� ���ش�.
	 * ���ο� ��ü ������ �ƴ϶� �ܼ��� �迭 ũ�� �����ؼ� ����
	 */
	public static String joinWords_stringBuilder(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for(String w :words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	

}
