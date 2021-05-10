users = [];
users = JSON.parse(localStorage.getItem("contacts"));
if (users == null) {
    users = new Array();
}

$("#save").click(function () {
    if (typeof (Storage) !== "undefined") {
        // Store
        var Uname = $("username").val();
        var Uname = document.getElementById("username").value;
        var Uphone = document.getElementById("telephone").value;
        var Uemail = document.getElementById("email").value;
        var Ugender = document.getElementById("gender").value;
        var user = { "Username": Uname, "telephone": Uphone, "email": Uemail, "gender": Ugender };
        users.push(user);
        localStorage.setItem("contacts", JSON.stringify(users))
        location.href = "#contactList"
        location.reload();
    }
});

for (var i = 0; i < users.length; i++) {
    addContactItem(users[i].Username, users[i].telephone);
}

function addContactItem(name, number) {
    $("#contactsList").html($("#contactsList").html() + "<li>" +
        "<a href=\"#\">" +
        "<img src=\"https://i.pinimg.com/564x/3d/fd/d3/3dfdd3cce72f6d62c17d4fa2c595d6c9.jpg\">" +
        "<h2>" + name + "</h2>"
        + "<p>" + number + "</p>" +
        "</a>" +
        "<a href=\"tel:" + number + "\" class=\"ui-shadow ui-btn ui-corner-all ui-btn-inline\" data-transition=\"pop\"></a>" +
        "</li>");
}

$('#contactsList li').click(function () {
    index = $(this).index();
    location.href = "#profile";
    getUserProfile(index)
});

function getUserProfile(index){
    var currentUser = users[index];
    console.log(index)
    $("#userName").html(currentUser.Username);
    $("#phoneNumber").on("click",()=>{
        location.href = "tel:"+currentUser.telephone;
    })
    $("#deleteBtn").on("click",()=>{
        location.href = "#deleteContact";
    });
    $("#yes").on("click",()=>{
        for (var i = 0; i < users.length; i++) {
            if (users[i].telephone == currentUser.telephone) {
                users.splice(i, 1);
            }
        }
        localStorage.setItem("contacts", JSON.stringify(users))
        location.href = "#contactList"
        location.reload();
    }); 
}


