package assignment22.programs;

import java.util.Date;
import java.util.List;

import assignment22.dao.ContactsDao;
import assignment22.dao.DaoException;
import assignment22.dao.DaoFactory;
import assignment22.entity.Contact;
import assignment22.entity.Gender;
import assignment22.utils.DateUtil;
import assignment22.utils.KeyboardUtil;

public class PhonebookApp {

	private ContactsDao dao;

	public PhonebookApp() throws DaoException {
		// TIGHT COUPLING
		// dao = new ContactsDaoJdbcImpl();
		
		// LOOSE COUPLING VIA FACTORY METHOD
		dao = DaoFactory.getContactsDao();
	}

	public void start() {
		int choice;

		while ((choice = menu()) != 0) {

			switch (choice) {
			case 1:
				addNewContact();
				break;
			case 2:
				listAllContacts();
				break;
			case 3:
				searchByLastname();
				break;
			case 4:
				searchByEmail();
				break;
			case 5:
				searchByPhone();
				break;
			case 6:
				searchByCity();
				break;
			case 7:
				searchByDateOfBirthRange();
				break;
			case 8:
				Contact contactToDelete = searchContactById();
				if (contactToDelete != null) {
					deleteContact(contactToDelete.getId());
				}
				break;
			case 9:
				Contact contactToEdit = searchContactById();
				if (contactToEdit != null) {
					editAndUpdateContact(contactToEdit);
				}
				break;

			}
		}

		System.out.println("Thanks for using the app!");
	}

	private void searchByEmail() {
		try {
			String email = KeyboardUtil.getString("Enter email address for searching contact: ");

			Contact contact = dao.getContactByEmail(email);
			if (contact == null) {
				System.out.println("No contact found for email: " + email);
				return;
			}
			printContactDetails(contact);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please try agian!");
		}
	}

	private void searchByPhone() {
		try {
			String phone = KeyboardUtil.getString("Enter phone number for searching contact: ");

			Contact contact = dao.getContactByPhone(phone);
			if (contact == null) {
				System.out.println("No contact found for phone number: " + phone);
				return;
			}
			printContactDetails(contact);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please try agian!");
		}
	}

