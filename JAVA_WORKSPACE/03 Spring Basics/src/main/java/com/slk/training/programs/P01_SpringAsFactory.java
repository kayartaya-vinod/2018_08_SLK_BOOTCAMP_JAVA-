package com.slk.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slk.training.service.HelloService;

public class P01_SpringAsFactory {
	public static void main(String[] args) {

		// a reference to a spring container
		ClassPathXmlApplicationContext ctx;
		
		// object of spring container
		// By default, all the beans defined in the XML are instantiated at this time.
		// These beans are "scoped" as "singleton".
		// Can be changed by using attribute "scope" like below:
		// <bean class="com.slk.training.service.EnglishHelloService" scope="singleton">
		ctx = new ClassPathXmlApplicationContext("context1.xml");
		System.out.println("Spring container is ready!");
		
		// a reference of the required service
		HelloService service, anotherService;
		
		// get the service object from spring
		// Note: for "singleton" beans, ctx.getBean(..) simply returns the bean from 
		// the container, where as, for the "prototype" beans, it will return a new
		// object of the configured bean class.
		service = ctx.getBean(HelloService.class);
		anotherService = ctx.getBean(HelloService.class);
		
		System.out.println("service==anotherService is " + (service==anotherService));
		
		// use the service
		String msg = service.getMessage("Vinod");
		System.out.println(msg);
		
		// close the container
		ctx.close();
	}
}
