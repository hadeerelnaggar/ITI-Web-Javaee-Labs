package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;

public class ServletContextLab implements Servlet{
	ServletConfig config;
	public void init(ServletConfig config) throws ServletException{
		System.out.println("I am inside inti fun");
		this.config = config;
	
	}
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		ServletContext servletContext = config.getServletContext();
		String username = (String)servletContext.getAttribute("username");
		String myPassword = (String)servletContext.getAttribute("MyPassword");
		out.println("My username is:"+username);
		out.println("My password is:"+myPassword);
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