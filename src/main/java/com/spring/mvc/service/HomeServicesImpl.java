package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.Employee;
import com.spring.mvc.repository.HomeRepository;

@Service
public class HomeServicesImpl implements HomeServices{
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public int saveEmployee(Employee employee) {
		
		return homeRepository.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return homeRepository.getAllEmployee();
	}

	@Override
	public Employee editEmployeeData(Employee employee) {
		
		return homeRepository.editEmployeeData(employee);
	}

	@Override
	public int updateEmployeeData(Employee employee) {
		
		return homeRepository.updateEmployeeData(employee);
	}

	@Override
	public int deleteEmployee(int id) {
		
		return homeRepository.deleteEmployee(id);
	}

	@Override
	public Employee findByName(String name) {
		
		return homeRepository.findByName(name);
	}

	 

}
