package com.slk.training.service;

public class KannadaHelloService implements HelloService {

	public KannadaHelloService() {
		System.out.println(">>> KannadaHelloService instantiated!");
	}
	@Override
	public String getMessage(String name) {
		return String.format("ಹೆಲೋ %s, ಹೇಗಿದ್ದೀರ?", name);
	}

}
