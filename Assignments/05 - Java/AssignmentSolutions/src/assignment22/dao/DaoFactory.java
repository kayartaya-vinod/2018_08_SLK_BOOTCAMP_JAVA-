package assignment22.dao;

import assignment22.dao.impl.ContactsDaoArrayListImpl;
import assignment22.dao.impl.ContactsDaoCsvImpl;
import assignment22.dao.impl.ContactsDaoHashMapImpl;
import assignment22.dao.impl.ContactsDaoJdbcImpl;

public final class DaoFactory {

	private static final String discriminator = "CSV";

	private DaoFactory() {
	}

	public static ContactsDao getContactsDao() throws DaoException {
		switch (discriminator.toUpperCase()) {
		case "JDBC":
			return new ContactsDaoJdbcImpl();
		case "HASHMAP":
			return new ContactsDaoHashMapImpl();
		case "CSV":
			return new ContactsDaoCsvImpl();
		case "ARRAYLIST":
			return new ContactsDaoArrayListImpl();
		default:
			throw new DaoException("No implementation found for discriminator: " + discriminator);
		}
	}
}
