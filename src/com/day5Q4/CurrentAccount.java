package com.day5Q4;

public class CurrentAccount extends Account {
	
	double extraCharges;
	
	/* Method Overriding */	
	public void withdrawAmount(double amount) {
		extraCharges = amount * 0.1;
		balance -= amount+extraCharges;
	}

}
