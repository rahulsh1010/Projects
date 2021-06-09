package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import connection.Db;

/**
 * Servlet implementation class EditPlayer
 */
@WebServlet("/EditPlayer")
public class EditPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlayer() {
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
	 */static final Logger LOGGER = Logger.getLogger(EditPlayer.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        String sid=request.getParameter("Seed");  
	        Integer seed=Integer.parseInt(sid);  
	      
	        try {
	        	 //PreparedStatement ps=Db.getCon().prepareStatement("select * from Player where Seed=?");  
				 //ps.setInt(1,seed);
				 //ResultSet rs=ps.executeQuery();  
				 //i++;
				// if(rs.next()) {
					 String name=request.getParameter("Name");  
					 String d=request.getParameter("Age");
				        Integer age=Integer.parseInt(d); 
				        String s=request.getParameter("Number of Tournaments Played");
				        Integer tournaments=Integer.parseInt(s);  
				        String nationality=request.getParameter("Nationality");
				      //  String strength=request.getParameter("Strength");
				        Player p=new Player();
				        p.setName(name);
				        p.setAge(age);
				        p.setSeed(seed);
				        p.setNoOfTournaments(tournaments);
				        p.setNationality(nationality);
				        //p.setStrength(strength)
				        GrandSlam.updatePlayer(p);
				        LOGGER.info("Player Updated");
				        RequestDispatcher rd = request.getRequestDispatcher("ShowPlayerList");
				        rd.forward(request,response);
				 }
				// else
				//	 throw new InvalidSeed("Invalid seed");
	        	
	   catch(InvalidSeed e) {
       	System.out.println("Invalid Seed");
        LOGGER.info("Invalid seed was entered");
			response.sendRedirect("InvalidSeed.html");
       }
	   
	       /* String name=request.getParameter("name");  
	        int age=Integer.parseInt(request.getParameter("age"));  
	        int tournaments=Integer.parseInt(request.getParameter("Tournaments Played"));  
	        String nationality=request.getParameter("nationality");
	       // String strength=request.getParameter("strength");
	        
	        Player p=new Player();
	        p.setName(name);
	        p.setAge(age);
	        p.setSeed(seed);
	        p.setNoOfTournaments(tournaments);
	        p.setNationality(nationality);
	       // p.setStrength(strength);
	       
	        GrandSlam.updatePlayer(p);*/
		doGet(request, response);
	}

}
