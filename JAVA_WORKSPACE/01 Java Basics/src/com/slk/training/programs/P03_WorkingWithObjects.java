package com.slk.training.programs;

import com.slk.training.entity.Person;

public class P03_WorkingWithObjects {

	public static void main(String[] args) {

		Person p1;
		p1 = new Person();
		p1.setName("Shyam");
		p1.setAge(45);
		p1.setHeight(6.1);

		p1.print();

		Person p2 = new Person("Kiran", 28, 5.7);
		p2.print();
		
		System.out.println(p1);
		System.out.println(p2);

	}
}
