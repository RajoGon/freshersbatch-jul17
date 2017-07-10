var count = 1;
var flag = 1;
function vow() {

	var pass = "Hello";
	var z = document.getElementById('alph2').value ;
	if ( z === pass && flag ==1)
	{
		alert("Successful ")
	}
	else if (count < 3) {
		alert ("Wrong password! " + (3-count) + "chances remaining.")
		count++ ;
	}
	else
	{	window.location = "error.html";
		alert("You have exhausted your chances, try again at a later time");
		flag = 0;
	}
}