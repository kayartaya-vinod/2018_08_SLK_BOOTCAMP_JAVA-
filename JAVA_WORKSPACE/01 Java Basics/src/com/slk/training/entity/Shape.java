package com.slk.training.entity;

public abstract class Shape {

	private String color;
	private boolean filled;

	public Shape() {
		color = "white";
		filled = true;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public abstract double perimeter();

	public abstract double area();

}
