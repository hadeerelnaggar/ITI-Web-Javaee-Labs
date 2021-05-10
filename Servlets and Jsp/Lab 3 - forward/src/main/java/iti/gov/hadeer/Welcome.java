package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;


public class Welcome extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		if(userName!=null){
			out.println("userName is:"+userName);
		}
		if(password!=null){
			out.println("password is:"+password);
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		if(userName!=null){
			out.println("userName is:"+userName);
		}
		if(password!=null){
			out.println("password is:"+password);
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}