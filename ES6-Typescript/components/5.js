export function assignment5(){
    
    let add = (a=5,b=7) => a + b
  
    let userfriends = (uname,...friends) => friends.forEach( (f) => console.log(`My name is ${uname} and my friend is ${f} `))
        
    
    let printNames = (...names) => console.log( names.map(  (e) =>  e.toUpperCase()))
        
        
    
    console.log(add());
    let a=['A','B','C']
    userfriends('Rajo',...a);
    //userfriends('Rajo','x','y','z');
    printNames('aa','bb','cc','dd','ee');
    
}