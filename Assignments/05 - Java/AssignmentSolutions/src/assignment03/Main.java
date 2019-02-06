package assignment03;

public class Main {
	static boolean isPrimeNumber(int num) {

		for (int i = 2, j = num / 2; i <= j; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.printf("isPrimeNumber(%d) is " + isPrimeNumber(i) + "\n", i);
		}
	}
}
