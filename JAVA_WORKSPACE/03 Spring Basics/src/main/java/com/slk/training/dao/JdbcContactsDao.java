package com.slk.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.slk.training.entity.Contact;

public class JdbcContactsDao implements ContactsDao {

	// fields
	private String driver;
	private String url;
	private String user;
	private String password;
	
	// connection pool
	private DataSource dataSource;

	public JdbcContactsDao() {
	}

	public JdbcContactsDao(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	// parameterized constructor for dependency injection
	public JdbcContactsDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// a setter function is kown as a writable property or mutator
	// The following function is a writable property called "driver"
	public void setDriver(String driver) {
		this.driver = driver;
	}

	// this is a writable property called "url"
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// a setter for dependency injection via property-injection
	// exposes a writable property called "dataSource"
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
		
		if(dataSource!=null) {
			return dataSource.getConnection();
		}
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public int count() throws DaoException {
		String sql = "select count(*) from contacts";

		try (Connection conn = createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

}
