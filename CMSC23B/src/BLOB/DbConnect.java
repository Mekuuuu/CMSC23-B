package CMSC23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    static String databaseURL = "jdbc:mysql://localhost:3306/java";
    static String user="root";
    static String password = "";
	
    public static Connection getConnection() {
	Connection conn=null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    try {
		conn = DriverManager.getConnection(databaseURL,user,password);
	    } catch (SQLException e) {
		System.out.println(e);
	    }
	} catch (ClassNotFoundException e) {
	    System.out.println("Class not found exception");
	}
	return conn;	
    } 
}
