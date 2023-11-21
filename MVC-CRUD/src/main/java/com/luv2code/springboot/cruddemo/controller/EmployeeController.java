package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		
		// Get the employees from DB
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		model.addAttribute(theEmployees);
		
		return "list-employees";
	}
	

}
