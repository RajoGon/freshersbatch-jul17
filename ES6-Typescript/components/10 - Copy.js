export function assignment10(){
    
    
    let i;
    class Arm{
       constructor(s){
                this.cur=s;
       }
      
    [Symbol.iterator](){
    
        
            return{
                next: () => {
                    this.cur2 = this.cur;
                    for(i=this.cur2;i<1000;i++)
                    {
                        
                        let digits = this.cur2.toString().split('');
                        let [a,b,c] = [...digits];                  
                        parseInt(a,b,c);
                        a = Math.pow(a, 3);
                        b = Math.pow(b, 3);
                        c = Math.pow(c, 3);
                       
                        if( (a+b+c) == this.cur2 )
                            {   
                                this.cur =this.cur2 + 1; 
                                return  {value: this.cur2, done: false};
                            }
                        
                        this.cur2 = this.cur2 +1;

                    }
                    
                }
            }
    }
}
let armobj = new Arm(100);
let itr=armobj[Symbol.iterator]();
function getNextArmstrong(){
  return  itr.next();
}
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());


}