addContactItem("hadeer",283829932);
addContactItem("hagar",737838282);
addContactItem("hashem",74838939);




function addContactItem(name,number){
    $("#contactsList").html( $("#contactsList").html() + "<li>"+
    "<a href=\"#\">"+
        "<img src=\"https://i.pinimg.com/564x/3d/fd/d3/3dfdd3cce72f6d62c17d4fa2c595d6c9.jpg\">"+
        "<h2>"+name+"</h2>"
    +"<p>"+number+"</p>"+
    "</a>"+
    "<a href=\"tel:"+number+"\" class=\"ui-shadow ui-btn ui-corner-all ui-btn-inline\" data-transition=\"pop\"></a>"+
"</li>");
}
