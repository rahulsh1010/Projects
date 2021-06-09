package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.logic.GrandSlam;
import com.model.Player;

import java.util.List;

/**
 * Servlet implementation class ShowPlayerList
 */
@WebServlet("/ShowPlayerList")
public class ShowPlayerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPlayerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */static final Logger LOGGER = Logger.getLogger(ShowPlayerList.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
		List<Player> l=GrandSlam.getAllPlayers();
		LOGGER.info("Display Player Command Activated");
		//out.print("Player List");
		 out.println("<html>");
	        out.println("<head><title>Player List</title> </head>");
	      //  out.print("<no-repeat>");
	        out.println("<body background=https://wallpapercave.com/wp/wp7274396.jpg >");
	        out.print("<center>");
	        out.print("<h2>Player List</h2>");
		  out.print("<table border='1' width='100%'");  
		  out.print("<tr><th>Seed</th><th>Name</th><th>Age</th><th>Tournaments Played</th><th>Nationality</th><th>Strength</th></tr>"); 
		for(Player p : l) {
			out.print("<tr><td>"+p.getSeed()+"</td><td>"+p.getName()+"</td><td>"+p.getAge()+"</td><td>"+p.getNoOfTournaments()+"</td><td>"+p.getNationality()+"</td><td>"+p.getStrength());
		}
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
