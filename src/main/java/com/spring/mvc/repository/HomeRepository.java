package com.spring.mvc.repository;

import java.util.List;

import com.spring.mvc.model.Employee;

public interface HomeRepository {

	public int saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();

	public Employee editEmployeeData(Employee employee);

	public int updateEmployeeData(Employee employee);

	public int deleteEmployee(int id);

	public Employee findByName(String name);

	

}
