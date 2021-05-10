<%@ page import="java.util.ArrayList,iti.gov.hadeer.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:if test="${result!=null}">
				<c:set var="emps" value="${result}"/>
				<c:if test="${emps.size()==0}">
					<p style="color: red">No names available</p>
				</c:if>
				<c:if test="${emps.size()!=0}">
					<table>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>UserName</th>
						<th>Password</th>
					</tr>
						<c:forEach items="${emps}" var="emp">
							<tr>
								<td>${emp.firstName}</td>
								<td>${emp.lastName}</td>
								<td>${emp.userName}</td>
								<td>${emp.password}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</c:if>
		</div>
		
	</body>
</html>