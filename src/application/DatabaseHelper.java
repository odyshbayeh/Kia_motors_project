package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
	private static final String URL = "jdbc:your_database_url";
	private static final String USER = "your_database_user";
	private static final String PASSWORD = "your_database_password";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static boolean authenticateManager(String username, String password) {
		String query = "SELECT * FROM Manager WHERE id = ? AND username = ? AND password = ?";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
