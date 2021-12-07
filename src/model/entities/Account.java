package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withDraw) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withDraw;
	}
	
	@Override
	public String toString() {
		return "New balance: $ " + getBalance();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withDraw) {
		this.withdrawLimit = withDraw;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (balance < amount) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
	}	
}
