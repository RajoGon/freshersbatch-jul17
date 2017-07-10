function findage() {
var x = document.getElementById('curage').value ;
var age = new Date().getFullYear()-x;
alert("Your birth year is " + age);
}