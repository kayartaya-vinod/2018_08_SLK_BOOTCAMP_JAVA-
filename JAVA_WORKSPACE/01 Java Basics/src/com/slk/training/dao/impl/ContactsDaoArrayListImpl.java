package com.slk.training.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;
import com.slk.training.entity.Gender;

public class ContactsDaoArrayListImpl implements ContactsDao {

	private List<Contact> list;

	public ContactsDaoArrayListImpl() {
		list = new ArrayList<>();

		list.add(new Contact("John", "Doe", "johndoe@example.com", "5553637444", "Dallas"));
		list.add(new Contact("Jane", "Doe", "janedoe@example.com", "5552345444", "Chicago"));

		list.get(1).setGender(Gender.FEMALE);
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		// skipping the required validations for now!!!

		// make a copy of the argument
		Contact c = copyOf(contact);
		list.add(c);
	}

	private Contact copyOf(Contact contact) {
		Contact c = new Contact();
		c.setId(contact.getId());
		c.setFirstname(contact.getFirstname());
		c.setLastname(contact.getLastname());
		c.setEmail(contact.getEmail());
		c.setPhone(contact.getPhone());
		c.setBirthDate(contact.getBirthDate());
		c.setGender(contact.getGender());
		c.setAddress(contact.getAddress());
		c.setCity(contact.getCity());
		c.setState(contact.getState());
		c.setCountry(contact.getCountry());
		c.setPincode(contact.getPincode());
		return c;
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		List<Contact> newList = new ArrayList<>();
		for (Contact c : list) {
			newList.add(c);
		}
		return newList;
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		for (Contact c : list) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		boolean found = false;
		for (int i = 0, j = list.size(); i < j && !found; i++) {
			Contact c = list.get(i);
			if (c.getId() == contact.getId()) {
				found = true;
				list.set(i, contact);
			}
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		boolean found = false;
		for (int i = 0, j = list.size(); i < j && !found; i++) {
			Contact c = list.get(i);
			if (c.getId() == id) {
				found = true;
				list.remove(i);
			}
		}
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		if (email == null) {
			return null;
		}

		for (Contact contact : list) {
			if (contact.getEmail().equalsIgnoreCase(email)) {
				return contact;
			}
		}

		return null;
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		if (phone == null) {
			return null;
		}

		for (Contact contact : list) {
			if (contact.getPhone().equals(phone)) {
				return contact;
			}
		}

		return null;
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		List<Contact> newList = new ArrayList<>();
		for (Contact c : list) {
			if (c.getLastname().equalsIgnoreCase(lastname)) {
				newList.add(c);
			}
		}
		return newList;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		List<Contact> newList = new ArrayList<>();
		for (Contact c : list) {
			if (c.getCity().equalsIgnoreCase(city)) {
				newList.add(c);
			}
		}
		return newList;
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		return null;
	}

}
