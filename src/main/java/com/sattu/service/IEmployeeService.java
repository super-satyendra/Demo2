package com.sattu.service;

import java.util.List;

import com.sattu.entity.Employee;

public interface IEmployeeService
{
	public void addEmployee(Employee e)throws Exception;
    public List<Employee> getAll()throws Exception;
    public Employee FindById(int id)throws Exception;
    public void delete(int id)throws Exception;
    public void update(Employee e)throws Exception;
}
