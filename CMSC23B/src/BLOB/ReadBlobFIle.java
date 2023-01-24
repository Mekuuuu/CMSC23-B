package CMSC23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadBlobFIle {

    public static void main(String[] args) throws Exception  {

	// connection
	Connection conn = DbConnect.getConnection();
		
	//sql query
	Statement stmt = conn.createStatement();
	String sql = "select resume from blob_table where id=4";
	ResultSet rs = stmt.executeQuery(sql);
	
	// Read audio from blob data type
	File file = new File("E://java/myaudio.mp3");
	FileOutputStream output = new FileOutputStream(file);
	
	if(rs.next()) {
            InputStream input = rs.getBinaryStream("resume");
			
	    byte[] buffer = new byte[1024];
	    while(input.read(buffer)>0) {
		output.write(buffer);
	    }
	}	
	System.out.println("Audio is successfully readable....");
    }
}