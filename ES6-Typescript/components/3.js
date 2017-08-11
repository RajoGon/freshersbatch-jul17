export function assignment3(){
    let order = {   id:1 ,
                    title:'TV', 
                    price: 200,
                    printorder(){
                       console.log(id);
                    },
                    getPrice(){
                        return this.price;
                    }               
                };
    let copy_obj={};
    let ordercopy = Object.assign(copy_obj,order);
    console.log(ordercopy);
}