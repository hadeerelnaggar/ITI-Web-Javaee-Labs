<%-- 
    Document   : index
    Created on : Mar 15, 2021, 12:13:11 AM
    Author     : Hadeer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="script.js"></script>

    </head>
    <body>
        <form class="form-inline" action="">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="message">Message</label>
                <input type="text" class="form-control" id="message">
            </div>
            <button type="button" class="btn btn-default" id="sendMessage">Submit</button>
        </form>
        <label id="confirm"></label>
        <div id="messages"></div>
        <div class="well well-sm" style="margin: 10px; border-radius: 10px;" >
            <h3>Hadeer</h3>
            <span>Message</span>
        </div>
    </body>
</html>
