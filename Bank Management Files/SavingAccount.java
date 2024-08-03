package com.saurya.assignment;

public class SavingAccount extends Account{

	static double minimumBalance=10000;
	
	static double rateInterest=3.5;
	
	public static double getRateInterest() {
		return rateInterest;
	}
	
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	

	public SavingAccount(int v1,String v2,double v3) {
		super(v1,v2,v3);
	//	MinimumBalance = minimumBalance;
	}

//	public void display()
//	{
//		System.out.println("Account Number:-"+AccountNo);
//		System.out.println("Account Name:-"+AccountName);
////		System.out.println("Account Balance:-"+balance);
////		System.out.println("Current Rate of Intrest:-"+this.RateOfInterest());
//	}
//	
	@Override
	public double RateOfInterest() {
		// TODO Auto-generated method stub
		double roi=this.balance*(rateInterest/100);
		return roi;
		
	}

	
	public void withDraw(double amount) 
	{
		if(minimumBalance < this.balance - amount)
		{
			this.balance-=amount;
			System.out.println("Account Balance:-"+this.balance);
		}
		else
		{
			System.out.println("\n MINIMUM BLANCE 10000 REQUIRED IN THIS ACCOUNT ");
			System.out.println("SOO THIS TRANSACTION CANOT BE POSSIBLE");
		}
		
		
	}


	public static double getMinimumBalance() {
		return minimumBalance;
	}


	public static void setMinimumBalance(double minimumBalance) {
		SavingAccount.minimumBalance = minimumBalance;
	}


	public static void setRateInterest(double rateInterest) {
		SavingAccount.rateInterest = rateInterest;
	}


	@Override
	public void TransferBalance(Account transferMember, double balance) {
		
		if(minimumBalance < this.balance - balance)
		{
			this.balance-=balance;
			transferMember.deposit(balance);
			System.out.println(" Transfer Process is Successfull ");
		}
		else
		{
			System.out.println("\n MINIMUM BALANCE 10000 REQUIRED IN THIS ACCOUNT ");
			System.out.println("SOO THIS TRANSFER CANOT BE POSSIBLE");
		}
		
		
	}


	


	
}
