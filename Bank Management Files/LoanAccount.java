package com.saurya.assignment;

public class LoanAccount extends Account {

	static double rateInterest=12;
	
	public LoanAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LoanAccount(int accountId, String accountName, double balance) {
		super(accountId, accountName,-(balance));
	}
	

		
	public static double getRateInterest() {
		return rateInterest;
	}


	public static void setRateInterest(double rateInterest) {
		LoanAccount.rateInterest = rateInterest;
	}


	public double RateOfInterest() {

		return this.balance * (rateInterest / 100);
	}

	public boolean deposite(double amount) {
		if (this.balance < 0) {
			this.balance += amount;
			return true;
		}
		System.out.println("This Account Loan Has Been Cleared!");
		return false;
	}

	public boolean withdraw(double amount) {
		System.out.println("Can Not Withdraw From This Account!");
		return false;
	}


	@Override
	public void withDraw(double amount) {
		System.out.println("You Cant Withdraw From this Account!");
		
	}


	@Override
	public void TransferBalance(Account transferMember, double balance) {
		System.out.println("You Cannot Transfer amount from this Account ");
		
	}


	

}
