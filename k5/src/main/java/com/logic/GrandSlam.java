package com.logic;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.exceptions.InvalidCourt;
import com.exceptions.InvalidSeed;
import com.model.Court;
import com.model.Match;
import com.model.Player;
import java.util.*;

import connection.Db;

public class GrandSlam {
	
	//static Connection con=null;
	/*public static void validUser(String user,String pass) {
		try {
			Statement st=Db.getCon().createStatement();
			ResultSet rs=st.executeQuery("Select * from register1");
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				if(rs.getString(1)==user) {
					RequestDispatcher rd=request.getRequestDispatcher("Options.html");
					
					}
				}
			
		}
		catch(Exception e){
			
		}
		
		
	}*/
	public static void addPlayer(Player p) throws InvalidSeed {
	
		try
		{
				PreparedStatement ps=Db.getCon().prepareStatement("INSERT INTO Player VALUES (?,?,?,?,?,?)"); 
				ps.setString(1,p.getName());  
				ps.setInt(2,p.getAge());  
				ps.setInt(3,p.getSeed());  
				ps.setInt(4,p.getNoOfTournaments());
				ps.setString(5,p.getNationality());
				ps.setString(6,p.getStrength());
				ps.executeUpdate();
		
			}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	
	}
	
	
	public static void deletePlayer(int seed)throws InvalidSeed {
		int i=0;
		
		try { //con=new Db().getCon();
			Statement st=Db.getCon().createStatement();
			ResultSet rs=st.executeQuery("Select * from Player");
			while(rs.next()) 
				//try{
			{//System.out.println(rs.getString(1));
				if(Integer.parseInt(rs.getString(3))==seed) {
		 PreparedStatement ps=Db.getCon().prepareStatement("DELETE FROM Player WHERE Seed = ? ");  
         ps.setInt(1,seed);  
         ps.executeUpdate();
         i++;
        // break;
				}
				//else {
				//	throw new InvalidSeed("Not valid");
					
				//}
       //  con.close();  
     
			}
			
		//}
		// catch (InvalidSeed e) {
				// TODO Auto-generated catch block
		//		System.out.println("Invalid Seed");
		//		continue;
				
			//System.out.println("Enter valid Player seed");
    	// e.printStackTrace();
    // }
	} 
		catch(Exception e){
    	e.printStackTrace();
       
		 }

		if(i==0){
			throw new InvalidSeed("Not valid");
		}
	}
	
	public static void updatePlayer(Player p) throws InvalidSeed {
	int i=0;
		 try{  
			 Statement st=Db.getCon().createStatement();
				ResultSet rs=st.executeQuery("Select * from Player");
				while(rs.next()) 
					//try{
				{//System.out.println(rs.getString(1));
					if(Integer.parseInt(rs.getString(3))==p.getSeed()) {
	           // con=Db.getCon(); 
	            PreparedStatement ps=Db.getCon().prepareStatement( "UPDATE Player SET name=?,age=?,tournaments=?,nationality=? WHERE seed=?");  
	            ps.setString(1,p.getName());  
	            ps.setInt(2,p.getAge());  
	            ps.setInt(3,p.getNoOfTournaments());  
	            ps.setString(4,p.getNationality());  
	            ps.setInt(5,p.getSeed());  
	              
	            ps.executeUpdate();  
	              i++;
	            //con.close();  
				
		 }
				}
		 }catch(Exception ex){
	        	ex.printStackTrace();
	        	}
		 if(i==0){
				throw new InvalidSeed("Not valid");
			}
		

	}
	
	public static Player getPlayer(int id){  
        Player p=new Player();  
          
        try{ 
					PreparedStatement ps=Db.getCon().prepareStatement("select * from Player where Seed = ? ");
					ps.setInt(1, id);
					 ResultSet rs=ps.executeQuery();  
			            while(rs.next()){  
            	p.setSeed(rs.getInt(3));
                 
                p.setName(rs.getString(1));  
                p.setAge(rs.getInt(2));  
                p.setNoOfTournaments(rs.getInt(4));;  
                p.setNationality(rs.getString(5));  
                ps.executeUpdate(); 
           // con.close();  
        }
        }catch(Exception ex){ex.printStackTrace();}  
          
        return p;  
        }
	
