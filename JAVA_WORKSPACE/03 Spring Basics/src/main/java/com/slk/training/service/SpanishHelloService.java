package com.slk.training.service;

public class SpanishHelloService implements HelloService {

	public SpanishHelloService() {
		System.out.println(">>> SpanishHelloService instantiated!");
	}
	@Override
	public String getMessage(String name) {
		return String.format("Hola %s, ¿cómo estás?", name);
	}

}
