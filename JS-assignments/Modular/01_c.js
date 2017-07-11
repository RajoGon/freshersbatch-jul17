var BankAccount = {
	accno:1,
	accbal: 123,
	accname: 'Example',
	deposit: function(dep){
		this.accbal +=  dep;
	},
	withdraw: function(wid){
		this.accbal = this.accbal - wid ;
	}
};

var Bo = Object.create(BankAccount);
Bo.accno = 100;
Bo.accbal = 1200;
Bo.accname = 'Rajo';
Bo.deposit(200);
console.log(Bo);
Bo.withdraw(700);
console.log(Bo);