package com.slk.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "com.slk.training.dao" })
public class AppConfig2 {
	
	
	@Bean
	public JdbcTemplate template(DataSource ds) { // ds is "Dependency Injected"
		return new JdbcTemplate(ds); // ds is "Manually Wired" with JdbcTemplate object
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

}
