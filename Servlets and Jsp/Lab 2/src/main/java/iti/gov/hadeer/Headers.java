package iti.gov.hadeer;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;


public class Headers extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			PrintWriter out = response.getWriter();
			String headerName = headers.nextElement(); 
			String value = request.getHeader(headerName);
			out.println(headerName+":"+value);
		}
	}

}