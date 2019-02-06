package com.slk.training.programs;

import java.io.FileInputStream;

public class P22_ReadFromFile {

	public static void main(String[] args) throws Exception {

		// example1();
		example2();

	}
	
	static void example2() throws Exception {
		String filename = "src/com/slk/training/dao/ContactsDao.java";
		FileInputStream file = new FileInputStream(filename);

		int size = file.available();		// returns the sizeof the file in most cases
		byte[] bytes = new byte[size];	// create an empty byte array to collect data
		
		file.read(bytes);
		String text = new String(bytes);
		System.out.println(text);
		
		file.close();
	}

	static void example1() throws Exception {
		String filename = "src/com/slk/training/dao/ContactsDao.java";
		FileInputStream file = new FileInputStream(filename);

		int ch;

		while ((ch = file.read()) != -1) {
			System.out.print((char) ch);
		}
		
		file.close();
	}

}
