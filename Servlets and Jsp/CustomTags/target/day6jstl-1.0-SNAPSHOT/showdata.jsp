<%@ page import="iti.gov.hadeer.UserBean" %>
<html>
	<head></head>
	<body>
	<% UserBean user = (UserBean)request.getAttribute("myBean"); %>
		<h2>
			Hello, <%= user.getUserName() %>
		</h2>
		<p> your last Name is: <%= user.getLastName()%> </p>
	</body>
</html>