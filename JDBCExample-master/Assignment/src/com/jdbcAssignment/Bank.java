package com.jdbcAssignment;

public class Bank {
	private int id; 
	private double amount; 
	
	Bank();
	
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
		System.out.println("New amount is : " + newAmount);
	}

	
	public void withdraw(double amount) 
	{
		double newAmount = getAmount() - amount;
		System.out.println("New amount is : " + newAmount);
	}	
	
	public void transferA(BankAccount destination, double amount) {
		destination.setAmount(destination.getAmount() + amount);
		
		this.setAmount(this.getAmount() - amount);
	}

	
	public void transferB(BankAccount destination, double amount) {
		destination.deposit(amount); 
		this.withdraw(amount); 
	}

}
