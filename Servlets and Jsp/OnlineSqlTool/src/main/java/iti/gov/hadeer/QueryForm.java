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



public class QueryForm extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>SQL Tool</h1>");
		out.println("<p>Please type your SQL statement in the following box</p>");
		out.println("<FORM method= POST id=\"sqlForm\">"); 
		out.println("<textarea form=\"sqlForm\" name=\"sql\" rows=\"7\" cols=\"50\" style=\"margin: 10px\"></textarea>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Execute>");
		out.println("</FORM>");
		
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	
		
		
		
	}

}