package busReservation;

import java.sql.*;

public class DbConnection {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/busresv";
	private static final String username = "root";
	private static final String password = "0123";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
  
}
