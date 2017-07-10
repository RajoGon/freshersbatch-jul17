r = 1;
function multi() {
var x = document.getElementById('num1').value ;

	if ( r == 1)
	{
		
			for(i=1; i<=10 ; i++)
			{
			var p = x*i ;
			var para = document.createElement("p");
			var node = document.createTextNode(x + " x " + i + " = " + p );
			para.appendChild(node);
			var element = document.getElementById("div1");
			element.appendChild(para);
			}
	}
r = confirm ("Do you want to enter again ? ");
}