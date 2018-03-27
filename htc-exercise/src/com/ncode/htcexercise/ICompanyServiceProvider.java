package com.ncode.htcexercise;

public interface ICompanyServiceProvider {

	public boolean add(Employee t);
    public boolean update(int index, String inName, int inAge, String inDes);
    public boolean remove(int index);
    public Employee getById(int index);
    
}
