package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.exceptions.InvalidSeed;
import com.logic.GrandSlam;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
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
	 */static final Logger LOGGER = Logger.getLogger(DeletePlayer.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		 int seed=Integer.parseInt(request.getParameter("Seed"));   
	     try {
			GrandSlam.deletePlayer(seed);
			LOGGER.info("Player Deleted");
			response.sendRedirect("DeleteResult.html");
			
		} 
		 catch (InvalidSeed e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid Seed");
				LOGGER.info("Invalid seed was entered");
				response.sendRedirect("InvalidSeed.html");
		 }
	    
	   //  catch (InvalidSeed e) {
			// TODO Auto-generated catch block
			//System.out.println("Exception occured"+ e);
	//	}  
	     //out.close();		//doGet(request, response);
	}

}
