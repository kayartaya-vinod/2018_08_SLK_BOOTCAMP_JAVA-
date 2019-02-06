package com.slk.training.entity;

public class Book implements Comparable<Book> {
	private String title;
	private double price;
	private int pages;

	public Book() {
	}

	public Book(String title, double price, int pages) {
		this.title = title;
		this.price = price;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", pages=" + pages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pages;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (pages != other.pages)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	// provides the natural comparison logic
	// so that two books can be compared as which one is big and which is small
	@Override
	public int compareTo(Book other) {
		// return Double.compare(this.price, other.price);
		// return this.pages - other.pages;
		return this.title.compareTo(other.title);
	}

}


