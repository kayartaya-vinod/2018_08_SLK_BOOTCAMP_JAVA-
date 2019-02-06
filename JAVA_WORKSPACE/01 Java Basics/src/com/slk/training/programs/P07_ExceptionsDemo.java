package com.slk.training.programs;

public class P07_ExceptionsDemo {

	public static void main(String[] args) {
		System.out.println("Start of main()");

		try {
			String arg1 = args[0];
			String arg2 = args[1];

			int num = Integer.parseInt(arg1);
			int den = Integer.parseInt(arg2);

			int quot = num / den;

			System.out.printf("%d / %d = %d\n", num, den, quot);
			
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("You must supply exactly 2 integers");
			// return
			// throw new RuntimeException("Just throwing...");
			System.exit(55);
		} catch (ArithmeticException e) {
			System.out.println("Hey, cannot divide by zero in Java!");
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e.getClass().getName() + " - " + e.getMessage());
		} finally {
			System.out.println("Inside the finally block!");
		}

		System.out.println("End of main()");

	}
}
