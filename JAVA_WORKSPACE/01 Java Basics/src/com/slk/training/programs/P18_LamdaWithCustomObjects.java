package com.slk.training.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.slk.training.entity.Contact;

public class P18_LamdaWithCustomObjects {

	public static void main(String[] args) {
		
		List<Contact> contacts = Arrays.asList(
			new Contact("Vinod", "Kumar", "vinod@vinod.co", "9731424784", "Bangalore"),
			new Contact("Vinay", "KM", "vinaykm@exmaple.com", "8881424123", "Hassan"),
			new Contact("Harish", "CJ", "harishcj@gmail.com", "7771424722", "Bangalore"),
			new Contact("Ajay", "Rao", "ajayrao123@yahoo.co.in", "6781424731", "Kolar"),
			new Contact("Ramesh", "Iyer", "ramesh_iyer_2233@gmail.com", "9876424755", "Shimoga"),
			new Contact("Nagaraj", "KK", "nagkk@example.com", "8877424732", "Davanagere")
			);

		// sort by firstname
		Collections.sort(contacts, (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname()));
		printContacts(contacts);

		Collections.sort(contacts, (c1, c2) -> c1.getCity().compareTo(c2.getCity()));
		printContacts(contacts);
		
		Contact contact = Collections.max(contacts, (c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname()));
		System.out.println("largest contact by firstname = " + contact);
		
	}

	private static void printContacts(List<Contact> contacts) {
		for(Contact c: contacts) {
			System.out.println(c);
		}
		System.out.println();
	}
}




