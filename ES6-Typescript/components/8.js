export function assignment8(){
    class Account {
    constructor (id, name, bal) {
        this.id = id,
        this.name=name,
        this.bal=bal
    }
    tbal(){
        return this.bal;
    }
}

class SavingAccount extends Account {
  constructor(id, name, bal,interest) {
    super(id, name, bal);
     this.interest = interest;
  }
  total(){
      return this.interest + super.tbal();
  }
}
class CurrentAccount extends Account {
  constructor(id, name, bal,cash_credit) {
    super(id, name, bal);
    this.cash_credit = cash_credit;
  }
  total(){
      return this.cash_credit + super.tbal();
  }
}
let accounts=[];
let s1 = new SavingAccount(1,'Rajo1',2000,73);
accounts.push(s1);
let s2 = new SavingAccount(2,'Rajo2',1000,12);
accounts.push(s2);
let s3 = new SavingAccount(3,'Rajo3',3000,34);
accounts.push(s3);
let c1 = new CurrentAccount(4,'Rajo4',700,56);
accounts.push(c1);
let c2 = new CurrentAccount(5,'Rajo5',1800,19);
accounts.push(c2);
let sum = 0;

function getTotalCashInBank(accounts){
    let itr=accounts[Symbol.iterator]();
    for(let i in accounts)
    {
    sum = sum + ( itr.next().value.total());
    }
    return sum;
}

console.log("Total Balance in bank is" ,getTotalCashInBank(accounts));

}