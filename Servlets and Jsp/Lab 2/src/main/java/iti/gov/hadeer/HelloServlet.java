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
		PrintWriter out = response.getWriter();
		ServletContext servletContext = config.getServletContext();
		String str = servletContext.getInitParameter("country");
		out.println("My country is:"+str);
		servletContext.setAttribute("username","hadeer");
		servletContext.setAttribute("MyPassword","iti");
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