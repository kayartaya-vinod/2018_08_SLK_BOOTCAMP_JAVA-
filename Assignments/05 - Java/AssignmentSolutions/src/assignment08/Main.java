package assignment08;

public class Main {

	static double power(double a, int b) {
		double p = 1;
		for (int i = 0; i < b; i++) {
			p *= a;
		}
		return p;
	}

	static double factorial(int num) {
		if (num <= 1)
			return 1;

		return num * factorial(num - 1);
	}

	static double sine(int angle, int n) {
		double radian = angle * Math.PI / 180;
		double sin = 0;
		int sign = 1;
		for (int i = 1; i <= n; i += 2) {
			sin += sign * power(radian, i) / factorial(i);
			sign *= -1;
		}
		return sin;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 360; i += 10) {
			double calculated = sine(i, 50);
			double actual = Math.sin(i * Math.PI / 180);

			System.out.printf("sine(%d): calculated = %f, actual = %f\n", i, calculated, actual);
		}
	}
}
