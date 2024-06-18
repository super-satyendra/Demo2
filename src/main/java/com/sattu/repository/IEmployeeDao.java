package com.sattu.repository;

import java.util.List;

import com.sattu.entity.Employee;

public interface IEmployeeDao
{
    public String saveData(Employee e)throws Exception;
    public List<Employee> retriveAllData()throws Exception;
    public Employee retriveDataById(int id)throws Exception;
    public void deleteDataById(int id)throws Exception;
    public void updateDataById(Employee e)throws Exception;
}
