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

import com.exceptions.InvalidCourt;
import com.logic.GrandSlam;
import com.model.Court;

/**
 * Servlet implementation class AddCourt
 */
@WebServlet("/AddCourt")
public class AddCourt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */static final Logger LOGGER = Logger.getLogger(AddCourt.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		
		String number=request.getParameter("Number");
		int num=Integer.parseInt(number);
		String name=request.getParameter("Name");
		String type=request.getParameter("Type");
		String cap=request.getParameter("Capacity");
		int capacity=Integer.parseInt(cap);
		
		Court c=new Court(num,name,type,capacity);
		
			GrandSlam.addCourt(c);
			LOGGER.info("Court Added");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCourtList");
			rd.forward(request,response);
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
