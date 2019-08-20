package question;

/*
 * 2������ ���ڿ��� : 0.72�� ���� 0�� 1 ������ �Ǽ��� double Ÿ������ �־����� ��, 
 * �� ���� 2���� ���·� ����ϴ� �ڵ带 �ۼ��϶�. ���̰� 32������ ���ڿ��� 2������ ��Ȯ�ϰ� ǥ���� �� ���ٸ� ERROR�� ����϶�
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
