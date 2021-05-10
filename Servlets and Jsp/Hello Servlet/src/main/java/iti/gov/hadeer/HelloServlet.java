package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;

public class HelloServlet implements Servlet{
	ServletConfig config;
	public void init(ServletConfig config) throws ServletException{
		System.out.println("I am inside inti fun");
		this.config = config;
	
	}
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		String databaseAddress = config.getInitParameter("DatabaseAddress");
		PrintWriter out = response.getWriter();
		out.println("Database Address is:"+databaseAddress);
		String userName = config.getInitParameter("username");
		out.println("Username is:"+userName);
		String password = config.getInitParameter("password");
		out.println("Password is:"+password);
	}
	
	public void destroy(){
		System.out.println("destroy");
	}	
	
	public String getServletInfo(){
		return null;
	}
	
	public ServletConfig getServletConfig(){
		return null;
	}

}