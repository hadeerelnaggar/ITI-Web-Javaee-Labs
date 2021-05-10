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



public class SqlTool extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("queryform");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("queryform");
		rd.include(request, response);
		String sql = request.getParameter("sql");
		try{
			Context initContext= new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();    
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if(sql.substring(0,6).toLowerCase().equals("select")){
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()){
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				out.println("<table>");
				out.println("<tr>");
				for(int i=1;i<=columnCount;i++){
					String name = rsmd.getColumnName(i);
					out.println("<th>");
					out.println(name);
					out.println("</th>");
				}
				do{
					out.println("<tr>");
					for(int i=1;i<=columnCount;i++){
					out.println("<td>");
					out.println(rs.getString(rsmd.getColumnName(i)));
					out.println("</td>");
					}
					out.println("</tr>");
				}while(rs.next());
				out.println("</tr>");
				out.println("</table>");
				}
				else{
					out.println("<p style=\"color: red\"> no result found</p>");
				}
			}
			else{
				int rowAffected = preparedStatement.executeUpdate();
				out.println("<p>"+rowAffected+" row(s) affected</p>");
			}
		}catch(SQLException | NamingException e){
			out.println("<p style=\"color: red\">"+e.getMessage()+"</p>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}