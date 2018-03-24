package com.ncode.htcexercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
+------------------------------------------------------------+
 | Module Name: Batch	                                     |
 | Module Purpose: emulate a programme batch with trainees   |
 | Inputs: 													 |
 | Outputs:                                                  |
 | Throws: user defined exception                            |
 | Created:	03/20/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
 |	03/24/2018 - Updated date format and printing batch 	 |
 |				 details.									 |
+------------------------------------------------------------+
*/

public class Batch {

	private String batchCode;
	private Date startDate;
	private Date endDate;
	private Trainee[] traineeArr;
	
	static DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
		@Override
	public String toString() {
		return " Batch     :" + batchCode + "\n startDate :" + startDate + "\n endDate   :" + endDate + "\n Trainee Details :\n";
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Trainee[] getTraineeArr() {
		return traineeArr;
	}

	public void setTraineeArr(Trainee[] traineeArr) {
		this.traineeArr = traineeArr;
	}

	// search and find a trainee from array using id
	public Trainee getTraineeById(int traineeId) throws TraineeNotFoundException{

		// loop thru all trainees in the batch
		for (Trainee tra : traineeArr) {
			if (tra != null) {
				if (tra.getTraineeId() == traineeId)
					return tra;
			} else {
				break;
			}
		}

		throw new TraineeNotFoundException(traineeId);
	}

	// list all trainee's of a particular gender from the array
	public Trainee[] getTraineeByGender(String gender) {

		List<Trainee> listTrainee = new ArrayList<Trainee>();

		if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
			// loop thru all trainees in the batch
			for (Trainee tra : traineeArr) {
				if (tra != null) {
					if (tra.getGender().equalsIgnoreCase(gender)) {
						listTrainee.add(tra);
					}
				} else {
					break;
				}
			}
		} else {
			return null;
		}

		return listTrainee.toArray(new Trainee[listTrainee.size()]);
	}

	public static void main(String[] args) {

		Batch firstBatch = new Batch();
		Trainee[] passTraineeArr = new Trainee[8];

		// only adding four instances to test for null pointer exception
		passTraineeArr[0] = new Trainee("Ashok", 1111111111L, "ashok1111@htcinc.com", "Male", 22);
		passTraineeArr[1] = new Trainee("Boby", 2222222222L, "boby2222@htcinc.com", "Male", 21);
		passTraineeArr[2] = new Trainee("Cathy", 3333333333L, "cathy3333@htcinc.com", "Female", 22);
		passTraineeArr[3] = new Trainee("Dany", 4444444444L, "dany4444@htcinc.com", "Male", 24);

		firstBatch.setTraineeArr(passTraineeArr);

		Trainee[] testTraineeArr = firstBatch.getTraineeArr();

		try {
			
			firstBatch.setBatchCode("JAVA1001");
			firstBatch.setStartDate(sdf.parse("03-04-2018"));
			firstBatch.setEndDate(sdf.parse("04-04-2018"));
			
			System.out.println(firstBatch.toString());

			// list all trainees in the batch
			for (Trainee tra : testTraineeArr) {
				// if(tra != null) {
				//System.out.println(tra.getTraineeName() + " with id " + tra.getTraineeId() + " can be reached at "
				//		+ tra.getContactNo());
				System.out.println(tra.toString());
				// }
				// else {
				// break;
				// }
			}
		} catch (ParseException e) { 
			System.out.println("Probable error in date fields.");
		}catch (NullPointerException e) {
			System.out.println("Test: Empty/Null/No Trainee instance in the array.");
		}
		
		System.out.println("\n" + "Search trainee by id:");

		// search for trainee using his/her id
		// if a trainee is not found then throw user defined exception
		try {
		System.out.println(firstBatch.getTraineeById(1007));
		}
		catch(TraineeNotFoundException e) {
			System.out.println("Messgae in user defined exception catch block.");
			System.out.println(e+"\n");
		}
		catch(Exception e) {
			System.out.println("Messgae in user generic exception catch block."+"\n");
		}

		// list all trainees of a particular gender
		// exception not handled
		// change input parameter other than male/female to throw exception
		
		System.out.println("\n" + "Search trainee's by gender:");
		
		for (Trainee tra1 : firstBatch.getTraineeByGender("Male")) {
			System.out.println(tra1.toString());
		}

		System.out.println("\n"+"End of class.");
	}

}
