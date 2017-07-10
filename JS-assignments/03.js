function divi() {
var x = document.getElementById('num1').value ;
var y = document.getElementById('num2').value ;
if (y == 0)
{
	alert("Divisor is 0 ! Plz enter it again");
}
else
{
	var z = x/y;
	alert("Quotient is " + z);
}
}