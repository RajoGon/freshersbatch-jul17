export function assignment4(){
    
    
    let strop= (...names) => {
            let a = [];
            names.map( (n) =>{
              a.push ( { name :n , length : n.length}); 
                }
            )
        return a;              
    }

  let names = ['Tom', 'Ivan', 'Jerry'];
  console.log(  strop(...names) );
}