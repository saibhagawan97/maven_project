package com.neo.employee.app.employeerestapi.exception;

public class EmployeeExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public EmployeeExistsException(String msg) {
		super(msg);
	}
}
