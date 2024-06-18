package com.sattu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sattu.entity.Employee;
import com.sattu.repository.IEmployeeDao;
@Service("empservice")
public class EmpolyeeServiceImpl implements IEmployeeService
{
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee e) throws Exception {
		validateEmployee(e);
		try {
			employeeDao.saveData(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAll() throws Exception {
		List<Employee> employees = employeeDao.retriveAllData();
		return employees;
	}

	@Override
	public Employee FindById(int id) throws Exception {
	     if(id<=0)
	     {
	    	 throw new IllegalArgumentException("ID must be greater than 0");
	     }
	     else
	     {
	    	 return employeeDao.retriveDataById(id);
	     }
	}

	@Override
	public void delete(int id) throws Exception
	{
	if(id<=0)
	{
		throw new IllegalArgumentException("ID must be greater than 0");
	}
	else
	{
           employeeDao.deleteDataById(id);
	}
		
	}

	@Override
	public void update(Employee employee) throws Exception {
		try {
            employeeDao.updateDataById(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	private void validateEmployee(Employee employee) throws Exception
	{
		if(employee.getEmployeeId()<=0)
		{
			throw new IllegalArgumentException("ID must be greater than 0");
		}
		if(employee.getEmployeeName()==null || employee.getEmployeeName().isEmpty())
		{
			throw new IllegalArgumentException("Employee name must not be empty");
		}
		if(employee.getEmployeeDesgnation()==null || employee.getEmployeeDesgnation().isEmpty())
		{
			throw new IllegalArgumentException("Employee designation must not be empty");
		}
		if(employee.getEmployeeSalary()<=0)
        {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
		if(employee.getEmployeeDepartment()==null || employee.getEmployeeDepartment().isEmpty())
		{
			throw new IllegalArgumentException("Employee department must not be empty");
		}
	}

}
