<%--
  Created by IntelliJ IDEA.
  User: Hadeer
  Date: 15-Mar-21
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body align="center">
    <h1>Chat room</h1>
    <h2><%= request.getParameter("name")%></h2>
    <h3><%= request.getParameter("gender")%></h3>
    <div class="panel panel-default" style="margin: 30px;">
        <div class="panel-heading" style="background-color: lightblue;
        padding: 1px;">

            <h2>Recent Chat History</h2>
        </div>
        <div align="left">
            <div class="panel-body" id="messages">

            </div>
        </div>
        <form>
            <input type="text" name="message" id="message"/>
            <input type="button"  value="send message" onclick="sendmessage(event)"/>
            <input type="hidden" value="<%= request.getParameter("name")%>" name="name" id="name"/>
            <input type="hidden" value="<%= request.getParameter("gender")%>" name="gender" id="gender"/>
        </form>
    </div>
    <div class="panel panel-default" style="margin: 30px;">
        <div class="panel-heading" style="background-color: lightblue;
        padding: 1px;">
            <h2>Online users</h2>
            <a value="logout" onclick="logout()" href="./">LogOut</a>
        </div>
        <div align="left">
            <div class="panel-body" id="onlineUsers">

            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="script.js"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>

</body>
</html>
