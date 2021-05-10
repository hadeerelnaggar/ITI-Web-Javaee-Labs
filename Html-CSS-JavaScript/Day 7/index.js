var studentsTable = document.getElementById("studentsTable");

var students = new Array();
var student;

function addStudent(e) {
    e.preventDefault();
    var fName = document.getElementById("fName").value;
    var lName = document.getElementById("lName").value;
    var birthDate = document.getElementById("birthdate").value;
    var dept = document.getElementById("dept").value;
    student = new Student(fName,lName,birthDate,dept);
    students.push(student);
    console.log(students)
    displayStudent();

}

function displayStudent(){
    studentsTable.innerHTML += "<div><tr id="+student.id+">"+
        "<td>"+student.id+"</td><td id="+student.id+"Name contenteditable='true'>"+student.getFullName()+"</td><td>"+student.getAge()+"</td><td id="+student.id+"dept contenteditable='true'>"+student.dept+"</td>"+
        "<td><button onclick=\"deleteStudent("+student.id+")\">delete</button></td>"+
        "<td><button onclick=\"editStudent("+student.id+")\">Edit</button></td>"
    +"</tr></div>"
}

function deleteStudent(id){
    console.log("delete"+ id)
    var row = document.getElementById(id);
    console.log(row.innerHTML)
    row.innerHTML = ""
}

function editStudent(id){
    var newName = document.getElementById(id+"Name").innerHTML;
    var newDept = document.getElementById(id+"dept").innerHTML;
    var splitNames = newName.split(" ");
    students[id].fName = splitNames[0];
    students[id].lName = splitNames[1];
    students[id].dept  = newDept;
}

function Student(fName, lName, birthDate, dept) {
    this.fName = fName;
    this.lName = lName;
    this.birthDate = birthDate;
    this.dept = dept;
    this.id = students.length;
}

Student.prototype.getFullName = function(){
    return this.fName+" "+this.lName;
}

Student.prototype.getAge = function(){
    var date = new Date().getFullYear();
    var birthdateSplitted = this.birthDate.split("-");
    return Math.abs(date - birthdateSplitted[0]);
}