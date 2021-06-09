package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import connection.Db;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
	 */static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		response.setContentType("text/html");
		PrintWriter obj = response.getWriter();
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		try
		{
		PreparedStatement ps=Db.getCon().prepareStatement("INSERT INTO Register VALUES (?,?,?,?)"); 
		ps.setString(1, Username);
		ps.setString(2, Password);
		ps.setString(3, Name);
		ps.setString(4, Email);
		ps.executeUpdate();
		flag=true;
		RequestDispatcher rd = request.getRequestDispatcher("New.html");
		rd.forward(request, response);
		doGet(request, response);
		
	}catch(Exception e) {
		
		e.printStackTrace();
	}
		if(flag==false) {
			LOGGER.warn("Check Credential");
			response.sendRedirect("Registration.html");
		}

}
}