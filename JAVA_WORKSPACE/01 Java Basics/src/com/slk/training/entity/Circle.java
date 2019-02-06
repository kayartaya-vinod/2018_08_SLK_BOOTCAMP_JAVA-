package com.slk.training.entity;

public class Circle extends Shape {
	private double radius;

	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override // hides the super class abstract method
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

}
