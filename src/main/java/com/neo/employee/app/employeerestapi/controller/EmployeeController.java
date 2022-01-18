package com.neo.employee.app.employeerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.employee.app.employeerestapi.repo.EmployeeRepo;
import com.neo.employee.app.employeerestapi.services.EmployeeServices;
import com.neo.employee.app.employeerestapi.model.Employee;

@RestController
public class EmployeeController 
{

	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping(value = "/")
	public String getPage()
	{
		return "Welcome to Spring Boot Application";
	}
	
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees()
	{
		return employeeServices.getEmployees();
	}
	
	@PostMapping(value = "/save")
	public String saveEmployee(@RequestBody Employee employee)
	{
		return employeeServices.createEmployee(employee);
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateEmployee(@PathVariable long id, @RequestBody Employee employee)
	{
		return employeeServices.updateEmployee(id, employee);
	}

	@PutMapping(value = "/updatesalary/{id}/{salary}")
	public String updateEmployee(@PathVariable long id, @PathVariable double salary)
	{
		return employeeServices.updateEmployeeSalary(id, salary);
	}
	
	
	@GetMapping(value = "/salary")
	public List<Employee> function(){
		return employeeServices.descendingSalary();
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		return employeeServices.deleteEmployee(id);
	}
	
}
