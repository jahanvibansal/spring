package com.java;

public class Account {
	
	
	private int accountNo;
	private float balance;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Account(int accountNo, float balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

}
