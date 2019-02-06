package assignment22.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbUtil {
	private DbUtil() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/assignment_22";
		String username = "sa";
		String password = "";

		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
