<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
    <body align="center" marginwidth="auto">
        <h1>Chatting room</h1>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col">
                    <img src="Chat-Rooms.png">
                </div>
                <div class="col-sm">
                    <form action="ChatRoom.jsp" method="POST" style=" margin-top: 100px;" align="center">
                        <div class="mb-3" style="max-width: 300px; margin: auto;" >
                            <input type="text" class="form-control" name="name" id="name" placeholder="Enter your Name">
                        </div>
                        <div class="row g-3" style="max-width: 150px; margin: auto; margin-bottom: 10px;" align="center">
                            <div class="form-check col-auto">
                                <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                                <label class="form-check-label" for="male">
                                    Male
                                </label>
                            </div>
                            <div class="form-check col-auto">
                                <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                                <label class="form-check-label" for="female">
                                    Female
                                </label>
                            </div>
                        </div>
                        <input class="btn btn-primary" type="submit" onsubmit="login(event)" value="Let's start">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>



    </body>
</html>