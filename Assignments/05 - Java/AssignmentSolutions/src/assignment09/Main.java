package assignment09;

public class Main {
	static boolean isLeap(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

	static int maxDays(int year) {
		return isLeap(year) ? 366 : 365;
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

	static int julianDate(int year, int month, int day) {
		int jd = day;
		for (int m = 1; m < month; m++) {
			jd += maxDays(year, m);
		}
		for (int y = 1900; y < year; y++) {
			jd += maxDays(y);
		}
		return jd;
	}

	static void printCalendar(int month, int year) {
		int dow = julianDate(year, month, 1) % 7;

		System.out.printf("Calendar for %d/%d\n", month, year);
		System.out.println("Su Mo Tu We Th Fr Sa");
		for (int i = 0; i < dow; i++) {
			System.out.print("   ");
		}
		for (int i = 1, days = maxDays(year, month); i <= days; i++) {
			System.out.printf("%2d ", i);
			if ((i + dow) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++) {
			printCalendar(i, 2018);
			System.out.println();
		}

	}
}
