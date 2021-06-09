package connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {
	
	
	static Connection con=null;
	public static Connection getCon()
	{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","Rahulapple10");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}


