package com.ncode.htcexercise;


/*
+------------------------------------------------------------+
 | Module Name: TraineeNotFoundException	                 |
 | Module Purpose: throw customized exception message   	 |
 | Inputs: (int) Id value 									 |
 | Outputs:                                                  |
 | Throws: 						                             |
 | Created:	03/23/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
+------------------------------------------------------------+
*/

public class TraineeNotFoundException extends Exception{

	private static final long serialVersionUID = 2264944791060152071L;
	private static String excepMsg1 = "Trainee with id ";
	private static String excepMsg2 = " not found. Please verify id.";
	
	TraineeNotFoundException(int inId){
		super(excepMsg1+inId+excepMsg2);
	}
}
