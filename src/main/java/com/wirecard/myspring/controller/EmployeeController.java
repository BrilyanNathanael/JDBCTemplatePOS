package com.wirecard.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wirecard.myspring.domain.Product;
import com.wirecard.myspring.model.Employee;
import com.wirecard.myspring.repository.ProductRepository;
import com.wirecard.myspring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listOfEmployee(Model model) {
//		EmployeeService service = new EmployeeService();
		
		model.addAttribute("employeeList", service.listOfEmployees());
		
		return "employee-list";
	}
	
	@GetMapping("/employee/form")
	public String showNewEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		
		return "employee-form";
	}
	
	@RequestMapping(value="/employee/add", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
//		EmployeeService service = new EmployeeService();
		employee.setId(service.nextId());
		
		service.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employee/view/{id}", method = RequestMethod.GET)
	public String viewEmployee(@PathVariable("id") int id, Model model) {
//		EmployeeService service = new EmployeeService();
		model.addAttribute("employee", service.findEmployeeById(id));
		return "employee-view";
	}
}
