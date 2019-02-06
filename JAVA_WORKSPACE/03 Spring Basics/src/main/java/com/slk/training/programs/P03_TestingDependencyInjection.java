package com.slk.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.slk.training.cfg.AppConfig1;
import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;

public class P03_TestingDependencyInjection {

	public static void main(String[] args) throws DaoException {

		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("context3.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

		ContactsDao dao = ctx.getBean("dao4", ContactsDao.class);
		int cc = dao.count();
		System.out.printf("There are %d contacts\n", cc);

		ctx.close();

	}
}
