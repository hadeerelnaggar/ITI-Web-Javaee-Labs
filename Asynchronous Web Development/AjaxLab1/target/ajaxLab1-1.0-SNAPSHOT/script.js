/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getFileData() {
    var textField = document.getElementById("textField");
    if (window.XMLHttpRequest)
    {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    request.onreadystatechange = function () {
        if (request.readyState == 4)
            if (request.status == 200) {
                textField.value = request.responseText;
            }
    }
    request.open("GET","file.txt?t="+new Date().getTime());
    request.send();

}
function validateUserName(){
    var username = document.getElementById("name");
    var validateSpan = document.getElementById("validateName");
    if (window.XMLHttpRequest)
    {
        namereq = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        namereq = new ActiveXObject("Microsoft.XMLHTTP");
    }
    namereq.onreadystatechange = function () {
        if (namereq.readyState == 4)
            if (namereq.status == 200) {
                validateSpan.innerHTML = namereq.responseText;
                
            }
    }
    
    namereq.open("POST","ValidateUsername");
    namereq.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    namereq.send("name=\""+username.value+"\"");
}

function startRequest(){
    var timeTable = document.getElementById("timeTable");
   if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject)
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.onreadystatechange = function () {
        if (req.readyState == 4)
            if (req.status == 200) {
                console.log(req.responseText);
                timeTable.innerHTML = req.responseText;
            }
    }
    req.open("GET","innerHTML.html");
    req.send(); 
}