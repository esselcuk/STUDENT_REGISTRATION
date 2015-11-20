package StudentCoursePlatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static Connection conn;
	static String url;
	static String dbname;
	static String driver;
	static String username;
	static String password;
	
	public static Connection getConnection()
	{
		
		String url="jdbc:mysql://localhost/";
		String dbName="courses";
		String driver="com.mysql.jdbc.Driver";
		String userName="root";
		String password="root";
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url+dbName,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}

}
