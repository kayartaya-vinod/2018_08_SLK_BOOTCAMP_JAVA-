package com.slk.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.slk.training.cfg.AppConfig2;
import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;

public class P05_TestingJdbcTemplateContactsDao {

	public static void main(String[] args) throws DaoException {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		
		ContactsDao dao = ctx.getBean(ContactsDao.class);
		System.out.println("dao is an object of " + dao.getClass());
		
		Contact c = dao.getContact(1);
		System.out.println(c);
		
		
		ctx.close();
	}
}
