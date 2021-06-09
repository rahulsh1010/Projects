package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.exceptions.InvalidCourt;
import com.exceptions.InvalidSeed;
import com.logic.GrandSlam;
import com.model.Court;
import com.model.Player;

import connection.Db;

/**
 * Servlet implementation class UpdateCourt
 */
@WebServlet("/UpdateCourt")
public class UpdateCourt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */static final Logger LOGGER = Logger.getLogger(UpdateCourt.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String number=request.getParameter("Number");  
        Integer num=Integer.parseInt(number);  
        
        try {
       //	 PreparedStatement ps=Db.getCon().prepareStatement("select * from Court where number=?");  
		//	 ps.setInt(1,num);
		//	 ResultSet rs=ps.executeQuery();  
		//	 if(rs.next()) {
				 String name=request.getParameter("Name");  
				 String type=request.getParameter("Type");
			      //  Integer age=Integer.parseInt(d); 
			        String s=request.getParameter("Capacity");
			        Integer capacity=Integer.parseInt(s);  
			       // String nationality=request.getParameter("Nationality");
			      //  String strength=request.getParameter("Strength");
			    Court c=new Court();
			    c.setNumber(num);
			    c.setName(name);
			    c.setType(type);
			    c.setCapacity(capacity);
			        //p.setName(name);
			      //  p.setAge(age);
			        //p.setSeed(seed);
			        //p.setNoOfTournaments(tournaments);
			        //p.setNationality(nationality);
			        //p.setStrength(strength)
			        GrandSlam.updateCourt(c);
			        LOGGER.info("Court Updated");
			        RequestDispatcher rd = request.getRequestDispatcher("ShowCourtList");
			        rd.forward(request,response);
			// }
			// else
			//	 LOGGER.info("Error in court Updation");
			//	 throw new InvalidCourt("Invalid Number");
       	
       }
       catch(InvalidCourt e) {
    	   System.out.println("Invalid Court");
    	   LOGGER.info("Invalid court was entered");
			response.sendRedirect("InvalidCourt.html");
       }
      // catch(Exception e){
       	//e.printStackTrace();
       //}
		doGet(request, response);
	}

}
