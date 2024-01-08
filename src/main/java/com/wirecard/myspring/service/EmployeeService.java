package com.wirecard.myspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wirecard.myspring.model.Employee;

@Service
public class EmployeeService {
	private static List<Employee> empList ;
	static {
		empList = new ArrayList<>();
		empList.add(new Employee(1, "Kwik", "Bebek", 10, "S1"));
		empList.add(new Employee(2, "Kwek", "Bebek", 10, "S1"));
		empList.add(new Employee(3, "Kwak", "Bebek", 10, "S1"));
		empList.add(new Employee(4, "Donald", "Bebek", 30, "S2"));
		empList.add(new Employee(5, "Gober", "Bebek", 60, "SMA"));
	}
	public List<Employee> listOfEmployees(){
		return empList;
	}
	
	public void addEmployee(Employee emp) {
		empList.add(emp);
	}
	
	public Employee findEmployeeById(Integer id) {
		for(Employee emp : empList) {
			if(emp.getId().equals(id)) {
				return emp;
			}
		}
		
		return null;
	}
	
	public int nextId() {
		return empList.size() + 1;
	}
}
