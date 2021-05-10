var eventSource=null;
var worker = null;
$(document).ready(function () {
    console.log("hellooo");
    //eventSource = new EventSource("chatServlet?name=" + $('#name').val() + "&gender=" + $('#gender').val());
    if(typeof (worker)!=="undefined"){
        worker = new Worker("worker.js");
        var thisUser = {"name": $('#name').val(),"gender": $('#gender').val()};
        worker.postMessage(thisUser);
        worker.onmessage = function (event){
            if(event.data.name === 'messageReceived')
                $('#messages').append(event.data.html);
            else if(event.data.name === 'userLoggedIn'){
                $('#onlineUsers').append(event.data.html);
            }
            else if(event.data.name === 'allMessages'){
                $('#messages').append(event.data.html);
            }
            else if(event.data.name === 'allUsersFirst'){
                $('#onlineUsers').html(event.data.html);

            }
            else if(event.data.name === 'allUsers'){
                $('#onlineUsers').append(event.data.html);

            }

        }
    }
})



function sendMessage(e) {
    e.preventDefault();
    console.log("sending message....");
    var message = $('#message').val();
    console.log(message);
    var msgObj = {"message": message, "senderName": $('#name').val(), "senderGender": $('#gender').val()};
    $.ajax({
        url: 'chatServlet',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: msgObj,
        dataType: 'json'
    });
}

function logout() {
    console.log("logging out");
    var msgObj = {"message": "CLOSECONNECTION", "senderName": $('#name').val(), "senderGender": $('#gender').val()};
    $.ajax({
        url: 'chatServlet',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: msgObj,
        dataType: 'json'
    });
    eventSource.close();

}