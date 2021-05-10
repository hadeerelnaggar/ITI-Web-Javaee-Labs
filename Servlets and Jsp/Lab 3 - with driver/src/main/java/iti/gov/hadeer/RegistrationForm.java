package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.*;
import javax.sql.DataSource;

public class RegistrationForm extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\" style=\"font-size: 30px\">");
		out.println("<h1>Registration Form</h1>");
		out.println("<h6>Please enter the user details</h6>");
		out.println("<FORM method= POST>"); 
		out.println("<BR> FirstName: <INPUT TYPE=TEXT NAME=firstName>");
		out.println("<BR> Lastname: <INPUT TYPE=TEXT NAME=lastName>");
		out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
		out.println("<BR> <INPUT TYPE=RESET VALUE=Reset>");
		out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			Context initContext= new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();    
            PreparedStatement preparedStatement = conn.prepareStatement("insert into emp values(?,?,?,?)");
			preparedStatement.setString(1,firstName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,userName);
			preparedStatement.setString(4,password);
            preparedStatement.executeUpdate();
			preparedStatement.close();
			response.sendRedirect("login");
		} catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
		
	}

}