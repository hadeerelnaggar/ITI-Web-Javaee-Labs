<%-- 
    Document   : index
    Created on : Mar 14, 2021, 9:25:40 PM
    Author     : Hadeer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body onload= "setInterval('startRequest()' ,5000)">
        <h1>Hello World!</h1>
        <section class="readFileForm">
            <form class="form-inline">
                <input type="button"  class="btn btn-default" value="submit" onClick="getFileData()"/>
                <input type="text" class="form-control" id="textField"/>
            </form>
        </section>
        <section class="login">
            <form>
                <div class="form-group">
                    <label for="name">UserName:</label>
                    <input type="name" class="form-control" id="name" name="name" onblur="validateUserName()">
                    <span id="validateName"></span>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </section>
        <section id="timeTable">
            
        </section>
        <script src="script.js"></script>
    </body>
</html>
