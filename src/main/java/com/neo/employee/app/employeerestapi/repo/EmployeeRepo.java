package com.neo.employee.app.employeerestapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.employee.app.employeerestapi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findByOrderBySalaryDesc();
}
