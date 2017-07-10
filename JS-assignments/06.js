function vow() {

	var x = document.getElementById('num1').value ;
	var y = document.getElementById('num2').value ;

	for (i=x ; i<=y ; i++)
	{
		var prime = 1;
		for ( var z = 2 ; z<y ; z++)
		{
			if ( (i!=z) && (i%z == 0))
			{
				prime = 0;
			}
		}
		

		if ( prime == 1 )
		{
			alert(i);
		}

	}
}