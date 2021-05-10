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



public class SendRedirect extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		RequestDispatcher rd = request.getRequestDispatcher("login");
		rd.include(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Context initContext= new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();    
            PreparedStatement preparedStatement = conn.prepareStatement("select * from emp where username = ? and password = ?");
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
				response.sendRedirect("welcome?userName=" + userName + "&password=" + password);
			}
			else { 
				out.println("<html>");
				out.println("<body>");
				out.println("<h3 style=\"color: red\">Login Failed, please try again</h3>"); 
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.include(request, response);
			}
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
	
		
		
		
	}

}