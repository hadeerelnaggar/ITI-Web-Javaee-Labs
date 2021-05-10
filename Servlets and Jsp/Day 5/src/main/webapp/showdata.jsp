<%@ page import="iti.gov.hadeer.UserBean" %>
<html>
	<head></head>
	<jsp:useBean id = "myBean" scope="request" class="iti.gov.hadeer.UserBean"/>
	<body>
		<h2>
			Hello, <jsp:getProperty name="myBean" property="userName"/>
		</h2>
		<p> 
			Your last Name is: <jsp:getProperty name="myBean" property="lastName"/>
		</p>
	</body>
</html>