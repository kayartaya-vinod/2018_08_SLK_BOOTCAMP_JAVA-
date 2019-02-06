package com.slk.training.entity;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
		super();
	}

	public InvalidNameException(String message) {
		super(message);
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
	}

}
