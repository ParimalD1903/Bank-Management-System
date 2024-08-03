package com.saurya.assignment;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class AccountMain {
	
	// Class level functions.
	
	static int index=0;
	
	static AccountReport[] ar =new AccountReport[10];
	static int accountreportcount=0;
	
	public static void genrateReport(int accountNumber, String name, double transation, String activity)
	{
		ar[accountreportcount++]=new AccountReport(accountNumber,name,transation,activity);
	}
	
	public static void fetchReport()
	{
		System.out.println("AccountNo \tHolderName \tTransation \tActivity");
		
		for (AccountReport ref : ar) {
			if (ref != null)
			{
				System.out.println(ref.getAccountNumber() + "\t\t" + ref.getName() + "\t\t" + ref.getTransation()
						+ "\t\t" + ref.getActivity());
			}
		}
		System.out.println("Till Now Nothing has to be Done");
		
	}

	public static double getROI(Account[] account)
	{
		String clss = account.getClass().getName();
		double roi=0;
		try {
			Class <?> var=Class.forName(clss);
			java.lang.reflect.Method temp = var.getMethod("getRateInterest", null);
			roi = (double) temp.invoke(null);
//			System.out.println(roi);
//			return roi;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			roi = 0;
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			roi = 0;
//			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			roi = 0;
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			roi = 0;
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			roi = 0;
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			roi = 0;
			e.printStackTrace();
		}
		return roi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		
		Account [] account = new Account [10];
		int choice,count=0,AccountNo=999;
		int ch;
		
		do
		{
			System.out.println( " |-----------Login Page--------------|");
			System.out.print( " | Option | Operation                |");
			System.out.print("\n |--------|--------------------------|");
			System.out.print("\n |  1.    |Login Page                |");
			System.out.print("\n |  2.    |Create Account            |");		 
			System.out.print("\n |  3.    |Display Account Lists     |");		  
			System.out.print("\n |  4.    |Daily Report              |");		  
			System.out.print("\n |  0.    |Exit                      |");
		System.out.println("  \n |-----------------------------------|");
			System.out.print(" 	Enter your choice:-> ");
			choice=sc.nextInt();
			
			switch (choice)
			{
				case 1:
				{
					System.out.println("\nEnter Your Account Number:-");
					int actno=sc.nextInt();
					if(index==0)
					{
						System.out.println("Account Does not Exist ");
					}
					else
					{
						for(int i=0;i<index;i++)
						{
							if(account[i].AccountNo == actno)
							{
								do
								{
									 System.out.println("---------------------------- Select Operation ----------------------------");
							            System.out.println("| Option | Operation                 |");
							            System.out.println("|--------|---------------------------|");
							            System.out.println("|   1    | Withdraw                  |");
							            System.out.println("|   2    | Deposit                   |");
							            System.out.println("|   3    | Check Balance             |");
							            System.out.println("|   4    | Transfer Amount           |");
							            System.out.println("|   5    | Interest on Account       |");
							            System.out.println("|   0    | Exit                      |");
							            System.out.println("-------------------------------------------------------------------------");

							            System.out.print("Select Operation: ");
							            ch=sc.nextInt();
									
									switch (ch) {
										case 1: 
										{
											System.out.println("Enter your Amount to Withdraw:-");
											int amount=sc.nextInt();
											account[i].withDraw(amount);
											genrateReport(account[i].getAccountId(), account[i].getAccountName(), amount, "Withdraw");
											
										}break;
										case 2:
										{
											System.out.println("Enter your Amount to Deposit");
											int amount =sc.nextInt();
											account[i].deposit(amount);
											genrateReport(account[i].getAccountId(), account[i].getAccountName(), amount, "Deposit");
										}break;
										case 3:
										{
											
											System.out.println("Your Current Balance:-"+account[i].getBalance());
											
										}break;
										case 4:
										{
											System.out.println("Enter Account No To Transfer Amount:-");
											int transferId=sc.nextInt();
											
											Account transferMember = null;
											
											for(int i1=0;i1<index;i1++)
											{
												if(account[i1].AccountNo == transferId)
												{
													transferMember = account[i1];
													break;
												}
											}
											if(transferMember !=null)
											{
												System.out.println("Enter your Amount ");
												int amount=sc.nextInt();
												account[i].TransferBalance(transferMember, amount);
												genrateReport(account[i].getAccountId(),account[i].getAccountName(),amount,"Transfer Amount");
											}
											else
											{
												System.out.println("Account is Not there in The Bank plzz Give Correct Account number");
											}
										}break;
										 case 5: {
			                                	System.out.println("Interest on This Account Balance By " + getROI(account) + "% is:- "
			                                            + account[i].RateOfInterest());
			                                    
			                                }break;
										
									}
									}while(ch!=0);
								}
							else
							{
								System.out.println("Plzz Check Your Account Number");
							}
								
							}
					
						}break;
					}
					
							
							
			case 2:
			{
				 System.out.println("\n--- Choose Account to Create ---");
			        System.out.println("| Option | Account Type          |");
			        System.out.println("|--------|-----------------------|");
			        System.out.println("|   1    | Savings Account       |");
			        System.out.println("|   2    | Salary Account        |");
			        System.out.println("|   3    | Current Account       |");
			        System.out.println("|   4    | Loan Account          |");
			        System.out.println("---------------------------------");

			        System.out.print("Select Account Type: ");
			        int accountType = sc.nextInt();
				
				switch(accountType)
				{
					case 1:
					{
						System.out.println("Enter your Name:-");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.println("Enter Starting Amount:-");
						double balance=sc.nextDouble();
						if(balance>SavingAccount.minimumBalance) 
						{
							account [count++] =new SavingAccount(AccountNo++,name,balance);
							System.out.println("Account Created Successfull");
							account[count-1].display();
							index++;
							genrateReport(account[count-1].getAccountId(),account[count-1].getAccountName(),balance,"Saving Account Created");
							
						}
						else
						{
							System.out.println("Not Specific Amount to Create Account\n");
						}
					}break;
					case 2:
					{
						System.out.println("Enter your Name:-");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.println("Enter Starting Amount:-");
						double balance=sc.nextDouble();
						if(balance>SalaryAccount.minimumBalance) 
						{
							account [count++] =new SalaryAccount(AccountNo++,name,balance);
							System.out.println("Account Created Successfull");
							account[count-1].display();
							index++;
							genrateReport(account[count-1].getAccountId(),account[count-1].getAccountName(),balance,"Salary Account Created");
							
						}
						else
						{
							System.out.println("Not Specific Amount to Create Account\n");
						}}break;
					case 3:
					{
						System.out.println("Enter your Name:-");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.println("Enter Starting Amount:-");
						double balance=sc.nextDouble();
						account [count++] =new CurrentAccount(AccountNo++,name,balance);
						account[count-1].display();
						System.out.println("Account Created Successfull");
						index++;
						genrateReport(account[count-1].getAccountId(),account[count-1].getAccountName(),balance,"Current Account Created");
					}break;
					case 4:
					{
						System.out.println("Enter your Name:-");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.println("Enter your Loan Amount:-");
						double balance=sc.nextDouble();
						account [count++] =new LoanAccount(AccountNo++,name,balance);
						System.out.println("Account Created Successfull");
						account[count-1].display();
						index++;
						genrateReport(account[count-1].getAccountId(),account[count-1].getAccountName(),balance,"Loan Account Created");
					
					}break;
					case 5:
					{
						
					}break;
				}
				
			}break;
			case 3:
			{
				int i = 0;
				if(account[i]==null)
				{
					System.out.println("Account List is Empty");
				}
				else
				{
					
					for(i=0;i<index;i++)
					{
						account[i].display();
					}
				}
			}break;
			case 4:
			{
				fetchReport();
				
			}break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}while(choice!=0);
		sc.close();
	}
	
	


}	

