package assignment07;

public class Main {

	static void printPattern(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printPattern(10);
	}
}
