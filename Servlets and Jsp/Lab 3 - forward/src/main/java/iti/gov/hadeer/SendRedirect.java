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
		if(!userName.equals("") && !password.equals("")){
			System.out.println("not null");
			//response.sendRedirect("welcome?userName=" + userName + "&password=" + password);
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			request.setAttribute("userName",userName);
			request.setAttribute("password",password);
			rd.forward(request, response);
		}
		else { 
			System.out.println("null");
			out.println("<html>");
			out.println("<body>");
			out.println("<h3 style=\"color: red\">Login Failed, please try again</h3>"); 
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.include(request, response);
		}
	}

}