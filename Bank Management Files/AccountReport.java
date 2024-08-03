package com.saurya.assignment;

public class AccountReport {

	int accountNumber;
	String name;
	double transation;
	String activity;
	
	public AccountReport() {
		// TODO Auto-generated constructor stub
	}
	

	public AccountReport(int accountNumber, String name, double transation, String activity) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.transation = transation;
		this.activity = activity;
	}


	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTransation() {
		return transation;
	}
	public void setTransation(double transation) {
		this.transation = transation;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
	
	
}
