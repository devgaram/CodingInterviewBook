package programmers;
import java.util.PriorityQueue;
import java.util.Queue;
// ´õ ¸Ê°Ô - Èü
public class P42626 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.print(solution(arr, K));
	}
	
	public static int solution(int[] scoville, int K) {		
		int ans = 0;
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (int i=0; i<scoville.length; i++) 
			q.add(scoville[i]);
		//print(q.toArray());
		while (q.size() > 1 && q.peek() < K) {
			int f = q.poll();			
			int s = q.poll();
			q.add(f + (s*2));
			ans++;
			//print(q.toArray());
		}
		if (q.size() == 1 && q.peek() < K) {
			ans = -1;
		}
		return ans;
	}

	public static int solution_2(int[] scoville, int K) {		
		int ans = 0;
		int[] heap = heap_sort(scoville);
		int lastIdx = heap.length-1;
		while (heap[1] < K) {
			int f = heap_delete(heap, lastIdx);
			int s = heap_delete(heap, lastIdx - 1);
			lastIdx-=2;
			int n = f + (s*2);
			insert_heap(heap, n, lastIdx);
			lastIdx++;
			//print(heap);
			ans++;
		}	
		
		return ans;
	}

	public static void print(Object[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	// ÃÖ¼ÒÈü
	/*
	 *          3
	 *     9         10
	 *  12             
	 */
	public static int heap_delete(int[] heap, int lastIdx) {
		int d = heap[1];
		int N = heap[lastIdx];
		heap[lastIdx] = 0;
		
		int idx = 1;
		int lIdx, rIdx, lVal, rVal;	
		
		while (idx < lastIdx) {
			lIdx = idx * 2;
			rIdx = idx * 2 + 1;
			lVal = Integer.MAX_VALUE;
			rVal = Integer.MAX_VALUE;
			if (lIdx < lastIdx && heap[lIdx] < N) {
				lVal = heap[lIdx];
			}
			if (rIdx < lastIdx && heap[rIdx] < N) {
				rVal = heap[rIdx];
			}
			
			if (lVal < rVal) {
				heap[idx] = heap[lIdx];
				idx = lIdx;
			} else if (lVal > rVal) {
				heap[idx] = heap[rIdx];
				idx = rIdx;
			} else {
				heap[idx] = N;
				break;
			}			
		}	

		return d;		
	}
	
	public static void insert_heap(int[] heap, int N, int lastIdx) {
		int cIdx = lastIdx+1;
		int pIdx = cIdx/2;
		while (pIdx > 0) {
			if (heap[pIdx] > N) {
				heap[cIdx] = heap[pIdx];
			} else break;
			cIdx = pIdx;
			pIdx = cIdx/2;
		}
		heap[cIdx] = N;		
	}

	public static int[] heap_sort(int[] scoville) {
		int[] heap = new int[scoville.length+1];
		int pIdx, cIdx, n;
		heap[1] = scoville[0];
		for (int i=1; i<scoville.length; i++) {
			n = scoville[i];
			cIdx = i+1;
			pIdx = cIdx/2;
			while (pIdx > 0) {
				if (heap[pIdx] > n) {
					heap[cIdx] = heap[pIdx];
				} else break;
				cIdx = pIdx;
				pIdx = cIdx/2;
			}
			heap[cIdx] = n;			
		}

		return heap;
	}


}
