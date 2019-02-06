package com.slk.training.dao;

import com.slk.training.dao.impl.ContactsDaoArrayListImpl;
import com.slk.training.dao.impl.ContactsDaoCsvImpl;
import com.slk.training.dao.impl.ContactsDaoHashMapImpl;
import com.slk.training.dao.impl.ContactsDaoJdbcImpl;

public final class DaoFactory {

	private static final String discriminator = "JDBC";

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
