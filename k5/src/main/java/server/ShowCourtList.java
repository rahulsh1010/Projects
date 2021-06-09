package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.logic.GrandSlam;
import com.model.Court;
import com.model.Player;

/**
 * Servlet implementation class ShowCourtList
 */
@WebServlet("/ShowCourtList")
public class ShowCourtList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourtList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */static final Logger LOGGER = Logger.getLogger(ShowCourtList.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
		List<Court> l=GrandSlam.showCourts();
		LOGGER.info("Display Court Command Activated");
		//out.print("Player List");
		 out.println("<html>");
	        out.println("<head><title>Player List</title> </head>");
	      //  out.print("<no-repeat>");
	        out.println("<body background=https://wallpapercave.com/wp/wp7274396.jpg>");
	        out.print("<center>");
	        out.print("<h2>Court List</h2>");
		  out.print("<table border='1' width='100%'");  
		  out.print("<tr><th>Number</th><th>Name</th><th>Type</th><th>Capacity</th></tr>"); 
		for(Court p : l) {
			out.print("<tr><td>"+p.getNumber()+"</td><td>"+p.getName()+"</td><td>"+p.getType()+"</td><td>"+p.getCapacity());
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
