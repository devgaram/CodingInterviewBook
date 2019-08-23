package graph;

/*
 * ��������Ʈ�� ������ �׷���
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

	// ���� x -> y
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

	// ���� ���� �迭�� ���� �����ϴ� �� Ȯ���ϴ� �Լ�
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
