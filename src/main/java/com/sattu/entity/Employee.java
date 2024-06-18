package com.sattu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee 
{
   private Integer employeeId;
   private String employeeName;
   private String employeeDesgnation;
   private Double employeeSalary;
   private String employeeDepartment;
}
