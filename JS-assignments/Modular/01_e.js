function BankAccount (an,ab,aname) {
	this.accno = an;
	this.accbal = ab;
	this.accname = aname;
}


	BankAccount.prototype.deposit = function(dep){
		this.accbal = dep;
	};

	BankAccount.prototype.withdraw = function(wid){
		this.accbal = wid;
	};

	BankAccount.prototype.showdata = function(){
		return {
			accno: this.accno,
			accbal: this.accbal,
			accname: this.accname
		}
	};


var Bo = new BankAccount(1,1200,'Rajo');
Bo.deposit(200);
console.log(Bo.showdata());
