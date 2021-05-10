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
import java.util.ArrayList;


public class Welcome extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
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
			ArrayList<Employee> emps = new ArrayList<>();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setFirstName(rs.getString("firstname"));
				emp.setLastName(rs.getString("lastname"));
				emp.setUserName(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emps.add(emp);
			}
			request.setAttribute("result",emps);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
		
	}
}