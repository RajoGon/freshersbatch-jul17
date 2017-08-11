export function assignment12(){
    var sum=0;
    var x = Promise.resolve(7);
    
    var y = Promise.resolve(3);

    // Promise.all([x,y]).then(function(promises){

    // });
    Promise.all([x, y]).then(function (promises) {
        promises.forEach(function (a) { sum = sum + a ; });
        console.log("The sum of promises is",promises)
});


}