package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.model.Employee;

public interface HomeServices {
	
	public int saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee editEmployeeData(Employee employee);

	public int updateEmployeeData(Employee employee);

	public int deleteEmployee(int id);

	public Employee findByName(String name);
	

}
