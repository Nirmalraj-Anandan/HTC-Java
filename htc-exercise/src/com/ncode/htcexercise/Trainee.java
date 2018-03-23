package com.ncode.htcexercise;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/*
+------------------------------------------------------------+
 | Module Name: Trainee	                                     |
 | Module Purpose: emulate a trainee                         |
 | Inputs: trainee name, contact number, email, gender, age  |
 | Outputs: user defined toString                            |
 | Throws: 	                                                 |
 | Created:	03/20/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
+------------------------------------------------------------+
*/

public class Trainee implements Serializable {

	private int traineeId;
	private String traineeName;
	private long contactNo;
	private String email;
	private String gender;
	private int age;

	private static final AtomicInteger count = new AtomicInteger(1000);

	@Override
	public int hashCode() {

		return Objects.hash(traineeId, traineeName, contactNo, email, gender, age);
		/*
		 * final int prime = 31; int result = 1; result = prime * result + age; result =
		 * prime * result + contactNo; result = prime * result + ((email == null) ? 0 :
		 * email.hashCode()); result = prime * result + ((gender == null) ? 0 :
		 * gender.hashCode()); result = prime * result + traineeId; result = prime *
		 * result + ((traineeName == null) ? 0 : traineeName.hashCode()); return result;
		 */
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;

		return Objects.equals(traineeId, other.traineeId) && Objects.equals(traineeName, other.traineeName)
				&& Objects.equals(contactNo, other.contactNo) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(age, other.age);
		/*
		 * if (age != other.age) return false; if (contactNo != other.contactNo) return
		 * false; if (email == null) { if (other.email != null) return false; } else if
		 * (!email.equals(other.email)) return false; if (gender == null) { if
		 * (other.gender != null) return false; } else if (!gender.equals(other.gender))
		 * return false; if (traineeId != other.traineeId) return false; if (traineeName
		 * == null) { if (other.traineeName != null) return false; } else if
		 * (!traineeName.equals(other.traineeName)) return false; return true;
		 */
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", contactNo=" + contactNo
				+ ", email=" + email + ", gender=" + gender + ", age=" + age + "]";
	}

	// traineeId is auto-generated when the class is instantiated.
	public Trainee() {

	}

	public Trainee(String traineeName, long contactNo, String email, String gender, int age) {
		super();
		this.traineeId = count.incrementAndGet();
		this.traineeName = traineeName;
		this.contactNo = contactNo;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public final void finalize() {
		// Nothing to do, only for cleanup purpose.
	}

}