	 public static List<Player> getAllPlayers(){  
	        List<Player> list=new ArrayList<Player>();  
	          
	        try{  
	           // con=Db.getCon();  
	            PreparedStatement ps=Db.getCon().prepareStatement("select * from Player");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Player p=new Player();  
	                p.setSeed(rs.getInt(3));
	                p.setName(rs.getString(1));  
	                p.setAge(rs.getInt(2));  
	                p.setNoOfTournaments(rs.getInt(4));;  
	                p.setNationality(rs.getString(5)); 
	                p.setStrength(rs.getString(6));
	                list.add(p);  
	            }  
	           // con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	 
	/* public static void addCourt(Court c) {
		 try {
		 PreparedStatement ps=Db.getCon().prepareStatement("INSERT INTO Court VALUES (?,?,?,?)"); 
			ps.setInt(1,c.getNumber());  
			ps.setString(2,c.getName());  
			ps.setInt(3,c.getPlayer1().getSeed());
			ps.setInt(4,c.getPlayer2().getSeed());
			ps.executeUpdate();
		 }
		 catch(Exception e){
			 e.printStackTrace();		 }
		 
	 }*/
	 
	 public static void addCourt(Court c)  {
		 try {
			PreparedStatement ps=Db.getCon().prepareStatement("INSERT INTO Court VALUES (?,?,?,?)");
			ps.setInt(1,c.getNumber());
			ps.setString(2, c.getName());
			ps.setString(3, c.getType());
			ps.setInt(4, c.getCapacity());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			
		} 
		 
		 
	 }
	 
	 public static void deleteCourt(int number) throws InvalidCourt {
		 int i=0;
			try { //con=new Db().getCon();
				Statement st=Db.getCon().createStatement();
				ResultSet rs=st.executeQuery("Select * from Court");
				while(rs.next())
				{//System.out.println(rs.getString(1));
					if(Integer.parseInt(rs.getString(1))==number) {
			 PreparedStatement ps=Db.getCon().prepareStatement("DELETE FROM Court WHERE Number = ? ");  
	         ps.setInt(1,number);  
	         ps.executeUpdate();  
	         i++;
					}
					
	       //  con.close();  
	     }
			}catch(Exception e){
	    	e.printStackTrace();//System.out.println("Enter valid Player seed");
	    	// e
	 }
			if(i==0){
				throw new InvalidCourt("Not valid");
			}
	 }
	 
	 public static void updateCourt(Court p) throws InvalidCourt{
		 int i=0;
		 try{  Statement st=Db.getCon().createStatement();
			ResultSet rs=st.executeQuery("Select * from Court");
			while(rs.next()) 
				//try{
			{
				if(Integer.parseInt(rs.getString(1))==p.getNumber()) {
	           // con=Db.getCon(); 
	            PreparedStatement ps=Db.getCon().prepareStatement( "UPDATE Court SET name=?,type=?,capacity=? WHERE number=?");  
	            ps.setString(1,p.getName());  
	            ps.setString(2,p.getType());  
	            ps.setInt(3,p.getCapacity());  
	            ps.setInt(4,p.getNumber());  
	              
	            ps.executeUpdate();  
	              i++;
				}
			}//con.close();  
				
		 }catch(Exception ex){
	        	ex.printStackTrace();
	        	}  
		 if(i==0){
				throw new InvalidCourt("Not valid");
			}

	}
	 
	 public static List<Court> showCourts(){
		 List<Court> list=new ArrayList<Court>();
		 
		 try{  
	           // con=Db.getCon();  
	            PreparedStatement ps=Db.getCon().prepareStatement("select * from Court");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Court c=new Court();
	            	c.setNumber(rs.getInt(1));
	            	c.setName(rs.getString(2));
	            	c.setType(rs.getString(3));
	            	c.setCapacity(rs.getInt(4));
	            	list.add(c);
	            	
	         	
	            }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return list;
	 }
}


