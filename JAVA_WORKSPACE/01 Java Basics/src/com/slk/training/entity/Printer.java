package com.slk.training.entity;

import java.lang.reflect.Method;

public class Printer<T> {

	public void print(T t) {
		@SuppressWarnings("rawtypes")
		Class clz = t.getClass();
		System.out.println("Got an instanceof " 
				+ clz.getSimpleName() + " of package " 
				+ clz.getPackage().getName());
		
		System.out.println("These methods exist in this class: ");
		for(Method m: clz.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		
		System.out.println();
	}
}
