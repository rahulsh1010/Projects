package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.exceptions.InvalidCourt;
import com.exceptions.InvalidSeed;
import com.logic.GrandSlam;

/**
 * Servlet implementation class DeleteCourt
 */
@WebServlet("/DeleteCourt")
public class DeleteCourt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourt() {
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
	 */static final Logger LOGGER = Logger.getLogger(DeleteCourt.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter(); 
		 int num=Integer.parseInt(request.getParameter("Number"));   
	     try {
			GrandSlam.deleteCourt(num);
			LOGGER.info("Court Deleted");
			response.sendRedirect("DeleteCourtResult.html");
			
		}  
	     //out.close();		//doGet(request, response);
 catch (InvalidCourt e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Court");
			LOGGER.info("Invalid Court was entered");
			response.sendRedirect("InvalidCourt.html");
		}
	}
	

}
