/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    count = 0;
    setInterval(function () {
        $.ajax({
            url: 'sendMessage?count='+count,
            type: 'GET',
            contentType: 'application/json',
            data: count,
            dataType: 'json',
            success: function (data) {
                console.log(data);
                messages = JSON.parse(JSON.stringify(data));
                count = count + messages.length;
                for (var i = 0; i < messages.length; i++) {
                    $('#messages').append("<div class=\"well well-sm\" style=\"margin: 10px; border-radius: 10px;\" >" +
                            "<h3>" + messages[i].name + "</h3>" +
                            "<span>" + messages[i].message + "</span>" +
                            "</div>")
                }
            }
        });
    }, 5000);
    console.log("kkk");
    $('#sendMessage').click(function () {
        console.log("hiiii");
        var name = $('#name').val();
        var message = $('#message').val();
        var jsonData = {"name": name, "message": message};
        $.ajax({
            url: 'sendMessage',
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            data: jsonData,
            dataType: 'json',
            success: function () {
                $('#confirm').html("Message Sent");
            }
        });
    });

});

