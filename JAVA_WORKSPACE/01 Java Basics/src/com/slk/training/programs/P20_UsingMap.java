package com.slk.training.programs;

import java.util.Map;
import java.util.TreeMap;

import com.slk.training.utils.KeyboardUtil;

public class P20_UsingMap {

	public static void main(String[] args) {

		Map<String, Integer> names = new TreeMap<>();

		while (true) {
			String name = KeyboardUtil.getString("Enter a name ('quit' to exit): ");
			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			if (names.containsKey(name)) {
				int count = names.get(name);
				names.put(name, count + 1);
			} else {
				names.put(name, 1);
			}
		}

		for (String name : names.keySet()) {
			System.out.printf("%s entered %d times\n", name, names.get(name));
		}

	}
}
