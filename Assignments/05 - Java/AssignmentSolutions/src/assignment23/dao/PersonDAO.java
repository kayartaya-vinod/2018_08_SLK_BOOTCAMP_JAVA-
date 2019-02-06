package assignment23.dao;

import java.util.List;

import assignment23.entity.Person;

public interface PersonDAO {
	public void insert(Person person);

	public List<Person> getAll();

	public void delete(int id);
}
