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
	Connection conn;
	public void init(ServletConfig config) throws ServletException{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/schema";
		try{
			conn = DriverManager.getConnection(url,"root","123");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
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
            PreparedStatement preparedStatement = conn.prepareStatement("select * from emp where username = ? and password = ?");
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
				response.sendRedirect("welcome");
			}
			else { 
				out.println("<html>");
				out.println("<body>");
				out.println("<h3 style=\"color: red\">Login Failed, please try again</h3>"); 
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.include(request, response);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
		
		
		
	}

}