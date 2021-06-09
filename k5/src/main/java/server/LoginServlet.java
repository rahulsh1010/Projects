package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import connection.Db;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		try {
		Statement st=Db.getCon().createStatement();
		ResultSet rs=st.executeQuery("Select * from Register");
		while(rs.next()) {
			if(rs.getString(1).equalsIgnoreCase(Username) && rs.getString(2).equalsIgnoreCase(Password)){
				flag=true;
				RequestDispatcher rd = request.getRequestDispatcher("OptionsMain.html");
				rd.forward(request, response);
				LOGGER.info("Login Successful");
			}
			
		}
		if(flag==false) {LOGGER.warn("Check Credential");
		response.sendRedirect("New.html");
		}
		}
		catch(Exception e) {
			LOGGER.warn("Check Credential");
	//	RequestDispatcher rd = request.getRequestDispatcher("New.html");
	//		rd.forward(request, response);
			response.sendRedirect("New.html");
			e.printStackTrace();
		}
	//	doGet(request, response);
	}

}
