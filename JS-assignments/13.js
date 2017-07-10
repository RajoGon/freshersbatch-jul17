

function asc() {
	var x =	document.getElementById('b1').value;
	x = x.toLowerCase();
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
		} 
		else{
		alert("Valid e-mail address");	
		}
}