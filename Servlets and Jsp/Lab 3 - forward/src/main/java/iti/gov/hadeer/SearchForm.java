package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;


public class SearchForm extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\" style=\"font-size: 30px\">");
		out.println("<h1>Search Form</h1>");
		out.println("<h6>Please enter Firstname,lastname or part of any</h6>");
		out.println("<FORM method= POST>"); 
		out.println("<b>Name:</b> <INPUT TYPE=TEXT NAME=name>");
		out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}

}