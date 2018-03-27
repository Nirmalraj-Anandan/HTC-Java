package com.ncode.htcexercise;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements Serializable {

	private static final long serialVersionUID = -5805887687834729466L;

	private int employeeId;
	private String employeeName;
	private int employeeAge;
	private String employeeDesignation;

	private static AtomicInteger count = new AtomicInteger(1000);

	// user defined hashCode using account number and account name
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName, employeeAge, employeeDesignation);
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
		Employee other = (Employee) obj;

		return Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeAge, other.employeeAge)
				&& Objects.equals(employeeDesignation, other.employeeDesignation);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeDesignation=" + employeeDesignation + "]";
	}

	public Employee() {

	}

	public Employee(String employeeName, int employeeAge, String employeeDesignation) {
		super();
		this.employeeId = count.incrementAndGet();
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeDesignation = employeeDesignation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public final void finalize() {
		// Nothing to do, only for cleanup purpose.
	}

}
