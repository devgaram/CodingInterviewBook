package question;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
	static int[] people;
	static int N = 9;
	static int AllSum = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		people = new int[N];
		for (int i=0; i<N; i++) {
			people[i] = scanner.nextInt();
			AllSum += people[i];
		}
		
		// 1) 비트마스크 활용
//		int[] realPeople = getRealPeople();
//		for (int i=0; i<realPeople.length; i++) {
//			if (realPeople[i] > 0)
//				System.out.println(realPeople[i]);
//		}
		
		// 2) 조합 활용
		bruteForce();
		for (int i=0; i<7; i++)
			System.out.println(people[i]);
	}
	
	public static int[] getRealPeople() {
		int[] realPeople = new int[N];
		int bitmask = 0;
		int sum = 0;
		for (int i=(1<<7)-1; i<(1<<9); i++) {			
			if (Integer.bitCount(i) == 7) {
				bitmask = i;
				sum = 0;
				for (int j=0; j<N; j++) {
					if ((bitmask & 1) == 1) {
						sum += people[j];
					}
					bitmask = bitmask>>>1;
				}
				if (sum == 100) {
					bitmask = i;
					int p = -1;
					for (int j=0; j<N; j++) {
						if ((bitmask & 1) == 1) {
							realPeople[++p] = people[j];
						}
						bitmask = bitmask>>>1;
					}
					Arrays.sort(realPeople);
					return realPeople;
				}
			}
		}
		return null;
	}
	
	public static void bruteForce() {
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (AllSum - people[i]- people[j] == 100) {
					people[i] = Integer.MAX_VALUE;
					people[j] = Integer.MAX_VALUE;
					Arrays.sort(people);
					return;					
				}
			}
		}
	}
}
