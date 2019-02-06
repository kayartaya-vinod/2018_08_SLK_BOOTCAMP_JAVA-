package assignment05;

public class Main {
	static boolean isPrimeNumber(int num) {

		for (int i = 2, j = num / 2; i <= j; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static int sumOfPrimes(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++) {
			sum += isPrimeNumber(i) ? i : 0;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("sumOfPrimes(1, 10) is " + sumOfPrimes(1, 10));
		System.out.println("sumOfPrimes(11, 20) is " + sumOfPrimes(11, 20));
		System.out.println("sumOfPrimes(21, 30) is " + sumOfPrimes(21, 30));

	}
}
