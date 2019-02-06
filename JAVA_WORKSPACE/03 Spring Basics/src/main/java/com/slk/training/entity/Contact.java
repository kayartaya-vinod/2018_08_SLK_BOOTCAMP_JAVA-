package com.slk.training.entity;

import java.util.Date;

public class Contact {

	private static int idCounter;

	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String city = "Bangalore";
	private String state = "Karnataka";
	private Integer pincode;
	private String country = "India";
	private Date birthDate;

	public Contact() {
		this.id = ++idCounter;
	}

	public Contact(String firstname, String lastname, String email, String phone, String city) {
		this.id = ++idCounter;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", country=" + country + ", birthDate=" + birthDate + "]";
	}

}
