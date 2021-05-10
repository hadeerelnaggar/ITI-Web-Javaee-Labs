<%@ page import="java.util.ArrayList,iti.gov.hadeer.Employee" %>
<html>
	<head></head>
	<body>
		<div align="center" style="font-size: 30px">
			<h1>Search form</h1>
			<h6>Please enter Firstname,lastname or part of any</h6>
			<form action="welcome" method="POST">
				<b>Name:</b> <INPUT TYPE=TEXT NAME="name">
				<INPUT TYPE=SUBMIT VALUE="Submit">
			</form>
			<% 
			ArrayList<Employee> emps = (ArrayList<Employee>)request.getAttribute("result");
				if(emps!=null){
					if(emps.size()==0){
						%>
						<p style="color: red">No names available</p>
						<%
					}
					else{
						%>
						<table align="center" style="width: 100%; font-size: 30px" cellspacing="20" text-align="center">
						<tr>
							<th>FirstName</th>
							<th>LastName</th>
							<th>UserName</th>
							<th>Password</th>
						</tr>
						<%
						for(int i=0;i<emps.size();i++){
							%>
							<tr>
								<td><%= emps.get(i).getFirstName()%></td>
								<td><%= emps.get(i).getLastName()%></td>
								<td><%= emps.get(i).getUserName()%></td>
								<td><%= emps.get(i).getPassword()%></td>
							</tr>
							<%
						}
						%>
						</table>
						<%
					}
				}
			%>
		</div>
		
	</body>
</html>