	private void deleteContact(int id) {
		String choice = getString("Do you want to delete this record? (yes/no)", "no");
		if (choice.equalsIgnoreCase("yes")) {
			try {
				dao.deleteContact(id);
				System.out.println("Contact deleted successfully!");
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
	}

	private void searchByDateOfBirthRange() {
		Date from = KeyboardUtil.getDate("Enter from date in YYYY-MM-DD format: ");
		Date to = KeyboardUtil.getDate("Enter to date in YYYY-MM-DD format: ");

		try {
			List<Contact> list = dao.getContactsByBirthDate(from, to);
			printContacts(list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private void searchByCity() {
		String city = KeyboardUtil.getString("Enter city to search contacts: ");
		try {
			List<Contact> list = dao.getContactsByCity(city);
			printContacts(list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private void listAllContacts() {
		List<Contact> list;
		try {
			list = dao.getContacts();
			printContacts(list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private void searchByLastname() {
		String lastname = KeyboardUtil.getString("Enter lastname to search contacts: ");
		try {
			List<Contact> list = dao.getContactsByLastname(lastname);
			printContacts(list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public int menu() {

		while (true) {
			line("~");
			System.out.println("1. Add new contact");
			System.out.println("2. List all contacts");
			System.out.println("3. Search by lastname");
			System.out.println("4. Search by email address");
			System.out.println("5. Search by phone number");
			System.out.println("6. Search by city");
			System.out.println("7. Search by date of birth range");
			System.out.println("8. Delete contact");
			System.out.println("9. Edit contact");
			line("~");
			try {
				int choice = KeyboardUtil.getInt("Enter your choice (0 to exit): ");
				if (choice < 0 || choice > 9) {
					System.out.println("Invalid choice. Please try again!");
				} else {
					return choice;
				}
			} catch (Exception e) {
				System.out.println("Only integers are acceptable. Please try again!");
			}
		}
	}

	private void addNewContact() {
		Contact c = new Contact();
		c = getFieldValuesFromKeyboard(c);

		try {
			dao.addContact(c);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private void printContacts(List<Contact> list) {
		if (list == null) {
			return;
		}

		if (list.size() == 0) {
			System.out.println("The search did not match any records!");
			return;
		}

		line("-");
		System.out.printf("%3s %-30s %-30s %-15s %-15s\n", "Id", "Name", "Email id", "Phone no.", "City");
		line("-");
		for (Contact c : list) {
			String title = c.getGender() == Gender.MALE ? "Mr." : "Ms.";

			System.out.printf("%3d %-30s %-30s %-15s %-15s\n", c.getId(),
					title + c.getFirstname() + " " + (c.getLastname() == null ? "" : c.getLastname()), c.getEmail(),
					c.getPhone(), c.getCity());

		}

	}

	private void editAndUpdateContact(Contact contact) {
		String choice = getString("Do you want to edit details? (yes/no)", "yes");
		if (choice.equalsIgnoreCase("yes")) {
			contact = getFieldValuesFromKeyboard(contact);
			try {
				dao.updateContact(contact);
				System.out.println("Contact details updated successfully!");
				line("=");
			} catch (DaoException e) {
				e.printStackTrace();
			}

		}
	}

	private Contact searchContactById() {
		try {
			int id = KeyboardUtil.getInt("Enter id for searching contact: ");
			Contact c = dao.getContact(id);
			if (c == null) {
				System.out.println("No contact found for id " + id);
				return null;
			}

			printContactDetails(c);

			return c;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please try agian!");
		}
		return null;

	}

	private void printContactDetails(Contact contact) {
		String title = contact.getGender() == Gender.MALE ? "Mr." : "Ms.";
		String fullname = String.format("%s%s %s", title, contact.getFirstname(), contact.getLastname());
		System.out.println("Name          : " + fullname);
		System.out.println("Date of birth : " + DateUtil.toString(contact.getBirthDate()));
		System.out.println("Email id      : " + contact.getEmail());
		System.out.println("Phone number  : " + contact.getPhone());
		System.out.println("Address       : " + contact.getAddress());
		System.out.println("City          : " + contact.getCity());
		System.out.println("State         : " + contact.getState());
		System.out.println("Pincode       : " + contact.getPincode());
		System.out.println("Country       : " + contact.getCountry());
	}

	private Contact getFieldValuesFromKeyboard(Contact contact) {
		contact = copyOf(contact);
		contact.setFirstname(getString("Firstname", contact.getFirstname()));
		contact.setLastname(getString("Lastname", contact.getLastname()));

		String input = getString("Gender", contact.getGender().toString());
		if (input.equalsIgnoreCase("male")) {
			contact.setGender(Gender.MALE);
		} else if (input.equalsIgnoreCase("female")) {
			contact.setGender(Gender.FEMALE);
		} else {
			System.out.println("Invalid value for gender. Accepted as MALE");
		}

		contact.setEmail(getString("Email", contact.getEmail()));
		contact.setPhone(getString("Phone", contact.getPhone()));
		contact.setAddress(getString("Address", contact.getAddress()));
		contact.setCity(getString("City", contact.getCity()));
		contact.setState(getString("State", contact.getState()));
		contact.setPincode(getInt("Pincode", contact.getPincode()));
		contact.setBirthDate(getDate("D.O.B in yyyy-mm-dd format", contact.getBirthDate()));
		contact.setCountry(getString("Country", contact.getCountry()));

		return contact;
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

	private String getString(String field, String value) {
		String msg = String.format("%s %s", field, value == null ? "" : "(" + value + ") ");
		String input = KeyboardUtil.getString(msg);
		if (input.trim().equals("")) {
			input = value;
		}
		return input;
	}

	private Integer getInt(String field, Integer value) {
		String msg = String.format("%s %s", field, value == null ? "" : "(" + value + ") ");
		String input = KeyboardUtil.getString(msg);
		if (input.trim().equals("")) {
			return value;
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private Date getDate(String field, Date value) {
		String msg = String.format("%s %s", field, value == null ? "" : "(" + DateUtil.toString(value) + ") ");
		Date input = KeyboardUtil.getDate(msg);
		if (input == null) {
			input = value;
		}
		return input;
	}

	private void line(String ch) {
		for (int i = 0; i < 90; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}

	public static void main(String[] args) throws DaoException {
		new PhonebookApp().start();
	}

}
