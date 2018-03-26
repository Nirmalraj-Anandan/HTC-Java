package com.ncode.htcexercise;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = 2250566224629012178L;
	
	private String exceptionMsg;
	   
	   public InvalidAmountException(double amount) {
	      this.exceptionMsg = "Invalid Amount: " + amount + " not in range of 1..5000";
	   }
	   
	   public String getExceptionMsg() {
	      return exceptionMsg;
	   }
}
