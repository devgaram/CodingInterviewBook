package question;

/*
 * 문제)
 * 중복이 없는가 : 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 구현하기
 * 자료구조를 추가로 사용하지않고 풀 수 있는 알고리즘 또한 고민하기.
 * 
 * 추가 질문사항) 
 * 면접관에게 문자열이 ASCII 문자열인지 유니코드 문자열인지 물어 봐야 한다. --> 아스키로 가정하면, 2^7 문자열 최대 길이 128로 한정
 * 
 * ASCII란?
 * 7bit 인코딩, 33개(출력 불가능한 제어 문자) + 95개(공백+출력 가능한 문자) = 128개
 * 95개 = 52개(영문 알파벳 대소문자) + 10개(숫자) + 32개(특수문자) + 1개(공백)
 * 숫자 0~9 : 48~57(10), 대문자 A~Z : 65~90(26), 소문자 a~z : 97~122(26) 
 * 
 * 유니코드란?
 * 각 나라별 언어를 모두 표현하기 위해 나온 코드 체계이다.
 * 언어와 상관없이 모든 문자를 16비트로 표현하므로 최대 65,536까지 표현할 수 있다.
 */

import java.util.*;

public class Question01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요.");
		String input = scanner.nextLine();
		while (input.compareTo("exit") != 0) {
			System.out.println(isUniqueCharsSort(input));
			System.out.println("문자열을 입력하세요.");
			input = scanner.nextLine();
		}
		
	}
	
	/*
	 * hint : 아스키코드의 갯수는 128개
	 * 시간복잡도 : O(n) n:문자열의 길이
	 * 공간복잡도 : O(1) 문자집합의 크기를 미리 지정해놔서.
	 * cf) 문자집합 크기 미리 지정안한다면,
	 * 시간복잡도 : O(min(c,n)) or O(c) c:문자집합의 크기
	 * 공간복잡도 : O(c)
	 */
	public static boolean isUniqueChars(String arg) {
		if (arg.length() > 128) return false;
		boolean[] char_set = new boolean[128];	//boolean default: false
		for(int i =0; i < arg.length(); i++) {
			int val = arg.charAt(i);
			if (char_set[val]) return false;
			else char_set[val] = true;
		}
		return true;
	}
	
	/*
	 * 문제) 비트벡터 사용해서 a~z 중복문자열 여부 반환.
	 * 공간을 줄일 수 있다.(메모리효율 높인다)
	 * --> 위에 방법 이용시 boolean[26] --> 1byte*26 = 26byte + 4byte(배열위치) = 30byte
	 * --> 비트벡터 이용시 int 변수 한개 --> 4byte 
	 * 단, 범위가 한정적일 때 유용함!
	 * 
	 * 기본개념)
	 * OR연산(|) : 특정비트값을 1로 만들고 싶다면, 바꾸고자 하는 비트 값의 위치에 1, 나머지는 0을 채운 값으로 OR 연산을 하면 된다.
	 * AND연산(&) : 특정비트값을 0으로 만들고 싶다면, 바꾸고자 하는 비트 값의 위치에0, 나머지는 1을 채우고 AND 연산을 한다.
	 * 			 : 특정비트가 1인지 확인하는 데 사용할 수 있다. 원하는 위치에 1, 나머지 0으로 채우고 AND 하면 된다.
	 * 비트벡터의 의미) 
	 * 중복없는 숫자 조합 {1,2,6}, 범위는 0~7
	 * a b c d e f g h i z k l n m .. (범위 대상)
	 *   유 유       유
	 * 0 1 1 0 0 0 1 0 0 0 0 0 0 0 .. (비트벡터)
	 * 
	 * -> 각각의 대상 값을 각각의 비트에 매칭시키므로 대상 범위만큼의 비트 갯수가 필요하다.
	 */
	
	public static boolean isUniqueCharsBit(String arg) {
		/*
		 * 'a'~'z' 는 26개 이므로 최소 26비트 이상을 저장할 수 있는 변수가 필요하다.
		 * int는  4byte = 32bit로 충분하므로 int 변수를 checker로 사용한다.
		 * cf) int 4byte, char 2byte, boolean 1byte, float 4byte
		 */
		int checker = 0;
		for (int i = 0; i < arg.length(); i++) {
			/*
			 * 원래 'a'의 아스키 코드 값은  97이다.
			 * 'a'~'z' : 97~122 
			 * 'a'를 빼는 것의 의미는 'a'~'z'를 0~25로 만들겠다는 것
			 */
			int val = arg.charAt(i) - 'a';
			/*
			 * 1을 val만큼 shift 하겠다 'a'~'z'를 각 비트의 위치가 겹치지않게 하기위해서.
			 * .... 0000 0001 << 0~25
			 * 'a', 0 : .... 0000 0001
			 * 'b', 1 : .... 0000 0010
			 * 'c', 2 : .... 0000 0100
			 * 'd', 3 : .... 0000 1000
			 */
			val = 1 << val; 
			/*
			 * 특정비트가 1이라는 것을 알고 싶을 때 그 비트 위치만 1로 한 후, AND 연산자를 실행한다.
			 * 앞서 설명했듯이, 각각의 문자의 비트 위치는 겹치지 않게 설정했기 때문에
			 * val로 AND 연산자를 했을 때, 0보다 큰 값, 즉  벡터에 1비트가 뜨면 중복이 되었다는 뜻이다.
			 */
			if ((checker & val) > 0) return false;
			/*
			 * 앞서 나온 문자와 중복이 아닐 때, 해당 문자의 비트 값(1)을 checker에 저장하는 용도
			 * OR 연산자는 특정 비트를 1로 바꾸고 싶으면 그 위치를 1로 한 후 OR 연산하면 된다. 라는 특징 기억하면 됨!!
			 */
			else checker |= val;
		}
		return true;
	}
	
	/*
	 * 조건 ) 자료구조를 추가로 사용하면 안된다
	 * 1. 두개의 반복문을 이용하여 모든 문자와 비교 O(n^2) 시간 복잡도, O(1) 공간복잡도
	 * 2. 입력 문자열 수정해도 되면, O(nlogn) 시간에 문자열 정렬한 뒤 문자열 훑어 나가면서 인접 문자가 동일한지 검사하기.
	 */
	public static boolean isUniqueCharsSort(String arg) {
		String[] arr_arg = arg.split("");
		Arrays.sort(arr_arg);
		for (int i = 0; i < arr_arg.length-1; i++) {
			if (arr_arg[i].compareTo(arr_arg[i+1]) == 0) return false;
		}
		return true;
	}
}
