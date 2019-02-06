package com.slk.training.programs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.slk.training.cfg.AppConfig2;
import com.slk.training.entity.Contact;

public class P04_TestingJdbcTemplate {

	static JdbcTemplate template;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);

		template = ctx.getBean(JdbcTemplate.class);

		printContactsCount();
		printEmailForContact(22); // 22 is the id
		printContactDetailsForId(22); // name, email, phone etc
		printContactsFromCity("Miami");
		getContactById(22); // should get an instanceof Contact.class
		getContactsByCity("Miami"); // should get a list of Contact instances
		ctx.close();
	}

	static void getContactsByCity(String city) {
		String sql = "select * from contacts where city = ?";
		// whenever you need a list of custom domain/entity objects,
		// use query() method by supplying appropriate RowMapper<?> instance
		List<Contact> list = template.query(sql, new ContactRowMapper(), city);
		for (Contact c : list) {
			System.out.println(c);
		}
		line();
	}

	static void getContactById(int id) {
		String sql = "select * from contacts where id = ?";

		// contains logic for converting ResultSet into Contact instance
		ContactRowMapper mapper = new ContactRowMapper();

		// whenever you need a custom domain/entity object from query based on candidate
		// key,
		// use queryForObject() method by suppying a RowMapper<?> instance
		Contact ct = template.queryForObject(sql, mapper, id);
		System.out.println(ct);
		line();
	}

	static void printContactsFromCity(String city) {
		String sql = "select * from contacts where city = ?";
		// multiple rows, muplit columns --> use queryForList
		List<Map<String, Object>> list = template.queryForList(sql, city);

		System.out.println("Contacts living in " + city + ": ");
		for (Map<String, Object> data : list) {
			System.out.println(data);
		}
		line();
	}

	static void printContactDetailsForId(int id) {
		String sql = "Select first_name, last_name, email, phone from contacts where id = ?";
		// since the query results in 1 row and multiple columns, use queryForMap
		Map<String, Object> data = template.queryForMap(sql, id);
		for (String column : data.keySet()) {
			System.out.println(column + " --> " + data.get(column));
		}
		line();
	}

	static void printEmailForContact(int id) {
		// Since the query results in 1 row 1 column, we use queryForObject
		String sql = "select email from contacts where id = ?";
		String email = template.queryForObject(sql, String.class, id);
		System.out.println("Email for id " + id + " is " + email);
		line();
	}

	static void printContactsCount() {
		// use queryForObject when the SQL query returns 1 row 1 column only
		Integer cnt = template.queryForObject("select count(*) from contacts", Integer.class);
		System.out.println("There are " + cnt + " contacts");
		line();
	}

	static void line() {
		System.out.println("--------------------------------------------------------");
	}

	static class ContactRowMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact c = new Contact();
			c.setId(rs.getInt("id"));
			c.setFirstname(rs.getString("first_name"));
			c.setLastname(rs.getString("last_name"));
			c.setEmail(rs.getString("email"));
			c.setPhone(rs.getString("phone"));
			c.setGender(rs.getString("gender"));
			c.setAddress(rs.getString("address"));
			c.setCity(rs.getString("city"));
			c.setState(rs.getString("state"));
			c.setCountry(rs.getString("country"));
			c.setPincode(rs.getInt("pincode"));
			c.setBirthDate(rs.getDate("birth_date"));

			return c;
		}

	}
}
