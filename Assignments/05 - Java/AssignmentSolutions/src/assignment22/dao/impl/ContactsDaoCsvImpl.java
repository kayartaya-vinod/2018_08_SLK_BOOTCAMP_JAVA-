package assignment22.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment22.dao.ContactsDao;
import assignment22.dao.DaoException;
import assignment22.entity.Contact;
import assignment22.entity.Gender;
import assignment22.utils.DateUtil;

public class ContactsDaoCsvImpl implements ContactsDao {
	
	private Map<Integer, Contact> map;
	private String filename = "contacts.csv";

	public ContactsDaoCsvImpl() {
		map = new HashMap<>();
		// populate the map from the CSV file, if the file exists
		try {
			FileReader file = new FileReader(filename);
			BufferedReader in  = new BufferedReader(file);
			
			// skip the header
			in.readLine();
			
			while(true) {
				String line = in.readLine();
				if(line==null) break;
				
				Contact contact = csvToContact(line);
				map.put(contact.getId(), contact);
			}
			in.close();
			file.close();
			
		} catch (IOException e) {
			// nothing to be done here!
		}
	}

	private Contact csvToContact(String line) {
		String[] fields = line.split(",");
		Contact contact = new Contact();
		contact.setId(Integer.parseInt(fields[0]));
		contact.setFirstname(fields[1]);
		contact.setLastname(fields[2]);
		contact.setGender(fields[3].equals("MALE") ? Gender.MALE : Gender.FEMALE);
		contact.setEmail(fields[4]);
		contact.setPhone(fields[5]);
		contact.setAddress(fields[6]);
		contact.setCity(fields[7]);
		contact.setState(fields[8]);
		contact.setPincode(new Integer(fields[9]));
		contact.setCountry(fields[10]);
		contact.setBirthDate(DateUtil.toDate(fields[11]));
		return contact;
	}
	
	private void saveToCsv() {
		
		String header = "ID,FIRSTNAME,LASTNAME,GENDER,EMAIL,PHONE,ADDRESS,CITY,STATE,PINCODE,COUNTRY,BIRTH_DATE";
		
		try {
			FileWriter file = new FileWriter(filename);
			PrintWriter out = new PrintWriter(file);
			
			out.println(header);
			
			for(Contact c: map.values()) {
				String csv = contactToCsv(c);
				out.println(csv);
			}
			
			out.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private String contactToCsv(Contact c) {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
				c.getId(),
				c.getFirstname(),
				c.getLastname(),
				c.getGender(),
				c.getEmail(),
				c.getPhone(),
				c.getAddress(),
				c.getCity(),
				c.getState(),
				c.getPincode(),
				c.getCountry(),
				DateUtil.toString(c.getBirthDate()));
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		map.put(contact.getId(), contact);
		saveToCsv();
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		return map.get(id);
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		

	}

	@Override
	public void deleteContact(int id) throws DaoException {
		if (map.containsKey(id)) {
			map.remove(id);
			saveToCsv();
		} else {
			throw new DaoException("Nothing was deleted since contact for the given id was not found!");
		}
	}

	@Override
	public Contact getContactByEmail(String email) throws DaoException {
		
		return null;
	}

	@Override
	public Contact getContactByPhone(String phone) throws DaoException {
		
		return null;
	}

	@Override
	public List<Contact> getContactsByLastname(String lastname) throws DaoException {
		
		return null;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		
		return null;
	}

	@Override
	public List<Contact> getContacts() throws DaoException {
		List<Contact> list = new ArrayList<>();
		for(Contact c: map.values()) {
			list.add(c);
		}
		return list;
	}

	@Override
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
		
		return null;
	}

}
