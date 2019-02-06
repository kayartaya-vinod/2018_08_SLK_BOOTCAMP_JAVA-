package com.slk.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.slk.training.entity.Contact;

// Spring treats this class as a "Component", and can search for these type of
// classes and instantiate automatically using @ComponentScan
@Component("dao")
public class JdbcTemplateContactsDao implements ContactsDao {

	@Autowired
	private JdbcTemplate template;

	private ContactRowMapper mapper;

	public JdbcTemplateContactsDao() {
		System.out.println(">>>> new instanceof JdbcTemplateContactsDao created!");
		mapper = new ContactRowMapper();
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		String sql = "insert into contacts(first_name, last_name, gender, email, phone, address, city, state, pincode, country, birth_date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			template.update(sql, contact.getFirstname()
					, contact.getLastname()
					, contact.getGender()
					, contact.getEmail()
					, contact.getPhone()
					, contact.getAddress()
					, contact.getCity()
					, contact.getState()
					, contact.getBirthDate()
					, contact.getCountry()
					, contact.getBirthDate());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		String sql = "select * from contacts where id = ?";
		try {
			return template.queryForObject(sql, mapper, id);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		String sql = "update contacts set first_name=?, last_name=?, gender=?, email=?, phone=?, address=?, city=?, state=?, pincode=?, country=?, birth_date=? where id=?";
		try {
			template.update(sql, contact.getFirstname()
					, contact.getLastname()
					, contact.getGender()
					, contact.getEmail()
					, contact.getPhone()
					, contact.getAddress()
					, contact.getCity()
					, contact.getState()
					, contact.getBirthDate()
					, contact.getCountry()
					, contact.getBirthDate()
					, contact.getId());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		// use template.update() method for DML statements (insert/update/delete)
		try {
			template.update("delete from contacts where id = ?", id);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		String sql = "select * from contacts where email = ?";
		try {
			return template.queryForObject(sql, mapper, email);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		String sql = "select * from contacts where phone = ?";
		try {
			return template.queryForObject(sql, mapper, phone);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		String sql = "select * from contacts where last_name = ?";
		try {
			return template.query(sql, mapper, lastname);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		String sql = "select * from contacts where city = ?";
		try {
			return template.query(sql, mapper, city);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		String sql = "select * from contacts";
		try {
			return template.query(sql, mapper);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		String sql = "select * from contacts where birth_date between ? and ?";
		try {
			return template.query(sql, mapper, from, to);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	@Override
	public int count() throws DaoException {
		try {
			return template.queryForObject("select count(*) from contacts", Integer.class);
		} catch (DataAccessException e) {
			throw new DaoException(e); // convert DataAccessException into DaoException
		}
	}

	class ContactRowMapper implements RowMapper<Contact> {

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
