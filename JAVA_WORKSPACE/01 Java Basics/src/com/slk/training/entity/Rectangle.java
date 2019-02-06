package com.slk.training.entity;

public class Rectangle extends Shape {

	private double width;
	private double length;

	public Rectangle() {
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double perimeter() {
		return 2 * (width + length);
	}

	@Override
	public double area() {
		return width * length;
	}

}
