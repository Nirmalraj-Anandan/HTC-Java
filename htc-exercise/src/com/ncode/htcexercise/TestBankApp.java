package com.ncode.htcexercise;

public class TestBankApp {

	public static void main(String[] args) {

		Bank bankI = new Bank();

		// creating a copy of bank account.
		//BankAccount bankAccTs = new BankAccount(bankI.checkAccount("1002"));
		
		// reference
		BankAccount bankAccI1 = new BankAccount();
		BankAccount bankAccI2 = new BankAccount();
		BankAccount bankAccI3 = new BankAccount();

		bankAccI1 = bankI.checkAccount("1002");
		bankAccI2 = bankI.checkAccount("1003");
		bankAccI3 = bankI.checkAccount("1004");

		System.out.println(bankAccI1.toString() + "\n");

		try {
			if (bankI.depositMoney(bankAccI1, 400.0D))
				System.out.println("Hash Code :" + Integer.toString(bankAccI1.hashCode()) + "\n" + "Account number :" + bankAccI1.getAccountNo() + "\n" + "Balance :"
						+ Double.toString(bankAccI1.getAccountBalance()) + "\n");
		} catch (InvalidAmountException e1) {
			System.out.println(e1.getExceptionMsg());
			e1.printStackTrace();
		}

		/*
		if (bankI.depositMoney(bankAccTs, 400.0D))
			System.out.println("Hash Code :" + Integer.toString(bankAccTs.hashCode()) + "\n" + "Account number :" + bankAccTs.getAccountNo() + "\n" + "Balance :"
					+ Double.toString(bankAccTs.getAccountBalance()) + "\n");
		*/

		try {
			if (bankI.depositMoney(bankAccI2, 400.0D))
				System.out.println("Hash Code :" + Integer.toString(bankAccI2.hashCode()) + "\n" + "Account number :" + bankAccI2.getAccountNo() + "\n" + "Balance :"
						+ Double.toString(bankAccI2.getAccountBalance()) + "\n");
		} catch (InvalidAmountException e1) {
			System.out.println(e1.getExceptionMsg());
			e1.printStackTrace();
		}
		try {
		if (bankI.withdrawMoney(bankAccI3, 100.0D))
			System.out.println("Hash Code :" + Integer.toString(bankAccI3.hashCode()) + "\n" + "Account number :" + bankAccI3.getAccountNo() + "\n" + "Balance :"
					+ Double.toString(bankAccI3.getAccountBalance()) + "\n");
		}
		catch (InsufficientFundsException e){
			System.out.println("Sorry, short of money valued at amount " + e.getAmount());
	         e.printStackTrace();
		} catch (InvalidAmountException e) {
			System.out.println(e.getExceptionMsg());
			e.printStackTrace();
		}
		
		try {
			if (bankI.transferMoney(bankAccI1, bankAccI3,600.0D))
				System.out.println("Hash Code :" + Integer.toString(bankAccI1.hashCode()) + "\n" + "Account number :" + bankAccI1.getAccountNo() + "\n" + "Balance :"
						+ Double.toString(bankAccI1.getAccountBalance()) + "\n -------------- \n" + "Hash Code :" + Integer.toString(bankAccI3.hashCode()) + "\n" + "Account number :" + bankAccI3.getAccountNo() + "\n" + "Balance :"
						+ Double.toString(bankAccI3.getAccountBalance()) + "\n");
		} catch (InvalidAmountException e) {
			System.out.println(e.getExceptionMsg());
			e.printStackTrace();
		}
		
		// check exception
		try {
			if (bankI.depositMoney(bankAccI1, 50000.10D))
				System.out.println("Hash Code :" + Integer.toString(bankAccI1.hashCode()) + "\n" + "Account number :" + bankAccI1.getAccountNo() + "\n" + "Balance :"
						+ Double.toString(bankAccI1.getAccountBalance()) + "\n");
		} catch (InvalidAmountException e1) {
			System.out.println(e1.getExceptionMsg());
			e1.printStackTrace();
		}
	}

}
