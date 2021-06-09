package com.logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exceptions.InvalidCourt;
import com.model.Court;

import connection.Db;

public class GrandSlamCourt {
	
	 public static void addCourt(Court c) {
		 try {
			 Statement st=Db.getCon().createStatement();
				ResultSet rs=st.executeQuery("Select * from Court");
				while(rs.next())
				{//System.out.println(rs.getString(1));
					if(Integer.parseInt(rs.getString(3))==c.getNumber()) {
						throw new InvalidCourt("Not Valid");
					}
					else {
			PreparedStatement ps=Db.getCon().prepareStatement("INSERT INTO Court VALUES (?,?,?,?)");
			ps.setInt(1,c.getNumber());
			ps.setString(2, c.getName());
			ps.setString(3, c.getType());
			ps.setInt(4, c.getCapacity());
			ps.executeUpdate();
			
		}
				}
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCourt e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		 
		 
	 }

}
