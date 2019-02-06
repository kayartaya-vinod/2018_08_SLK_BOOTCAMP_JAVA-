package com.slk.training.programs;

import java.util.Arrays;

import com.slk.training.entity.Person;

public class P05_ArrayOfObjects {

	public static void main(String[] args) {

		Person[] people;

		people = new Person[5];

		people[0] = new Person("Shyam", 45, 6.1);
		people[1] = new Person("Kiran", 25, 5.61);
		
		System.out.println(Arrays.toString(people));
		
	}

}
