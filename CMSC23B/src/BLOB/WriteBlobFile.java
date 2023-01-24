package CMSC23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class WriteBlobFile {

    public static void main(String[] args) throws SQLException  {
	// BLOB --> Binary Large Object
		
	//connection
	Connection conn=null;
		
	//Sql query
	String sql = "update blob_table set resume=? where id=4";
	PreparedStatement stmt = null;
	try {
	    stmt = conn.prepareStatement(sql);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
		
	//Insert audio in blob data type
	File file = new File("E://java/audio1.mp3");
	FileInputStream input;
	try {
	    input = new FileInputStream(file);
	    stmt.setBinaryStream(1, input);
	    stmt.executeUpdate();
	    System.out.println("Audio is succesfully inserted...");
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    System.out.println("File is not located in specified location....");
	}
    }
}