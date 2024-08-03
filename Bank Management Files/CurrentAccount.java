package com.saurya.assignment;

public class CurrentAccount extends Account  {
		
	static double overDraftLimit=-10000;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CurrentAccount(int accountId, String accountName, double balance) {
		super(accountId, accountName, balance);
		//this.overDraftLimit = overDraftLimit;
	}
	@Override
	public double RateOfInterest() {
		// TODO Auto-generated method stub
		return 0;
	}
	public  void withDraw(double amount)
	{
		if(this.balance-amount>CurrentAccount.overDraftLimit)
		{
			this.balance-=amount;
			System.out.println("Amount WithDraw Sucessfully");
		}
		else
		{
			System.out.println("\n Your OverDraft Limit is Over ");
			System.out.println("\n You Cannot do Further Transaction ");
		}
	}


	@Override
	public void TransferBalance(Account transferMember, double balance) {
		if(this.balance-balance>CurrentAccount.overDraftLimit)
		{
			this.balance-=balance;
			transferMember.deposit(balance);
			System.out.println("Transfer Process is Sucessfully");
		}
		else
		{
			System.out.println("\n Your OverDraft Limit is Over ");
			System.out.println("\n You Cannot do Further Transaction ");
		}
		
	}
	

}
