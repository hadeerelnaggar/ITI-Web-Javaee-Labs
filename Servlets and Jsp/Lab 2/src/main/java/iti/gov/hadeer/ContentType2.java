package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;

public class ContentType2 implements Servlet{
	ServletConfig config;
	public void init(ServletConfig config) throws ServletException{
		System.out.println("I am inside inti fun");
		this.config = config;
	
	}
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		response.setContentType("application/msword");
		PrintWriter out = response.getWriter();
		out.println("Hellooooooo");
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