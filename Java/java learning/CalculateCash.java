class Account {
	private int accountid;
	private double accountbalance;
	public Account(int accountid, double accountbalance){
		this.accountid = accountid;
		this.accountbalance = accountbalance;
	}
	public double getBalance(){
		return this.accountbalance;
	}
}

class Saving extends Account {
	private double fixeddeposits;
	public Saving(int accountid, double accountbalance , double fixeddeposits){
		super(accountid,accountbalance);
		this.fixeddeposits = fixeddeposits;
	}
	public double getBalance(){
		return this.fixeddeposits + super.getBalance() ;
	}
}
class Current extends Account {
	private double cashcredits;
	public Current(int accountid, double accountbalance , double cashcredits){
		super(accountid,accountbalance);
		this.cashcredits = cashcredits;
	}
	public double getBalance(){
		return this.cashcredits + super.getBalance() ;
	}
}

public class CalculateCash{
	private static double totalcash=0;
	public static double getTotalCash(Account a[]){
		
		for(int i = 0 ; i<a.length ; i++){
			totalcash = totalcash + a[i].getBalance();
		}
		return totalcash;
	}
	public static void main(String[] args) {
		double totalcash;
		Account a[] = new Account[4];
		a[0] = new Saving(1,250,20);
		a[1] = new Saving(2,330,10);
		a[2] = new Current(1,2000,200);
		a[3] = new Current(1,3000,1500);
		totalcash = CalculateCash.getTotalCash(a);
		System.out.println("Total cash in bank is, " + totalcash );
	}
}