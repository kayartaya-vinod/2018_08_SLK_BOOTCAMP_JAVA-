package com.slk.training.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class P24_TestJdbcConnection {

	public static void main(String[] args) throws Exception {

		String driver = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/NORTHWIND_DB";
		String username = "sa";
		String password = "";

		// driver = "com.mysql.jdbc.Driver";
		// url = "jdbc:mysql://localhost/northwind";
		// username = "root";
		// password = "root";

		// step 1: load the db driver into the JVM
		// loading a jdbc driver class into the JVM, automatically creates
		// an instance of the same class and registers with JDBC DriverManager
		Class.forName(driver);

		// step 2: get an instance of java.sql.Connection (which is an interface)
		// using DriverManager's factory method
		Connection conn = DriverManager.getConnection(url, username, password);

		System.out.println("Got a connection of " + conn.getClass());

		conn.close();
	}

}
