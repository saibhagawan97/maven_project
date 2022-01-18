package com.neo.employee.app.employeerestapi.services;

import java.util.List;

import com.neo.employee.app.employeerestapi.model.Employee;

public interface EmployeeServices 
{
	public String createEmployee(Employee employee);
	public List<Employee> getEmployees();
	public String updateEmployee(Long id, Employee employee);
	public List<Employee> descendingSalary();
	public List<Employee> getEmployeesBySorting();
	public String deleteEmployee(Long id);
	public String updateEmployeeSalary(long id, double salary);
}
