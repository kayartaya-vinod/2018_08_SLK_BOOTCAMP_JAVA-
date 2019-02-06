package com.slk.training.programs;

import java.util.List;
import java.util.Vector;

public class P13_UsingLists {

	public static void main(String[] args) {
		
		// as a good practice, always create variables of interface types
		// and assign objects of desired classes.
		// Especially use the interface types as function arguments and return types.
		// This gives the flexibility of passing (as arguments) or returning objects
		// of any class that implements the interface (LOOSE COUPLING)
		List<String> names = new Vector<>();
		
		names.add("Vinod");
		names.add("Shyam");
		names.add("John");
		names.add("Jane");
		names.add("Vinod");
		names.add("vinod"); // notice "v" is lower case here
		names.add("Arun");
		
		System.out.println(names);
		names.add(1, "Kishore");
		System.out.println(names);
		names.remove("John");
		names.remove(2);
		System.out.println(names);
		
		int index = names.indexOf("Vinod");
		System.out.println("The string \"Vinod\" is at index: " + index);
		
		index = names.lastIndexOf("Vinod");
		System.out.println("The last index of the string \"Vinod\" is: " + index);
		
		index = names.indexOf("Pawan");
		System.out.println("The string \"Pawan\" is at index: " + index);
		
	}
}





