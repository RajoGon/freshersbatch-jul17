var BankAccount = {
	accno:1,
	accbal: 1200,
	accname: 'Rajo',
	deposit: function(dep){
		this.accbal +=  dep;
	},
	withdraw: function(wid){
		this.accbal = this.accbal - wid ;
	}
};
console.log(BankAccount);

BankAccount.deposit(200);
console.log(BankAccount);
BankAccount.withdraw(700);
console.log(BankAccount);