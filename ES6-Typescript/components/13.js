export function assignment13(){
let Mroomusers = new Set(); 
Mroomusers.add("A");
Mroomusers.add("B");
Mroomusers.add("C");
let Sroomusers = new Set();
Sroomusers.add("D");
Sroomusers.add("E");
Sroomusers.add("F");

let Mmessages = ["M1","M2","M3"];
let Smessages = ["M4","M5","M6"];
let Messages = new Map();
Messages.set('Musicroom', Mmessages);
Messages.set('Sportsroom', Smessages);
let Users = new Map();
Users.set('Musers', Mroomusers);
Users.set('Susers', Sroomusers);

function getMessage(x)
{
  return  Messages.get(x);
}
function getUser(x)
{
  return  Users.get(x);
}

console.log("Music room users are", getUser('Musers'));
console.log("Sports room users are", getUser('Susers'));
console.log("Music room Messages are", getMessage('Musicroom'));
console.log("Sports room Messages are", getMessage('Sportsroom'));



}