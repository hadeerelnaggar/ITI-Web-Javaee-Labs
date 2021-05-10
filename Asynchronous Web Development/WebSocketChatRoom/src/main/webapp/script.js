webSocket = null;
$(document).ready(function () {
    console.log("helooo")
    webSocket = new WebSocket("ws://localhost:1919/WebSocketChatRoom_war_exploded/chat?name=" + $('#name').val() + "&gender=" + $('#gender').val());
    webSocket.onmessage = function (evt) {

        var data = JSON.parse(evt.data);
        console.log(data)
        if (!Array.isArray(data)) {
            var source = "boy.png";
            source = data.sender.gender === "male" ? "boy.png" : "girl.png";
            $('#messages').append("" +
                "<div class=\"well well-sm inline\">\n" +
                "<img width='100px' height='100px' src=\"" + source + "\"/>" +
                "<h3>" + data.sender.name + "</h3>\n" +
                " <p>" + data.message + "</p>\n" +
                " </div>")
        } else {
            for (var i = 0; i < data.length; i++) {
                //message sent
                if (data[i].sender != null) {
                    var source = "boy.png";
                    source = data[i].sender.gender === "male" ? "boy.png" : "girl.png";
                    $('#messages').append("" +
                        "<div class=\"well well-sm\">\n" +
                        "<img width='100px' height='100px' src=\"" + source + "\"/>" +
                        "<h3>" + data[i].sender.name + "</h3>\n" +
                        " <p>" + data[i].message + "</p>\n" +
                        " </div>")
                }
                //users sent
                else {
                    var source = "boy.png";
                    source = data[i].gender === "male" ? "boy.png" : "girl.png";
                    if (i === 0) {
                        $('#onlineUsers').html("" +
                            "<div class=\"well well-sm inline\">\n" +
                            "<img width='100px' height='100px' src=\"" + source + "\"/>" +
                            "<h3>" + data[i].name + "</h3>\n" +
                            " </div>")
                    } else {

                        $('#onlineUsers').append("" +
                            "<div class=\"well well-sm inline\">\n" +
                            "<img width='100px' height='100px' src=\"" + source + "\"/>" +
                            "<h3>" + data[i].name + "</h3>\n" +
                            " </div>")
                    }
                }
            }
        }
    }
})

function sendmessage(e) {
    e.preventDefault();
    message = $('#message').val();
    webSocket.send(message);
}

function logout() {
    webSocket.close();
}