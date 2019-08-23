package graph;

/*
 * 인접리스트로 구현한 그래프
 */
import java.util.*;
public class Graph {
	private List<Node> graph;

	public Graph() {
		graph = new ArrayList<Node>();
	}

	public List<Node> getNodes() {
		return this.graph;
	}

	// 방향 x -> y
	public void putSingle(int x, int y) {
		Node nodeX = isVertex(x);
		Node nodeY = isVertex(y);
		if (nodeX == null) {
			nodeX = new Node(x);
			graph.add(nodeX);
		}
		if (nodeY == null) {
			nodeY = new Node(y);
			graph.add(nodeY);
		}
		
		nodeX.adjacentList.add(nodeY);
	}

	// 정접 집합 배열에 값이 존재하는 지 확인하는 함수
	public Node isVertex(int x) {
		Node returnVal = null;
		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(i).data == x) return graph.get(i);
		}
		return returnVal;
	}

	public void printGraph() {
		Node v;
		for (int i = 0; i < graph.size(); i++) {
			v = graph.get(i);
			System.out.print(v.data + " : ");
			for (Node u : v.adjacentList) {
				System.out.print(u.data + " ");
			}
			System.out.println();
		}
	}

	public class Node {

		public int data;
		public boolean visited;	
		public LinkedList<Node> adjacentList;

		public Node(int data) {
			this.data = data;
			adjacentList = new LinkedList<Node>();
		}

		public LinkedList<Node> getAdjacent() {
			return adjacentList;
		}


	}
	
}
