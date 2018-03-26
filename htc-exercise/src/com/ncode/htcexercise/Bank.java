package com.ncode.htcexercise;

import java.util.concurrent.atomic.AtomicInteger;

/*
+------------------------------------------------------------+
 | Module Name: Bank                                         |
 | Module Purpose: emulate a bank with accounts              |
 | Inputs:													 |
 | Outputs: 										         |
 | Throws: 	                                                 |
 | Created:	03/24/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
+------------------------------------------------------------+
*/

public class Bank implements IBankServiceProvider {

	private static AtomicInteger lastAssignedNumber = new AtomicInteger(1000);

	private BankAccount[] thisBankAccount;

	// sample account numbers initiated for testing this class
	BankAccount[] intBA = new BankAccount[] {
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING"),
			new BankAccount(Integer.toString(lastAssignedNumber.incrementAndGet()), "CHECKING") };

	public Bank() {
		this.setThisBankAccount(intBA);
	}

	public BankAccount[] getThisBankAccount() {
		return thisBankAccount;
	}

	public void setThisBankAccount(BankAccount[] thisBankAccount) {
		this.thisBankAccount = thisBankAccount;
	}
	
	// validate input ammount to be within range 1 to 50000
	public static void checkForRange(double aNumber) throws InvalidAmountException {
	    if ( aNumber < 1 || aNumber > 50000 ) {
	      throw new InvalidAmountException(aNumber);
	    }
	  }

	//
	public BankAccount checkAccount(String inAccNo) {

		// loop thru all trainees in the batch
		for (BankAccount ba : this.getThisBankAccount()) {
			if (ba != null) {
				if (inAccNo.equalsIgnoreCase(ba.getAccountNo()))
					return ba;
			}
		}

		return null;
	}

	public double getBalance(BankAccount inAcc) {

		for (BankAccount ba : this.getThisBankAccount()) {
			if (ba.equals(inAcc)) {
				return ba.getAccountBalance();
			}
		}

		return 0;
	}

	public boolean depositMoney(BankAccount inAcc, double inAmmount) throws InvalidAmountException{

		checkForRange(inAmmount);
		
		// loop thru all trainees in the batch
		for (BankAccount ba : this.getThisBankAccount()) {
			if (ba != null) {
				if (inAcc.equals(ba)) {

					ba.setAccountBalance(ba.getAccountBalance() + inAmmount);
					return true;
				}
			}
		}

		return false;
	}

	public boolean withdrawMoney(BankAccount inAcc, double inAmmount) throws InsufficientFundsException, InvalidAmountException{

		checkForRange(inAmmount);
		
		// loop thru all trainees in the batch
		for (BankAccount ba : this.getThisBankAccount()) {
			if (ba != null) {
				if (inAcc.equals(ba)) {
					
					if (inAmmount <= ba.getAccountBalance()) {

					ba.setAccountBalance(ba.getAccountBalance() - inAmmount);
					return true;
					}
					else {
						double needs = inAmmount - ba.getAccountBalance();
				         throw new InsufficientFundsException(needs);
					}
				}
			}
		}

		return false;
	}

	public boolean transferMoney(BankAccount inFrmAcc, BankAccount inToAcc, double inAmmount) throws InvalidAmountException{
		int counterFlag = 0;
		
		checkForRange(inAmmount);

		for (BankAccount ba : this.getThisBankAccount()) {
			if (ba.equals(inFrmAcc) || ba.equals(inToAcc)) {
				counterFlag++;
			}
		}

		System.out.println("--->" + counterFlag);

		if (counterFlag == 2) {

			for (BankAccount ba : this.getThisBankAccount()) {
				if (ba.equals(inFrmAcc))
					ba.setAccountBalance(ba.getAccountBalance() - inAmmount);
				
				if (ba.equals(inToAcc))
					ba.setAccountBalance(ba.getAccountBalance() + inAmmount);

			}
			return true;
		} else {
			return false;
		}
	}

}
