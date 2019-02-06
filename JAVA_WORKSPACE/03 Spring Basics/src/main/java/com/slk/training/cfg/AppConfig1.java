package com.slk.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.JdbcContactsDao;

// This entire class is equivalent of context.xml which defines one ore more beans
@Configuration
public class AppConfig1 {

	// This class should define one ore more functions returning
	// a bean object, and must be annotated as @Bean.
	// By default, the name of the function is the name of the bean itself.
	// We can give more than one name as @Bean(name={"a", "b", "c"})
	@Bean
	public ContactsDao dao1() {
		JdbcContactsDao dao = new JdbcContactsDao();
		dao.setDriver("org.h2.Driver");
		dao.setUrl("jdbc:h2:tcp://localhost/~/assignment_22");
		dao.setUser("sa");
		dao.setPassword("");
		return dao;
	}

	@Scope("prototype")
	@Bean(name = "dao2")
	public ContactsDao dao2() {
		return new JdbcContactsDao("org.h2.Driver", "jdbc:h2:tcp://localhost/~/assignment_22", "sa", "");
	}

	@Bean(name = { "dbcp", "dataSource" })
	public DataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/assignment_22");
		bds.setUsername("sa");
		bds.setPassword("");
		bds.setInitialSize(10);
		bds.setMaxTotal(100);
		return bds;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public ContactsDao dao3() {
		return new JdbcContactsDao();
	}

	// Spring invokes this function, and passes an instanceof DataSource as argument
	// This is another example of how dependency injection works in Spring.
	@Bean
	public ContactsDao dao4(DataSource dataSource) {
		return new JdbcContactsDao(dataSource); // manual wiring using constructor
	}

}
