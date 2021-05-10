function validateEmail(email) {
    var pattern = new RegExp("[a-z].+@[a-z].+\.[a-z].*", "i")
    if (!pattern.test(email))
        return false
}
function validatePhone(phone) {
    var pattern = new RegExp("01[012][0-9]{8}")
    if (!pattern.test(phone))
        return false
}
function validateInput(input) {
    if (input.length == 0) {
        return false
    }
}
var userName = document.getElementsByName("username")[0]
var email = document.getElementsByName("email")[0]
var phone = document.getElementsByName("phoneNumber")[0]
var gender = document.getElementById("gender")
var Products = document.getElementsByName("Products");
var country = document.getElementById("counrty")
var genderError = document.getElementById("genderError")
var productsError = document.getElementById("productsError")
var countryError = document.getElementById("countryError")
function submitForm(e) {
    e.preventDefault()
    genderError.innerHTML = ""
    productsError.innerHTML = ""
    countryError.innerHTML = ""
    userName.style = "border-color: black"
    email.style = "border-color: black"
    phone.style = "border-color: black"
    if (validate()) {
        var myWindow = window.open("", "", "width=500,height=300")
        var productsString = "";
        for (var checkbox of Products) {
            if(checkbox.checked){
                productsString+=checkbox.value+","
            }
        }
        myWindow.document.write("<div>" +
            "<p>UserName:" + userName.value + "</p>" +
            "<p>Email:" + email.value + "</p>" +
            "<p>Phone:" + phone.value + "</p>" +
            "<p>Gender:" + gender.options[gender.selectedIndex].text + "</p>" +
            "<p>Products:" + productsString + "</p>" +
            "<p>Country:" + country.options[country.selectedIndex].text + "</p>"
            + "</div>")
    }

}
function validate() {
    var cansubmit = true
    if (userName.value == "") {
        console.log("wrong")
        userName.style = "border-color: red;"
        cansubmit = false
    }
    if (validateEmail(email.value)) {
        console.log("wrong")
        email.style = "border-color: red;"
        email.className = "red-border"
        cansubmit = false
    }
    if (validatePhone(phone.value)) {
        console.log("wrong")
        phone.style = "border-color: red;"
        cansubmit = false
    }
    if (gender.selectedIndex == 0) {
        cansubmit = false
        genderError.innerHTML = "please choose gender"
    }
    if (Products.values().length == 0) {
        cansubmit = false
        productsError.innerHTML = "please choose product"
    }
    if (country.selectedIndex == 0) {
        cansubmit = false
        countryError.innerHTML = "please choose country"
    }
    return cansubmit
}
