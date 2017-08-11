export function assignment9(){
    
    
let prev=Symbol();
let cur=Symbol();
    class Fibo{
        constructor(a,b){
         this[cur]=a;
        this[prev] = b;   
        }
    [Symbol.iterator](){
        // let cur=1;
        // let prev = 0;
        return{
            next(){
                [this[cur],this[prev]]=[this[cur]+this[prev],this[cur]]
                return  {value: this[cur], done: false};
            }
        }
    }
}
let fib = new Fibo(1,0);
let itr=fib[Symbol.iterator]();
console.log(itr.next());
console.log(itr.next());
console.log(itr.next());
console.log(itr.next());
console.log(itr.next());
console.log(itr.next());
console.log(itr.next());



}