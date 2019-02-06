package assignment22.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import assignment22.dao.ContactsDao;
import assignment22.dao.DaoException;
import assignment22.entity.Contact;
import assignment22.entity.Gender;
import assignment22.utils.DbUtil;

public class ContactsDaoJdbcImpl implements ContactsDao {

	@Override
	public void addContact(Contact contact) throws DaoException {
		// Skipping the necessary validations

		String sql = "insert into contacts (first_name, last_name, gender, email, phone, address, city, state, pincode, country, birth_date) values (?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			// set the PreparedStatement's parameters using the function's argument contact
			// For example, stmt.setString(1, contact.getFirstname()) and so on..
			stmt.setString(1, contact.getFirstname());
			stmt.setString(2, contact.getLastname());
			stmt.setString(3, contact.getGender().toString());
			stmt.setString(4, contact.getEmail());
			stmt.setString(5, contact.getPhone());
			stmt.setString(6, contact.getAddress());
			stmt.setString(7, contact.getCity());
			stmt.setString(8, contact.getState());
			if (contact.getPincode() == null) {
				stmt.setNull(9, Types.INTEGER);
			} else {
				stmt.setInt(9, contact.getPincode());
			}

			stmt.setString(10, contact.getCountry());
			java.sql.Date bd = null;
			if (contact.getBirthDate() != null) {
				bd = new java.sql.Date(contact.getBirthDate().getTime());
			}

			stmt.setDate(11, bd);

			stmt.executeUpdate();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@Override
	public Contact getContact(int id) throws DaoException {
		String sql = "select * from contacts where id = ?";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return contactFromResultSet(rs);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		// Skipping the necessary validations

		String sql = "update contacts set first_name=?, last_name=?, gender=?, email=?, phone=?, address=?, city=?, state=?, pincode=?, country=?, birth_date=? where id=?";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			// set the PreparedStatement's parameters using the function's argument contact
			// For example, stmt.setString(1, contact.getFirstname()) and so on..
			stmt.setString(1, contact.getFirstname());
			stmt.setString(2, contact.getLastname());
			stmt.setString(3, contact.getGender().toString());
			stmt.setString(4, contact.getEmail());
			stmt.setString(5, contact.getPhone());
			stmt.setString(6, contact.getAddress());
			stmt.setString(7, contact.getCity());
			stmt.setString(8, contact.getState());
			if (contact.getPincode() == null) {
				stmt.setNull(9, Types.INTEGER);
			} else {
				stmt.setInt(9, contact.getPincode());
			}

			stmt.setString(10, contact.getCountry());
			java.sql.Date bd = null;
			if (contact.getBirthDate() != null) {
				bd = new java.sql.Date(contact.getBirthDate().getTime());
			}

			stmt.setDate(11, bd);
			stmt.setInt(12, contact.getId());

			stmt.executeUpdate();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		String sql = "delete from contacts where id = ?";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);

			int status = stmt.executeUpdate();
			if (status == 0) {
				throw new DaoException("Invalid id for deletion: " + id);
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		String sql = "select * from contacts where email = ?";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return contactFromResultSet(rs);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		String sql = "select * from contacts where phone = ?";

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, phone);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return contactFromResultSet(rs);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		String sql = "select * from contacts where upper(last_name) = upper(?)";
		List<Contact> list = new ArrayList<>();

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, lastname);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact c = contactFromResultSet(rs);
				list.add(c);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		String sql = "select * from contacts where upper(city) = upper(?)";
		List<Contact> list = new ArrayList<>();

		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, city);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact c = contactFromResultSet(rs);
				list.add(c);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		String sql = "select * from contacts";
		List<Contact> list = new ArrayList<>();

		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Contact c = contactFromResultSet(rs);
				list.add(c);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

	private Contact contactFromResultSet(ResultSet rs) throws SQLException {
		Contact c = new Contact();
		c.setId(rs.getInt("id"));
		c.setFirstname(rs.getString("first_name"));
		c.setLastname(rs.getString("last_name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getString("phone"));
		String gender = rs.getString("gender");
		c.setGender(gender.equals("MALE") ? Gender.MALE : Gender.FEMALE);
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getString("city"));
		c.setState(rs.getString("state"));
		c.setCountry(rs.getString("country"));
		c.setPincode(rs.getInt("pincode"));
		c.setBirthDate(rs.getDate("birth_date"));

		return c;
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		String sql = "select * from contacts where birth_date between ? and ?";
		List<Contact> list = new ArrayList<>();

		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			java.sql.Date fromDate = new java.sql.Date(from.getTime());
			java.sql.Date toDate = new java.sql.Date(to.getTime());

			stmt.setDate(1, fromDate);
			stmt.setDate(2, toDate);

			while (rs.next()) {
				Contact c = contactFromResultSet(rs);
				list.add(c);
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

}
