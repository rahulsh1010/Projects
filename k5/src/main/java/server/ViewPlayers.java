package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.GrandSlam;
import com.model.Player;

import connection.Db;

/**
 * Servlet implementation class ViewPlayers
 */
@WebServlet("/ViewPlayers")
public class ViewPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlayers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter(); 
	      int seed=Integer.parseInt(request.getParameter("Seed"));
					 Player p=GrandSlam.getPlayer(seed);
					    out.print("Player");
						  out.print("<table border='1' width='100%'");  
						  out.print("<tr><th>Seed</th><th>Name</th><th>Age</th><th>Tournaments Played</th><th>Nationality</th><th>Strength</th></tr>");
						  out.print("<tr><td>"+p.getSeed()+"</td><td>"+p.getName()+"</td><td>"+p.getAge()+"</td><td>"+p.getNoOfTournaments()+"</td><td>"+p.getNationality()+"</td><td>"+p.getStrength());
	        out.close();       
	        
	    
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
