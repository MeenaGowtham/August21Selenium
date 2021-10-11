package com.day5Q4;

import java.util.Scanner;

class SavingsAccount extends Account{
	
}

public class Account {
	public static double balance = 10000.00, amount;
	static Scanner sc = new Scanner(System.in);

	/* prompts the user to choose the account */
	public static int display() {
		System.out.println("Choose:\n1.Savings \n2.Current");
		int accType = sc.nextInt();
		return accType;
	}
	
	/* prompts the user to choose the operation */
	public static int operation() {
		System.out.println("1.Withdraw\n2.Make Payment");
		int	opType = sc.nextInt();
		return opType;
	}
	
	public void withdrawAmount(double amount) {
		balance -= amount;
	}
	
	public void makePayment(double amount) {
		balance += amount;
	}
	
	public static void main(String[] args) {
		double getAmount;
		int accType = Account.display();
		int opType = Account.operation();
		
		Account acc1 = new SavingsAccount();
		Account acc2 = new CurrentAccount();
		
		/* chooses between savings and current account */
		switch(accType) {
		case 1:
			/* executes when the selection is savings and withdrawal */
			if(opType == 1) {
				System.out.println("Amount to be withdrawn: ");
				getAmount = sc.nextDouble();
				if(getAmount > Account.balance)
					System.out.println("Not enough balance");
				else {
					acc1.withdrawAmount(getAmount);
				}				
			}
			/* executes when the selection is savings and deposit */
			else if(opType == 2) {
				System.out.println("Amount to be deposited : ");
				getAmount = sc.nextDouble();
				acc1.makePayment(getAmount);
			}
			break;
		case 2:
			/* executes when the selection is current and withdrawal */
			if(opType == 1) {
				System.out.println("Amount to be withdrawn: ");
				getAmount = sc.nextDouble();
				if(getAmount > Account.balance)
					System.out.println("Not enough balance");
				else {
					acc2.withdrawAmount(getAmount);
				}
					
			}
			/* executes when the selection is current and deposit */
			else if(opType == 2) {
				System.out.println("Amount to be deposited : ");
				getAmount = sc.nextDouble();
				acc2.makePayment(getAmount);
			}
			break;
		}
		System.out.println("Current balance : "+Account.balance);
	}
}
