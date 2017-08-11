export function assignment10(){
    
    
    let i;
    let j;
    let z;
    let arr=[];
    let sum=0;
    let digits=[];
    class Arm{
       constructor(s){
                this.cur=s;
       }     
    [Symbol.iterator](){    
            return{
                next: () => {
                    this.cur2 = this.cur;                   
                    
                    for(i=0;;i++)
                    {       
                        this.len=this.cur2.toString().split('');  
                        this.len = this.len.length;         
                        digits = this.cur2.toString().split('');
                         [...arr] = [...digits]; 
                          for(j=0;j<this.len;j++){
                          arr[j]=parseInt(arr[j]);                          
                         }                        
                          for(z=0;z<this.len;z++){
                            arr[z] = Math.pow(arr[z],this.len);
                            sum = sum +  arr[z];  
                         }    
                        // console.log(this.cur2," and length is ",this.len, " and sum is ",sum);                   
                        if( (sum) === this.cur2 )
                             {   
                                 this.cur = this.cur2 + 1; 
                                 sum = 0;
                                 while(arr.length > 0) {
                                        arr.pop();
                                    }
                                 return  {value: this.cur2,len: this.len, done: false};
                            } 
                        while(arr.length > 0) {
                                arr.pop();
                        }                      
                        this.cur2 = this.cur2 +1;
                        sum=0;
                    }
                   //this.cur = this.cur2 +1;
                }
            }
    }
}
let armobj = new Arm(1);
let itr=armobj[Symbol.iterator]();
function getNextArmstrong(){
  return  itr.next();
}
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());
console.log(getNextArmstrong());




}