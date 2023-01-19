//still to be finished
package cmsc23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TableList {

	public static void main(String[] args) throws Exception {
		createTable(); //test1
		post(); //test2
		get(); //test3
		clear(); //test4
	}


	public static ArrayList<String> get() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM List");

			ResultSet result = statement.executeQuery();

			ArrayList<String> table = new ArrayList<String>();
			while(result.next()){
				System.out.print(result.getString("first"));
				System.out.print(result.getString(" "));
				System.out.println(result.getString("last"));

				table.add(result.getString("last"));
			}
			System.out.println("All records have been selected.");
			return table;
		} catch (Exception e) {System.out.println(e);}

		return null;
	}
	
	public static void clear() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("TRUNCATE TABLE 'List'");
			statement.executeUpdate();
		} catch (Exception e) {System.out.println(e);}
		finally{System.out.println("Clear Completed.");};
	}

	public static void post() throws Exception{
		//Scanner inputs will be implemented later
		final String var1 = "John"; //input1
		final String var2 = "Smith"; //input2
		try{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO List (first,last) VALUES ('"+var1+"','"+var2+"')");
			posted.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Insert Completed");};
	}
	public static void createTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXIST List(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();

		}catch(Exception e){System.out.println(e);}
		finally{System.out.println("Function Complete.");};
	}
	public static Connection getConnection() throws Exception{
		try{
			//placeholders
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://24.196.52.166:3306/testdb";
			String username = "javadata";
			String password = "mypass";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}

		return null;
	}

}
