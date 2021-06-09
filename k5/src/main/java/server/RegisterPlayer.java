package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.exceptions.InvalidSeed;
import com.logic.GrandSlam;
import com.model.Player;

import k5.TestLog4jServlet;

/**
 * Servlet implementation class RegisterPlayer
 */
@WebServlet("/RegisterPlayer")
public class RegisterPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPlayer() {
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
	 */static final Logger LOGGER = Logger.getLogger(RegisterPlayer.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
	try {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		String name=request.getParameter("Name");  
		String age1=request.getParameter("Age");
		int age=Integer.parseInt(age1); 
		String seed1=request.getParameter("Seed");
		int seed=Integer.parseInt(seed1); 
		String t=request.getParameter("Number of Tournaments Played");
		int tournaments=Integer.parseInt(t);  
		String nationality =request.getParameter("Nationality");
		String strength=request.getParameter("Strength");
		
		Player p=new Player(name,age,seed,tournaments,nationality,strength);
		
			GrandSlam.addPlayer(p);
		LOGGER.info("Player Saved");
		RequestDispatcher rd = request.getRequestDispatcher("ShowPlayerList");
		rd.forward(request,response);
		out.close();
		}
	 catch (InvalidSeed e) {
			System.out.println("Invalid Seed");
	        LOGGER.info("Invalid seed was entered");
				response.sendRedirect("InvalidSeed.html");
		}
		//doGet(request, response);
	  

}
}
