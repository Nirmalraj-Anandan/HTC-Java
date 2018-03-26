package com.ncode.htcexercise;

import java.io.Serializable;
import java.util.Objects;

/*
+------------------------------------------------------------+
 | Module Name: BankAccount                                  |
 | Module Purpose: emulate a bank account                    |
 | Inputs: account no., name, balance						 |
 | Outputs: user defined toString, equals and hashcode       |
 | Throws: 	                                                 |
 | Created:	03/24/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
+------------------------------------------------------------+
*/

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 197523220376180807L;
	
	private String accountNo = "";
	private String accountName = "";
	private double accountBalance = 0D;

	// user defined hashCode using account number and account name
	@Override
	public int hashCode() {
		return Objects.hash(accountNo, accountName);
	}
	
	// user defined equals method to check only account number and account name
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;

		return Objects.equals(accountNo, other.accountNo) && Objects.equals(accountName, other.accountName);
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + "]";
	}
	
	public BankAccount() {
		
	}
	
	public BankAccount(BankAccount obj) {
		accountNo = obj.accountNo;
		accountName = obj.accountName;
		accountBalance = obj.accountBalance;
	}
	
	public BankAccount(String inAccNo, String inAccName) {
		super();
		this.accountNo = inAccNo;
		this.accountName = inAccName;
		this.accountBalance = 1000D;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}
	
		public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	
}
