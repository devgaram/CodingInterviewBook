package question;

/*
 * 2진수를 문자열로 : 0.72와 같이 0과 1 사이의 실수가 double 타입으로 주어졌을 때, 
 * 그 갑을 2진수 형태로 출력하는 코드를 작성하라. 길이가 32이하인 문자열로 2진수로 정확하게 표현할 수 없다면 ERROR를 출력하라
 */
public class Question02 {
	
	public static void main(String[] args) {
		toBinaryDouble(0.625);
	}

	public static void toBinaryDouble(double N) {
		StringBuilder strBuilder = new StringBuilder("0.");
		double temp, r = N;
		int q;		
		
		while(r != 0) {				
			if (strBuilder.length() == 32) {
				System.out.println("ERROR");
				return;
			}	
			temp = r * 2;
			q = (int) temp;
			strBuilder.append(q);
			r = temp - q;			
		}
		
		System.out.println(strBuilder.toString());
	}
}
