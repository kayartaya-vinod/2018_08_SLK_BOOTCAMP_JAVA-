package assignment06;

public class Main {
	public static int fibonacci(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		}

		return fibonacci(index - 1) + fibonacci(index - 2);
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 20; i++) {
			System.out.printf("fibonacci(%d) is " + fibonacci(i) + "\n", i);
		}
	}
}
