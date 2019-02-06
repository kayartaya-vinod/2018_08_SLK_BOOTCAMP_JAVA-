package com.slk.training.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.slk.training.entity.Book;

public class P19_UsingMap {
	
	public static void main(String[] args) {
		
		// Map is a key/value based data structure.
		
		// While storing a "value", we must specify a "key" explicitly
		
		// For example, books.put("AS36367", new Book("Let us C", 299.0, 150));
		
		// Keys are/must be unique in a Map
		
		// If you try to store an object with an existing key, then 
		// the existing value will be replaced with the new value
		
		// Some of the important methods of a Map:
		// 1. containsKey --> checks if a key is present or not
		// 2. keySet --> returns a Set of all the keys in the Map object
		// 3. values --> returns a collection of all the values (with out keys)
		// 4. get --> accepts the key as argument, and returns the corresponding value
		
		Map<String, Book> books = new HashMap<>();
		books.put("AS36367", new Book("Let us C", 299.0, 150));
		books.put("TY75452", new Book("C Pointers", 1299.0, 400));
		books.put("WQ73636", new Book("Java Complete Reference", 799.0, 350));
		books.put("AS36367", new Book("Let us C (2nd edition)", 349.0, 175));
		books.put("AS36367", new Book("Let us C (3rd edition)", 349.0, 180));
		
		for(String key: books.keySet()) {
			System.out.println(key + " --> " + books.get(key));
		}
		
		System.out.println();
		
		Map<Integer, String> names;
		names = new LinkedHashMap<>();
		
		names.put(1010, "John Smith");
		names.put(7788, "Vinod Kumar");
		names.put(7865, "Arun Rao");
		names.put(1010, "John Doe");
		names.put(1011, "Martin");
		names.put(7654, "Shyam Sundar");
		names.put(6543, "Shyam Sundar");

		System.out.println(names);
		
		
	}

}
