package com.createexception;
class LowBalance extends Exception{
	/**
	 * 
	 */
	int message;
	private static final long serialVersionUID = 1L;
	public LowBalance(){
		
	}
	public LowBalance(int message){
		this.message = message;
	}
	public String toString(){
		if(this.message == 0){
			return "Your balance is low";
		}else{
			return "Your balance is low and withdrawl of "+message+" exceeds it.";
		}
		
	}
}


class Account implements AutoCloseable{
	int bal;
	Account(int bal){
		this.bal = bal;
	}
	public void withdraw(int withdraw) throws LowBalance{
		if(withdraw < this.bal){
			
		this.bal = this.bal - withdraw;
		System.out.println("Withdrawn "+withdraw+ " remaining amount is "+ this.bal);
		}else{
			throw new LowBalance();
		}
	}
	@Override
	public void close(){
		System.out.println("closing object");
	}
}



public class CustomException {

	public static void main(String[] args) {
		try(Account a = new Account(1000);){
			try {
				a.withdraw(400);
			} catch (LowBalance e) {
				System.out.println(e);
			}
			finally{
				System.out.println("You can withdraw again.");
			}
			try {
				a.withdraw(2000);
			} 
			
			finally{
				System.out.println("You can withdraw again.");
			}
		}catch(Exception e){

			System.out.println("Outter catch handling");
		}
		System.out.println("Terminating program......");
		
		
		

	}

}
