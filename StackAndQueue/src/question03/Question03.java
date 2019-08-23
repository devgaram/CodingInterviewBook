package question03;

public class Question03 {

	public static void main(String[] args) {
		Question03SetOfStacks stack = new Question03SetOfStacks(5);
		for (int i = 1; i <= 17; i++) 
			stack.push(i);
		System.out.println(stack.printStacks());
		for (int i = 0; i < 18; i++) {
			stack.pop();
			System.out.println("pop " + i);
			System.out.println(stack.printStacks());
		}
	}
}
