package assignment02;

public class Main {

	static boolean isLeap(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

	static int maxDays(int year, int month) {
		switch (month) {
		case 2:
			return isLeap(year) ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	static boolean isValidDate(int year, int month, int day) {
		if (year < 0)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (day < 1 || day > maxDays(year, month))
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println("isValidDate(2018, 13, 1) is " + isValidDate(2018, 13, 1));
		System.out.println("isValidDate(2018, 2, 29) is " + isValidDate(2018, 2, 29));
		System.out.println("isValidDate(2016, 2, 29) is " + isValidDate(2016, 2, 29));

	}

}
