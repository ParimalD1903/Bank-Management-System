package com.saurya.assignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends SavingAccount {

	LocalDate lastTranscation;
	static double RateInterest=3;
	
	public SalaryAccount() {
		// TODO Auto-generated constructor stub
	}		
	
	public SalaryAccount(int accountId, String accountName, double balance) {
		super(accountId, accountName, balance);
		this.lastTranscation=LocalDate.now();
		
	}

	public LocalDate getLastTranscation() {
		return lastTranscation;
	}

	public void setLastTranscation(LocalDate lastTranscation) {
		this.lastTranscation = lastTranscation;
	}

	public static double getRateInterest() {
		return RateInterest;
	}



	public static void setRateInterest(double rateInterest) {
		RateInterest = rateInterest;
	}



	@Override
	public double RateOfInterest() {
		// TODO Auto-generated method stub
		double RoI=this.balance*(RateInterest/100);
		return RoI;
	}
	public  void withDraw(double amount)
	{	
		if(this.frozen())
		{
			System.out.println("\n Your Account is Frezzed ");
			System.out.println("\n You Cannot Perform Futher Transcation ");
		}
		else
		{
		
			this.balance-=amount;
			System.out.println("Amount WithDraw Sucessfully");
		}
		
	}
	
	
	public void deposit(double amount)
	{
		if(this.frozen())
		{
			System.out.println("\n Your Account is Frezzed ");
			System.out.println("\n You Cannot Perform Futher Transcation ");
		}
		else
		{
			
			this.balance+=amount;
			System.out.println("Amount Deposit Sucessfully");
		}
	}
	
	public boolean frozen()
	{
		long diff=ChronoUnit.DAYS.between(LocalDate.now(),this.lastTranscation);
		
		if(diff>60)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void TransferBalance(Account transferMember, double balance) {
		
		if(this.frozen())
		{
			System.out.println("\n Your Account is Frezzed ");
		}
		else
		{
			this.balance-=balance;
			transferMember.deposit(balance);
			System.out.println("Transfer Process is Successfull");
		}
		
	}
	
}
