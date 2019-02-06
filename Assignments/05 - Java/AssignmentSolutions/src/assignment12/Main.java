package assignment12;

public class Main {

	static String getWord(int num) {
		String[] ar1 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty" };
		String[] ar2 = { "", "", "", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		if (num <= 20) {
			return ar1[num];
		} else {
			int q = num / 10, r = num % 10;
			return ar2[q] + " " + ar1[r];
		}
	}

	static String getUnit(int pos) {
		return new String[] { "", "hundred", "thousand", "lakh", "crore" }[pos];
	}

	static String inWords(int num) {
		int i = 0;
		int[] nums = new int[5];
		while (num > 0) {
			if (i == 1) {
				nums[i] = num % 10;
				num /= 10;
			} else {
				nums[i] = num % 100;
				num /= 100;
			}
			i++;
		}

		i--;
		String words = "";
		while (i >= 0) {
			if (nums[i] > 0) {
				words += getWord(nums[i]) + " " + getUnit(i) + " ";
			}
			i--;
		}
		return words;
	}

	public static void main(String[] args) {
		System.out.printf("%d --> %s\n", 12345, inWords(12345));
		System.out.printf("%d --> %s\n", 10203040, inWords(10203040));
		System.out.printf("%d --> %s\n", 101, inWords(101));
		System.out.printf("%d --> %s\n", 10001, inWords(10001));
		System.out.printf("%d --> %s\n", 101001, inWords(101001));
	}
}
