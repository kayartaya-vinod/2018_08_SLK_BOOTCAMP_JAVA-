package com.slk.training.programs;

import java.util.Set;
import java.util.TreeSet;

import com.slk.training.entity.Book;

public class P15_UsingCustomObjectsWithSet {
	
	public static void main(String[] args) {
		
		// If you want to use HashSet (or LinkedHashSet, Hashtable, HashMap, LinkedHashMap)
		// with your custom objects, make sure that the class overrides hashCode() and equals()
		// methods with appropriate logic
		Set<Book> books = new TreeSet<>();
		
		Book b = new Book("Let us C", 299, 150);
		System.out.println("b.hashCode() is " + b.hashCode());
		books.add(b);
		
		b = new Book("Let us Java", 599, 300);
		System.out.println("b.hashCode() is " + b.hashCode());
		books.add(b);
		
		b = new Book("Let us C", 299, 150);
		System.out.println("b.hashCode() is " + b.hashCode());
		books.add(b);
		
		b = new Book("C Pearls", 400, 175);
		System.out.println("b.hashCode() is " + b.hashCode());
		books.add(b);
		
		b = new Book("Let us C", 299, 150);
		System.out.println("b.hashCode() is " + b.hashCode());
		books.add(b);
		
		System.out.println("books.size() = " + books.size());
		for(Book b1: books) {
			System.out.println(b1);
		}
		
	}

}
