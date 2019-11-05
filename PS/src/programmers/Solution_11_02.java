package programmers;

import java.util.*;
public class Solution_11_02 {

	// 구명보트
	public int solution(int[] people, int limit) {
		int answer = 0;        
		if (people.length == 1) return 1;        
		Arrays.sort(people);
		int i=0, j=people.length-1;        
		while (i < j) {
			if (people[i] + people[j] <= limit) i++;
			answer++;
			j--;
		}
		if (i == j) answer++;

		return answer;
	}
	
	// H-Index
	// [20,19,18,1]
    // 1 18 19 20
    // 4 3 2 1
    public int solution_42747(int[] citations) {
        int answer = 0;
        int h;
        int length = citations.length;
        
        Arrays.sort(citations);       
        
        for (int i=0; i<citations.length; i++) {
            h = length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }       
        
        return answer;
    }
    
    
}
