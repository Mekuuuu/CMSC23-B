package firstoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertdem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// link and load the driver
		// establish a connection
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "system";
		String password = "system";
		Connection connection = null;
		Statement statement = null;

		System.out.println("Enter Details");
		String name = sc.next();
		int id = sc.nextInt();
		int age = sc.nextInt();
		
		
		String sql = "insert into student values('" + name + "'," + id + ",'" + age + "')";
		try {
			// establish a connection
			connection = DriverManager.getConnection(url, username, password);

			// create a statement object and add a query
			statement = connection.createStatement();
			// execute the statement
			boolean result = statement.execute(sql);
			System.out.println("inserted " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
