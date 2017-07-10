

function asc() {
	var x =	document.getElementById('b1').value;
	x = x.toLowerCase();
 	var count=0;
 	for(var i = 0; i<x.length;i++)
 	{
 			if(x[i] == " "){
 				count++;
 				console.log("found");
 			}
 	}
 	count = x.length - count;
 	alert("Number of characters = " + count);
}