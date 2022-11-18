package com.spring.mvc.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.Employee;
import com.spring.mvc.service.HomeServices;

@org.springframework.stereotype.Controller
public class HomeController {
	
	@Autowired
	private HomeServices homeServices; 
	
	@RequestMapping("/")
	public String loginPage() {
		
		return "login";
	}
	@RequestMapping("/register")
	public String registerNewEmployee() {
		
		return "register";
	}
	
	@RequestMapping(value = "/save_employee")
	public String saveEmployee(@ModelAttribute Employee employee,Model model) {
		int id=homeServices.saveEmployee(employee);
		List<Employee> listEmployee=homeServices.getAllEmployee();
		model.addAttribute("data", listEmployee);
		return "success";
	}
	@RequestMapping("/login")
	public String getAllEmployee(@RequestParam ("uname") String un,@RequestParam ("pass") String pas, Model model) {
		List<Employee> listEmployee=homeServices.getAllEmployee();
		model.addAttribute("data", listEmployee);
		return "success";
	}
	@RequestMapping("/edit")
	public String editEmployeeData(@ModelAttribute Employee employee, Model model) {
		Employee employe=homeServices.editEmployeeData(employee);
		model.addAttribute("data", employe);
		return "edit";
	}
	@RequestMapping("/update_data")
	public String updateEmployeeData(@ModelAttribute Employee employee, Model model) {
		int id	=homeServices.updateEmployeeData(employee);
		List<Employee>list= homeServices.getAllEmployee();
		if(id>0)
		{
			model.addAttribute("data", list);
			return "success";
		}
		else
		{
			return "login";	
		}
	}
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id, Model model) {
		int id1=homeServices.deleteEmployee(id);
		List<Employee> listEmployee=homeServices.getAllEmployee();
		model.addAttribute("data", listEmployee);
		return "success";
	}
	@RequestMapping("/find_by_name")
	public String findById() {
		
		return "find";
	}@RequestMapping("/get_data_by_name")
	public String openid(@RequestParam ("name") String name, Model m)
	{
	
		Employee i=homeServices.findByName(name);
		System.out.println(i.getAddr());
		m.addAttribute("user", i);
		return "successid";
	}
	

}
