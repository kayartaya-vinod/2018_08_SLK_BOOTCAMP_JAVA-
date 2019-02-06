package com.slk.training.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P17_UsingArrowFunctionOrLamda {

	public static void main(String[] args) {

		// arrow functions work only with functional interfaces.
		// A functional interface is an interface with exactly one abstract method.
		// For example, java.util.Comprator, java.lang.Comparable, java.lang.Runnable,
		// java.awt.ActionListener

		// From Java 1.8 onwards, an interface may have methods with body (marked as
		// default methods)

		List<String> names = Arrays.asList("vinay", "harish kumar", "arun", 
				"ramnath nishdh", "vinod kumar kayartaya",
				"james bond", "akash", "jones");

		// sort the names in ascending order of their lengths

		Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
		
		for (String name : names) {
			System.out.println(name);
		}

	}
}
