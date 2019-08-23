package question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 문제
 * 노드 사이의 경로 : 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는 지 확인하는 알고리즘을 작성하라.
 * 
 * 해결
 * 그래프 조회하는 알고리즘 DFS, BFS를 이용하여 한 노드에서 시작하여 순회할 때 다른 노드가 확인되는 지를 알아내면 된다.
 */
/*
 * 큐는 인터페이스,
 * 큐를 구현하기 위해서는 LinkedList로 구현하는 것이 적합하다.
 * 만약 ArrayList와 같이 배열 기반의 컬렉션 클래스를 사용한다면 데이터를 꺼낼 때
 * 항상 첫번째 저장한 데이터를 삭제하므로 빈 공간을 채우기 위해 데이터의 복사가 발생해 비효율적이기 때문이다.
 * + LinkedList로 구현한 큐는 null을 허용함
 * 
 * 추가) 자바에서 스택은 Stack 클래스로 구현하여 제공하나, 큐는 Queue 인터페이스만 정의해놓았을 뿐
 * 별도의 클래스를 제공하지 않기 때문에 Queue 인터페이스를 구현한 클래스들 중에 하나를 사용해야한다.
 * 큐 구현체 : PriorityQueue, PriorityBlockingQueue, LinkedList 등.
 * (개발문서, All Known Implementing Classes 확인)
 */
import graph.Graph;
import graph.Graph.Node;

public class Question01 {

	public static void main(String[] args) {		
		Graph graph = new Graph();
		graph.putSingle(1, 2);
		graph.putSingle(1, 4);
		graph.putSingle(2, 5);
		graph.putSingle(3, 6);
		graph.putSingle(3, 5);
		graph.putSingle(4, 2);
		graph.putSingle(5, 4);
		graph.putSingle(6, 6);
		graph.printGraph();
		
		System.out.println("x -> y : " + isRouteBFS(graph, graph.isVertex(3), graph.isVertex(2)));
	}

	
	// 두 노드 중 하나를 고른 뒤 탐색 도중 다른 노드가 발견되는지 검사하면 된다.
	// 사이클에 대비하고, 중복되는 일을 피하기 위해 방문한 노드는 이미 방문했음을 표시해야한다.
	// 그래프의 노드 클래스의 visited 변수를 추가했음..
	public static boolean isRouteBFS(Graph g, Node start, Node end) {
		if (start == end) return true;
		
		LinkedList q = new LinkedList(); // 큐처럼 동작
		for (Node u : g.getNodes()) {
			u.visited = false;
		}
		
		start.visited = true;
		q.add(start);
		Node u;
		
		while (!q.isEmpty()) {
			u = (Node) q.removeFirst(); 	// dequeue()와 같음
			if (u != null) {
				System.out.print(u.data + " ");
				for (Node v : u.adjacentList) {
					if (v == end) return true;
					if (!v.visited) {
						v.visited = true;
						q.add(v);
					}
				
				}
			}
		}
		
		return false;
		
	}
	

}
