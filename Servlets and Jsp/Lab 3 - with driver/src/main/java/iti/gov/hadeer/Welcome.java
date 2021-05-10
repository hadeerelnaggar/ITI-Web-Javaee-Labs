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


public class Welcome extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("searchform");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("searchform");
		rd.include(request, response);
		String name = request.getParameter("name");
		try {
			Context initContext= new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();    
            PreparedStatement preparedStatement = conn.prepareStatement("select * from emp where firstName LIKE ? or lastName LIKE ?");
			preparedStatement.setString(1,"%"+name+"%");
			preparedStatement.setString(2,"%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()){
				out.println("<h3 align=\"center\" style=\"color: red\">No name found</h3>");
			}
			else{
				request.setAttribute("emps",rs);
				RequestDispatcher dd = request.getRequestDispatcher("drawemptable");
				dd.include(request, response);
			}
		} catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
		
		out.println("</body>");
		out.println("</html>");
	}
}