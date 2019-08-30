
import java.util.*;
public class Cache {
	private int cacheSize;
	private HashMap<String, Node> map;
	private LinkedList<Node> list;
	private int time;

	public Cache(int cacheSize) {
		this.cacheSize = cacheSize;
		map = new HashMap<String, Node>();
		list = new LinkedList<Node>();
		time = 0;
	}

	public void insertResults(String city) {
		city = city.toLowerCase();
		if (map.containsKey(city)) {
			time+=1;
			Node node = map.get(city);
			list.remove(node);
			list.addFirst(node);
			return;
		}
		
		time+=5;
		Node node = new Node(city);
		map.put(city, node);
		list.addFirst(node);
		
		if (list.size() > cacheSize) {
			Node lastNode = list.removeLast();
			map.remove(lastNode.cityName);
		}
	}
	
	public void printCache() {
		Iterator<Node> i = list.iterator();
		while (i.hasNext()) {
			System.out.print(i.next().cityName + " ");
		}
	}
	
	public int getTime() {
		return time;
	}

	class Node {
		String cityName;
		Node next;

		public Node(String cityName) {
			this.cityName = cityName;
			this.next = null;
		}
	}


}
