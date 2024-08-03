package com.saurya.assignment;

public abstract class Account {

	int AccountNo;
	String AccountName;
	double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
		}

	public Account(int accountId, String accountName, double balance) {
		
		AccountNo = accountId;
		AccountName = accountName;
		this.balance = balance;
	}

	public int getAccountId() {
		return AccountNo;
	}

	public void setAccountId(int accountId) {
		AccountNo = accountId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void withDraw(double amount);
//	{
//		this.balance-=amount;
//	}
	
	
	public void deposit(double amount)
	{
		this.balance+=amount;
		System.out.println("Amount Deposit Sucessfully");
	}
	public void display()
	{
		 System.out.println("\n--- Account Details ---");
	        System.out.println("| Field            | Value                |");
	        System.out.println("|------------------|----------------------|");
	        System.out.println("| Account Number   | " + AccountNo      +"|");
	        System.out.println("| Account Name     | " + AccountName    +"|");
	        System.out.println("| Account Balance  | " + balance        +"|");
	        System.out.println("------------------------------------------|");
	}
	public abstract void TransferBalance(Account transferMember,double balance);

	public abstract double RateOfInterest();

	

}
