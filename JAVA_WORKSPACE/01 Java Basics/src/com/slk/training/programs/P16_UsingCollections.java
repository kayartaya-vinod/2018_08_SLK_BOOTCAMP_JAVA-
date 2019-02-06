package com.slk.training.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P16_UsingCollections {

	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return s2.compareTo(s1);
		}
	}

	public static void main(String[] args) {

		List<String> names = Arrays.asList("vinod", "shyam", "sudheer", 
				"suresh", "ramesh", "harish", "naveen", "ajay",
				"anand", "uday");

		System.out.println(names);

		Collections.shuffle(names); // mutating the list
		System.out.println(names);

		Collections.sort(names); // uses the built in String comparison logic
		System.out.println(names);

		Collections.sort(names, new StringComparator()); // uses custom comparison logic
		System.out.println(names);

		// object of anonymous class (anonymous object)
		Comparator<String> cmptr = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				s1 = new StringBuffer(s1).reverse().toString();
				s2 = new StringBuffer(s2).reverse().toString();
				return s1.compareTo(s2);
			}
		};
		Collections.sort(names, cmptr); // uses custom comparison logic
		System.out.println(names);

		String maxName = Collections.max(names);
		String minName = Collections.min(names);

		System.out.println("maxName = " + maxName);
		System.out.println("minName = " + minName);

	}
}
