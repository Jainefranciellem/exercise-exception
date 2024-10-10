package model.Entities;

import model.Exception.DomainException;

public class Bank {
	private Number number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;


	public Bank(Number number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String AccountData(Number number, String holder, Double balance, Double withdrawLimit) {
		return "Number: " + number 
				+ ", Holder: " + holder
				+ ", Initial balance: " + balance
				+ ", Withdraw limit: " + withdrawLimit;
	}

	public Number getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return this.balance;
	}

	public Double setBalance() {
		return this.balance;
	}

	public Double getWithdrawLimit() {
		return this.withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if(amount > this.withdrawLimit ) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > this.balance) {
			throw new DomainException("Not enough balance");
		}
		this.balance -= amount;
	}
}
