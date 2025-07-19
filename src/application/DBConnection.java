package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 3306;
	private static final String DB_NAME = "KIA_PALESTINE_BRANCH";
	private static final String USERNAME = "kiaDB";
	private static final String PASSWORD = "120kiaDB119";

	private static Connection connection;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME),
					USERNAME, PASSWORD);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}
}
