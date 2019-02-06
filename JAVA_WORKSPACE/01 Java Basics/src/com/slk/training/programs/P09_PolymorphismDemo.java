package com.slk.training.programs;

import com.slk.training.entity.Circle;
import com.slk.training.entity.Rectangle;
import com.slk.training.entity.Shape;
import com.slk.training.entity.Triangle;

public class P09_PolymorphismDemo {
	
	static void printShapeDetails(Shape shape) {
		System.out.println("Area = " + shape.area());
		System.out.println("Perimeter = " + shape.perimeter());
	}

	public static void main(String[] args) {

		Circle c1 = new Circle();
		c1.setRadius(12.34);
		printShapeDetails(c1);

		Rectangle r1 = new Rectangle();
		r1.setWidth(12.0);
		r1.setLength(34.0);
		printShapeDetails(r1);

		Triangle t1 = new Triangle();
		t1.setBase(12.0);
		t1.setHeight(34.0);
		printShapeDetails(t1);
	}
}
