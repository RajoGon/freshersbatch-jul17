export function assignment7(){
    let [,,a,]= [1,2,3,4];
    console.log(a);
    
    let organization = {
        name : 'Rajo',
        address:{
            pincode: 440013,
            std: 712
        }
    };
    let {address:{pincode}} = organization;
    console.log(`The pin code is ${pincode}`);
}