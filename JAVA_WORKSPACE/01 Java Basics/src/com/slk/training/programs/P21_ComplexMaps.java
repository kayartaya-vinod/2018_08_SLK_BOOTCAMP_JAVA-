package com.slk.training.programs;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P21_ComplexMaps {

	public static void main(String[] args) {

		Map<String, Set<String>> map = new TreeMap<>();
		String[] names = { "arun", "ramesh", "harish", "arun", "anil", "kiran", "zaheer", "kishore", "vinod", "vinay",
				"avinash", "vinod", "vinay", "vijay", "harish", "ramesh", "nagesh", "naresh" };

		for (String name : names) {
			String firstChar = name.charAt(0) + "";
			Set<String> set;

			if (map.containsKey(firstChar)) {
				set = map.get(firstChar);
				set.add(name);
			} else {
				set = new TreeSet<>();
				set.add(name);
				map.put(firstChar, set);
			}
			
		}

		System.out.println("The names are: ");
		for(String name: names) {
			System.out.println(name);
		}
		System.out.println();
		
		for (String key : map.keySet()) {
			System.out.println(key + " --> " + map.get(key));
		}

	}

}
