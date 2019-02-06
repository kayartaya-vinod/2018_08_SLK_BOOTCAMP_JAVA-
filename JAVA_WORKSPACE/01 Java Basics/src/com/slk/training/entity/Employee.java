package com.slk.training.entity;

// EMPLOYEE is an extension of PERSON
public class Employee extends Person {

	private int id;
	private String dept;
	private String email;
	private double salary;

	public Employee() {
	}

	public Employee(int id, String name, String dept, String email, double salary) {
		super(name, 0, 0.0);
		this.id = id;
		this.dept = dept;
		this.email = email;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public void print() {
		System.out.println("Id         = " + id);
		System.out.println("Name       = " + getName());
		System.out.println("Salary     = $" + salary);
		System.out.println("Department = " + dept);
		System.out.println("Email id   = " + email);
		System.out.println("---------------------");
	}

	

}
