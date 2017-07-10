

function asc() {
	var x =	document.getElementById('b1').value;
	x = x.toLowerCase();
	var y = x.split("").reverse().join("");
	console.log(y);
	if ( x === y)
	{
		alert("It is a Palindrome!");
	}
	else
	{
		alert("It is NOT a Palindrome!");
	}
} 