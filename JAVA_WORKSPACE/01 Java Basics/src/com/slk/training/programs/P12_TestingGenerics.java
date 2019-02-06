package com.slk.training.programs;

import com.slk.training.entity.Circle;
import com.slk.training.entity.Employee;
import com.slk.training.entity.Printer;
import com.slk.training.entity.Product;

public class P12_TestingGenerics {

	public static void main(String[] args) {

		Printer<Employee> printer1 = new Printer<>();
		Printer<Circle> printer2 = new Printer<Circle>();
		Printer<Product> printer3 = new Printer<Product>();

		printer1.print(new Employee());
		printer2.print(new Circle());
		printer3.print(new Product());

	}
}
