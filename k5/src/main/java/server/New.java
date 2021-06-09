 package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.GrandSlam;
import com.model.Player;

import connection.Db;

/**
 * Servlet implementation class New
 */
@WebServlet("/New")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	// TODO Auto-generated method stub
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
		List<Player> l=GrandSlam.getAllPlayers();
		 out.println("<html>");
	        out.println("<head><title>Player List</title> </head>");
	      //  out.print("<no-repeat>");
	        out.println("<body background=https://www.svgeurope.org/wp-content/blogs.dir/17/files/2018/08/Tennis-generic-clay.jpg><background-repeat:no-repeat>");
	        out.print("<center>");
	        out.print("<h2>Player List</h2>");
		
		  out.print("<table border='1' width='100%'");  
		  out.print("<tr><th>Seed</th><th>Name</th><th>Age</th><th>Tournaments Played</th><th>Nationality</th><th>Strength</th></tr>"); 
		for(Player p : l) {
			out.print("<tr><td>"+p.getSeed()+"</td><td>"+p.getName()+"</td><td>"+p.getAge()+"</td><td>"+p.getNoOfTournaments()+"</td><td>"+p.getNationality()+"</td><td>"+p.getStrength());
		}
		out.close();
	/*	//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		System.out.println(Username + Password);
		//System.out.println(Password);
		try {
			/*String s="INSERT INTO Register VALUES (?,?)";
			PreparedStatement stmt=Db.getCon().prepareStatement(s);
			stmt.setString(1, Username);
			stmt.setString(2, Password);
			stmt.executeUpdate();
			//System.out.println("kbsdnjs");
			RequestDispatcher rd= request.getRequestDispatcher("OptionsMain.html");
			rd.forward(request, response);
			//return;
			}
			catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("User already exists");
				RequestDispatcher rd= request.getRequestDispatcher("OptionsMain.html");
				rd.forward(request, response);
			 */
		
		
		}
			
			
		catch(Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
