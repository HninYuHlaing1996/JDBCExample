package com.jdbcAssignment;

public class Bank {
	private int id; 
	private double amount; 
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() 
	{
		return amount;
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

	
	
	public void transferFundsA(Bank second, double amount) {
		second.setAmount(second.getAmount() + amount);
		
		this.setAmount(this.getAmount() - amount);
	}

	
	/*public void transferFundsB(BankAccount destination, double amount) {
		destination.deposit(amount); 
		this.withdraw(amount); 
	}*/

	
}
