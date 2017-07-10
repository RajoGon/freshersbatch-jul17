var sum = 0;
var av = 0;
function ary() {
var x = [ 1, 5, 23, 14 , 72];
var m = Math.max(...x);
var mi = Math.min(...x);
document.getElementById('max').innerHTML = m ;
document.getElementById('min').innerHTML = mi ;
x.forEach(adding);
x.forEach(avg);
}
	function adding (i) {
		sum = sum + i;
		document.getElementById('ttl').innerHTML = sum ;
	}
		function avg (j) {
		av = av + j;
		av = av / 5;
		document.getElementById('avg').innerHTML = av ;
	}

	function maxx () {

	}

