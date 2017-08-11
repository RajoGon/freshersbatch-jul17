export function assignment6(){
    let laptop = {
        model: 7336,
        deskno: 7,
        name: 'Rajo',
        sendticket2() { 
            let b = `My name is ${this.name}, at desk ${this.deskno} and my laptop with model no
         ${this.model} is having a problem, please resolve the issue at its earliest`;
         return b;

        }
    };


   let c = laptop.sendticket2();
   console.log(c);
}