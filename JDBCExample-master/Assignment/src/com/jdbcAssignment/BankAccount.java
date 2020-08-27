package com.jdbcAssignment;

public class BankAccount {
	private String id; 
	private double amount; 

	public BankAccount(String id, double initialAmount) {
		this.id = id;
		setAmount(initialAmount);
	}

	
	public void deposit(double amount) 
	{
		double newAmount = getAmount() + amount;
		setAmount(newAmount);
	}

	
	public void withdraw(double amount) 
	{
		double newAmount = getAmount() - amount;
		setAmount(newAmount); 
	}

	public String getId() 
	{
		return id; 
	}

	
	public double getAmount() // note "accessor" method
	{
		return amount; // returns value of instance var
	}

	
	public void transferFundsA(BankAccount destination, double amount) {
		destination.setAmount(destination.getAmount() + amount);
		
		this.setAmount(this.getAmount() - amount);
	}

	
	public void transferFundsB(BankAccount destination, double amount) {
		destination.deposit(amount); // deposit to "destination" account
		this.withdraw(amount); // withdraw from this account
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
