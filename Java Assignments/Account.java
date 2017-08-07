public class Account{
	private int accountid;
	private int accountbalance;
	private String accountname;
	public Account(int id, int amount,String name){
		this.accountid = id;
		this.accountname = name;
		this.accountbalance = amount;
	}
	public void deposit(int amount){
		this.accountbalance = this.accountbalance + amount;
	}
	public void withdraw(int amount){
		if(amount < this.accountbalance)
		this.accountbalance = this.accountbalance - amount;
		else
		System.out.println("Error : Low account balance");
	}
	public void getBalance(){
		System.out.println("Current account balance is, "+this.accountbalance);
	}
	public static void main(String args[]){
		Account a = new Account(1,2000,"Rajo");
		a.deposit(1000);
		a.withdraw(5000);
		a.getBalance();
	}
}