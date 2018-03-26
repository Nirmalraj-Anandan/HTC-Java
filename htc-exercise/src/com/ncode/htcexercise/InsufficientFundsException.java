package com.ncode.htcexercise;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 4999755221619014248L;
	
	private double amount;
	   
	   public InsufficientFundsException(double amount) {
	      this.amount = amount;
	   }
	   
	   public double getAmount() {
	      return amount;
	   }
	}

