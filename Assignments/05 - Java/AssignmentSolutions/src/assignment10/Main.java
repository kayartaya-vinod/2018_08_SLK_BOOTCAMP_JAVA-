package assignment10;

import java.util.Arrays;

public class Main {

	static int[] sumOfEvensAndOdds(int[] nums) {
		int[] sums = new int[2];
		for (int i : nums) {
			if (i % 2 == 0) {
				sums[0] += i;
			} else {
				sums[1] += i;
			}
		}
		return sums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] result = sumOfEvensAndOdds(nums);

		System.out.println("Result: " + Arrays.toString(result));
	}

}
