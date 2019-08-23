package question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ����
 * ��� ������ ��� : ���� �׷����� �־����� �� �� ��� ���̿� ��ΰ� �����ϴ� �� Ȯ���ϴ� �˰����� �ۼ��϶�.
 * 
 * �ذ�
 * �׷��� ��ȸ�ϴ� �˰��� DFS, BFS�� �̿��Ͽ� �� ��忡�� �����Ͽ� ��ȸ�� �� �ٸ� ��尡 Ȯ�εǴ� ���� �˾Ƴ��� �ȴ�.
 */
/*
 * ť�� �������̽�,
 * ť�� �����ϱ� ���ؼ��� LinkedList�� �����ϴ� ���� �����ϴ�.
 * ���� ArrayList�� ���� �迭 ����� �÷��� Ŭ������ ����Ѵٸ� �����͸� ���� ��
 * �׻� ù��° ������ �����͸� �����ϹǷ� �� ������ ä��� ���� �������� ���簡 �߻��� ��ȿ�����̱� �����̴�.
 * + LinkedList�� ������ ť�� null�� �����
 * 
 * �߰�) �ڹٿ��� ������ Stack Ŭ������ �����Ͽ� �����ϳ�, ť�� Queue �������̽��� �����س����� ��
 * ������ Ŭ������ �������� �ʱ� ������ Queue �������̽��� ������ Ŭ������ �߿� �ϳ��� ����ؾ��Ѵ�.
 * ť ����ü : PriorityQueue, PriorityBlockingQueue, LinkedList ��.
 * (���߹���, All Known Implementing Classes Ȯ��)
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

	
	// �� ��� �� �ϳ��� �� �� Ž�� ���� �ٸ� ��尡 �߰ߵǴ��� �˻��ϸ� �ȴ�.
	// ����Ŭ�� ����ϰ�, �ߺ��Ǵ� ���� ���ϱ� ���� �湮�� ���� �̹� �湮������ ǥ���ؾ��Ѵ�.
	// �׷����� ��� Ŭ������ visited ������ �߰�����..
	public static boolean isRouteBFS(Graph g, Node start, Node end) {
		if (start == end) return true;
		
		LinkedList q = new LinkedList(); // ťó�� ����
		for (Node u : g.getNodes()) {
			u.visited = false;
		}
		
		start.visited = true;
		q.add(start);
		Node u;
		
		while (!q.isEmpty()) {
			u = (Node) q.removeFirst(); 	// dequeue()�� ����
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
