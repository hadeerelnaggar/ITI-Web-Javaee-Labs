package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;


public class SendRedirect extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(request.getParameter("error")!=null){
			out.println("Login Failed, please try again");
		}
		out.println("<FORM method= POST>"); 
		out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</body>");
		out.println("</html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(userName.equals("hadeer") && password.equals("123")){
			response.sendRedirect("welcome?userName=" + userName + "&password=" + password);
		}
		else { 
			out.println("Login Failed, please try again"); 
			response.sendRedirect("/lab2/sendredirect?error=true");
		}
	}

}