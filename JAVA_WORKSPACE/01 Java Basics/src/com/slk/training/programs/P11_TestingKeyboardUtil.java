package com.slk.training.programs;

import java.util.Date;

import com.slk.training.utils.KeyboardUtil;

public class P11_TestingKeyboardUtil {

	public static void main(String[] args) {

		String name;
		int age;
		double height;
		Date dob;

		name = KeyboardUtil.getString("Enter name: ");
		age = KeyboardUtil.getInt("Enter age: ");
		height = KeyboardUtil.getDouble("Enter height: ");
		dob = KeyboardUtil.getDate("Enter date of birth in YYYY-MM-DD format: ");

		System.out.println("Name   = " + name);
		System.out.println("Age    = " + age + " years.");
		System.out.println("Height = " + height);
		System.out.println("DOB    = " + dob);

	}

}
