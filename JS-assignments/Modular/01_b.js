function BankAccount (an,ab,aname,dep,wid) {
	this.accno = an,
	this.accbal = ab,
	this.accname = aname,
	this.deposit=  function(dep){
		this.accbal +=  dep;
	},
	this.withdraw= function(wid){
		this.accbal = this.accbal - wid ;
	}
};
var Bo = new BankAccount(1,1200,'Rajo');
Bo.deposit(200);
Bo.withdraw(700);
console.log(Bo);

