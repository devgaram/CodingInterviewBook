package programmers;
import java.util.*;
//124 나라의 숫자

public class P12899 {
	public String solution(int n) {
	      String answer = "";
	      String[] s = {"4", "1", "2"};
	      
	      if (n < 3) return s[n];
	      
	      boolean zeroCheck = false;
	      int b = n%3;
	      n = n/3;
	      if (b == 0) zeroCheck = true;
	      answer = s[b] + answer;
	      
	      while (n >= 3) {  
	          b = n%3;
	          if (zeroCheck) {              
	              b--;
	              if (b < 0) b = 2;              
	          }
	          answer = s[b] + answer;
	          
	          if (n%3 == 0 || b == 0) zeroCheck = true;
	          else zeroCheck = false;
	          
	          n /= 3;
	      }
	      if (!zeroCheck) answer = s[n] + answer;
	      else if (zeroCheck && n>1) answer = s[n-1] + answer;     
	      
	      return answer;
	      
	  }
}
