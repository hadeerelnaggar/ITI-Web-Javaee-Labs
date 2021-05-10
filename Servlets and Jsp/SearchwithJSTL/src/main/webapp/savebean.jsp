<jsp:useBean id = "myBean" scope="request" class="iti.gov.hadeer.UserBean"/>
<jsp:setProperty name="myBean" property="*"/>

<jsp:forward page="showdata.jsp"/>