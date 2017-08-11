export function assignment9(){
    
    
let prev=Symbol();
let cur=Symbol();
    class Fibo{
        constructor(a,b){
         cur=a;
        prev = b;   
        }
    [Symbol.iterator](){
        // let cur=1;
        // let prev = 0;
        return{
            next(){
                [cur,prev]=[cur+prev,cur]
                return  {value: cur, done: false};
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