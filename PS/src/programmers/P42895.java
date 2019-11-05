package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P42895 {
	public static void main(String[] args) {
		System.out.println(solution(5, 31168));
	}
	public static int solution(int N, int number) {
        int answer = solution(N, N, number, 1);
        if (answer == 0) answer = -1;
        return answer;
    }
	// (4*4) + (4/4) = 17
	
	public static int solution(int val, int N, int number, int count) {
    	ArrayList<List<Integer>> M = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(N);
    	M.add(list);
    	Set<Integer> set;
    	int ser = N;
        for (int i=1; i<8; i++) {
        	set = new HashSet<Integer>();
        	//System.out.println("----" + i + "----");
        	for (int j=0; j<i; j++) {
        		//System.out.println(j + "," + (i-j));
        		List<Integer> h = M.get(j);
        		List<Integer> t = M.get(i-j-1);        		
        		for (int hi=0; hi<h.size(); hi++) {
        			for (int ti=0; ti<t.size(); ti++) {
        				set.add(h.get(hi) + t.get(ti));
        				set.add(h.get(hi) - t.get(ti));
        				if (t.get(ti) != 0) set.add(h.get(hi) / t.get(ti));
        				set.add(h.get(hi) * t.get(ti));
        			}
        		}
        	}
        	ser = ser*10 + N;
        	set.add(ser);
        	if (set.contains(number)) return i+1;
        	list = new ArrayList<Integer>();
        	list.addAll(set);
        	M.add(list);
        }
        
        return 0;
	}
}
