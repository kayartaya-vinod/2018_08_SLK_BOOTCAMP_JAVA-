package com.slk.training.service;

public class EnglishHelloService implements HelloService {
	
	public EnglishHelloService() {
		System.out.println(">>> EnglishHelloService instantiated!");
	}

	@Override
	public String getMessage(String name) {
		return String.format("Hello %s, How are you doing?", name);
	}

}
