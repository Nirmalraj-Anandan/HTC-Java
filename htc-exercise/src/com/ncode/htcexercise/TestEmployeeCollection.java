package com.ncode.htcexercise;

import java.util.Iterator;
import java.util.Map.Entry;

public class TestEmployeeCollection {

	public static void main(String[] args) {

		Employee e1 = new Employee("Test Emp1", 26, "Analyst");
		Employee e2 = new Employee("Test Emp2", 26, "Analyst");
		Employee e3 = new Employee("Test Emp3", 27, "Analyst");
		Employee e4 = new Employee("Test Emp4", 28, "HR");
		Employee e5 = new Employee("Test Emp5", 27, "Lead");

		HTCglobalservices htc1 = new HTCglobalservices(223355, "HTC Global Services, MEPZ, Chennai-45");

		htc1.add(e1);
		htc1.add(e2);
		htc1.add(e3);
		htc1.add(e5);
		htc1.add(e4);
		htc1.add(e5);
		
		try {
			System.out.println(htc1.getById(1002).toString());
		} catch (NullPointerException e) {
			System.out.println("Specific employee with provided id not in collection.");
		}

		// retrive all employees from the collection
		for (Entry<Integer, Employee> hmc : htc1.getEmployeeMap().entrySet()) {
			System.out.println("Key : " + hmc.getKey());
			System.out.println("Value : " + hmc.getValue().toString() + "\n");
		}

		// Thru iterator
		System.out.println("All Keys in Collection: Insertion order not maintained.");
		Iterator<Entry<Integer, Employee>> hmci = htc1.getEmployeeMap().entrySet().iterator();

		while (hmci.hasNext()) {
			Entry<Integer, Employee> nxt = hmci.next();
			System.out.println(nxt.getKey());
		}
		
		System.out.println("All Keys in List: Insertion order maintained and duplicates allowed.");
		for(Employee e21 : htc1.getEmployeeList()) {
			System.out.println(e21.getEmployeeId());
		}

		System.out.println("\n Update employee id 1003");

		System.out.println("Id 1003 inside collection before update of employee object: \n" + htc1.getById(1003));

		// update
		htc1.update(1003, e3.getEmployeeName(), e3.getEmployeeAge(), "Developer");
		System.out.println("Id 1003 after collection update: \n" + htc1.getById(1003));

		// delete
		htc1.remove(1005);
		System.out.println("\n Listing after employee id 1005 being removed:");
		for (Entry<Integer, Employee> hmc : htc1.getEmployeeMap().entrySet()) {
			System.out.println("Key : " + hmc.getKey());
		}

	}

}
