package assignment23.entity;

public class Person {

	private static int idCounter;

	private final int id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;

	public Person() {
		id = ++idCounter;
	}

	public Person(String firstname, String lastname, String phone, String email) {
		id = ++idCounter;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	// by not having a setter for "id", the property "id" becomes readonly

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
