package com.slk.training.programs;

public class P02_LoopExample {

	public static int bin2dec(long bin) {
		int e = 0;
		long dec = 0;

		while (bin > 0) {
			long rem = bin % 10;
			bin /= 10;
			dec = dec + rem * ((int) Math.pow(2, e++));
		}

		return (int) dec;
	}

	public static long dec2bin(int num) {

		// 1. divide num by 2
		// 2. collect the reminder
		// 3. repeat the above until num becomes 0

		String bin = "";
		while (num > 0) {
			int rem = num % 2;
			bin = rem + bin;
			num /= 2;
		}
		return Long.parseLong(bin);
	}

}
