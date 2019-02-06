package com.slk.training.programs;

import java.util.Set;
import java.util.TreeSet;

public class P14_UsingSet {

	public static void main(String[] args) {

		Set<String> names = new TreeSet<String>();

		names.add("xavier");
		names.add("arvind");
		names.add("vinod");
		names.add("zaheer");
		names.add("vinod");
		names.add("anand");
		names.add("vinod");
		names.add("kumar");
		names.add("kumar");
		names.add("kumar");
		names.add("kumar");
		
		System.out.println("names.size() = " + names.size());
		System.out.println("names = " + names);

	}
}
