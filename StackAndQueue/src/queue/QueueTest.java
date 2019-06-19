package queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println(queue.isEmpty());
		System.out.println(queue.search(20));

	}

}
