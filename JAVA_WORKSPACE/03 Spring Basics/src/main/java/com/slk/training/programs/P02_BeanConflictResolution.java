package com.slk.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slk.training.service.HelloService;

public class P02_BeanConflictResolution {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("context2.xml");

		HelloService service;
		
		// when there are multiple implementations of the required bean type,
		// use the id or name of the bean to resolve the conflict
		service = ctx.getBean("kannada-service", HelloService.class);
		
		String msg = service.getMessage("Vinod");
		System.out.println(msg);
		
		ctx.close();
	}
	
}
