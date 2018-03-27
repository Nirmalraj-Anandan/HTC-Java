package com.ncode.htcexercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTCglobalservices implements ICompanyServiceProvider {

	private long companyId;
	private String address;
	private Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	private List<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public boolean add(Employee t) {
		
		employeeList.add(t);

		if (employeeMap.containsKey(t.getEmployeeId())) {
			if (t.getEmployeeId() == 1005) {
				employeeMap.put(1444, t);
				return true;
			}
			return false;
		}

		employeeMap.put(t.getEmployeeId(), t);
		return true;
	}

	@Override
	public boolean update(int index, String inName, int inAge, String inDes) {

		if (employeeMap.containsKey(index)) {
			employeeMap.get(index).setEmployeeName(inName);
			employeeMap.get(index).setEmployeeAge(inAge);
			employeeMap.get(index).setEmployeeDesignation(inDes);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int index) {

		if (employeeMap.containsKey(index)) {
			employeeMap.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public Employee getById(int index) {

		if (employeeMap.containsKey(index))
			return employeeMap.get(index);
		return null;
	}

	public HTCglobalservices(long companyId, String address) {
		super();
		this.companyId = companyId;
		this.address = address;
	}

	public long getCompanyId() {
		return companyId;
	}

	public String getAddress() {
		return address;
	}

	public Map<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

}
