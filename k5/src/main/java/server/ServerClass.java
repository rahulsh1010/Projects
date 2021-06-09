package server;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exceptions.InvalidUser;

import java.io.*;

//import com.sun.jdi.connect.spi.Connection;


import connection.Db;

/**
 * Servlet implementation class ServerClass
 */
@WebServlet("/ServerClass")
public class ServerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//con=Db.getCon();
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		System.out.println(Password);
	
			//Statement st=Db.getCon().createStatement();
		//ResultSet rs=st.executeQuery("Select * from Register1");
		//while(rs.next())
		//{
			//System.out.println(rs.getString(1));
			//if(rs.getString(1)==Username) {
			//System.out.println(Username + Password);
			try {
			String s="INSERT INTO Register1 VALUES (?,?)";
			PreparedStatement stmt=Db.getCon().prepareStatement(s);
			stmt.setString(1, Username);
			stmt.setString(2, Password);
			stmt.executeUpdate();
			//System.out.println("kbsdnjs");
			RequestDispatcher rd= request.getRequestDispatcher("OptionsMain.html");
			rd.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//response.addHeader("REFRESH","1: URL=NewPlayer.html");  
		
	
			//else
			//{
			//	throw new InvalidUser("User does not exist");
			//}
		//catch(InvalidUser e){
		//	System.out.println("Exception" + e);
		//}
		
		//doGet(request, response);
		
		
	
	}

}
