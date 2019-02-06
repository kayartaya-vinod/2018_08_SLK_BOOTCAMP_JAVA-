package assignment22.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment22.dao.ContactsDao;
import assignment22.dao.DaoException;
import assignment22.entity.Contact;

public class ContactsDaoHashMapImpl implements ContactsDao {

	private Map<Integer, Contact> map;

	public ContactsDaoHashMapImpl() {
		map = new HashMap<>();
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		// Validate the contact before storing it in the map
		// Validation rule#1: firstname, email, phone are mandatory
		// Validation rule#2: email must be unique
		// Validation rule#3: phone must be unique
		// Validation rule#4: pincode must be a positive number and less than 6 digits
		// Validation rule#5: birthDate should be at least 12 years older than today

		map.put(contact.getId(), contact);
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		return map.get(id);
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		// Validate the contact before updating it in the map
		// Validation rule#1: firstname, email, phone are mandatory
		// Validation rule#2: email must be unique
		// Validation rule#3: phone must be unique
		// Validation rule#4: pincode must be a positive number and less than 6 digits
		// Validation rule#5: birthDate should be at least 12 years older than today

		if (map.containsKey(contact.getId())) {
			map.put(contact.getId(), contact);
		} else {
			throw new DaoException("Nothing was updated since contact for the given id was not found!");
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		if (map.containsKey(id)) {
			map.remove(id);
		} else {
			throw new DaoException("Nothing was deleted since contact for the given id was not found!");
		}
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		for (Contact contact : map.values()) {
			if (contact.getEmail().equalsIgnoreCase(email)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		for (Contact contact : map.values()) {
			if (contact.getPhone().equalsIgnoreCase(phone)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		List<Contact> list = new ArrayList<>();
		for (Contact contact : map.values()) {
			if (contact.getLastname().equalsIgnoreCase(lastname)) {
				list.add(contact);
			}
		}
		return list;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		List<Contact> list = new ArrayList<>();
		for (Contact contact : map.values()) {
			if (contact.getCity().equalsIgnoreCase(city)) {
				list.add(contact);
			}
		}
		return list;
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		List<Contact> list = new ArrayList<>();
		for (Contact contact : map.values()) {
			list.add(contact);
		}
		return list;
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		List<Contact> list = new ArrayList<>();
		for (Contact contact : map.values()) {
			Date dob = contact.getBirthDate();

			if (dob.after(from) && dob.before(to)) {
				list.add(contact);
			}
		}
		return list;
	}

}
