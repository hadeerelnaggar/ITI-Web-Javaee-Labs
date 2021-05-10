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


public class Welcome extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session == null)
			response.sendRedirect("login");
		else
		{
			String userName= (String) session.getAttribute("username");
			out.println("<h1>Welcome,"+userName+"</h1>");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		doGet(request,response);
		
	}
}