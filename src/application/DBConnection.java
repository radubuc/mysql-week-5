package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
		private final static String URL = "jdbc:mysql://localhost:3306/chocolates";
		private final static String USERNAME = "root";
		private final static String PASSWORD = "IsMySQL2Obvious?";
		private static Connection connection; 
		private static DBConnection instance;
		
		private DBConnection(Connection connection) {
			this.connection = connection;
		}
		
		public static Connection getConnection() {
			if(instance == null) {
				try {
					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					instance = new DBConnection(connection);
					System.out.println("Connection successful. Welcome to the Chocobase!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return DBConnection.connection;
		}
}

