

function asc() {
	var x =	document.getElementById('b1').value;
	x = x.toLowerCase();
	var a = 0;
	var e = 0;
	var ii = 0;
	var o = 0;
	var u = 0;
for( i = 0 ; i< x.length; i ++)
{
		if(x[i] === 'a'){
			a++;
			console.log(a);
		}
		if(x[i] === 'e'){
			e++;
			console.log(e);
		}
		if(x[i] === 'i'){
			ii++;
			console.log(ii);
		}
		if(x[i] === 'o'){
			o++;
			console.log(o);
		}
		if(x[i] === 'u'){
			u++;
			console.log(u);
		}

	}
alert("a = " + a + " e = " + e + " i = " + ii + " o = " + o + " u = " + u );
} 