package question;

// 1,000,000 * 1,000,000 이므로 long 타입
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Q13458 {
	static int N;
	static int[] place;
	static int B;
	static int C;
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(in.readLine());
		place = new int[N];
		String[] arrIn = in.readLine().split(" ");
		for (int i=0; i<arrIn.length; i++) 
			place[i] = Integer.parseInt(arrIn[i]);
		
		arrIn = in.readLine().split(" ");
		B = Integer.parseInt(arrIn[0]);
		C = Integer.parseInt(arrIn[1]);
			
		System.out.println(solution() +"");
		in.close();
	}
	
	public static long solution() {
		long peopleCount = 0;
		for (int i=0; i<N; i++) {
			place[i] -= B;
			peopleCount++;
			if (place[i] > 0) {
				peopleCount += place[i] / C;
				if (place[i] % C > 0) peopleCount++;
			}
		}
			
		return peopleCount;
	}
}