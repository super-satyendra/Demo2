package com.sattu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sattu.entity.Employee;
@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao
{
	@Autowired
	private DataSource dataSource;

	@Override
	public String saveData(Employee e) throws Exception 
	{
		int k=0;
		try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO employeeData values (?,?,?,?,?)");)
		{
			ps.setInt(1,e.getEmployeeId());
			ps.setString(2,e.getEmployeeName());
			ps.setString(3,e.getEmployeeDesgnation());
			ps.setDouble(4,e.getEmployeeSalary());
			ps.setString(5,e.getEmployeeDepartment());
			k=ps.executeUpdate();
	
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}

		return k>0?"Data saved successfully":"data not saved successfully";
	}

	@Override
	public List<Employee> retriveAllData() throws Exception 
	{
		final String GET_ALL_DATA="Select * from employeeData";
		
		List<Employee> list=new ArrayList<Employee>();
		
		try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL_DATA);)
		{
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setEmployeeName(rs.getString(2));
				emp.setEmployeeDesgnation(rs.getString(3));
				emp.setEmployeeSalary(rs.getDouble(4));
				emp.setEmployeeDepartment(rs.getString(5));
				list.add(emp);
			}
		}
		return list;
		
	}

	@Override
	public Employee retriveDataById(int id) throws Exception {
		final String FIND_BY_ID ="SELECT * FROM employeeData WHERE empolyeeId =?";
		Employee emp=new Employee();
		if(id>0) {
		try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);)
		{
			ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                
                emp.setEmployeeId(rs.getInt(1));
                emp.setEmployeeName(rs.getString(2));
                emp.setEmployeeDesgnation(rs.getString(3));
                emp.setEmployeeSalary(rs.getDouble(4));
                emp.setEmployeeDepartment(rs.getString(5));
                
            }
		}
		}
		else
		{
			throw new IllegalStateException("Invalid employee id!!!");
		}
		return emp;
		
	}

	@Override
	public void deleteDataById(int id) throws Exception
	{
		final String DELETE_BY_ID="delete from employeeData where empolyeeId=?";
		if(id>0) {
		try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID);)
		{
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				System.out.println("Data Delete  from employeeData successfully!!!");
			}
			else {
				System.out.println("Data not Delete from employeeData successfully!!!");
			}
		}
		}
		else
		{
			throw new IllegalArgumentException("Invalid employee id!!!");
		}
		
		
	}

	@Override
	public void updateDataById(Employee e) throws Exception 
	{
		
		final String UPDATE_BY_ID ="update employeeData set employeeName=?,employeeDesgnation=?,employeeSalary=?,employeeDepartment=? where empolyeeid=?";
		//Employee emp=new Employee();
        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(UPDATE_BY_ID);)
        {
        	ps.setString(1,e.getEmployeeName());
        	ps.setString(2,e.getEmployeeDesgnation());
            ps.setDouble(3,e.getEmployeeSalary());
            ps.setString(4,e.getEmployeeDepartment());
            ps.setInt(5,e.getEmployeeId());
            int rs = ps.executeUpdate();
            if(rs>0)
            {
                System.out.println("Data Update from employeeData successfully!!!");
            }
            else {
                System.out.println("Data not Update from employeeData successfully!!!");
            }
        }
		
	}

}
