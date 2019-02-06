package com.slk.training.entity;

public class Product {

	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {
		if (name == null || name.trim().equals("") || name.length() > 25) {
			throw new InvalidNameException("Name can not be null or empty string or > 25 letters!");
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws InvalidPriceException {

		if (price <= 0) {
			throw new InvalidPriceException("Product price must be > 0");
		}

		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
