package com.slk.training.entity;

public class InvalidPriceException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPriceException() {
		super();
	}

	public InvalidPriceException(String message) {
		super(message);
	}

	public InvalidPriceException(Throwable cause) {
		super(cause);
	}

}
