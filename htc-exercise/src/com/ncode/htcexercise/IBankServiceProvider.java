package com.ncode.htcexercise;

public interface IBankServiceProvider {
	
	BankAccount checkAccount(String inAccNo);
	
	double getBalance(BankAccount inAcc);
	
	boolean depositMoney(BankAccount inAcc, double inAmmount) throws InvalidAmountException;
	
	boolean withdrawMoney(BankAccount inAcc, double inAmmount) throws InsufficientFundsException, InvalidAmountException;
	
	boolean transferMoney(BankAccount inFrmAcc, BankAccount inToAcc, double inAmmount) throws InvalidAmountException;

}
