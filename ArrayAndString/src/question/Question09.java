package question;

/*
 * Q. 문자열 회전 : 한 단어가 다른 문자열에 포함되어 있는지 판별하는 isSubstring 이라는 메서드가 있다고 하자.
 * s1과 s2의 두 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자 한다. 
 * (가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다.)
 * isSubring 메서드를 한번만 호출해서 판별할 수 있는 코드를 작성하라.
 */
import java.util.*;
public class Question09 {

	public static void main(String[] args) {
		
	}
	
	// s1*s1 에는 s2가 포함되어있다 **
	public static boolean isRotate(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0) return false;
		String s1s1 = s1+s1;
		return isSubString(s1s1, s2);
	}
	
	// 가상의 isSubstring 
	public static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}
	

}
