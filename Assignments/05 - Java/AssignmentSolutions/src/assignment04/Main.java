package assignment04;

public class Main {
	public static void sortThreeNumbers(int a, int b, int c) {
		int x, y, z;
		if (a < b && a < c) {
			// a is smallest
			x = a;
			if (b < c) {
				y = b;
				z = c;
			} else {
				y = c;
				z = b;
			}
		} else if (b < c) {
			// b is smallest
			x = b;
			if (a < c) {
				y = a;
				z = c;
			} else {
				y = c;
				z = a;
			}
		} else {
			// c is smallest
			x = c;
			if (a < b) {
				y = a;
				z = b;
			} else {
				y = b;
				z = a;
			}
		}
		System.out.printf("%d,  %d, %d\n", x, y, z);
	}

	public static void main(String[] args) {
		sortThreeNumbers(2, 10, 1);
		sortThreeNumbers(20, 10, 1);
		sortThreeNumbers(2, 10, 100);
	}
}
