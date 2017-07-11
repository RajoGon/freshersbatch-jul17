function BankAccount (an,ab,aname) {
	var accno = an;
	var accbal = ab;
	var accname = aname;
	

return{

	deposit :function(dep){
		accbal = dep;
	},

	withdraw :function(wid){
		accbal = wid;
	},

	showdata :function(){
		return {
			accno: an,
			accbal: accbal,
			accname: accname,
		}
	}

}
};
var Bo = new BankAccount(1,1200,'Rajo');
Bo.deposit(200);
console.log(Bo.showdata());
