/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 10, 2020
 * @version 1.0
 */ 
package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static DBConnection instance;
	private Connection connection;

	private DBConnection() {
		Properties properties = new Properties();
		try {
			properties.load(DBConnection.class.getResourceAsStream("/dbconfig.properties"));
			final String driver = properties.getProperty("driver");
			final String server = properties.getProperty("server");
			final String user = properties.getProperty("user");
			final String pass = properties.getProperty("pass");
			Class.forName(driver);
			connection = DriverManager.getConnection(server, user, pass);
		} catch (ClassNotFoundException | IOException | SQLException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}

		return instance;
	}

	public static void main(String[] args) {
		try {
			System.out.println(DBConnection.getInstance().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
