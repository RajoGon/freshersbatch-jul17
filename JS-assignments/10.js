var x = [ 5 , 3 , 18 , 13 , 2 , 45];
function asc() {
alert(x.sort(function(a, b){return a-b}));
}
function desc() {
alert(x.sort(function(a, b){return b-a}));
}


