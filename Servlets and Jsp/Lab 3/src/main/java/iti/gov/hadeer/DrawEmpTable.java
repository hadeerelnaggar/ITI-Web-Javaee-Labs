package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.sql.SQLException;


public class DrawEmpTable extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<table align=\"center\" style=\"width: 100%; font-size: 30px\" cellspacing=\"20\" text-align=\"center\">");
		out.println("<tr>");
		out.println("<th>");
		out.println("FirstName");
		out.println("</th>");
		out.println("<th>");
		out.println("LastName");
		out.println("</th>");
		out.println("<th>");
		out.println("UserName");
		out.println("</th>");
		out.println("<th>");
		out.println("Password");
		out.println("</th>");
		out.println("</tr>");
		try{
			ResultSet rs = (ResultSet) request.getAttribute("emps");
			do{
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getString("firstname"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("lastname"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("username"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("password"));
				out.println("</td>");
				out.println("</tr>");
			}while(rs.next());
			out.println("</table>");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}

}