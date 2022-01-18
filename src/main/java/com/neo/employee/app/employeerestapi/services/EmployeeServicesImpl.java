/**
 * 
 */
package com.neo.employee.app.employeerestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neo.employee.app.employeerestapi.exception.EmployeeExistsException;
import com.neo.employee.app.employeerestapi.model.Employee;
import com.neo.employee.app.employeerestapi.repo.EmployeeRepo;

/**
 * @author neoBusinessMan
 *
 */
@Service
public class EmployeeServicesImpl implements EmployeeServices 
{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public String createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeRepo.existsById(employee.getId())) {
			throw new EmployeeExistsException("Employee Already Exists");
		}
		employeeRepo.save(employee);
		return "Saved Employee";
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public String updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		Employee employeeUpdated = employeeRepo.findById(id).get();
		
		employeeUpdated.setName(employee.getName());
		employeeUpdated.setDesignation(employee.getDesignation());
		if(0 < employee.getSalary()) {
			employeeUpdated.setSalary(employee.getSalary());
		}

		employeeRepo.save(employeeUpdated);
		return "Updated Employee";
	}

	@Override
	public List<Employee> descendingSalary() {
		// TODO Auto-generated method stub
		return employeeRepo.findByOrderBySalaryDesc();
	}

	@Override
	public List<Employee> getEmployeesBySorting() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepo.findAll(Sort.by("salary").descending().and(Sort.by("name")));
		return list;
	}

	@Override
	public String deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee deleteEmployee = employeeRepo.findById(id).get();
		employeeRepo.delete(deleteEmployee);
		return "Delete user with id: " + id;
	}

	@Override
	public String updateEmployeeSalary(long id, double salary) {
		// TODO Auto-generated method stub
		Employee employeeUpdated = employeeRepo.findById(id).get();

		if(0 < salary) {
			employeeUpdated.setSalary(salary);
		}

		employeeRepo.save(employeeUpdated);
		return "Updated Employee Salary";
	}

}
