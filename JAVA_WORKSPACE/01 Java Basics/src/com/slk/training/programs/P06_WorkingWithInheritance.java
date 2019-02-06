package com.slk.training.programs;

import com.slk.training.entity.Employee;

public class P06_WorkingWithInheritance {

	public static void main(String[] args) {
		
		final Employee e1;
		e1 = new Employee();
		e1.setName("James");

		
		Employee e2 = new Employee(7788, "Scott", "ADMIN", "scott@example.com", 2500);
	
		e1.print();
		e2.print();
		
	}
}
