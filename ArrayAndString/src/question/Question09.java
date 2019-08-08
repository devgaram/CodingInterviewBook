package question;

/*
 * Q. ���ڿ� ȸ�� : �� �ܾ �ٸ� ���ڿ��� ���ԵǾ� �ִ��� �Ǻ��ϴ� isSubstring �̶�� �޼��尡 �ִٰ� ����.
 * s1�� s2�� �� ���ڿ��� �־�����, s2�� s1�� ȸ����Ų ������� �Ǻ��ϰ��� �Ѵ�. 
 * (���� 'waterbottle'�� 'erbottlewat'�� ȸ������ ���� �� �ִ� ���ڿ��̴�.)
 * isSubring �޼��带 �ѹ��� ȣ���ؼ� �Ǻ��� �� �ִ� �ڵ带 �ۼ��϶�.
 */
import java.util.*;
public class Question09 {

	public static void main(String[] args) {
		
	}
	
	// s1*s1 ���� s2�� ���ԵǾ��ִ� **
	public static boolean isRotate(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0) return false;
		String s1s1 = s1+s1;
		return isSubString(s1s1, s2);
	}
	
	// ������ isSubstring 
	public static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}
	

}
