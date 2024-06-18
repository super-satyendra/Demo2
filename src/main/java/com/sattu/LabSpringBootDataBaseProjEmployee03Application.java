package com.sattu;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sattu.entity.Employee;
import com.sattu.service.EmpolyeeServiceImpl;

@SpringBootApplication
public class LabSpringBootDataBaseProjEmployee03Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LabSpringBootDataBaseProjEmployee03Application.class, args);
		
		EmpolyeeServiceImpl service = ctx.getBean("empservice",EmpolyeeServiceImpl.class);
		
		try
		{
			Employee emp1=new Employee(103,"satyendra","Senior developer",100000.00,"Developer");
    		service.addEmployee(emp1);
			Employee emp2=new Employee(102,"Mahesh","junior developer",80000.00,"Developer");
			service.addEmployee(emp2);
			
			List<Employee> list=service.getAll();
			for(Employee employee:list)
			{
				System.out.println(employee);
			} 
			
			Employee emp3=service.FindById(101);
			System.out.println("Found Employee"+ emp3);
			
			Employee emp4=new Employee();
			emp4.setEmployeeName("Sonu");
			emp4.setEmployeeDesgnation("Seniour Tester");
			emp4.setEmployeeSalary(120000.00);
			emp4.setEmployeeDepartment("tester");
			emp4.setEmployeeId(101);
			service.update(emp4);
			service.delete(102);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
