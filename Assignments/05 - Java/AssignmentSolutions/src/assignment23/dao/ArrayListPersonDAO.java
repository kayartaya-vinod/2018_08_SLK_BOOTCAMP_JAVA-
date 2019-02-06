package assignment23.dao;

import java.util.ArrayList;
import java.util.List;

import assignment23.entity.Person;

public class ArrayListPersonDAO implements PersonDAO {

	private static List<Person> persons = new ArrayList<>();

	static {
		persons.add(new Person("Vinod", "Kumar", "9731424784", "vinod@vinod.co"));
		persons.add(new Person("Shyam", "Sundar", "9383736344", "shyamsundarkc@gmail.com"));
		persons.add(new Person("Kiran", "Kumar", "9776544784", "kirankumar@example.com"));
	}

	public ArrayListPersonDAO() {
	}

	@Override
	public void insert(Person person) {
		persons.add(person);
	}

	@Override
	public List<Person> getAll() {
		return persons;
	}

	@Override
	public void delete(int id) {
		for (Person p : persons) {
			if (p.getId() == id) {
				persons.remove(p);
				break;
			}
		}
	}

}
